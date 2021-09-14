package mobile.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import logger.Log;
import pages.ENPage;
import utilities.CommonUtility;
import utilities.CreateSession;

public class ENFunctionalityTest extends CreateSession{
	
	ENPage enPage;
	CommonUtility utility;
	
	@BeforeSuite(alwaysRun = true)
	public void init() {

	}
	
	@Parameters({ "os" })
	@BeforeMethod(alwaysRun = true)
	public void instantiateHelpers(String invokeDriver) throws InterruptedException {
		if (invokeDriver.equalsIgnoreCase("android")) {
			utility = new CommonUtility(driver);
			enPage = new ENPage(driver);
			utility.accessApp();
		}
	}
	
	@Test()
	public void testENFunctionality() {
		Log.info("Click on EN button");
		enPage.clickENButton();
		Log.info("Verified EN Pop-Up Message is displayed");
		assertEquals(enPage.validateENPopUpMessageText(), true);
		Log.info("Click on EN Pop-Up No button");
		enPage.clickENPopUpNoButton();
		Log.info("Verified Title text is displayed");
		assertEquals(enPage.validateTitleText(), true);
	}
}
