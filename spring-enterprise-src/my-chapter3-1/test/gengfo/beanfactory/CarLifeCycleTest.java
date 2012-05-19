package gengfo.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class CarLifeCycleTest {
	
	public static void LifeCycleBeanFactory(){
		Resource res = new ClassPathResource("gengfo/beanfactory/MyBean.xml");
		BeanFactory bf = new XmlBeanFactory(res);
		
		((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyBeanPostProcessor());
		
		Car car1 = (Car)bf.getBean("car");
		car1.introduce();
		//car1.setColor("¼tÉ«");
		//car1.introduce();
	
		
		
		
	}
	
	public static void main(String args[]){
		
		LifeCycleBeanFactory();
		
	}

}
