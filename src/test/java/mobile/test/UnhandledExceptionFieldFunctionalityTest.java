package mobile.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import logger.Log;
import pages.UnhandledExceptionFieldPage;
import utilities.CommonUtility;
import utilities.ConfigFileReader;
import utilities.CreateSession;

public class UnhandledExceptionFieldFunctionalityTest extends CreateSession{
	
CommonUtility utility;
UnhandledExceptionFieldPage fieldPage;
	
	@BeforeSuite(alwaysRun = true)
	public void init() {

	}
	
	@Parameters({ "os" })
	@BeforeMethod(alwaysRun = true)
	public void instantiateHelpers(String invokeDriver) throws InterruptedException {
		if (invokeDriver.equalsIgnoreCase("android")) {
			utility = new CommonUtility(driver);
			fieldPage = new UnhandledExceptionFieldPage(driver);
			utility.accessApp();
		}
	}
	
	@Test()
	public void testUnhandledExceptionFieldFunctionality() throws Exception {
		Log.info("Enter in Unhandled Exception Field");
		fieldPage.enterUnhandledExceptionText();
		Log.info("Verified Alert Message is displayed");
		assertEquals(fieldPage.validateAlertText(), true);
		Log.info("Click on Close Button");
		fieldPage.clickCloseButton();
	}

}
