package utilities;

import org.openqa.selenium.WebDriver;

import io.appium.java_client.AppiumDriver;
import pages.ApplicationPage;

public class CommonUtility {
	
	protected WebDriver driver;
	ApplicationPage appPage;
	
	public CommonUtility(WebDriver driver) {
		this.driver = driver;
		this.appPage = new ApplicationPage(driver);
	}
	
	public void accessApp() {
		this.appPage.clickContinueButton();
		this.appPage.clickOkButton();
	}
	
	public void hideKeyboard(final WebDriver driver) {
		((AppiumDriver<?>) driver).hideKeyboard();
	}

}
