package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import screens.AddCropScreen;
import screens.AgreeandContinueScreen;
import screens.SelectLanguageScreen;

public class VerifyAddCropDetailsAreSaved extends TestBase {

	SelectLanguageScreen slc;
	AgreeandContinueScreen acs;
	AddCropScreen cs;
	
	@BeforeTest
	public void init() throws IOException {
		setUp();
		slc = new SelectLanguageScreen(driver);
	
	}

	@Test
	public void verifyCropDetailsAreSaved() {
		acs=slc.selectLanguage("english");
		cs=acs.selectAgreeContinue();
		cs.addCrop();
		cs.enterFarmNameandDetails("test1", "Basmatic", "Short", ">5 acres");
		cs.selectSave();
		Assert.assertTrue(cs.verifyFarmDetailsAreSaved());
	}

}
