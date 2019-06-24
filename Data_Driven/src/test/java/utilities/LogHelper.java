package utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogHelper {
	
	private static boolean root = false;
	
	@SuppressWarnings("rawtypes")
	public static Logger printLogs(Class classname)
	{
		
		if (root) {
			return Logger.getLogger(classname);
		}
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\Property_Files\\log4j.properties");
		root = true;
		return Logger.getLogger(classname);
		
	}
}
