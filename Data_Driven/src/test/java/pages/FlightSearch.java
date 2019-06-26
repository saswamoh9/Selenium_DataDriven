package pages;

import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import utilities.PropertyReader;
import utilities.dateSelector;

public class FlightSearch {

	private WebDriver driver;
	
	public FlightSearch(WebDriver driver)
	{
		this.driver = driver;
	}
		
	PageNavigation pgnav = new PageNavigation(driver);
	
	Logger log = Logger.getLogger("devpinoyLogger");

	
	
	
	public void initialise_flight()
	{
		pgnav.navigate_to_Flight();
	}
	
	
	public void enterFrom(String From, String FromCity) throws IOException
	{
		driver.findElement(By.xpath(PropertyReader.OR_Reader("flight_OR", "flight_roundtrip"))).click();
		log.debug("Roundtrip option clicked");
		driver.findElement(By.xpath("//span[contains(text(), 'From')]")).click();
		log.debug("Deparature field clicked");
		driver.findElement(By.xpath(PropertyReader.OR_Reader("flight_OR", "flight_from_textbox"))).sendKeys(From);
		log.debug("Airport Code Entered: "+From);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String dropdownvalue = "//p[@class='font14 appendBottom5 blackText' and contains(text(),'"+FromCity+"')]";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath(dropdownvalue)).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void enterTo(String To, String ToCity) throws IOException
	{
		driver.findElement(By.xpath("//span[contains(text(), 'To')]")).click();
		driver.findElement(By.xpath(PropertyReader.OR_Reader("flight_OR", "flight_to_textbox"))).sendKeys(To);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String dropdownvalue = "//p[@class='font14 appendBottom5 blackText' and contains(text(),'"+ToCity+"')]";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath(dropdownvalue)).click();
	}
			
	public void enterToDate(String ToDate) throws IOException, ParseException
	{
		driver.findElement(By.xpath("//span[contains(text(),'RETURN')]")).click();
		log.debug("Return clicked");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement currentdatexpath = driver.findElement(By.xpath("//*[@class='DayPicker-Day DayPicker-Day--start DayPicker-Day--selected' and @aria-selected='true']"));
		String currentdate_day = currentdatexpath.getAttribute("aria-label");
		log.debug(currentdate_day);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		int noOfClicks = dateSelector.numberOfClicks(currentdate_day, ToDate);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		log.debug("Number of Clicks "+noOfClicks);
		for(int i=1;i<=noOfClicks;i++)
		{
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			log.debug("Clicked on next button "+i + " Time");
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		}
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath(dateSelector.convertDateToXpath(ToDate))).click();
	}
	
	public void enterFromDate(String FromDate) throws IOException, ParseException
	{
		driver.findElement(By.xpath("//span[contains(text(), 'DEPARTURE')]")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement currentdatexpath = driver.findElement(By.xpath("//*[@class='DayPicker-Day DayPicker-Day--start DayPicker-Day--selected' and @aria-selected='true']"));
		String currentdate_day = currentdatexpath.getAttribute("aria-label");
		log.debug(currentdate_day);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		int noOfClicks = dateSelector.numberOfClicks(currentdate_day, FromDate);
		log.debug("Number of Clicks "+noOfClicks);
		for(int i=1;i<=noOfClicks;i++)
		{
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			log.debug("Clicked on next button "+i + " Time");
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		}
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath(dateSelector.convertDateToXpath(FromDate))).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}
	
	public void changeTravellerClass() throws IOException
	{
		driver.findElement(By.xpath(PropertyReader.OR_Reader("flight_OR", "flight_traveller_class"))).click();
	}
	
	public void enterNoOfAdults(int noOfAdults) throws IOException, InterruptedException
	{
		WebElement ele = driver.findElement(By.xpath("//*[@class='travellers']//child::div[@class='appendBottom20']//child::ul[1]//li[contains(text(), '"+noOfAdults+"')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		//driver.findElement(By.xpath("//*[@class='travellers']//child::div[@class='appendBottom20']//child::ul[1]//li[contains(text(), '"+noOfAdults+"')]")).click();
		//driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Thread.sleep(5000);
	}
	
	public void enterNoOfChildren(int noOfChildren) throws InterruptedException
	{
		WebElement ele = driver.findElement(By.xpath("//*[@class='travellers']//child::div[@class='appendBottom20']//child::ul[2]//li[contains(text(), '"+noOfChildren+"')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
	}
	
	public void enterNoOfInfants(int noOfInfants) throws InterruptedException
	{
		WebElement ele = driver.findElement(By.xpath("//*[@class='travellers']//child::div[@class='appendBottom20']//child::ul[3]//li[contains(text(), '"+noOfInfants+"')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Thread.sleep(5000);
	}
	
	public void travellerClass(String travelClass) throws InterruptedException
	{
		if(travelClass.equalsIgnoreCase("Economy"))
		{
			WebElement ele = driver.findElement(By.xpath("//*[@class='appendBottom20']//child::ul[4]//li[1]"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ele);
			Thread.sleep(5000);
		}
		else if (travelClass.equalsIgnoreCase("Premium Economy"))
		{
			WebElement ele = driver.findElement(By.xpath("//*[@class='appendBottom20']//child::ul[4]//li[2]"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ele);
			Thread.sleep(5000);
		}
		else if (travelClass.equalsIgnoreCase("Business"))
		{
			WebElement ele = driver.findElement(By.xpath("//*[@class='appendBottom20']//child::ul[4]//li[3]"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ele);
			Thread.sleep(5000);
		}
	}
	
	public void travelClassApply() throws IOException, InterruptedException
	{
		driver.findElement(By.xpath(PropertyReader.OR_Reader("flight_OR", "flight_travelclass_apply"))).click();
		Thread.sleep(5000);
	}
	public void clickSearch() throws IOException, InterruptedException
	{
		driver.findElement(By.xpath(PropertyReader.OR_Reader("flight_OR", "flight_search_button"))).click();
		Thread.sleep(5000);
	}
}
