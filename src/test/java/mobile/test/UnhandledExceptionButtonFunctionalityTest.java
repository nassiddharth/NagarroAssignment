package mobile.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import logger.Log;
import pages.UnhandledExceptionPage;
import utilities.CommonUtility;
import utilities.CreateSession;

public class UnhandledExceptionButtonFunctionalityTest extends CreateSession{

	CommonUtility utility;
	UnhandledExceptionPage unhandledExpPage;
	
	@BeforeSuite(alwaysRun = true)
	public void init() {

	}
	
	@Parameters({ "os" })
	@BeforeMethod(alwaysRun = true)
	public void instantiateHelpers(String invokeDriver) throws InterruptedException {
		if (invokeDriver.equalsIgnoreCase("android")) {
			utility = new CommonUtility(driver);
			unhandledExpPage = new UnhandledExceptionPage(driver);
			utility.accessApp();
		}
	}
	
	@Test()
	public void testUnhandledExceptionTest() throws Exception {
		Log.info("Click on Unhandled Exception Button");
		unhandledExpPage.clickUnhandledExceptionButton();
		Log.info("Verified Alert Message is displayed");
		assertEquals(unhandledExpPage.validateAlertText(), true);
		Log.info("Click on Close Button");
		unhandledExpPage.clickCloseButton();
	}
}
