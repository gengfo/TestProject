package com.baobaotao.oxm.castor;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import com.baobaotao.domain.LoginLog;
import com.baobaotao.domain.User;
import com.baobaotao.utils.ResourceUtils;

public class CastorSample {
    public static User getUser(){
    	LoginLog log1 = new LoginLog();
		log1.setIp("192.168.1.91");
		log1.setLoginDate(new Date());
		LoginLog log2 = new LoginLog();
		log2.setIp("192.168.1.92");
		log2.setLoginDate(new Date());
		LoginLog log3 = new LoginLog();
		log3.setIp("192.168.1.93");
		log3.setLoginDate(new Date());
		User user = new User();
		user.setUserName("castor");
		user.addLoginLog(log1);
		user.addLoginLog(log2);
		user.addLoginLog(log3);
		return user;
    }
	/**
	 * JAVA����ת��ΪXML
	 */
	public static void objectToXml() {
		try {
			User user = getUser();
			FileWriter writer = new FileWriter("D:\\masterSpring\\chapter14\\out\\CastorSampe.xml");
			Mapping mapping = new Mapping();
			// ��Mapping.xml�ļ��м���ӳ����Ϣ
			String mappingFile = ResourceUtils.getResourceFullPath(
					CastorSample.class, "mapping.xml");
			mapping.loadMapping(mappingFile);
			Marshaller marshaller = new Marshaller(writer);
			marshaller.setMapping(mapping);
			marshaller.setEncoding("GBK");
			marshaller.marshal(user);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	/**
	 * XMLת��ΪJAVA����
	 */
	public static User xmlToObject() {
		try {
			FileReader reader = new FileReader("D:\\masterSpring\\chapter14\\out\\CastorSampe.xml");
	
			Mapping mapping = new Mapping();
			// ��Mapping.xml�ļ��м���ӳ����Ϣ
			String mappingFile = ResourceUtils.getResourceFullPath(
					CastorSample.class, "mapping.xml");
			mapping.loadMapping(mappingFile);
			Unmarshaller unmar = new Unmarshaller(mapping);
			User u = (User) unmar.unmarshal(reader);
			System.out.println("�û���: " + u.getUserName());
			for (LoginLog log : u.getLogs()) {
				System.out.println("����IP: " + log.getIp());
				System.out.println("����ʱ��: " + log.getLoginDate());
			}
		    return u;
             
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace(System.err);
		}
		return null;
	}

	public static void main(String[] args) {
		objectToXml();
		xmlToObject();
	}
}
