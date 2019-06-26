package utilities;

import java.io.File;

import org.apache.log4j.Logger;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportManager {
	
	private static ExtentReports report;
	static Logger log = Logger.getLogger("devpinoyLogger");
	
	public static ExtentReports getInstance()
	{
		if(report==null)
		{
			
			report = new ExtentReports(System.getProperty("user.dir") +"\\Output\\ExtentReport.html", true);
			log.debug("Extent Report initialised");
			report.addSystemInfo("Host Name", "Saswat Computer").addSystemInfo("Environment", "Automation Testing").addSystemInfo("User Name", "Saswamoh");
			log.debug("Details Added");
			report.loadConfig(new File(System.getProperty("user.dir")+"\\Property_Files\\extent-config.xml"));
			log.debug("Config file read");
		}
		return report;
	}

}
