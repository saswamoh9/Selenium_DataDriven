package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class PageNavigation{
	
	private WebDriver driver;
	
	public PageNavigation(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	//Navigate to Flights Page
	public FlightSearch navigate_to_Flight()
	{
		driver.findElement(By.xpath("//*[@class='makeFlex font12']//child::li[1]//child::a")).click();
		return new FlightSearch(driver);
	}
	//Navigate to Hotels Page
	public HotelSearch navigate_to_Hotels()
	{
		driver.findElement(By.xpath("//*[@class='makeFlex font12']//child::li[2]//child::a")).click();
		return new HotelSearch(driver);
	}
	
	//Navigate to Holidays
	public HolidaySearch navigate_to_Holidays()
	{
		driver.findElement(By.xpath("//*[@class='makeFlex font12']//child::li[3]//child::a")).click();
		return new HolidaySearch(driver);
	}
	
	//Navigate to Trains
	public TrainSearch navigate_to_Trains()
	{
		driver.findElement(By.xpath("//*[@class='makeFlex font12']//child::li[4]//child::a")).click();
		return new TrainSearch(driver);
	}
	

}
