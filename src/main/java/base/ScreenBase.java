package base;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ScreenBase {

	public static AndroidDriver<AndroidElement> driver;
	

	public ScreenBase(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;

	}
	
	public static void pressBackKey() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

	public static void waitForElement(String locator, String elementType) {
		WebDriverWait wait ;

		switch (elementType) {

		case "XPATH":
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			break;

		case "ID":
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
			break;

		case "CLASSNAME":
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
			break;
			
		case "UIAUTOMATOR":
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(locator)));
			break;
			
		
		default:
			System.out.println("Element type mentioned is wrong");

		}

	}
}