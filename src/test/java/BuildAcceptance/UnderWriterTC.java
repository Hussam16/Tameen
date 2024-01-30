package BuildAcceptance;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;

import PageObjects.CustomerPage;
import PageObjects.LoginPage;
import TestPackage.TestClass;

public class UnderWriterTC extends TestClass {

	LoginPage loginPage;
	CustomerPage customerPage;

	@BeforeMethod
	public void setup() {

		loginPage = new LoginPage(driver);
		customerPage = new CustomerPage(driver);
	}

	@Test(description = "Underwriter Can Filter Customer List With Any Of Critria (regisertaion Date or Mobile No or National Id or commercial register No)")
	public void searchFilterCustomer() {

		loginPage.loginToPortal();
		customerPage.getCustomerCount();
		customerPage.searchCustomerByName("Kaley");
		customerPage.refreshPage();
		customerPage.searchByMobNum();
		customerPage.refreshPage();
		customerPage.searchByNahtionalID();
		loginPage.logOut();
	}
	
	
	@Test(description = "Underwriter Can Add New Customer Save And Add Another One (Individual &Company)")
	public void addNewCustomer() throws AWTException {
		loginPage.loginToPortal();
		customerPage.addNewCustomer();
	}
	
	
	@Test(description = "Underwriter can edit customer data")
	public void editCustomer() throws AWTException {
		
		// Login to the portal
		loginPage.loginToPortal();
		
		//Search for the customer you want to update
		driver.element().type(By.cssSelector("input[name='FullName']"), "Edit User").keyPress(By.cssSelector("input[name='FullName']"), Keys.ENTER);
		
		// Click the update button
		driver.element().click(By.cssSelector("#dropdownAction0"));
		driver.element().click(By.xpath("//a[ @class='dropdown-item' and text()=' Update ']"));
		
		
		// Generate the Random data
		String mobNumber=customerPage. generateRandomMobileNumber();
		String Id=customerPage.generateRandomNationalID();
		
		
		// Edit the user
		//driver.element().clear(By.cssSelector("input[data-qa='input-Customer-MobileNo']"));
		driver.getDriver().findElement(By.cssSelector("input[data-qa='input-Customer-MobileNo']")).clear();

		driver.element().clear(By.cssSelector("input[data-qa='input-Customer-NationalId']"));
		
		
		
		
		driver.element().type(By.cssSelector("input[data-qa='input-Customer-MobileNo']"), mobNumber);
		driver.element().type(By.cssSelector("input[data-qa='input-Customer-NationalId']"), Id);
		customerPage.zoomOut();
		driver.element().click(By.xpath("(//button[@name='save'])[1]"));
		customerPage.zoomIn();
		
		By.cssSelector("div[role='alert']");
		
		driver.element().verifyThat(By.cssSelector("div[role='alert']")).text().isEqualTo("Customer is saved successfully").perform();
		driver.element().click(By.cssSelector("button[aria-label='Close']"));
//		
//		// Verify the user had been edited 
//		
//		
//		driver.element().click(By.xpath("//span[@class='text-end' and text()=' Customers Management ']"));
//		driver.element().click(By.xpath("//span[@class='text-end' and text()=' Customers ']"));
//		
//		// Search for the customer again
//		driver.element().type(By.cssSelector("input[name='FullName']"), "Edit User").keyPress(By.cssSelector("input[name='FullName']"), Keys.ENTER);
//		
//		// Click update button
//		driver.element().click(By.cssSelector("#dropdownAction0"));
//		driver.element().click(By.xpath("//a[ @class='dropdown-item' and text()=' Update ']"));
//		
//		String mob=mobNumber;
//		String uid=Id;
//		
////		driver.element().verifyThat(By.cssSelector("input[data-qa='input-Customer-MobileNo']")).text().isEqualTo(mobNumber).perform();
////		driver.element().verifyThat(By.cssSelector("input[data-qa='input-Customer-NationalId']")).text().isEqualTo(Id).perform();
//		
//		mobNumber=driver.getDriver().findElement(By.cssSelector("input[data-qa='input-Customer-MobileNo']")).getText();
//		String nathionalNumber = driver.getDriver().findElement(By.cssSelector("input[data-qa='input-Customer-NationalId']")).getText();
//		
//		assertEquals("asdsaddas",nathionalNumber);
//		assertEquals("xxxxxxxxxxxxx",mobNumber);
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	@Test
	public void name() {
		
		System.out.println("========================================"+customerPage.generateRandomMobileNumber());
		System.out.println("========================================"+customerPage.generateRandomNationalID());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
