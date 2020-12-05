package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CommonUtils {
	
	private static AndroidDriver driver;
	private static int IMPLICIT_WAIT;
	private static int EXPLICIT_WAIT;
	private static String PLATFORM_NAME;
	private static String PLATFORM_VERSION;
	private static String APPIUM_PORT_NUMBER;
	private static String DEVICE_NAME;
	private static String APP_PACKAGE;
	private static String APP_ACTIVITY;
	private static URL serverUrl;
	private static DesiredCapabilities capabilities = new DesiredCapabilities();
	
	public static void loadConfig(String loadConfigFile) throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\"+loadConfigFile);
		Properties pro = new Properties();
		pro.load(fis);
		
		IMPLICIT_WAIT = Integer.parseInt(pro.getProperty("implicit.wait"));
		EXPLICIT_WAIT = Integer.parseInt(pro.getProperty("explicit.wait"));
		DEVICE_NAME = pro.getProperty("device.name");
		PLATFORM_NAME = pro.getProperty("platform.name");
		PLATFORM_VERSION = pro.getProperty("platform.version");
		APPIUM_PORT_NUMBER = pro.getProperty("appium.port.number");
		APP_PACKAGE = pro.getProperty("base.pkg");
		APP_ACTIVITY = pro.getProperty("activity.pkg");
		
	}
	
	public static void loadCapabilities() {
		
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
		capabilities.setCapability("appPackage", APP_PACKAGE);
		capabilities.setCapability("appActivity", APP_ACTIVITY);
		
	}
	
	public static AndroidDriver getDriver() throws IOException {
		
		serverUrl=new URL("http://0.0.0.0:"+APPIUM_PORT_NUMBER+"/wd/hub");
		driver = new AndroidDriver(serverUrl, capabilities);
		
		return driver;
	}
	

}
