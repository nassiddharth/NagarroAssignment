package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import base.basePage;

import static pageconstants.JqueryuiPageConstants.*;

import utilities.SynchronisationUtils;

public class JqueryDroppablePage extends basePage{

	public JqueryDroppablePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = DROPPABLE_LINK)
	private WebElement droppableLink;
	
	@FindBy(xpath = FRAME)
	private WebElement frame;
	
	@FindBy(id = DRAG_ITEM)
	private WebElement dragItem;
	
	@FindBy(id = DROP_ITEM)
	private WebElement dropItem;
	
	public void clickDroppableLink() {
		SynchronisationUtils.waitForElementToBeClickable(this.droppableLink, driver);
		this.droppableLink.click();
	}
	
	public void performDragAndDropItem() {
		SynchronisationUtils.waitForElementToBeClickable(this.frame, driver);
		driver.switchTo().frame(frame);
		Actions actions = new Actions(driver);
		actions.dragAndDrop(dragItem, dropItem).build().perform();
	}

}
