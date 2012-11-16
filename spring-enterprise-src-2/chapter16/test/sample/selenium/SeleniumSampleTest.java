package sample.selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class SeleniumSampleTest {
	
	WebDriver driver = null;

	@Before
	public void init() {
	    driver = new HtmlUnitDriver();
	}
	
	@Test
	public void testFormPost(){
		//��ȫװ��ҳ��󽫿��Ʒ��ظ����Խű�
		//ע�⣺��ҳ���ֺܶ�AJAX����ʱ���ýӿ��޷�ȷ��ҳ���Ƿ���ȫװ�أ�������Ҫʹ��"waits"
		//navigate().to()��get()������ȫһ����
		driver.get("http://www.google.com"); 
		
		//�������ǰ���ͺ���
		//driver.navigate().forward();
		//driver.navigate().back();

		
		//��XPATH���ص�һ��ƥ�䵽��Ԫ�أ����û��ƥ�䵽���׳�NoSuchElementException��
		//element = driver.findElement(By.xpath( "//input[@id=��passwd-id��]" ));
		WebElement element = driver.findElement(By.name("q"));  
		
		//�κ�ҳ��Ԫ�ض����Ե���sendKeys��
		//������Բ���һЩ��ݷ�ʽ�������̵�ÿ�����붼�Ǹ������ı����ĺ���
		//element.clear(); ����ı�������
		element.sendKeys("Cheese!");     
	    
		
		//1. driver.findElement(By.id( "submit" )).click();
		//2. element.submit(); Ҫ��element�����ڱ��У������׳�NoSuchElementException
		element.submit();       
		
		// Check the title of the page         
		//System.out.println("Page title is: " + driver.getTitle());
		
		
		/**
		//Cookies������������Ŀ��url���ϣ�
		driver.get( "http://www.example.com" );
		Cookie cookie = new Cookie( "key" , "value" );
		driver.manage().addCookie(cookie);
		
		Set<Cookie> allCookies = driver.manage().getCookies();
		for (Cookie loadedCookie : allCookies) {
		    System.out.println(String.format( "%s -> %s" , loadedCookie.getName(), loadedCookie.getValue()));
		}
		**/


		

	}
	
	public void testWindowAndFrame(){
		//1 .�������Ĵ���֮���ƶ���switchTo
		//������ͨ��js���ߴ򿪴��ڵ����ӻ�ȡ�������ƣ�
		driver.switchTo().window( "windowName" ); 
		//2. Ҳ��ͨ�����ھ���л���
		for (String handle : driver.getWindowHandles()) {
		driver.switchTo().window(handle);
		}
		
		//3. frame֮���л������л���iframe��
		driver.switchTo().frame( "frameName" );
		//ͨ����������subframe��
		//��frameName�ĵ�һ��subframe������child��frame��
		driver.switchTo().frame( "frameName.0.child" ); 
	}
	
	@Test
	public void testLogin() {
		driver.get("http://www.iteye.com/login");
		driver.findElement(By.id("user_name")).sendKeys("jeast");
		driver.findElement(By.id("password")).sendKeys("mjulkx2004");
		driver.findElement(By.id("button")).click();
		System.out.println("Page title is: " + driver.getTitle()); 	
		System.out.println("Page title is: " + driver.getPageSource()); 	
		//driver.findElement(By.linkText("My Matches")).click();
		//driver.findElement(By.linkText("New")).click();
		/*try {
			while (true) {
				try {
					driver.findElement(By.linkText("View Match Details"))
							.click();
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					driver.findElement(By.linkText("Request my photo")).click();
				} catch (Exception e) {

				}
				driver.findElement(By.linkText("Send her a Message")).click();
				driver.findElement(By.name("chooseQuestionsButton.x")).click();
				// Send Questions
				driver.findElement(By.linkText("Return to My Matches")).click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		driver.quit();

	}
		 
	
}
