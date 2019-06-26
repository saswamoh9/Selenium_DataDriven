package testCases;

import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;


import org.testng.annotations.Test;

import base.BasePage;
import pages.FlightSearch;

public class FlightPageTestCase extends BasePage{
	
	
	
  @Test
  public void TestCase_1() throws IOException, ParseException, InterruptedException {
	 // Fs.initialise_flight();
	  driver.get("https://www.makemytrip.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	  FlightSearch Fs = new FlightSearch(driver);
	  Fs.enterFrom("BBI", "Bhubaneswar");
	  Fs.enterTo("MAA", "Chennai");
	  Fs.enterFromDate("22-Jul-2019");
	  Fs.enterToDate("02-Jan-2020");
	  //Fs.changeTravellerClass();
	  //Fs.enterNoOfAdults(2);
	  //Fs.enterNoOfChildren(3);
	  //Fs.enterNoOfInfants(1);
	  //Fs.travelClassApply();
	  Fs.clickSearch();
	  Thread.sleep(5000);
	  
  }
}
