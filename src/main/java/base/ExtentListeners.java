package base;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

public class ExtentListeners implements ITestListener {
	
	//public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	
	
public void onTestSuccess(ITestResult result) {
	try {
		CommonFunctions.captureScreenshot();
	} catch (Exception e) {

	}
	

	}

	public void onTestFailure(ITestResult result) {

		try {
			CommonFunctions.captureScreenshot();
		} catch (Exception e) {

		}
		

	}

	public void onTestSkipped(ITestResult result) {


	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

		

	}

	public void onFinish(ITestContext context) {

		

	}

}




