package PageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.shaft.driver.SHAFT;
import com.shaft.driver.SHAFT.GUI.WebDriver;
import com.shaft.gui.element.TouchActions.KeyboardKeys;

public class CustomerPage {

	private SHAFT.GUI.WebDriver driver;
	private By addCustomerBttn = By.cssSelector(".btn.btn-primary");
	private By customerForm = By.xpath("(//form[@class='ng-untouched ng-pristine ng-invalid'])[1]");
	private By nameTxt = By.xpath("(//input[@name='FullName'])[1]");
	private By mobileTxt = By.xpath("(//input[@name='MobileNo'])[1]");
	private By nationalTxt = By.xpath("//input[@name='NationalId']");
	private By savebutton = By.xpath("(//button[@name='save'])[1]");
	private By errorMessage = By.cssSelector(".modal-content");
	private By closeButton = By.cssSelector("button[aria-label='Close']");
	private By customerSearch = By.cssSelector("input[name='FullName']");
	private By customerCardName = By.xpath("//a[contains(@href, 'update-customer')]");
	private By noSearchResults = By.cssSelector("div[class='alert col-12 alert-info text-center fade show']");

	public CustomerPage(WebDriver driver) {

		this.driver = driver;
	}

	public void clickAddCustomerButton() {
		driver.element().click(addCustomerBttn);
		driver.element().assertThat(customerForm).isVisible().perform();

	}

	public void fillRequiredFields(String fullName, String mob, String NatID)

			throws InterruptedException, AWTException {
		// TODO Auto-generated method stub

		driver.element().type(nameTxt, fullName);
		driver.element().type(mobileTxt, mob);
		driver.element().type(nationalTxt, NatID);

		Robot robot = new Robot();
		System.out.println("About to zoom out");
		for (int i = 0; i < 8; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}

		driver.element().click(savebutton);
		driver.element().assertThat(errorMessage).isVisible().perform();
		driver.element().click(closeButton);

	}

	public void searchCustomer(String searchByName) {

		driver.element().type(customerSearch, searchByName);
		driver.element().keyPress(customerSearch, Keys.ENTER);
		// driver.element().assertThat(customerCardName).text().equalsIgnoringCaseSensitivity(searchByName).perform();

//		if ((driver.element().getElementsCount(customerCardName) >= 1)) {
//			driver.element().assertThat(noSearchResults).doesNotExist().perform();
//			
//		}
//		else {
//			driver.element().assertThat(noSearchResults).exists().perform();
//		}		;

		int numOfElements = driver.element().getElementsCount(customerCardName);

		if (numOfElements > 0) {

			driver.element().assertThat(customerCardName).text().equalsIgnoringCaseSensitivity(searchByName);

		}

		else {
			driver.element().assertThat(noSearchResults).exists().perform();
		}

	}
}
