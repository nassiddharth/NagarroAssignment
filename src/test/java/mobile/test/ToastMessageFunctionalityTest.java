package mobile.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import logger.Log;
import pages.ToastMessagePage;
import utilities.CommonUtility;
import utilities.ConfigFileReader;
import utilities.CreateSession;

public class ToastMessageFunctionalityTest extends CreateSession{
	
CommonUtility utility;
ToastMessagePage toastPage;
	
	@BeforeSuite(alwaysRun = true)
	public void init() {

	}
	
	@Parameters({ "os" })
	@BeforeMethod(alwaysRun = true)
	public void instantiateHelpers(String invokeDriver) throws InterruptedException {
		if (invokeDriver.equalsIgnoreCase("android")) {
			utility = new CommonUtility(driver);
			toastPage = new ToastMessagePage(driver);
			utility.accessApp();
		}
	}
	
	@Test()
	public void testToastMessage() throws Exception {
		Log.info("Click Display a Toast Button");
		toastPage.clickDisplayToastButton();
		Log.info("Verified Toast Message is displayed");
		assertEquals(toastPage.readToastMessage(), ConfigFileReader.readDataFromPropertiesFile("EXPECTED_TOAST_MESSAGE"));
	}

}
