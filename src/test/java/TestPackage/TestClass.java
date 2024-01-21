package TestPackage;

import com.shaft.driver.SHAFT;

import PageObjects.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class TestClass {
	protected SHAFT.GUI.WebDriver driver;
	SHAFT.TestData.JSON testData;

	@BeforeClass
	public void beforeClass() {
		driver = new SHAFT.GUI.WebDriver();
		testData = new SHAFT.TestData.JSON("simpleJSON.json");
		driver.browser().deleteAllCookies();
		

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

}
