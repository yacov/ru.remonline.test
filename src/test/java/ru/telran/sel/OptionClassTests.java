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
public class OptionClassTests extends ru.telran.sel.pages.TestBase {
private boolean acceptNextAlert = true;
private StringBuffer verificationErrors = new StringBuffer () ;

@Test
public void testOption () throws Exception {    
	
	openPage();
	clickToLogin();    
    fillLoginForm(new LoginData("Nastya3", "qwerty123456"));    
    clickOnEnter();
   
    clickMyCompany();
    clickSetting();
    fillSettingForm();
    clickSave();
    try {
      assertEquals("Успешно сохранено", driver.findElement(By.xpath("//div[5]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
        
    clickToLogin();
 }
private void clickSave() {
	driver.findElement(By.xpath("//*[@class='btn btn-primary h-mt-20']")).click();
}
private void fillSettingForm() {
    
    driver.findElement(By.id("l-settings-name")).clear();
    driver.findElement(By.id("l-settings-name")).sendKeys("My company");
    driver.findElement(By.id("l-settings-address")).clear();
    driver.findElement(By.id("l-settings-address")).sendKeys("Tartar");
    new Select(driver.findElement(By.id("js-settings-country"))).selectByVisibleText("Молдова");
	
}
private void clickSetting() {
	driver.findElement(By.xpath(".//*[@id='container']//ul[@class='nav nav-tabs h-mb-20']//a[@href='#!/company/settings']")).click();
}
private void clickMyCompany() {
	driver.findElement(By.xpath("//a[@href='#!/company']")).click();
}

}
