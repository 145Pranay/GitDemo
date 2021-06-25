package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class portalHomePage {

	public WebDriver driver;

	By searchBox = By.name("query");

	public portalHomePage(WebDriver driver) { // This is constructor coming from home page test file where argument is
												// defined
		// TODO Auto-generated constructor stub

		this.driver = driver; // this is to give the life to above mentioned constructor
	}

	public WebElement getSearchBox() {

		return driver.findElement(searchBox);
	}

}
