package mobile.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import logger.Log;
import pages.ChromeLogoPage;
import utilities.CommonUtility;
import utilities.ConfigFileReader;
import utilities.CreateSession;

public class ChromeLogoFunctionalityTest extends CreateSession{
	
	CommonUtility utility;
	ChromeLogoPage chromePage;
	
	@BeforeSuite(alwaysRun = true)
	public void init() {

	}
	
	@Parameters({ "os" })
	@BeforeMethod(alwaysRun = true)
	public void instantiateHelpers(String invokeDriver) throws InterruptedException {
		if (invokeDriver.equalsIgnoreCase("android")) {
			utility = new CommonUtility(driver);
			chromePage = new ChromeLogoPage(driver);
			utility.accessApp();
		}
	}
	
	@Test()
	public void testChromeLogoFunctionality() throws IOException {
		Log.info("Click on Chrome Logo button");
		chromePage.clickChromeLogoButton();
		Log.info("Verified Web Text is displayed");
		assertEquals(chromePage.validateWebText(), true);
		Log.info("Verified Title Text is displayed");
		assertEquals(chromePage.validateTitleText(), true);
		Log.info("Verified Hello, can you please tell me your name? Text is displayed");
		assertEquals(chromePage.validateHelloText(), true);
		Log.info("Enter Your Name in Text Box");
		chromePage.enterName(ConfigFileReader.readDataFromPropertiesFile("NAME"));
		Log.info("Click on Preferred Card Drop-Down");
		chromePage.selectMercedes();
		Log.info("Click on Send me your name! button");
		chromePage.clickSendMeYourNameButton();
		Log.info("Verified This is my way of saying Text is displayed");
		assertEquals(chromePage.validateThisIsMyWayText(), true);
		Log.info("Verified Entered Name Text is displayed");
		assertEquals(chromePage.validateNameText(), true);
		Log.info("Verified Selected Car Text is displayed");
		assertEquals(chromePage.validateMyCarText(), true);
		Log.info("Click on here link button");
		chromePage.clickHereButton();
		Log.info("Verified Default Selected Car Text is displayed");
		assertEquals(chromePage.validateDefaultSelectedCarText(), true);
	}
}
