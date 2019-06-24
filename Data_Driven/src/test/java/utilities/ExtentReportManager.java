package utilities;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportManager {
	
	private static ExtentReports report;
	
	public static ExtentReports getInstance()
	{
		if(report==null)
		{
			report = new ExtentReports(System.getProperty("user.dir") +"\\Output\\ExtentReport.html", true);
			report.addSystemInfo("Host Name", "Saswat Computer").addSystemInfo("Environment", "Automation Testing").addSystemInfo("User Name", "Saswamoh");
			report.loadConfig(new File(System.getProperty("user.dir")+"\\Property_Files\\extent-config.xml"));
		}
		return report;
	}

}
