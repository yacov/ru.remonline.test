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
public class EmployeeTest extends ru.telran.sel.pages.TestBase {
private boolean acceptNextAlert = true;
private StringBuffer verificationErrors = new StringBuffer () ;
@Test
public void testAddEmpl () throws Exception {
	openPage();
	clickToLogin();
    fillLoginForm(new LoginData("demo30", "1234"));
    clickOnEnter();
    goToMyComp();
    //goToSettings();
   // setSettings();
    goToEmployees();
    openAddEmplWindow();
    fillpersData(new PersData("correctusername", "correctuserlog", "coruserpassord", "1234567890123", "mailmail@em.il", "6125", "9"));
    saveEmp();
}


private void openAddEmplWindow() throws InterruptedException {
	driver.findElement(By.xpath("//div[@id='container']//button[@class='js-add-button pull-left btn btn-sm btn-success']")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//div[5]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }
}


private void goToEmployees() {
	driver.findElement(By.xpath("//a[contains(@href, '#!/company/employee')]")).click();
}


private void setSettings() {
	driver.findElement(By.id("l-settings-phonemask")).clear();
    driver.findElement(By.id("l-settings-phonemask")).sendKeys("");
    driver.findElement(By.xpath("//div[@id='container']//button[class='btn btn-primary']")).click();
}


private void goToSettings() {
	driver.findElement(By.xpath("//a[@href = '#!/company/settings']")).click();
}


private void goToMyComp() {
	driver.findElement(By.xpath("//ul//a[@href='#!/company']")).click();
}


private void saveEmp() {
	driver.findElement(By.xpath("//div[@class='form-group h-mt-15']//button[@class='btn btn-primary js-submit-dialog']")).click();
}


private void fillpersData(PersData parameterObject) {
	driver.findElement(By.id("l-e-name")).clear();
    driver.findElement(By.id("l-e-name")).sendKeys(parameterObject.username);
    driver.findElement(By.id("l-e-login")).clear();
    driver.findElement(By.id("l-e-login")).sendKeys(parameterObject.login);
    driver.findElement(By.id("l-e-password")).clear();
    driver.findElement(By.id("l-e-password")).sendKeys(parameterObject.pass);
    driver.findElement(By.id("l-e-phone")).clear();
    driver.findElement(By.id("l-e-phone")).sendKeys(parameterObject.phone);
    driver.findElement(By.id("l-e-email")).clear();
    driver.findElement(By.id("l-e-email")).sendKeys(parameterObject.mail);
    new Select(driver.findElement(By.xpath("//select"))).selectByValue(parameterObject.selectVal);
    driver.findElement(By.id("l-e-percent")).clear();
    driver.findElement(By.id("l-e-percent")).sendKeys(parameterObject.percent);
    driver.findElement(By.xpath("//td/input")).click();

}


}
