package pages;

import static pageconstants.SelendroidPageConstants.*;

import org.openqa.selenium.WebDriver;

import base.basePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.SynchronisationUtils;

public class FileLogoPage extends basePage{

	public FileLogoPage(WebDriver driver) {
		super(driver);
	}

	@AndroidFindBy(id = TITLE_TEXT)
	private MobileElement titleTxt;
	
	@AndroidFindBy(id = FILE_BUTTON)
	private MobileElement fileBtn;
	
	@AndroidFindBy(xpath = WELCOME_TO_REGISTER_TEXT)
	private MobileElement welcomeRegisterTxt;
	
	@AndroidFindBy(xpath = USER_NAME_TEXT)
	private MobileElement userNameTxt;
	
	@AndroidFindBy(xpath = EMAIL_TEXT)
	private MobileElement emailTxt;
	
	@AndroidFindBy(xpath = PASSWORD_TEXT)
	private MobileElement passwordTxt;
	
	@AndroidFindBy(xpath = NAME_TEXT)
	private MobileElement nameTxt;
	
	@AndroidFindBy(xpath = PROGRAMMING_TEXT)
	private MobileElement programmingTxt;
	
	@AndroidFindBy(xpath = TANDC_TEXT)
	private MobileElement tandcTxt;
	
	@AndroidFindBy(xpath = MR_BURNS_TEXT)
	private MobileElement burnsTxt;
	
	@AndroidFindBy(xpath = RUBY_TEXT)
	private MobileElement rubyTxt;
	
	@AndroidFindBy(id =  ENTER_USER_NAME_TEXT_BOX)
	private MobileElement enterUserNameTxt;
	
	@AndroidFindBy(id =  ENTER_EMAIL_TEXT_BOX)
	private MobileElement enterEmailTxt;
	
	@AndroidFindBy(id =  ENTER_PASSWORD_TEXT_BOX)
	private MobileElement enterPasswordTxt;
	
	@AndroidFindBy(xpath = ACCEPT_CHECKBOX)
	private MobileElement acceptChkBox;
	
	@AndroidFindBy(xpath = REGISTER_USER_BUTTON)
	private MobileElement registerUserBtn;
	
	@AndroidFindBy(id =  ACCEPT_TRUE_TEXT)
	private MobileElement acceptTrueTxt;
	
	@AndroidFindBy(xpath = HELLO_DEFAULT_TEXT)
	private MobileElement helloTxt;
	
	@AndroidFindBy(id =  ENTERED_MR_BURNS_TEXT)
	private MobileElement enteredBurnsTxt;

	@AndroidFindBy(id =  ENTERED_USERNAME_TEXT)
	private MobileElement enteredUserNameTxt;
	
	@AndroidFindBy(id =  ENTERED_EMAIL_TEXT)
	private MobileElement enteredEmailTxt;
	
	@AndroidFindBy(id =  ENTERED_PASSWORD_TEXT)
	private MobileElement enteredPasswordTxt;
	
	public boolean validateTitleText() {
		SynchronisationUtils.waitForElementToBeVisible(this.titleTxt, driver);
		return titleTxt.isDisplayed();
	}
	
	public void clickFlileButton() {
		SynchronisationUtils.waitForElementToBeClickable(this.fileBtn, driver);
		this.fileBtn.click();
		SynchronisationUtils.staticWait(1);
	}
	
	public boolean validateWelComeToResisterText() {
		SynchronisationUtils.waitForElementToBeVisible(this.welcomeRegisterTxt, driver);
		return welcomeRegisterTxt.isDisplayed();
	}
	
	public boolean validateUserNameText() {
		SynchronisationUtils.waitForElementToBeVisible(this.userNameTxt, driver);
		return userNameTxt.isDisplayed();
	}
	
	public boolean validateEmailText() {
		SynchronisationUtils.waitForElementToBeVisible(this.emailTxt, driver);
		return emailTxt.isDisplayed();
	}
	
	public boolean validatePasswordText() {
		SynchronisationUtils.waitForElementToBeVisible(this.passwordTxt, driver);
		return passwordTxt.isDisplayed();
	}
	
	public boolean validateNameText() {
		SynchronisationUtils.waitForElementToBeVisible(this.nameTxt, driver);
		return nameTxt.isDisplayed();
	}
	
	public boolean validateProgrammingText() {
		SynchronisationUtils.waitForElementToBeVisible(this.programmingTxt, driver);
		return programmingTxt.isDisplayed();
	}
	
	public boolean validateTandacText() {
		SynchronisationUtils.waitForElementToBeVisible(this.tandcTxt, driver);
		return tandcTxt.isDisplayed();
	}
	
	public boolean validateMrBurnsText() {
		SynchronisationUtils.waitForElementToBeVisible(this.burnsTxt, driver);
		return burnsTxt.isDisplayed();
	}
	
	public boolean validateRubyText() {
		SynchronisationUtils.waitForElementToBeVisible(this.rubyTxt, driver);
		return rubyTxt.isDisplayed();
	}
	
	public void enterUserName(String name) {
		SynchronisationUtils.waitForElementToBeClickable(this.enterUserNameTxt, driver);
		this.enterUserNameTxt.sendKeys(name);
	}
	
	public void enterEmail(String email) {
		SynchronisationUtils.waitForElementToBeClickable(this.enterEmailTxt, driver);
		this.enterEmailTxt.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		SynchronisationUtils.waitForElementToBeClickable(this.enterPasswordTxt, driver);
		this.enterPasswordTxt.sendKeys(password);
	}
	
	public void clickIAcceptAddsCheckBox() {
		SynchronisationUtils.waitForElementToBeClickable(this.acceptChkBox, driver);
		this.acceptChkBox.click();
	}
	
	public void clickRegisterUserButton() {
		SynchronisationUtils.waitForElementToBeClickable(this.registerUserBtn, driver);
		this.registerUserBtn.click();
		SynchronisationUtils.staticWait(1);
	}
	
	public boolean validateAcceptTrueText() {
		SynchronisationUtils.waitForElementToBeVisible(this.acceptTrueTxt, driver);
		return acceptTrueTxt.isDisplayed();
	}
	
	public boolean validateHelloText() {
		SynchronisationUtils.waitForElementToBeVisible(this.helloTxt, driver);
		return helloTxt.isDisplayed();
	}
	
	public boolean validateEnteredMrBurnsText() {
		SynchronisationUtils.waitForElementToBeVisible(this.enteredBurnsTxt, driver);
		return enteredBurnsTxt.isDisplayed();
	}
	
	public boolean validateEnteredUserNameText() {
		SynchronisationUtils.waitForElementToBeVisible(this.enteredUserNameTxt, driver);
		return enteredUserNameTxt.isDisplayed();
	}
	
	public boolean validateEnteredPasswordText() {
		SynchronisationUtils.waitForElementToBeVisible(this.enteredPasswordTxt, driver);
		return enteredPasswordTxt.isDisplayed();
	}
	
	public boolean validateEnteredEmailText() {
		SynchronisationUtils.waitForElementToBeVisible(this.enteredEmailTxt, driver);
		return enteredEmailTxt.isDisplayed();
	}
	
}
