package base;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import utilities.AppiumServer;
import utilities.CommonUtils;

public class TestBase {
	
	public static AndroidDriver driver;
	public static Logger log = Logger.getLogger(TestBase.class);
	public static String loadPropertyFile = "yara_Android.properties";
	
	
	public void setUp() throws IOException {
		PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/test/resources/properties/logs4j.properties");
		
		AppiumServer.start();
		
		CommonUtils.loadConfig(loadPropertyFile);
		CommonUtils.loadCapabilities();
		driver = CommonUtils.getDriver();
	

		
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
		AppiumServer.stop();
		
	}

}

