package pages;

import static pageconstants.SelendroidPageConstants.*;

import org.openqa.selenium.WebDriver;

import base.basePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.SynchronisationUtils;

public class ENPage extends basePage{

	public ENPage(WebDriver driver) {
		super(driver);
	}
	
	@AndroidFindBy(id = TITLE_TEXT)
	private MobileElement titleTxt;
	
	@AndroidFindBy(id = EN_BUTTON)
	private MobileElement enBtn;
	
	@AndroidFindBy(id = EN_POPUP_MESSAGE_TEXT)
	private MobileElement enPopUpMsgTxt;
	
	@AndroidFindBy(id = EN_POPUP_NO_BUTTON)
	private MobileElement enPopUpNoBtn;
	
	public boolean validateTitleText() {
		SynchronisationUtils.waitForElementToBeVisible(this.titleTxt, driver);
		return titleTxt.isDisplayed();
	}
	
	public void clickENButton() {
		SynchronisationUtils.waitForElementToBeClickable(this.enBtn, driver);
		this.enBtn.click();
	}
	
	public boolean validateENPopUpMessageText() {
		SynchronisationUtils.waitForElementToBeVisible(this.enPopUpMsgTxt, driver);
		return enPopUpMsgTxt.isDisplayed();
	}
	
	public void clickENPopUpNoButton() {
		SynchronisationUtils.waitForElementToBeVisible(this.enPopUpNoBtn, driver);
		this.enPopUpNoBtn.click();
	}

}
