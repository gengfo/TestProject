package com.baobaotao.oxm.xstream.annotations;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Date;

import com.baobaotao.domain.LoginLog;
import com.baobaotao.domain.User;
import com.baobaotao.utils.ResourceUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
public class XStreamAnnotationSample {
	private static XStream xstream;
	static{
	    xstream = new XStream(new DomDriver());
	    xstream.processAnnotations(User.class);
		xstream.processAnnotations(LoginLog.class);
		//xstream.autodetectAnnotations(true); 
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
    public static void objectToXml()throws Exception{
    	User user = getUser();
        FileOutputStream fs = new FileOutputStream("D:\\masterSpring\\chapter14\\out\\XStreamAnnotationSample.xml");
        OutputStreamWriter writer = new OutputStreamWriter(fs, Charset.forName("UTF-8"));    
        xstream.toXML(user, writer);
    }
    
    /**
     * XMLת��ΪJAVA����
     */
    public static User xmlToObject()throws Exception{
    	FileInputStream fis = new FileInputStream("D:\\masterSpring\\chapter14\\out\\XStreamAnnotationSample.xml");
    	InputStreamReader reader = new InputStreamReader(fis, Charset.forName("UTF-8")); 
        User user = (User) xstream.fromXML(fis);
        for(LoginLog log : user.getLogs()){
        	if(log!=null){
        		System.out.println("����IP: " + log.getIp());
        		System.out.println("����ʱ��: " + log.getLoginDate());
            }
        }
        return user;
    }

    public static void main(String[] args)throws Exception {
        objectToXml();
        xmlToObject();
    }
}
