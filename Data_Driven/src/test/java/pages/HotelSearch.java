package pages;

import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.PropertyReader;
import utilities.dateSelector;

public class HotelSearch {
	
	private WebDriver driver;
	
	public HotelSearch(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void search_hotel_city_area_building() throws IOException
	{
		driver.findElement(By.xpath(PropertyReader.OR_Reader("hotel_OR", "hotel_destination"))).click();
	}
	
	public void checkin_date(String FromDate) throws IOException, ParseException
	{
		driver.findElement(By.xpath(PropertyReader.OR_Reader("hotel_OR", "check_in_date_click"))).click();
		WebElement currentdate = driver.findElement(By.xpath(PropertyReader.OR_Reader("hotel_OR", "checkin_currentdate")));
		String currentdateString = currentdate.getAttribute("aria-label");
		int noOfClicks = dateSelector.numberOfClicks(currentdateString, FromDate);
		for(int i=1;i<=noOfClicks;i++)
		{
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		}
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath(dateSelector.convertDateToXpath(FromDate))).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
	}
	
	public void checkout_date(String ToDate)
	{
		
	}
}
