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

@Test (dataProviderClass = DataProviders.class, dataProvider = "optionsFromFile")
public void testOption (String companyName, String companyAddress, String countryfromList) throws Exception {    
	
	openPage();
	clickToLogin();    
    fillLoginForm(new LoginData("Nastya3", "qwerty123456"));    
    clickOnEnter();
   
    clickMyCompany();
    clickSetting();
    OptionsSettingData fillSettings = new OptionsSettingData();
    fillSettings.companyName = companyName;
    fillSettings.companyAddress = companyAddress;
    fillSettings.countryfromList = countryfromList;
    fillSettingForm(fillSettings);
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
private void fillSettingForm(OptionsSettingData settingsData) {
    
    driver.findElement(By.id("l-settings-name")).clear();
    driver.findElement(By.id("l-settings-name")).sendKeys(settingsData.companyName);
    driver.findElement(By.id("l-settings-address")).clear();
    driver.findElement(By.id("l-settings-address")).sendKeys(settingsData.companyAddress);
    new Select(driver.findElement(By.id("js-settings-country"))).selectByVisibleText(settingsData.countryfromList);
	
}
private void clickSetting() {
	driver.findElement(By.xpath(".//*[@id='container']//ul[@class='nav nav-tabs h-mb-20']//a[@href='#!/company/settings']")).click();
}
private void clickMyCompany() {
	driver.findElement(By.xpath("//a[@href='#!/company']")).click();
}

}
