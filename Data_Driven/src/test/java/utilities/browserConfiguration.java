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
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\Browser\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("InternetExplorer")){
			
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\Resources\\Browser\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Resources\\Browser\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else
		{
			
		}
		
		
		return driver;
		
	}

}
