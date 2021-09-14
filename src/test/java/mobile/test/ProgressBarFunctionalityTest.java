package mobile.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import logger.Log;
import pages.ProgressBarPage;
import utilities.CommonUtility;
import utilities.CreateSession;

public class ProgressBarFunctionalityTest extends CreateSession {

	CommonUtility utility;
	ProgressBarPage progressBarPage;

	@BeforeSuite(alwaysRun = true)
	public void init() {

	}

	@Parameters({ "os" })
	@BeforeMethod(alwaysRun = true)
	public void instantiateHelpers(String invokeDriver) throws InterruptedException {
		if (invokeDriver.equalsIgnoreCase("android")) {
			utility = new CommonUtility(driver);
			progressBarPage = new ProgressBarPage(driver);
			utility.accessApp();
		}
	}

	@Test()
	public void testProgressBarFunctionality() throws Exception {
		Log.info("Click on Show Progress Bar for a while Button");
		progressBarPage.clickProgressBarButton();
		Log.info("Verified Welcome to register a new user text is displayed");
		assertEquals(progressBarPage.validateWelComeToResisterText(), true);

	}
}
