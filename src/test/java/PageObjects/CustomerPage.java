package PageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.ibm.db2.jcc.am.dr;
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
	private By advancedSearchButton=By.cssSelector("button[class='btn btn-secondary m-l-10']");
	
	private By registerationDate=By.cssSelector("[data-qa='db-CustomerList-AdvFilter-FromRegistrationDate']");
	private By yearDropdown=By.cssSelector("select[aria-label='Select year']");
	private By monthDropdown=By.cssSelector("select[aria-label='Select month']");
	
	private By customerSearch = By.cssSelector("input[name='FullName']");
	private By customerCardName = By.xpath("//a[contains(@href, 'update-customer')]");
	private By noSearchResults = By.cssSelector("div[class='alert col-12 alert-info text-center fade show']");
	//private By elementLocator=By.cssSelector("button[name='SaveAndCreateVehiclePolicy']");
	private By elementLocator=By.xpath("(//div[@class='col-md-6'])[1]");
	private By counter=By.cssSelector("div[class='col-md-12 row justify-content-end']");

	public CustomerPage(WebDriver driver) {

		this.driver = driver;
	}

	
    public static String generateRandomNationalID() {
        // Format: 292120601017XX, where XX is a random 5-digit number

        // Fixed part of the national ID
        String fixedPart = "292120601017";

        // Generate a random 5-digit number
        String randomDigits = String.format("%05d", new Random().nextInt(100000));

        // Concatenate the fixed part and the random digits
        return fixedPart + randomDigits;
    }
    
    public static String generateRandomMobileNumber() {
        // Format: 01234018348, where the last 5 digits are random

        // Fixed part of the mobile number
        String fixedPart = "012340183";

        // Generate a random 5-digit number
        String randomDigits = String.format("%05d", new Random().nextInt(100000));

        // Concatenate the fixed part and the random digits
        return fixedPart + randomDigits;
    }
	
	public void addNewCustomer() throws AWTException {
		
		driver.element().click(By.cssSelector("a[class='btn btn-primary']"));
		driver.element().type(By.cssSelector("input[data-qa='input-Customer-FullName']"), "Hussam");
		driver.element().type(By.cssSelector("input[data-qa='input-Customer-MobileNo']"), generateRandomMobileNumber());
		driver.element().type(By.cssSelector("input[data-qa='input-Customer-NationalId']"), generateRandomNationalID());
		zoomOut();
		driver.element().click(By.xpath("(//button[@name='save'])[1]"));
		zoomIn();
		driver.element().click(By.cssSelector("button[aria-label='Close']"));
	}
	
	public void searchByNahtionalID() {
		
		driver.element().click(advancedSearchButton);
		driver.element().click(registerationDate);
		driver.element().select(yearDropdown, "2014");
		driver.element().select(monthDropdown, "December");
		driver.getDriver().findElements(By.cssSelector("[class='btn-light']")).get(0).click();
		driver.element().type(By.cssSelector("[data-qa='input-CustomerList-AdvFilter-NationalID']"),"29312060787878");
		driver.element().click(By.cssSelector("[data-qa='btn-CustomerList-AdvFilter-Search']"));
		driver.element().verifyThat(customerCardName).text().isEqualTo("jhhkhj").perform();
		
		
		
	}
	
	
	public void searchByMobNum() {
		
		driver.element().click(advancedSearchButton);
		driver.element().click(registerationDate);
		driver.element().select(yearDropdown, "2014");
		driver.element().select(monthDropdown, "December");
		driver.getDriver().findElements(By.cssSelector("[class='btn-light']")).get(0).click();
		driver.element().type(By.cssSelector("[data-qa='input-CustomerList-AdvFilter-Mobile']"),"01063113894");
		driver.element().click(By.cssSelector("[data-qa='btn-CustomerList-AdvFilter-Search']"));
		driver.element().verifyThat(customerCardName).text().isEqualTo("jhhkhj").perform();
		
		
		
	}
	
	public void getCustomerCount() {
		
		driver.element().verifyThat(counter).isVisible().perform();
	 	
	}
	
	public void refreshPage() {
		driver.getDriver().navigate().refresh();
	}
	
	public void searchCustomerByName() {
		
		driver.element().type(customerSearch, "Kaley").keyPress(customerSearch, Keys.ENTER);
		driver.element().verifyThat(customerCardName).text().isEqualTo("Kaley").perform();
		
	
		
		
	}
	
	
	public void clickAddCustomerButton() {
		driver.element().click(addCustomerBttn);
		driver.element().assertThat(customerForm).isVisible().perform();

	}
	
	public void enterReqFields(String fullName, String mob, String NatID) {

//		driver.element().type(nameTxt, fullName);
//		driver.element().type(mobileTxt, mob);
//		driver.element().type(nationalTxt, NatID);
		driver.element().scrollToElement(savebutton);
		JavascriptExecutor js = (JavascriptExecutor) driver.getDriver();
		String command="document.body.style.zoom='50%'";
		js.executeAsyncScript(command);
		driver.element().scrollToElement(savebutton);
//		driver.element().scrollToElement(elementLocator);
		driver.element().click(savebutton);
		
	}
	
	
	public void zoomOut() throws AWTException {
		Robot robot = new Robot();
		System.out.println("About to zoom out");
		for (int i = 0; i < 8; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
	}
	
	public void zoomIn() throws AWTException {
		for (int i = 0; i < 8; i++) {
			Robot robot = new Robot();
		    robot.keyPress(KeyEvent.VK_CONTROL);
		    robot.keyPress(KeyEvent.VK_ADD);
		    robot.keyRelease(KeyEvent.VK_ADD);
		    robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		
	}

	public void fillRequiredFields(String fullName, String mob, String NatID)

			throws InterruptedException, AWTException {
		// TODO Auto-generated method stub

		driver.element().type(nameTxt, fullName);
		driver.element().type(mobileTxt, mob);
		driver.element().type(nationalTxt, NatID);
		zoomOut();
		driver.element().click(savebutton);
		driver.element().assertThat(errorMessage).isVisible().perform();
		zoomIn();
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
