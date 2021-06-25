package stepDefinations;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.landingPage;
import pageObject.loginPage;
import pageObject.portalHomePage;
import resources.base;

public class stepDefination extends base {

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		driver = initializeDriver();
	}

	@Given("^Navigate to \"([^\"]*)\" Site$")
	public void navigate_to_Site(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.get(arg1);

	}

	@Given("^Click on Login link in home page to land on Secure sign in Page$")
	public void click_on_Login_link_in_home_page_to_land_on_Secure_sign_in_Page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		landingPage ldp = new landingPage(driver);
		ldp.getLogin().click();

	}

	/*
	 * @Then("^Verify that user is successfully logged in$") public void
	 * verify_that_user_is_succesfully_logged_in() throws Throwable { // Write code
	 * here that turns the phrase above into concrete actions
	 * 
	 * portalHomePage p = new portalHomePage(driver);
	 * 
	 * Assert.assertTrue(p.getSearchBox().isDisplayed());
	 * 
	 * }
	 */

	@When("^User enters (.+) and (.+) and logs in $")
	public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		loginPage lgp = new loginPage(driver);

		lgp.getEmail().sendKeys(username);

		lgp.getPassword().sendKeys(password);

		lgp.getSubmit().click();
	}
	
	@And("^Close browsers$")
    public void close_browsers() throws Throwable {
        
		driver.quit();
    }

}