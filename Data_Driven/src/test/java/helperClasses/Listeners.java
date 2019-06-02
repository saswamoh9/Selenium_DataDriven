package helperClasses;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import base.BasePage;

public class Listeners extends BasePage implements ITestListener{

	
	public void onTestStart(ITestResult result) {
		ExTest.log(LogStatus.INFO, result.getName().toUpperCase()+"TEST CASE STARTED");
		
	}

	
	public void onTestSuccess(ITestResult result) {
		ExTest.log(LogStatus.PASS, result.getName().toUpperCase()+"PASS");
		repo.endTest(ExTest);
		repo.flush();
	}

	
	public void onTestFailure(ITestResult result) {
		ExTest.log(LogStatus.FAIL, result.getName().toUpperCase()+"FAIL");
		repo.endTest(ExTest);
		repo.flush();
	}

	
	public void onTestSkipped(ITestResult result) {
		ExTest.log(LogStatus.SKIP, result.getName().toUpperCase()+"TEST CASE SKIPPED");
		repo.endTest(ExTest);
		repo.flush();
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
