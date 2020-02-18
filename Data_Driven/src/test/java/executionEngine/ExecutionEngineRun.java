package executionEngine;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.Test;

import utilities.Dataprovider;
import utilities.Excel_Reader;


public class ExecutionEngineRun {

	
	
	
	public static ArrayList<String> TestSuiteToBeExecuted() throws IOException
	{
		Excel_Reader Er = new Excel_Reader("D:\\Data_Driven_Java\\Selenium_DataDriven\\Data_Driven\\Resources\\Excel_Files\\Test_Suite.xlsx");
		ArrayList<String> suitelist = new ArrayList<String>();
		int rowlen = Er.getSheetData("Suite", 0).length;
		//int collen = Er.getSheetData("Suite", 0)[0].length;
		//String[][] sheet1 = new String[rowlen][collen];
		
		for(int i=1;i<rowlen;i++)
		{
			if(Er.getSheetData("Suite",0)[i][1].equalsIgnoreCase("Y"))
			{
				suitelist.add(Er.getSheetData("Suite",0)[i][0].toString());
			}
		}
		
		return suitelist;
		
	}
	
}
