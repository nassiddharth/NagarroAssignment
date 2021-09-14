package pages;

import static pageconstants.SelendroidPageConstants.*;

import org.openqa.selenium.WebDriver;

import base.basePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.SynchronisationUtils;

public class ProgressBarPage extends basePage{

	public ProgressBarPage(WebDriver driver) {
		super(driver);
	}
	
	@AndroidFindBy(id = PROGRESS_BAR_BUTTON)
	private MobileElement progressBarBtn;
	
	@AndroidFindBy(xpath = WELCOME_TO_REGISTER_TEXT)
	private MobileElement welcomeRegisterTxt;
	
	public void clickProgressBarButton() {
		SynchronisationUtils.waitForElementToBeClickable(this.progressBarBtn, driver);
		this.progressBarBtn.click();
		SynchronisationUtils.staticWait(5);
	}
	
	public boolean validateWelComeToResisterText() {
		SynchronisationUtils.waitForElementToBeVisible(this.welcomeRegisterTxt, driver);
		return welcomeRegisterTxt.isDisplayed();
	}

}
