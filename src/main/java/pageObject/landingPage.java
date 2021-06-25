package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {

	public WebDriver driver;

	By signin = By.cssSelector("a[href*='sign_in']");

	By title = By.xpath("//*[@id=\"content\"]/div/div/h2");

	By navbar = By.xpath("//*[@id=\"homepage\"]/header/div[2]/div/nav/ul");

	public landingPage(WebDriver driver2) { // This is constructor coming from home page test file where argument is
											// defined
		// TODO Auto-generated constructor stub

		this.driver = driver2; // this is to give the life to above mentioned constructor
	}

	public loginPage getLogin() {

		driver.findElement(signin).click();

		loginPage lgp = new loginPage(driver);

		return lgp;
	}

	public WebElement getTitle() {

		return driver.findElement(title);
	}

	public WebElement getNavigationBar() {

		return driver.findElement(navbar);
	}

}
