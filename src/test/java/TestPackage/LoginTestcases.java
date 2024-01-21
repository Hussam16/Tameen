package TestPackage;

import java.awt.AWTException;

import org.testng.annotations.Test;

import PageObjects.CustomerPage;
import PageObjects.LoginPage;
import PageObjects.SideMenu;

public class LoginTestcases extends TestClass {

	LoginPage loginPage;
	SideMenu sideMenu;
	CustomerPage customerPage;

	@Test(description = "Verify the sucessfull login using vaild username and password")
	public void verifySucessfulLogin() throws InterruptedException, AWTException {

		loginPage = new LoginPage(driver);
		sideMenu = new SideMenu(driver);
		customerPage = new CustomerPage(driver);
		

		loginPage.loginToPortal();
		customerPage.clickAddCustomerButton();
		customerPage.fillRequiredFields("asdas", "01063113874", "24117480101843");
		//sideMenu.clickSideMenuIteam();
		loginPage.logOut();

	}




	@Test(description = "Full customer creation cycle")
	public void createCustomerFullCycle() throws InterruptedException, AWTException {
		loginPage = new LoginPage(driver);
		customerPage = new CustomerPage(driver);
		loginPage.loginToPortal();
		//customerPage.clickAddCustomerButton();
//		driver.browser().maximizeWindow();
//		customerPage.fillRequiredFields("HussffffadfsdSam", "01036123794", "24113480101843");
		customerPage.searchCustomer("jhkhjkh");
		
		
	}


}
