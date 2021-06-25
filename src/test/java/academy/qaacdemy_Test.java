package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPassword;
import pageObject.landingPage;
import pageObject.loginPage;
import resources.base;

public class qaacdemy_Test extends base {

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		
		driver = initializeDriver();
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException {

		driver.get(prop.getProperty("url"));

		// one is inheritance

		// creating object to the class and invoke methods of it

		// page object for landing page

		landingPage ldp = new landingPage(driver);

		ldp.getLogin().click(); // This is implemented in landing page class for jenkins

		loginPage lgp = ldp.getLogin();

		// page object for login page

		// loginPage lgp = new loginPage(driver); // This is implemented in landing page
		// class for jenkins

		lgp.getEmail().sendKeys(Username);

		lgp.getPassword().sendKeys(Password);

		// Log.info(text);

		lgp.getSubmit().click();

		ForgotPassword fp = lgp.forgorPassword();
		
		fp.getEmail().sendKeys("xxx");

	}

	@DataProvider
	public Object[][] getData() {

		// Row stands for how many different data types test should run
		// column stands for how many values per each test
		Object[][] data = new Object[2][3];
		// 0th row

		data[0][0] = "nomrestricteduser@qw.com";
		data[0][1] = "12345";
		data[0][2] = "Restricted User";

		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "56789";
		data[1][2] = "Non restricted user";

		return data;
	}

	@AfterTest
	public void teardown() {

		driver.close();
	}

}
