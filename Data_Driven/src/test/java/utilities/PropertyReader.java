package utilities;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
	public static String OR_Reader(String filename, String propertyname) throws IOException
	{
		Properties config = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\OR\\"+filename+".properties");
		config.load(fis);
		
		return config.getProperty(propertyname);
	}
	
}
