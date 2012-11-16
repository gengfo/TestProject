package com.baobaotao.oxm.xstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Locale;
import com.baobaotao.domain.LoginLog;
import com.baobaotao.domain.User;
import com.baobaotao.utils.ResourceUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XStreamSample {
	private static XStream xstream;
	static {
		// new DomDriver()�����ַ�ʽ����Ҫ��xpp3��
		xstream = new XStream(new DomDriver());
	}

	// ��ʼ��ת������
	public static User getUser() {
		LoginLog log1 = new LoginLog();
		LoginLog log2 = new LoginLog();
		log1.setIp("192.168.1.91");
		log1.setLoginDate(new Date());
		log2.setIp("192.168.1.92");
		log2.setLoginDate(new Date());
		User user = new User();
		user.setUserId(1);
		user.setUserName("xstream");
		user.addLoginLog(log1);
		user.addLoginLog(log2);
		return user;
	}

	/**
	 * JAVA����ת��ΪXML
	 */
	public static void objectToXml() throws Exception {
		User user = getUser();
		FileOutputStream outputStream = new FileOutputStream("D:\\masterSpring\\chapter14\\out\\XStreamSample.xml");
		xstream.toXML(user, outputStream);
	}

	/**
	 * XMLת��ΪJAVA����
	 */
	public static User xmlToObject() throws Exception {
		FileInputStream fis = new FileInputStream("D:\\masterSpring\\chapter14\\out\\XStreamSample.xml");
		User u = (User) xstream.fromXML(fis);
		for (LoginLog log : u.getLogs()) {
			if (log != null) {
				System.out.println("����IP: " + log.getIp());
				System.out.println("����ʱ��: " + log.getLoginDate());
			}
		}
		return u;
	}

	public static void main(String[] args) throws Exception {
		objectToXml();
		xmlToObject();
	}
}
