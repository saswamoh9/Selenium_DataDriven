package helperClasses;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import base.BasePage;





public class Listeners extends BasePage implements ITestListener{

	@Override	
	public void onTestStart(ITestResult result) {
		System.out.println("Test Case Started");
		ExTest.log(LogStatus.INFO, result.getName().toUpperCase()+"TEST CASE STARTED");
		
	}

	@Override	
	public void onTestSuccess(ITestResult result) {
		ExTest.log(LogStatus.PASS, result.getName().toUpperCase()+"PASS");
		repo.endTest(ExTest);
		repo.flush();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExTest.log(LogStatus.FAIL, result.getName().toUpperCase()+"FAIL");
		repo.endTest(ExTest);
		repo.flush();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExTest.log(LogStatus.SKIP, result.getName().toUpperCase()+"TEST CASE SKIPPED");
		repo.endTest(ExTest);
		repo.flush();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
