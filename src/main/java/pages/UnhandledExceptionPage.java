package pages;

import static pageconstants.SelendroidPageConstants.*;

import org.openqa.selenium.WebDriver;

import base.basePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.SynchronisationUtils;

public class UnhandledExceptionPage extends basePage{

	public UnhandledExceptionPage(WebDriver driver) {
		super(driver);
	}
	
	@AndroidFindBy(id = UNHANDLED_EXCEPTION_BUTTON)
	private MobileElement unhandledBtn;
	
	@AndroidFindBy(id = ALERT_STOP_POPUP)
	private MobileElement alertTxt;
	
	@AndroidFindBy(id = CLOSE_APP_BUTTON)
	private MobileElement closeBtn;
	
	public void clickUnhandledExceptionButton() {
		SynchronisationUtils.waitForElementToBeClickable(this.unhandledBtn, driver);
		this.unhandledBtn.click();
	}
	
	public boolean validateAlertText() {
		SynchronisationUtils.waitForElementToBeVisible(this.alertTxt, driver);
		return alertTxt.isDisplayed();
	}
	
	public void clickCloseButton() {
		SynchronisationUtils.waitForElementToBeClickable(this.closeBtn, driver);
		this.closeBtn.click();
	}

}
