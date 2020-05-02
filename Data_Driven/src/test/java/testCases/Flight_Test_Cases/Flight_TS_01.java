package testCases.Flight_Test_Cases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import helperClasses.ElementColourIdentifier;
import utilities.PropertyReader;

public class Flight_TS_01 extends base.BasePage{
  @Test
  public void TS01_TC_01_Verify_Colour_Flight_Icon() throws IOException {
	  ElementColourIdentifier Eci = new ElementColourIdentifier();
	  String color = driver.findElement(By.xpath(PropertyReader.OR_Reader("flight_OR", "flight_icon"))).getCssValue("color");
	  assertEquals(Eci.returncolorHexVal(color), "#008cff");
  }
  
  @Test
  public void TS01_TC_02_Verify_Default_TripType() throws IOException
  {
	  
  }
  
  @Test
  public void TS01_TC_03_Verify_Default_From_Field() throws IOException
  {
	  String from = driver.findElement(By.xpath(PropertyReader.OR_Reader("flight_OR", "flight_from_readonly"))).getAttribute("value");
	  assertEquals(from, "Delhi");
  }
  
  @Test
  public void TS01_TC_04_Verify_Default_To_Field() throws IOException
  {
	
	  String to = driver.findElement(By.xpath(PropertyReader.OR_Reader("flight_OR", "flight_to_readonly"))).getAttribute("value");
	  assertEquals(to, "Bangalore");
  }
  
  @Test
  public void TS01_TC_05_Verify_Default_Dep_Date()
  {
	  
  }
  
  @Test
  public void TS01_TC_06_Verify_Default_Arr_Date()
  {
	
  }
  
  @Test
  public void TS01_TC_07_Verify_Default_Search_Btn()
  {
	  
  }
  
  
}
