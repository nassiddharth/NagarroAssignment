package web.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import logger.Log;
import pages.JqueryDroppablePage;
import utilities.CommonUtility;
import utilities.ConfigFileReader;

public class JqueryDroppableFunctionalityTest {

	public WebDriver driver;

	CommonUtility utility;

	JqueryDroppablePage droppablePage;

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
	public void testDroppableFunctionality() {
		droppablePage = new JqueryDroppablePage(driver);
		Log.info("Click on Droppable Link");
		droppablePage.clickDroppableLink();
		Log.info("User Performed Drag & Drop functionality");
		droppablePage.performDragAndDropItem();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
