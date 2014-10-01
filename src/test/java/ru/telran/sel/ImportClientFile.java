package ru.telran.sel;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.annotations.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ImportClientFile extends ru.telran.sel.pages.TestBase {
	
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer () ;
	
	@Test
	public void testFile_import() throws Exception {
		openPage();
		clickToLogin();
		fillLoginForm(new LoginData("qazwsx", "qazwsx"));
		clickOnEnter();
		//driver.get("/app#!/clients");
		driver.findElement(By.xpath("//a[@href='#!/clients']")).click();
		driver.findElement(By.xpath("//button[@class='h-ml-15 pull-left btn btn-sm btn-default js-import js-tooltip']")).click();
		driver.findElement(By.xpath("//div[@class='js-spinner-wp h-mt-25']//button")).click();
		((WebElement) driver).sendKeys("D:/dasha/client.xls");
		driver.findElement(By.xpath("//button[@class='btn btn-primary js-do-import']")).click();
		
		checkImport();
	}
	
	public void checkImport(){
	    try {
	        assertTrue(isElementPresent(By.xpath("//i[@class=\"h-mt-20 b-file-import__icon b-file-import__icon_type_success\"]")));
	      } catch (Error e) {
	    	  verificationErrors.append(e.toString());
	      }
	     
	    try {
	        assertEquals("Импорт клиентов завершен успешно", driver.findElement(By.xpath("//h3[@class=\"col-xs-12 h-p-0 h-mt-20 h-ta-c\"]")).getText());
	      } catch (Error e) {
	    	  verificationErrors.append(e.toString());
	      }
	}
}