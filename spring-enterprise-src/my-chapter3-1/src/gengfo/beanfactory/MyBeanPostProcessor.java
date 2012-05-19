package gengfo.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor{

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		
		if (beanName.equals("car")){
			Car car = (Car)bean;
			if (car.getColor() == null){
				System.out.println("����MyBeanPostProcessor.postProcessAfterInitialization color Ϊ�գ�����Ĭ����ɫblack");
				car.setColor("��ɫ");
			}else{
				System.out.println("����MyBeanPostProcessor.postProcessAfterInitialization");
				System.out.println("colore is��"+car.getColor());
			}
		}
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		if (beanName.equals("car")){
			Car car = (Car)bean;
			if (car.getMaxSpeed()>=200){
				System.out.println("����MyBeanPostProcessor.postProcessBeforeInitialization maxSpeed����Ϊ200");
				car.setMaxSpeed(200);
			}
		}
		return bean;
	}
	

}
