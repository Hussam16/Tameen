package PageObjects;



import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;
import com.shaft.driver.SHAFT.GUI.WebDriver;

public class SideMenu {
	
	private SHAFT.GUI.WebDriver driver;
	private By customerManagment=By.xpath("//span[text()=' إدارة العملاء ']");
	private By customerRequest=By.cssSelector("a[href='/home/sharing-requests']");
	

	public SideMenu(WebDriver driver) {

		this.driver = driver;
	}

	
	public void clickSideMenuIteam() {
		driver.element().click(customerManagment);
		driver.element().click(customerRequest);
		
		
	}

}
