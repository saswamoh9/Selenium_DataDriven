package base;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import executionEngine.ExecutionEngineRun;
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
	@BeforeSuite
	public void testcasese() throws IOException
	{
		ArrayList<String> s = ExecutionEngineRun.TestSuiteToBeExecuted();
		
		for(int i=0;i<s.size();i++)
		{
			System.out.println(s.get(i));
		}
		
		for(int j=0;j<s.size();j++)
		{
			String Mod_Type[] = s.get(j).split("_", 2);
			String fileName = "D:\\Data_Driven_Java\\Selenium_DataDriven\\Data_Driven\\Resources\\Excel_Files\\"+Mod_Type[0]+".xlsx";
			//System.out.println(fileName);
			Excel_Reader Er = new Excel_Reader(fileName);
			int rowlen = Er.getSheetData("Test_Case_List", 0).length;
			ArrayList<String> TestCaseList = new ArrayList<String>();
			
			for(int i=1;i<rowlen;i++)
			{
				if(Er.getSheetData("Test_Case_List",0)[i][3].equalsIgnoreCase("Y"))
				{
					TestCaseList.add(Er.getSheetData("Test_Case_List",0)[i][1].toString());
				}
			}
			System.out.println(TestCaseList);
		}
		
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
