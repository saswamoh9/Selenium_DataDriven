package base;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import utilities.ConfigReader;
import utilities.ExtentReportManager;
import utilities.LogHelper;
import utilities.browserConfiguration;
public class BasePage {
	
	public static WebDriver driver;
	
	
	ConfigReader cnfgRdrObj = new ConfigReader();
	browserConfiguration brwsrconfigObj = new browserConfiguration();
	LogHelper logObj = new LogHelper();
	public ExtentReports repo = ExtentReportManager.getInstance();
	public static ExtentTest ExTest;
	
	Logger log = logObj.printLogs(BasePage.class);
	
	@BeforeSuite
	public void setUp() throws IOException, InterruptedException
	{
		String browserName = cnfgRdrObj.getConfigDetails("browser");
		driver = brwsrconfigObj.browserconfig(browserName);
		driver.get("https://azure.microsoft.com/");
		driver.wait(500);
	}
	
	
	public void TakeScreenshot(ITestResult result) throws IOException
	{
		final DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd SSS");
		Date date = new Date();
		String fileName = result.getName()+ "_" + dateFormat.format(date);
		
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"\\test-output\\"+fileName+".png";
		
		File target = new File(dest);
		Files.copy(src, target);
	}
	
	@Test
	public void test_case_1()
	{
		System.out.print("Test Case 1 executed");
		log.info("Saswat");
	}
	
	
	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}
}
