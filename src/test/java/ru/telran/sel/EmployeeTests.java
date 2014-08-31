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
	@Test
	public void testAddEmpl() throws Exception {
		openPage();
		clickToLogin();
		fillLoginForm(new LoginData("demo30", "1234"));
		clickOnEnter();
		goToMyComp();
		// goToSettings();
		// setSettings();
		goToEmployees();
		openAddEmplWindow();
				
		fillpersData("/params.data");
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

	private void fillpersData(String path) {
		
		ArrayList params =rpf.getParameters(path);
		ArrayList tags = rpf.getTags(path);
		
		for(int i=0;i<params.size();i++){
			driver.findElement(By.id((String)tags.get(i))).clear();
			driver.findElement(By.id((String)tags.get(i))).sendKeys((String)params.get(i));
		}
		
	}

}
