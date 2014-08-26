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
public class RegistTests extends ru.telran.sel.pages.TestBase {
private boolean acceptNextAlert = true;
private StringBuffer verificationErrors = new StringBuffer () ;
@Test
public void testRegistr1 () throws Exception {
    openPage();
    driver.findElement(By.xpath("//span[@class='js-auth-signup b-navbar__entrance h-ml-15']")).click();
    driver.findElement(By.id("l-auth-email")).clear();
    driver.findElement(By.id("l-auth-email")).sendKeys("Levinshtein@mail.ru");
    driver.findElement(By.id("l-auth-login")).click();
    driver.findElement(By.id("l-auth-login")).clear();
    driver.findElement(By.id("l-auth-login")).sendKeys("ksusha12345");
    driver.findElement(By.id("l-auth-pass")).clear();
    driver.findElement(By.id("l-auth-pass")).sendKeys("123456");
    driver.findElement(By.xpath("//button[@class='b-button_type_cta b-button_color_green js-submit']")).click();
}
}
