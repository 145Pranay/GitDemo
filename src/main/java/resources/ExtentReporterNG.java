package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	static ExtentReports extent;

	@BeforeTest
	public static ExtentReports getReportObject() {

		String path = System.getProperty("user.dir") + "\\reports\\index.html";

		ExtentSparkReporter  reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Resuslts");

		extent = new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Tester", "Rahul Shetty");

		return extent;

	}

	@Test
	public void initialDemo() {

		ExtentTest test = extent.createTest("Initial Demo");

		System.setProperty("webdriver.chrome.driver", "E:\\Testing Required Files\\Webdrivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com");

		System.out.println(driver.getTitle());

		driver.close();

		// test.fail("Result do not match"); // by this the test will fail & in the
		// report it will show fail test
		extent.flush();

	}

}
