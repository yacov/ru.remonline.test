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

public class RegTests extends ru.telran.sel.pages.TestBase {
private boolean acceptNextAlert = true;
private StringBuffer verificationErrors = new StringBuffer () ;


@Test
public void testUntitled () throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("//span[@class = 'js-auth-signup b-navbar__entrance h-ml-15']")).click();
    driver.findElement(By.id("l-auth-email")).clear();
    driver.findElement(By.id("l-auth-email")).sendKeys("volf1212@gmail.com");
    driver.findElement(By.id("l-auth-login")).clear();
    driver.findElement(By.id("l-auth-login")).sendKeys("Tor");
    driver.findElement(By.id("l-auth-pass")).clear();
    driver.findElement(By.id("l-auth-pass")).sendKeys("hammer1");
    driver.findElement(By.xpath("//div[5]/button")).click();
    try {
      assertTrue(isElementPresent(By.xpath("//span[@class = 'b-navigation-control__item h-mt-3 h-branch-1']")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
}


}
