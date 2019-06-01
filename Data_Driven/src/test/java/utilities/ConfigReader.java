package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public String getConfigDetails(String PropertyName) throws IOException
	{
		Properties config = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Property_Files\\Config.properties");
		config.load(fis);
		return config.getProperty(PropertyName);
	}

}
