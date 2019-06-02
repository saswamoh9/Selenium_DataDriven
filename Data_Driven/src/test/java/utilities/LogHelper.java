package utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogHelper {
	
	
	
	public Logger printLogs(Class<?> classname)
	{
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\Property_Files\\log4j.properties");
		return Logger.getLogger(classname);
		
	}
}
