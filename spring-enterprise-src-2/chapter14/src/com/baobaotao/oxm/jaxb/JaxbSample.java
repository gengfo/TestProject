package com.baobaotao.oxm.jaxb;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.GregorianCalendar;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import com.baobaotao.domain.jaxb.LoginLog;
import com.baobaotao.domain.jaxb.User;
import com.baobaotao.utils.ResourceUtils;

public class JaxbSample {
	
	public static User getUser(){
		LoginLog log1 = new LoginLog();
		log1.setIp("192.168.1.91");
		log1.setLoginDate(new GregorianCalendar());
		LoginLog log2 = new LoginLog();
		log2.setIp("192.168.1.92");
		log2.setLoginDate(new GregorianCalendar());
		LoginLog log3 = new LoginLog();
		log3.setIp("192.168.1.93");
		log3.setLoginDate(new GregorianCalendar());
	    User user = new User();
		user.setUserName("jaxb");
		User.Logs logs = new User.Logs();
		logs.getLoginLog().add(log1);
		logs.getLoginLog().add(log2);
		logs.getLoginLog().add(log3);
		user.setLogs(logs);
		return user;
	}

	/**
	 * JAVA����ת��ΪXML
	 */
	public static void objectToXml() throws Exception {
		User user = getUser();
		JAXBContext context = JAXBContext.newInstance(User.class);
		Marshaller m = context.createMarshaller();
	    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		FileWriter writer = new FileWriter("D:\\masterSpring\\chapter14\\out\\JaxbSample.xml");
		m.marshal(user, writer);
	}
	/**
	 * XMLת��ΪJAVA����
	 */
	public static User  xmlToObject() throws Exception {
		JAXBContext context = JAXBContext.newInstance(User.class);
		FileReader reader = new FileReader("D:\\masterSpring\\chapter14\\out\\JaxbSample.xml");
		Unmarshaller um = context.createUnmarshaller();
		User u = (User) um.unmarshal(reader);
		for (LoginLog log : u.getLogs().getLoginLog()) {
			if (log != null) {
				System.out.println("����IP: " + log.getIp());
				System.out.println("����ʱ��: " + log.getLoginDate().getTime());
			}
		}
		return u;
	}

	public static void main(String args[]) throws Exception {
		objectToXml();
		xmlToObject();
	}

}