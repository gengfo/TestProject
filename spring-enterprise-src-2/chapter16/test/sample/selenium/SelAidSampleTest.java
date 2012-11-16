package sample.selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.junit.Assert.*;

import com.path_not_tested.selaid.FormHelper;
import com.path_not_tested.selaid.SelectHelper;

/**
 * SelAid ʹ�ÿ��Ժܷ����ʹ�� Selenium 2.0 WebDriver ������ Web Ӧ�ó���
 * �������ṩ�ḻ�Ĺ��� WebDriver �� WebElement �ĳ���㡣
 * ʹ�� SelAid ����д Web ���Գ���ʹ�ò��Ը��Ӽ򵥡��ɶ��Ϳ�ά����
 */
public class SelAidSampleTest {
	WebDriver driver = null;

	@Before
	public void init() {
	    driver = new HtmlUnitDriver();
	}
	@Test
	public void test(){
		
		/**
		WebElement element = driver.findElement(By.id("colors"));
		SelectHelper helper = new SelectHelper(element);
		assertTrue(helper.isMultiSelect());
		assertTrue(helper.isSelected("yellow"));
		assertFalse(helper.isSelected("red"));
		assertFalse(helper.isSelected("fuchsia")); // doesn't exist
		assertArrayEquals(new String[] { "Yellow", "Green" }, helper
				.getSelectedText());
		**/
		
		driver.get("http://www.oschina.net/home/login");
		WebElement element = driver.findElement(By.id("frm_login"));
		FormHelper form = new FormHelper(element);
		assertNotNull(form);
	    
	}

}
