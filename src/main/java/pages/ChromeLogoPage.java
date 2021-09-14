package pages;

import static pageconstants.SelendroidPageConstants.*;

import org.openqa.selenium.WebDriver;

import base.basePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.SynchronisationUtils;

public class ChromeLogoPage extends basePage{

	public ChromeLogoPage(WebDriver driver) {
		super(driver);
	}
	
	@AndroidFindBy(id = TITLE_TEXT)
	private MobileElement titleTxt;
	
	@AndroidFindBy(id = CHROME_BUTTON)
	private MobileElement chromeBtn;
	
	@AndroidFindBy(xpath = CHROME_HELLO_TEXT)
	private MobileElement chromeHelloTxt;
	
	@AndroidFindBy(id = CHROME_WEB_TEXT)
	private MobileElement chromeWebTxt;
	
	@AndroidFindBy(xpath = NAME_TEXT_BOX)
	private MobileElement enterNameTxt;
	
	@AndroidFindBy(xpath = ENTER_NAME)
	private MobileElement enterNamTxt;
	
	@AndroidFindBy(xpath = SELECT_CAR_DROP_DOWN)
	private MobileElement selectCarDrpDwn;
	
	@AndroidFindBy(xpath = SELECT_MERCEDES)
	private MobileElement mercedesTxt;
	
	@AndroidFindBy(xpath = SEND_ME_YOUR_NAME_BUTTON)
	private MobileElement sendMeBtn;
	
	@AndroidFindBy(xpath = THIS_IS_MY_WAY_TEXT)
	private MobileElement thisMyWayTxt;
	
	@AndroidFindBy(xpath = MY_NAME_TEXT)
	private MobileElement myNameTxt;
	
	@AndroidFindBy(xpath = MY_CAR_TEXT)
	private MobileElement carTxt;
	
	@AndroidFindBy(xpath = HERE_LINK)
	private MobileElement hereLnk;
	
	public boolean validateTitleText() {
		SynchronisationUtils.waitForElementToBeVisible(this.titleTxt, driver);
		return titleTxt.isDisplayed();
	}
	
	public void clickChromeLogoButton() {
		SynchronisationUtils.waitForElementToBeClickable(this.chromeBtn, driver);
		this.chromeBtn.click();
	}
	
	public boolean validateWebText() {
		SynchronisationUtils.waitForElementToBeVisible(this.chromeWebTxt, driver);
		return chromeWebTxt.isDisplayed();
	}
	
	public boolean validateHelloText() {
		SynchronisationUtils.waitForElementToBeVisible(this.chromeHelloTxt, driver);
		return chromeHelloTxt.isDisplayed();
	}
	
	public void enterName(String name) {
		SynchronisationUtils.waitForElementToBeClickable(this.enterNameTxt, driver);
		this.enterNameTxt.clear();
		this.enterNamTxt.sendKeys(name);
	}
	
	public void selectMercedes() {
		SynchronisationUtils.waitForElementToBeClickable(this.selectCarDrpDwn, driver);
		this.selectCarDrpDwn.click();
		this.mercedesTxt.click();
	}
	
	public void clickSendMeYourNameButton() {
		SynchronisationUtils.waitForElementToBeClickable(this.sendMeBtn, driver);
		this.sendMeBtn.click();
	}
	
	public boolean validateThisIsMyWayText() {
		SynchronisationUtils.waitForElementToBeVisible(this.thisMyWayTxt, driver);
		return thisMyWayTxt.isDisplayed();
	}
	
	public boolean validateNameText() {
		SynchronisationUtils.waitForElementToBeVisible(this.myNameTxt, driver);
		return myNameTxt.isDisplayed();
	}
	
	public boolean validateMyCarText() {
		SynchronisationUtils.waitForElementToBeVisible(this.carTxt, driver);
		return carTxt.isDisplayed();
	}
	
	public boolean validateDefaultSelectedCarText() {
		SynchronisationUtils.waitForElementToBeVisible(this.selectCarDrpDwn, driver);
		return selectCarDrpDwn.isDisplayed();
		
	}
	
	public void clickHereButton() {
		SynchronisationUtils.waitForElementToBeClickable(this.hereLnk, driver);
		this.hereLnk.click();
	}

}
