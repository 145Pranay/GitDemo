package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	public WebDriver driver;

	By email = By.id("user_email");

	By sendMeInstructions = By.cssSelector("[type='submit']");

	public ForgotPassword(WebDriver driver) { // This is constructor coming from home page test file where argument is
												// defined
		// TODO Auto-generated constructor stub

		this.driver = driver; // this is to give the life to above mentioned constructor
	}

	public WebElement getEmail() {

		return driver.findElement(email);
	}
	
	public WebElement sendMeInstructions() {

		return driver.findElement(sendMeInstructions);
	}

}
