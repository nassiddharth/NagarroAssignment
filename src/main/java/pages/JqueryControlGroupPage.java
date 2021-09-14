package pages;

import static pageconstants.JqueryuiPageConstants.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.basePage;
import utilities.SynchronisationUtils;

public class JqueryControlGroupPage extends basePage{

	public JqueryControlGroupPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = CONTROL_GROUP_LINK)
	private WebElement controlGroupLink;
	
	@FindBy(xpath = FRAME)
	private WebElement frame;
	
	@FindBy(id = COMPACT_CAR_DROP_DOWN)
	private WebElement compactCarDD;
	
	@FindBy(id = SUV_CAR)
	private WebElement suvCarOption;
	
	@FindBy(xpath = AUTOMATIC_OPTION)
	private WebElement automaticOption;
	
	@FindBy(xpath = INSURANCE_OPTION)
	private WebElement insuranceOption;
	
	@FindBy(id = NO_OF_CAR)
	private WebElement noOfCar;
	
	@FindBy(id = COMBO_BOX)
	private WebElement comboBox;
	
	@FindBy(id = TRUCK_OPTION)
	private WebElement truckOption;
	
	@FindBy(xpath = STANDARD_OPTION)
	private WebElement standardOption;
	
	@FindBy(xpath = COMBO_BOX_INSURANCE_OPTION)
	private WebElement comboBoxInsuranceOption;
	
	@FindBy(id = COMBO_BOX_NO_OF_CAR)
	private WebElement comboBoxNoOfCar;
	
	@FindBy(id = BOOK_BUTTON)
	private WebElement bookBtn;
	
	public void clickControlGroupLink() {
		SynchronisationUtils.waitForElementToBeClickable(this.controlGroupLink, driver);
		this.controlGroupLink.click();
	}
	
	public void selectHorizontalCarType() {
		SynchronisationUtils.waitForElementToBeClickable(this.frame, driver);
		driver.switchTo().frame(frame);
		this.compactCarDD.click();
		this.suvCarOption.click();
	}
	
	public void selectHorizontalOptions(String car) {
		SynchronisationUtils.waitForElementToBeClickable(this.automaticOption, driver);
		this.automaticOption.click();
		this.insuranceOption.click();
		this.noOfCar.sendKeys(car);
	}
	
	public void selectVerticalCarType() {
		SynchronisationUtils.waitForElementToBeClickable(this.comboBox, driver);
		this.comboBox.click();
		this.truckOption.click();
	}
	
	public void selectVerticalOptions(String car) {
		SynchronisationUtils.waitForElementToBeClickable(this.standardOption, driver);
		this.standardOption.click();
		this.comboBoxInsuranceOption.click();
		this.comboBoxNoOfCar.sendKeys(car);
		this.bookBtn.click();
	}

}
