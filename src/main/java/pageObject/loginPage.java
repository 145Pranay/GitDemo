package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {

	public WebDriver driver;

	By email = By.id("user_email");

	By password = By.id("user_password");

	By submit = By.name("commit");

	By forgotPassword = By.cssSelector("[href*='password/new']");

	public loginPage(WebDriver driver2) { // This is constructor coming from home page test file where argument is
											// defined
		// TODO Auto-generated constructor stub

		this.driver = driver2; // this is to give the life to above mentioned constructor
	}

	public ForgotPassword forgorPassword() {

		driver.findElement(forgotPassword).click();

		return new ForgotPassword(driver);

	}

	public WebElement getEmail() {

		return driver.findElement(email);
	}

	public WebElement getPassword() {

		return driver.findElement(password);
	}

	public WebElement getSubmit() {

		return driver.findElement(submit);
	}

	public void click() {
		// TODO Auto-generated method stub
		
		driver.findElement(submit);
		
	}
}
