package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import logger.Log;

/**
 * contains all the methods to create a new session and destroy the session
 * after the test(s) execution is over. Each test extends this class.
 */
public class CreateSession {

	public WebDriver driver = null;
	Properties configFile;
	protected static Properties lobConfigProp = new Properties();
	protected static Properties localeConfigProp = new Properties();
	protected FileInputStream configFis, lobConfigFis, localeConfigFis;
	public Properties testDataFile;
	private final String CONFIG_FILE_PATH = "/resource/config/config.properties";
	protected File file = new File("");
	Properties configProp = new Properties();
	String OS;

	/**
	 * this method creates the driver depending upon the passed parameter (android
	 * or iOS) and loads the properties files (config and test data properties
	 * files).
	 * 
	 * @param os         android or iOS
	 * @param methodName - name of the method under execution
	 * @throws Exception issue while loading properties files or creation of driver.
	 */
	@Parameters({ "os" })
	@BeforeMethod(alwaysRun = true)
	public void createDriver(String os) throws Exception {

		propertiesFileLoad(os);

		File propertiesFile = new File(file.getAbsoluteFile() + "/resource/log4j.properties");
		PropertyConfigurator.configure(propertiesFile.toString());
		Log.info("--------------------------------------");

		if (os.equalsIgnoreCase("android")) {
			String buildPath = choosebuild(os);
			androidDriver(buildPath);
			Log.info("Android driver created");

		} else if (os.equalsIgnoreCase("iOS")) {
			String buildPath = choosebuild(os);
			iOSDriver(buildPath);
			Log.info("iOS driver created");
		}
	}

	/**
	 * this method quit the driver after the execution of test(s)
	 */
	@AfterMethod(alwaysRun = true)
	public void teardown() {
		Log.info("Shutting down driver");
		// driver.quit();
	}

	/**
	 * this method creates the android driver
	 * 
	 * @param buildPath  - path to pick the location of the app
	 * @param methodName - name of the method under execution
	 * @throws MalformedURLException Thrown to indicate that a malformed URL has
	 *                               occurred.
	 */
	public synchronized void androidDriver(String buildPath) throws MalformedURLException {
		File app = new File(buildPath);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", configProp.getProperty("DEVICE_NAME"));
		capabilities.setCapability("platformName", configProp.getProperty("PLATFORM_NAME"));
		capabilities.setCapability("appPackage", configProp.getProperty("APP_PACKAGE"));
		capabilities.setCapability("appActivity", configProp.getProperty("APP_ACTIVITY"));
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
		capabilities.setCapability("automationName", configProp.getProperty("ANDROID_AUTOMATION_ENGINE"));
		capabilities.setCapability("autoGrantPermissions", true);
		driver = new AndroidDriver(new URL(configProp.getProperty("APPIUM_URL")), capabilities);

	}

	/**
	 * this method creates the iOS driver
	 * 
	 * @param buildPath-  path to pick the location of the app
	 * @param methodName- name of the method under execution
	 * @throws MalformedURLException Thrown to indicate that a malformed URL has
	 *                               occurred.
	 */
	public void iOSDriver(String buildPath) throws MalformedURLException {
		File app = new File(buildPath);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", configProp.getProperty("PLATFORM_NAME"));
		capabilities.setCapability("platformVersion", "13.0");
		capabilities.setCapability("appiumVersion", "1.17.1");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, configProp.getProperty("DEVICE_NAME"));
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("noReset", "true");
		driver = new IOSDriver(new URL(configProp.getProperty("APPIUM_URL")), capabilities);

	}

	/**
	 * this method loads properties files config and file having test data.
	 * 
	 * @param platform android or ios, to load specific test data file.
	 * @throws Exception property files are not loaded successfully
	 */
	public void propertiesFileLoad(String platform) throws Exception {
		configFis = new FileInputStream(file.getAbsoluteFile() + CONFIG_FILE_PATH);
		configProp.load(configFis);

		File f = new File(file.getAbsoluteFile() + "/resource/config/" + platform + "_config.properties");

		if (f.exists() && !f.isDirectory()) {
			lobConfigFis = new FileInputStream(
					file.getAbsoluteFile() + "/resource/config/" + platform + "_config.properties");
			lobConfigProp.load(lobConfigFis);
		} else {
			throw new Exception("Properties files loading failed ");
		}
	}

	public String choosebuild(String invokeDriver) {
		String appPath = null;
		if (invokeDriver.equals("android")) {
			appPath = configProp.getProperty("ANDROID_APP_PATH");
			return appPath;
		} else if (invokeDriver.equals("iOS")) {
			appPath = configProp.getProperty("IOS_APP_PATH");
			return appPath;
		}

		return appPath;
	}

}
