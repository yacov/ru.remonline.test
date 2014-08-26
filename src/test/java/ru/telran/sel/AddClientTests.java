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

import ru.telran.sel.LoginData;
public class AddClientTests extends ru.telran.sel.pages.TestBase {
private StringBuffer verificationErrors = new StringBuffer () ;
@Test
public void testAddClient (String username, String password) throws Exception {
	openPage();
	clickToLogin();
	fillLoginForm(new LoginData("Alexxxxx", "159357ab"));
    clickOnEnter();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//a[@href=\"#!/clients\"]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    ClicOnClient();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//button[@class=\"js-add-button pull-left btn btn-sm btn-success\"]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    ClicOnAddClient();
    FillFormAddClient(new FillFormAddClientParameter("Alexander", "3333333333", "2rab74@mail.ru", "Rossia"));
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//button[@class=\"btn btn-primary js-submit-dialog\"]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//button[@class=\"btn btn-primary js-submit-dialog\"]")).click();
    driver.findElement(By.xpath("//a[@class='b-navigation-control__item']")).click();
}



private void FillFormAddClient(FillFormAddClientParameter fillformclient) {
	driver.findElement(By.id("l-c-name")).clear();
    driver.findElement(By.id("l-c-name")).sendKeys(fillformclient.name);
    driver.findElement(By.id("l-c-phone")).clear();
    driver.findElement(By.id("l-c-phone")).sendKeys(fillformclient.telephon);
    driver.findElement(By.id("l-c-email")).clear();
    driver.findElement(By.id("l-c-email")).sendKeys(fillformclient.email);
    driver.findElement(By.id("l-c-address")).clear();
    driver.findElement(By.id("l-c-address")).sendKeys(fillformclient.adress);
}



private void ClicOnAddClient() {
	driver.findElement(By.xpath("//button[@class=\"js-add-button pull-left btn btn-sm btn-success\"]")).click();
}



private void ClicOnClient() {
	driver.findElement(By.xpath("//a[@href=\"#!/clients\"]")).click();
}




}
