package com.baobaotao.web.selenium;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.opera.core.systems.OperaDriver;

public class LoginControllerTest {
	//����WebDriver
	WebDriver driver = null;
	
	@Before
	public void init() {
	    driver = new HtmlUnitDriver(); //IE
	}
	@Test
	public void loginCheck(){
		//��ȫװ��ҳ��󽫿��Ʒ��ظ����Խű�
		//navigate().to()��get()������ȫһ����
		driver.get("http://localhost/chapter16/index.html"); 

		//��XPATH���ص�һ��ƥ�䵽��Ԫ�أ����û��ƥ�䵽���׳�NoSuchElementException��
		//element = driver.findElement(By.xpath( "//input[@id=��xxx��]" ));
		WebElement userName = driver.findElement(By.name("userName"));  
		WebElement password = driver.findElement(By.name("password"));
		
		//�κ�ҳ��Ԫ�ض����Ե���sendKeys��
		userName.sendKeys("tom");     
		password.sendKeys("1234");  
		
		//�ύ��
		driver.findElement(By.id( "loginBtn" )).click();
		//driver.findElement(By.id( "submit" )).submit(); Ҫ��element�����ڱ��У������׳�NoSuchElementException

		//��֤���ص���ҳ�� main.jsp
		assertThat(driver.getTitle(), equalTo("��������̳"));
		assertThat(driver.getPageSource(), containsString("tom"));
		WebElement body  = driver.findElement(By.xpath( "//body" ));
		assertThat(body.getText(), containsString("tom,��ӭ�����뱦������̳"));
	}
	
}
