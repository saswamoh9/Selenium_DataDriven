package helperClasses;


import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import base.BasePage;
import utilities.ExtentReportManager;





public class Listeners extends BasePage implements ITestListener{

	Logger log = Logger.getLogger("devpinoyLogger");
	@Override	
	public void onTestStart(ITestResult result) {
		log.debug("Test Case Started");
		ExTest = repo.startTest(result.getMethod().getMethodName());
		ExTest.log(LogStatus.INFO, result.getName().toUpperCase()+"TEST CASE STARTED");
		
	}

	@Override	
	public void onTestSuccess(ITestResult result) {
		log.debug("Test Case Passed");
		ExTest.log(LogStatus.PASS, result.getName().toUpperCase()+"PASS");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		log.debug("Test Case Failed");
		ExTest.log(LogStatus.FAIL, result.getName().toUpperCase()+"FAIL");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log.debug("Test Case Skipped");
		ExTest.log(LogStatus.SKIP, result.getName().toUpperCase()+"TEST CASE SKIPPED");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		repo= ExtentReportManager.getInstance();
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		repo.endTest(ExTest);
		repo.flush();
	}

}
