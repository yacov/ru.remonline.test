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

import ru.telran.sel.pages.TestBase;
public class LoginTests extends ru.telran.sel.pages.TestBase {
private StringBuffer verificationErrors = new StringBuffer () ;


@Test(groups = "positive", dataProviderClass = DataProviders.class, dataProvider = "usersSimple")
public void loginTest (String username, String password) throws Exception {
   
	openPage();
	clickToLogin();
	LoginData login = new LoginData();
	LoginData.userName = username;
	LoginData.password = password;
    fillLoginForm(login);
    clickOnEnter();
    assertTrue(isLoggedIn());
    

}

@Test(groups = "negative",dataProviderClass = DataProviders.class, dataProvider = "usersSimpleNeg")
public void loginNegativeTest (String username, String password) throws Exception {
	
	openPage();
	clickToLogin();
	LoginData login = new LoginData();
	LoginData.userName = username;
	LoginData.password = password;
    fillLoginForm(login);
    clickOnEnter();
    
    assertTrue(isNotLoggedIn());
    

}

@AfterMethod
public void mayBeLogout() {
  if (isLoggedIn()) {
	  exitToMain();
  }
  
}



}
