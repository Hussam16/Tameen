package PageObjects;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.shaft.driver.SHAFT;
import com.shaft.driver.SHAFT.GUI.WebDriver;

public class LoginPage {

	private SHAFT.GUI.WebDriver driver;
	private By userName = By.cssSelector("input[name='userName']");
	private By password = By.cssSelector("input[name='pass']");
	private By loginButton = By.cssSelector(".btn.btn-primary.w-md.waves-effect.waves-light");
	private By pageTitle = By.cssSelector(".page-title");
	private By profileIcon=By.cssSelector(".rounded-circle");
	private By logoutBtn=By.cssSelector("button[tabindex=\"0\"]:nth-of-type(3)");

	public LoginPage(SHAFT.GUI.WebDriver driver) {

		this.driver = driver;
	}

	public void loginToPortal() {

		driver.browser().navigateToURL("https://testportal.eg-insurtech.com/login");
//		driver.element().type(userName, "MIportal");
//		driver.element().type(password, "P@ssw0rd");
		driver.element().type(userName, "producer");
		driver.element().type(password, "Asd123@@");
		driver.element().click(loginButton);
		driver.element().assertThat(pageTitle).isVisible().perform();
		//driver.element().assertThat(pageTitle).text().isEqualTo("العملاء").perform();

	}

	public void logOut() {
		// TODO Auto-generated method stub
		driver.element().click(profileIcon);
		driver.element().click(logoutBtn);
		driver.element().assertThat(loginButton).isVisible().perform();
		
	}

}
