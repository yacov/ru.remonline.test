package ru.telran.sel;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class EmployeeTests extends ru.telran.sel.pages.TestBase {
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private ReadingParamFiles rpf = new ReadingParamFiles();
	@Test(groups = "positive", dataProviderClass = DataProviders.class, dataProvider = "loadEmpDataFromFile")
	public void testAddEmpl(String name,String login,String password,String phone,String email,String percent) throws Exception {
		openPage();
		clickToLogin();
		fillLoginForm(new LoginData("demo30", "1234"));
		clickOnEnter();
		goToMyComp();
		// goToSettings();
		// setSettings();
		goToEmployees();
		openAddEmplWindow();
				
		fillpersData(name, login, password, phone, email, percent);
		setSelect("6125");
		checkBox();
		
		saveEmp();
		exitToMain();
	}

	private void openAddEmplWindow() throws InterruptedException {
		driver.findElement(
				By.xpath("//div[@id='container']//button[@class='js-add-button pull-left btn btn-sm btn-success']"))
				.click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.xpath("//div[5]")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
	}

	private void goToEmployees() {
		driver.findElement(
				By.xpath("//a[contains(@href, '#!/company/employee')]"))
				.click();
	}

	private void setSettings() {
		driver.findElement(By.id("l-settings-phonemask")).clear();
		driver.findElement(By.id("l-settings-phonemask")).sendKeys("");
		driver.findElement(
				By.xpath("//div[@id='container']//button[class='btn btn-primary']"))
				.click();
	}

	private void goToSettings() {
		driver.findElement(By.xpath("//a[@href = '#!/company/settings']"))
				.click();
	}

	private void goToMyComp() {
		driver.findElement(By.xpath("//ul//a[@href='#!/company']")).click();
	}

	private void saveEmp() {
		driver.findElement(
				By.xpath("//div[@class='form-group h-mt-15']//button[@class='btn btn-primary js-submit-dialog']"))
				.click();
	}
	
	private void setSelect(String value){
		new Select(driver.findElement(By.xpath("//select")))
		.selectByValue(value);

	}
	
	private void checkBox(){
		driver.findElement(By.xpath("//td/input")).click();
	}

	private void fillpersData(String name,String login,String password,String phone,String email,String percent) {
				
		driver.findElement(By.id("l-e-name")).clear();
		driver.findElement(By.id("l-e-name")).sendKeys(name);
		driver.findElement(By.id("l-e-login")).clear();
		driver.findElement(By.id("l-e-login")).sendKeys(login);
		driver.findElement(By.id("l-e-password")).clear();
		driver.findElement(By.id("l-e-password")).sendKeys(password);
		driver.findElement(By.id("l-e-phone")).clear();
		driver.findElement(By.id("l-e-phone")).sendKeys(phone);
		driver.findElement(By.id("l-e-email")).clear();
		driver.findElement(By.id("l-e-email")).sendKeys(email);
		driver.findElement(By.id("l-e-percent")).clear();
		driver.findElement(By.id("l-e-percent")).sendKeys(percent);
	}

}
