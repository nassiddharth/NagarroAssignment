package mobile.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import logger.Log;
import pages.ApplicationPage;
import utilities.CommonUtility;
import utilities.CreateSession;

public class ApplicationTest extends CreateSession{
	
	private ApplicationPage applicatioPage;
	private CommonUtility utility;
	
	@BeforeSuite(alwaysRun = true)
	public void init() {
	}
	
	@Parameters({ "os" })
	@BeforeMethod(alwaysRun = true)
	public void instantiateHelpers(String invokeDriver) throws InterruptedException {
		if (invokeDriver.equalsIgnoreCase("android")) {
			//CreateSession.launchEmulator("Pixel_XL");
			utility = new CommonUtility(driver);
			applicatioPage = new ApplicationPage(driver);
			utility.accessApp();
		}
	}
	
	@Test()
	public void testApplicationValidation() throws Exception {
		Log.info("Verified Title text is displayed");
		assertEquals(applicatioPage.validateTitleText(), true);
		Log.info("Verified Hello Default Locale text is displayed");
		assertEquals(applicatioPage.validateHelloText(), true);
		Log.info("Verified Localization Text is displayed");
		assertEquals(applicatioPage.validateLocalizationText(), true);
		Log.info("Verified EN Button is displayed");
		assertEquals(applicatioPage.validateENButton(), true);
		Log.info("Verified Chrome Button is displayed");
		assertEquals(applicatioPage.validateChromeButton(), true);
		Log.info("Verified File Button is displayed");
		assertEquals(applicatioPage.validateFileButton(), true);
		Log.info("Verified Show Progress Bar Button is displayed");
		assertEquals(applicatioPage.validateProgressBarButton(), true);
		Log.info("Verified I accept adds Checkbox is displayed");
		assertEquals(applicatioPage.validateIAcceptCheckbox(), true);
		Log.info("Verified Display Text View Button is displayed");
		assertEquals(applicatioPage.validateDisplayTextViewButton(), true);
		Log.info("Verified Displays a Toast Button is displayed");
		assertEquals(applicatioPage.validateDisplayToastButton(), true);
		Log.info("Verified Display Popup Window Button is displayed");
		assertEquals(applicatioPage.validatePopUpWindowButton(), true);
		Log.info("Verified Press to throw unhandled exception Button is displayed");
		assertEquals(applicatioPage.validateThrowExceptionButton(), true);
		Log.info("Verified Display and focus on layout Button is displayed");
		assertEquals(applicatioPage.validateDisplayFocusButton(), true);
	}

}
