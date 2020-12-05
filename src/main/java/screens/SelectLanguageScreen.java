package screens;

import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import constants.Constants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SelectLanguageScreen extends ScreenBase {

	public SelectLanguageScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(xpath=Constants.SELECT_ENGLISH_XPATH)
	private AndroidElement selectEnglish;
	
	@AndroidFindBy(xpath=Constants.SELECT_HINDI_XPATH)
	private AndroidElement selectHindi;
	
	@AndroidFindBy(xpath=Constants.SELECT_TAMIL_XPATH)
	private AndroidElement selectTamil;
	
	public AgreeandContinueScreen selectLanguage(String language) {
		
		if(language.toLowerCase().contains("english")) {
			
			waitForElement(Constants.SELECT_ENGLISH_XPATH, "XPATH");
			selectEnglish.click();
	
		}else if(language.toLowerCase().contains("hindi")) {
			
			waitForElement(Constants.SELECT_HINDI_XPATH, "XPATH");
			selectHindi.click();
			
		}else if(language.toLowerCase().contains("tamil")) {
			
			waitForElement(Constants.SELECT_TAMIL_XPATH, "XPATH");
			selectTamil.click();
		}		
		
		return new AgreeandContinueScreen(driver);
	}


}
