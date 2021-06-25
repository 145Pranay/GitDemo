package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.landingPage;
import pageObject.loginPage;
import resources.base;

public class validateNavigationBar_Test extends base {
	
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();

		driver.get(prop.getProperty("url"));

	}

	@Test
	public void basePageNavigation() throws IOException {

		// one is inheritance
		// creating object to the class and invoke methods of it

		// page object for landing page

		landingPage ldp = new landingPage(driver);

		// compare the text from the browser with actual text = Error

		Assert.assertTrue(ldp.getNavigationBar().isDisplayed());

	}

	@AfterTest
	public void teardown() {

		driver.close();
	}

}
