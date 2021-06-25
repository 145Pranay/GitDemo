package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {

	public WebDriver driver;

	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\dekat_000\\eclipse-workspace\\E2EProject_RahulS\\src\\main\\java\\Resources\\data.properties");

		prop.load(fis);

		String browserName = prop.getProperty("browser");

		System.out.println(browserName);

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "E:\\Testing Required Files\\Webdrivers\\chromedriver.exe");

			driver = new ChromeDriver();

			// execute in chrome driver

		} else if (browserName.equals("firefox")) {

			// execute in firefox with code

		} else if (browserName.equals("IE")) {
			// execute in the IE with code
		}

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); // wait is declared globally means it is
																		// applicable for all the test cases
		// driver.close();

		return driver;

	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		
		FileUtils.copyFile(source, new File(destinationFile));
		
		return destinationFile;
		
	}

}
