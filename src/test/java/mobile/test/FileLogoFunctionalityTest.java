package mobile.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import logger.Log;
import pages.FileLogoPage;
import utilities.CommonUtility;
import utilities.ConfigFileReader;
import utilities.CreateSession;

public class FileLogoFunctionalityTest extends CreateSession{
	
	CommonUtility utility;
	FileLogoPage filePage;
	
	@BeforeSuite(alwaysRun = true)
	public void init() {

	}
	
	@Parameters({ "os" })
	@BeforeMethod(alwaysRun = true)
	public void instantiateHelpers(String invokeDriver) throws InterruptedException {
		if (invokeDriver.equalsIgnoreCase("android")) {
			utility = new CommonUtility(driver);
			filePage = new FileLogoPage(driver);
			utility.accessApp();
		}
	}
	
	@Test()
	public void testFileLogoFunctionality() throws Exception {
		Log.info("Click on File Logo button");
		filePage.clickFlileButton();
		Log.info("Verified Title text is displayed");
		assertEquals(filePage.validateTitleText(), true);
		Log.info("Verified Welcome to register a new user text is displayed");
		assertEquals(filePage.validateWelComeToResisterText(), true);
		utility.hideKeyboard(driver);
		Log.info("Verified UserName text is displayed");
		assertEquals(filePage.validateUserNameText(), true);
		Log.info("Verified E-Mail text is displayed");
		assertEquals(filePage.validateEmailText(), true);
		Log.info("Verified Password text is displayed");
		assertEquals(filePage.validatePasswordText(), true);
		Log.info("Verified Name text is displayed");
		assertEquals(filePage.validateNameText(), true);
		Log.info("Verified Programming Language text is displayed");
		assertEquals(filePage.validateProgrammingText(), true);
		Log.info("Verified Ruby text is displayed");
		assertEquals(filePage.validateRubyText(), true);
		Log.info("Enter User Name");
		filePage.enterUserName(ConfigFileReader.readDataFromPropertiesFile("NAME"));
		Log.info("Enter User Email id");
		filePage.enterEmail(ConfigFileReader.readDataFromPropertiesFile("EMAIL"));
		Log.info("Enter User Password");
		filePage.enterPassword(ConfigFileReader.readDataFromPropertiesFile("PASSWORD"));
		Log.info("Click on I accept adds checkbox");
		filePage.clickIAcceptAddsCheckBox();
		Log.info("Click on Register User button");
		filePage.clickRegisterUserButton();
		Log.info("Verified Name text is displayed");
		assertEquals(filePage.validateNameText(), true);
		Log.info("Verified Mr Burns text is displayed");
		assertEquals(filePage.validateEnteredMrBurnsText(), true);
		Log.info("Verified User Name text is displayed");
		assertEquals(filePage.validateUserNameText(), true);
		Log.info("Verified Entered User Name text is displayed");
		assertEquals(filePage.validateEnteredUserNameText(), true);
		Log.info("Verified Password text is displayed");
		assertEquals(filePage.validatePasswordText(), true);
		Log.info("Verified Entered Password text is displayed");
		assertEquals(filePage.validateEnteredPasswordText(), true);
		Log.info("Verified Email text is displayed");
		assertEquals(filePage.validateEmailText(), true);
		Log.info("Verified Entered Email id text is displayed");
		assertEquals(filePage.validateEnteredEmailText(), true);
		Log.info("Verified Programming Language text is displayed");
		assertEquals(filePage.validateProgrammingText(), true);
		Log.info("Verified Ruby text is displayed");
		assertEquals(filePage.validateRubyText(), true);
		Log.info("Click on Register User button");
		filePage.clickRegisterUserButton();
		Log.info("Verified Home Page Hello text is displayed");
		assertEquals(filePage.validateHelloText(), true);
	}

}
