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
private StringBuffer verificationErrors = new StringBuffer () ;


@Test(dataProviderClass = DataProviders.class, dataProvider = "users")
public void loginTest (String username, String password) throws Exception {
   
	openPage();
	clickToLogin();
	LoginData login = new LoginData();
	login.userName = username;
	login.password = password;
    fillLoginForm(login);
    clickOnEnter();
    
    //verify 
    try {
      assertTrue(isElementPresent(By.xpath("//span")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    
    exitToMain();

}

//@Test(dataProviderClass = DataProviders.class, dataProvider = "loadUserFromFile")
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



}
