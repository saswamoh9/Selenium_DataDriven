package utilities;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
	public static void main(String[] args) throws IOException
	{
		Properties config = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Property_Files\\Config.properties");
		config.load(fis);
		
		
		System.out.println(config.getProperty("browser"));
		
	}
	
}
