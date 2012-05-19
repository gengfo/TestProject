package gengfo.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Car implements BeanFactoryAware,BeanNameAware, InitializingBean,DisposableBean{
	
	public Car(){
		System.out.println("����Car()���캯��");
	}
	
	private String brand;
	private String color;
	private int maxSpeed;
	
	private BeanFactory beanFactory;
	private String beanName;
	
	public void introduce(){
		System.out.println("in introduce brand:"+brand+";color:"+color+";maxSpeed:"+maxSpeed);
	}
	
	

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("����BeanFactoryAware.setBeanFactory()");
		this.beanFactory = beanFactory;
	}

	public void setBeanName(String name) {
		System.out.println("����BeanNameAware.setBeanName()");
		this.beanName=name;
		
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("����InitializingBean.afterPropertiesSet()");
		
	}

	public void destroy() throws Exception {
		System.out.println("����DisposableBean.destroy()");
	}
	
	public void myInit(){
		System.out.println("����init-method�ƶ���myInit(),��maxSpeed����Ϊ20");
		this.maxSpeed = 20;
	}
	
	public void myDestroy(){
		System.out.println("����destroy-method�ƶ���myDestroy()");
		this.maxSpeed = 20;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	

}
