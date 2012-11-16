package com.baobaotao.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

import sample.unitils.dataset.util.XlsDataSetBeanFactory;

import com.baobaotao.domain.User;

@SpringApplicationContext( {"baobaotao-dao.xml" })
public class UserDaoTest extends UnitilsJUnit4 {

	@SpringBean("jdbcUserDao")
	private UserDao userDao;


	@Test
	@DataSet("BaobaoTao.Users.xls")//׼������ 
	public void findUserByUserName() {
		User user = userDao.findUserByUserName("tony");
		assertNull("�������û���Ϊtony���û�!", user);
		user = userDao.findUserByUserName("jan");
		assertNotNull("Jan�û����ڣ�", user);
		assertEquals("jan", user.getUserName());
		assertEquals("123456",user.getPassword());
		assertEquals(10,user.getCredits());
	}

	// ��֤���ݿⱣ�����ȷ��
	@Test
	@ExpectedDataSet("BaobaoTao.ExpectedSaveUser.xls")// ׼����֤����
	public void saveUser()throws Exception  {
		/**
		Ӳ���봴������ʵ��
		User u = new User();
		u.setUserId(1);
		u.setUserName("tom");
		u.setPassword("123456");
		u.setLastVisit(getDate("2011-06-06 08:00:00","yyyy-MM-dd HH:mm:ss"));
		u.setCredits(30);
		u.setLastIp("127.0.0.1");
		**/
		//ͨ��XlsDataSetBeanFactory���ݼ��󶨹�����������ʵ��
		User u  = XlsDataSetBeanFactory.createBean("BaobaoTao.SaveUser.xls", "t_user", User.class);
		userDao.save(u);  //ִ���û���Ϣ���²���
	}
	
	//��֤���ݿⱣ�����ȷ��
	@Test
	@ExpectedDataSet("BaobaoTao.ExpectedSaveUsers.xls")// ׼����֤����
	public void saveUsers()throws Exception  {
		List<User> users  = XlsDataSetBeanFactory.createBeans("BaobaoTao.SaveUsers.xls", "t_user", User.class);
		for(User u:users){
		     userDao.save(u);
		}
	}

}
