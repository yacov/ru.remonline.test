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
public class LoginTest extends ru.telran.sel.pages.TestBase {
private boolean acceptNextAlert = true;
private StringBuffer verificationErrors = new StringBuffer () ;


@Test
public void loginTest () throws Exception {
   openPage();
	clickToLogin();
    fillLoginForm(new LoginData("demo30", "1234"));
    clickOnEnter();
    
    //verify 
    try {
      assertTrue(isElementPresent(By.xpath("//span")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    
    exitToMain();

}

private void exitToMain() {
	driver.findElement(By.cssSelector("span.text-label")).click();
}

//@Test
public void loginVoidTest () throws Exception {
	
   openPage();
	clickToLogin();
    fillLoginForm(new LoginData("", ""));
    clickOnEnter(); 
    
    try {
        assertTrue(isElementPresent(By.cssSelector("#tooltip820641 > div.tooltip-inner")));
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }

}

private void clickOnEnter() {
	driver.findElement(By.xpath("//div[3]/button")).click();
}

private void fillLoginForm(LoginData namePass) {
    driver.findElement(By.id("l-auth-login")).clear();
    driver.findElement(By.id("l-auth-login")).sendKeys(namePass.userName);
    driver.findElement(By.id("l-auth-pass")).clear();
    driver.findElement(By.id("l-auth-pass")).sendKeys(namePass.password);
}

private void clickToLogin() {
    driver.findElement(By.xpath("//li[5]/span")).click();
}

private void openPage() {
	driver.get(baseUrl + "/");
}

private boolean isElementPresent (By by) {
try {
driver.findElement (by);
return true;
} catch (NoSuchElementException e) {
return false;
}
}

private String closeAlertAndGetItsText() {
try {
Alert alert = driver.switchTo().alert();
String alertText = alert.getText ();
if (acceptNextAlert) {
alert.accept();
} else {
alert.dismiss();
}
return alertText;
} finally {
acceptNextAlert = true;
}
}



}
