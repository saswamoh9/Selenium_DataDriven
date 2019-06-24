package utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class browserConfiguration {
	
	WebDriver driver;
	Logger log = Logger.getLogger("devpinoyLogger");
	
	public WebDriver browserconfig(String browserName)
	{
		if (browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\Browser\\chromedriver.exe");
			driver = new ChromeDriver();
			log.debug("Chrome driver started");
		}
		else if (browserName.equalsIgnoreCase("InternetExplorer")){
			
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\Resources\\Browser\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			log.debug("Internet Explorer driver started");
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Resources\\Browser\\geckodriver.exe");
			driver = new FirefoxDriver();
			log.debug("Firefox driver started");
		}
		else
		{
			
		}
		
		
		return driver;
		
	}

}
