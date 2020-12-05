package screens;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;

import base.CommonFunctions;
import base.ScreenBase;
import constants.Constants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class AddCropScreen extends ScreenBase {
	public String farmNameSaved;

	public AddCropScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBy(xpath=Constants.SELECT_ADDCROP_XPATH)
	private AndroidElement selectAddCrop;

	@AndroidFindBy(xpath=Constants.SELECT_FARMNAME_XPATH)
	private AndroidElement farmName;

	@AndroidFindBy(xpath=Constants.SELECT_FARMNAME1_XPATH)
	private AndroidElement farmName1;

	@AndroidFindBy(xpath=Constants.SELECT_RICEVARIETIES_XPATH)
	private  List<AndroidElement>  riceVariety;

	@AndroidFindBy(xpath=Constants.SELECT_GROWINGPERIOD_XPATH)
	private  List<AndroidElement> growPeriod;

	@AndroidFindBy(xpath=Constants.SELECT_FARMSIZE_XPATH)
	private  List<AndroidElement>  sizeFarm;

	@AndroidFindBy(xpath=Constants.VERIFY_FARMDETAILS_XPATH)
	private  List<AndroidElement>  farmDetails;

	@AndroidFindBy(xpath=Constants.SELECT_SAVE_XPATH)
	private AndroidElement selectSave;

	public void addCrop() {
		selectAddCrop.click();
	}

	public void enterFarmNameandDetails(String nameFarm, String varietyRice, String growingPeriod, String farmSize) {
		farmNameSaved=nameFarm;
		farmName.click();
		farmName1.sendKeys(nameFarm);
		ScreenBase.pressBackKey();

		for(int i=0; i<riceVariety.size(); i++) {

			if(riceVariety.get(i).getText().equals(varietyRice)) {
				riceVariety.get(i).click();
				riceVariety.get(i).click();
				break;
			}else {
				continue;
			}
		}
		if(growPeriod.size()<=0) {
			CommonFunctions.scrollUp(1, driver);
			for(int j=0; j<growPeriod.size(); j++) {
				if(growPeriod.get(j).getText().equals(growingPeriod)) {
					growPeriod.get(j).click();
					break;
				}else {
					CommonFunctions.scrollUp(1, driver);
					continue;
				}
			}}else {
				for(int j=0; j<growPeriod.size(); j++) {
					if(growPeriod.get(j).getText().equals(growingPeriod)) {
						growPeriod.get(j).click();
						break;
					}else {

						CommonFunctions.scrollUp(1, driver);
						continue;
					}
				}	
			}


		if(sizeFarm.size()<=0) {
			CommonFunctions.scrollUp(1, driver);
			for(int k=0; k<sizeFarm.size(); k++) {
				if(sizeFarm.get(k).getText().equals(farmSize)) {
					sizeFarm.get(k).click();
					break;
				}else {
					CommonFunctions.scrollUp(1, driver);
					continue;
				}

			}
		}else {

			for(int k=0; k<sizeFarm.size(); k++) {
				if(sizeFarm.get(k).getText().equals(farmSize)) {
					sizeFarm.get(k).click();
					break;
				}else {
					CommonFunctions.scrollUp(1, driver);
					continue;
				}

			}
		}

	}
	public void selectSave() {
		selectSave.click();
	}

	public Boolean verifyFarmDetailsAreSaved() {
		Boolean flag=false;
		ScreenBase.pressBackKey();
		waitForElement(Constants.VERIFY_FARMDETAILS_XPATH, "XPATH");
		if(farmDetails.size()>=0) {
			for(int i=0; i<farmDetails.size(); i++) {
				if(farmDetails.get(i).getText().equals(farmNameSaved)) {
					System.out.println("--- : " + farmDetails.get(i).getText());
					flag=true;
				}
			}
		}

		if(flag) {
			return true;
		}else {
			return false;
		}
	}


}
