package testCases.Flight_Test_Cases;

import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BasePage;
import dataproviders.FlightDataprovider;
import pages.FlightSearch;

public class Flight_TS_03 extends BasePage{
  @Test(dataProvider="FlightData", dataProviderClass = FlightDataprovider.class)
  public void TS03_TC_01_Oneway_Search_Business(String TravelType, String Flight_Search_From, String Flight_Search_From_City, 
		  String Flight_Search_To, String Flight_Search_To_City, String Deparature_Date,	
		  String Adults, String Children, String Infants, String Traveller_Class, String Carrier ) throws IOException, ParseException, InterruptedException {
	  
	  FlightSearch fls1 = new FlightSearch(driver);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  fls1.enterFrom(Flight_Search_From, Flight_Search_From_City);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  fls1.enterTo(Flight_Search_To, Flight_Search_To_City);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  fls1.enterFromDate(Deparature_Date);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  fls1.enterNoOfAdults(Adults);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  fls1.enterNoOfChildren(Children);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  fls1.enterNoOfInfants(Infants);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  fls1.travellerClass(Traveller_Class);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  fls1.clickSearch();
	  
  }
  
  
  
  public void TS03_TC_02_Oneway_Search_Economy()
  {
	  
  }
}
