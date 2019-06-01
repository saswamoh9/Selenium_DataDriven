package utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogHelper {
	
	
	
	public Logger printLogs(Class<?> classname)
	{
		PropertyConfigurator.configure("D:\\Selenium_Data_Driven\\Data_Driven\\Property_Files\\log4j.properties");
		return Logger.getLogger(classname);
		
	}
}
