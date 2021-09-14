package pages;

import static pageconstants.SelendroidPageConstants.*;

import org.openqa.selenium.WebDriver;

import base.basePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.SynchronisationUtils;

public class ToastMessagePage extends basePage{

	public ToastMessagePage(WebDriver driver) {
		super(driver);
	}
	
	@AndroidFindBy(id = TOAST_MESSAGE_BUTTON)
	private MobileElement toastMsgBtn;
	
	@AndroidFindBy(xpath = TOAST_MESSAGE)
	private MobileElement toastMsg;
	
	@AndroidFindBy(id = POPUP_WINDOW_BUTTON)
	private MobileElement popupWindowBtn;
	
	public void clickDisplayToastButton() {
		SynchronisationUtils.waitForElementToBeClickable(this.toastMsgBtn, driver);
		this.toastMsgBtn.click();
	}
	
	public String readToastMessage() {
		String actualToastMessage = this.toastMsg.getText();
		return actualToastMessage;
	}

}
