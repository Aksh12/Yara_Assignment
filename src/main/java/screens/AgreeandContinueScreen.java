package screens;

import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import constants.Constants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AgreeandContinueScreen extends ScreenBase {

	public AgreeandContinueScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(xpath=Constants.SELECT_AGREECOTINUE_XPATH)
	private AndroidElement selectAgreeContinue;
	
	public AddCropScreen selectAgreeContinue() {
		waitForElement(Constants.SELECT_AGREECOTINUE_XPATH, "XPATH");
		selectAgreeContinue.click();
		return new AddCropScreen(driver);
	}

}
