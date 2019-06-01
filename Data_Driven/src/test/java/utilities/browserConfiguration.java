package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class browserConfiguration {
	
	WebDriver driver;
	
	public WebDriver browserconfig(String browserName)
	{
		if (browserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Browserdrive\\chromedriver.exe");
			
		}
		else if (browserName.equalsIgnoreCase("InternetExplorer")){
			driver=new InternetExplorerDriver();
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\Resources\\Browser\\IEDriverServer.exe");
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			System.setProperty("webdriver.gecko.driver","D:\\Selenium_Data_Driven\\Browser\\geckodriver.exe");
			
		}
		else
		{
			
		}
		
		
		return driver;
		
	}

}
