package pages;

import static pageconstants.JqueryuiPageConstants.*;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import base.basePage;
import utilities.SynchronisationUtils;

public class JquerySelectablePage extends basePage{

	public JquerySelectablePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = FRAME)
	private WebElement frame;
	
	@FindBy(xpath = SELECTABLE_LINK)
	private WebElement selectableLink;
	
	@FindBy(xpath = FIRST_ITEM)
	private WebElement firstItem;
	
	@FindBy(xpath = THIRD_ITEM)
	private WebElement thirdItem;
	
	@FindBy(xpath = SEVENTH_ITEM)
	private WebElement seventhItem;
	
	public void clickSelectableLink() {
		SynchronisationUtils.waitForElementToBeClickable(this.selectableLink, driver);
		this.selectableLink.click();
	}
	
	public void selectItemFromList() {
		SynchronisationUtils.waitForElementToBeClickable(this.frame, driver);
		driver.switchTo().frame(frame);
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).perform();
		this.firstItem.click();
		this.thirdItem.click();
		this.seventhItem.click();
		actions.keyUp(Keys.CONTROL).perform();
	}

}
