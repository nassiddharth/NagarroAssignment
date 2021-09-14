package pages;

import static pageconstants.SelendroidPageConstants.*;

import org.openqa.selenium.WebDriver;

import base.basePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.SynchronisationUtils;

public class ApplicationPage extends basePage{

	public ApplicationPage(WebDriver driver) {
		super(driver);
	}

	@AndroidFindBy(id = CONTINUE_BUTTON)
	private MobileElement continueBtn;
	
	@AndroidFindBy(id = OK_BUTTON)
	private MobileElement okBtn;
	
	@AndroidFindBy(id = TITLE_TEXT)
	private MobileElement titleTxt;
	
	@AndroidFindBy(id = EN_BUTTON)
	private MobileElement enBtn;
	
	@AndroidFindBy(id = CHROME_BUTTON)
	private MobileElement chromeBtn;
	
	@AndroidFindBy(id = FILE_BUTTON)
	private MobileElement fileBtn;
	
	@AndroidFindBy(id = PROGRESS_BAR_BUTTON)
	private MobileElement progressBarBtn;
	
	@AndroidFindBy(id = TOAST_MESSAGE_BUTTON)
	private MobileElement toastMsgBtn;
	
	@AndroidFindBy(id = POPUP_WINDOW_BUTTON)
	private MobileElement popupWindowBtn;
	
	@AndroidFindBy(id = UNHANDLED_EXCEPTION_BUTTON)
	private MobileElement unhandledBtn;
	
	@AndroidFindBy(id = UNHANDLED_EXPECTION_TEXT_BOX)
	private MobileElement unhandledTxtBox;
	
	@AndroidFindBy(xpath = HELLO_DEFAULT_TEXT)
	private MobileElement helloTxt;
	
	@AndroidFindBy(xpath = LOCALIZATION_TEXT)
	private MobileElement localizationTxt;
	
	@AndroidFindBy(xpath = I_ACCEPT_CHECKBOX)
	private MobileElement iAcceptTxt;
	
	@AndroidFindBy(id = DISPLAY_BUTTON)
	private MobileElement displayBtn;
	
	@AndroidFindBy(id = DISPLAY_FOCUS_BUTTON)
	private MobileElement displayFocusBtn;
	
	public void clickContinueButton() {
		SynchronisationUtils.waitForElementToBeClickable(this.continueBtn, driver);
		this.continueBtn.click();
	}
	
	public void clickOkButton() {
		SynchronisationUtils.waitForElementToBeClickable(this.okBtn, driver);
		this.okBtn.click();
	}
	
	public boolean validateTitleText() {
		SynchronisationUtils.waitForElementToBeVisible(this.titleTxt, driver);
		return titleTxt.isDisplayed();
	}
	
	public boolean validateHelloText() {
		SynchronisationUtils.waitForElementToBeVisible(this.helloTxt, driver);
		return helloTxt.isDisplayed();
	}
	
	public boolean validateLocalizationText() {
		SynchronisationUtils.waitForElementToBeVisible(this.localizationTxt, driver);
		return localizationTxt.isDisplayed();
	}
	
	public boolean validateENButton() {
		SynchronisationUtils.waitForElementToBeVisible(this.enBtn, driver);
		return enBtn.isDisplayed();
	}
	
	public boolean validateChromeButton() {
		SynchronisationUtils.waitForElementToBeVisible(this.chromeBtn, driver);
		return chromeBtn.isDisplayed();
	}
	
	public boolean validateFileButton() {
		SynchronisationUtils.waitForElementToBeVisible(this.fileBtn, driver);
		return fileBtn.isDisplayed();
	}
	
	public boolean validateProgressBarButton() {
		SynchronisationUtils.waitForElementToBeVisible(this.progressBarBtn, driver);
		return progressBarBtn.isDisplayed();
	}
	
	public boolean validateIAcceptCheckbox() {
		SynchronisationUtils.waitForElementToBeVisible(this.iAcceptTxt, driver);
		return iAcceptTxt.isDisplayed();
	}
	
	public boolean validateDisplayTextViewButton() {
		SynchronisationUtils.waitForElementToBeVisible(this.displayBtn, driver);
		return displayBtn.isDisplayed();
	}
	
	public boolean validateDisplayToastButton() {
		SynchronisationUtils.waitForElementToBeVisible(this.toastMsgBtn, driver);
		return toastMsgBtn.isDisplayed();
	}
	
	public boolean validatePopUpWindowButton() {
		SynchronisationUtils.waitForElementToBeVisible(this.popupWindowBtn, driver);
		return popupWindowBtn.isDisplayed();
	}
	
	public boolean validateThrowExceptionButton() {
		SynchronisationUtils.waitForElementToBeVisible(this.unhandledBtn, driver);
		return unhandledBtn.isDisplayed();
	}
	
	public boolean validateDisplayFocusButton() {
		SynchronisationUtils.waitForElementToBeVisible(this.displayFocusBtn, driver);
		return displayFocusBtn.isDisplayed();
	}
}
