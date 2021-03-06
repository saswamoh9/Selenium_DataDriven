package base;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.xml.XmlSuite;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import executionEngine.ExecutionEngineRun;
import executionEngine.TestngXmlCreator;
import utilities.ConfigReader;
import utilities.Excel_Reader;
import utilities.LogHelper;
import utilities.browserConfiguration;


public class BasePage {
	
	public WebDriver driver;
	String browserName;
	
	ConfigReader cnfgRdrObj = new ConfigReader();
	browserConfiguration brwsrconfigObj = new browserConfiguration();
	
	public static ExtentReports repo;
	public static ExtentTest ExTest;
	
	Logger log = LogHelper.printLogs(BasePage.class);
	
	public Object[][] getDataForTest(String path, String TC_No) throws IOException
	{
			String fileName = path;
			Excel_Reader Er = new Excel_Reader(fileName);
			Object[][] data = Er.getTestData(TC_No);
			return data;	
	}
	
	@BeforeSuite
	public void testcasese() throws IOException
	{
		

	}
	
	@BeforeClass
	public void setUp() throws IOException, InterruptedException
	{
		browserName = cnfgRdrObj.getConfigDetails("browser");
		driver = brwsrconfigObj.browserconfig(browserName);
		driver.get("https://www.makemytrip.com/");
				
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
	
	
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
