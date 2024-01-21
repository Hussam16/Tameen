package BuildAcceptance;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;

import org.openqa.selenium.By;
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
		customerPage.searchCustomerByName();
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

}
