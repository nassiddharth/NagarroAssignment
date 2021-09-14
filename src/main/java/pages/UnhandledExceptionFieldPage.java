package pages;

import static pageconstants.SelendroidPageConstants.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import base.basePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.SynchronisationUtils;

public class UnhandledExceptionFieldPage extends basePage{

	public UnhandledExceptionFieldPage(WebDriver driver) {
		super(driver);
	}
	
	@AndroidFindBy(xpath = UNHANDLED_EXPECTION_TEXT_BOX)
	private MobileElement unhandledTxtBox;
	
	@AndroidFindBy(id = ALERT_STOP_POPUP)
	private MobileElement alertTxt;
	
	@AndroidFindBy(id = CLOSE_APP_BUTTON)
	private MobileElement closeBtn;
	
	public void enterUnhandledExceptionText() {
		SynchronisationUtils.waitForElementToBeClickable(this.unhandledTxtBox, driver);
		this.unhandledTxtBox.click();
		SynchronisationUtils.staticWait(2);
		Actions action = new Actions(driver);
		action.sendKeys("i").perform();
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
