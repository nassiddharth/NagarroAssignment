package web.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import logger.Log;
import pages.JqueryControlGroupPage;
import utilities.ConfigFileReader;

public class JqueryControlGroupFunctionalityTest {

	public WebDriver driver;

	JqueryControlGroupPage controlGroupPage;

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		System.setProperty(ConfigFileReader.readDataFromPropertiesFile("WEBDRIVER_CONFIG"),
				ConfigFileReader.readDataFromPropertiesFile("CHROME_DRIVER_PATH"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(ConfigFileReader.readDataFromPropertiesFile("URL"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testControlGroupFunctionality() throws IOException {
		controlGroupPage = new JqueryControlGroupPage(driver);
		Log.info("Click on Control Group Link");
		controlGroupPage.clickControlGroupLink();
		Log.info("Select Car Type in Horizontal toolbar");
		controlGroupPage.selectHorizontalCarType();
		Log.info("Select Options in Horizontal toolbar");
		controlGroupPage.selectHorizontalOptions(ConfigFileReader.readDataFromPropertiesFile("CAR"));
		Log.info("Select Car Type in Vertical toolbar");
		controlGroupPage.selectVerticalCarType();
		Log.info("Select Options in Vertical toolbar");
		controlGroupPage.selectVerticalOptions(ConfigFileReader.readDataFromPropertiesFile("CAR"));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
