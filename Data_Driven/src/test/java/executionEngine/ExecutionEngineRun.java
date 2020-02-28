package executionEngine;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import utilities.Dataprovider;
import utilities.Excel_Reader;
import java.util.Arrays;

public class ExecutionEngineRun {

	
	
	
	public static ArrayList<String> TestSuiteToBeExecuted() throws IOException
	{
		Excel_Reader Er = new Excel_Reader("D:\\Data_Driven_Java\\Selenium_DataDriven\\Data_Driven\\Resources\\Excel_Files\\Test_Suite.xlsx");
		ArrayList<String> suitelist = new ArrayList<String>();
		String[][] SuiteListArray = Er.getSheetData("Suite", 0);
		System.out.println(SuiteListArray[1][1]);
		for(int i=0;i<SuiteListArray.length;i++)
		{
			System.out.println(SuiteListArray[i][0]);
		}
		for(int i=0;i<SuiteListArray.length;i++)
		{
			if(SuiteListArray[i][1].equalsIgnoreCase("Y"))
			{
				suitelist.add(SuiteListArray[i][0].toString());
			}
		}
		System.out.println(suitelist);
		return suitelist;
	}
	
	public static ArrayList<ArrayList<String>> TCtoBeExecuted() throws IOException
	{
		ArrayList<String> s = ExecutionEngineRun.TestSuiteToBeExecuted();
		String[][] TestCaseArray1 = null;
		  ArrayList<ArrayList<String> > x = new ArrayList<ArrayList<String> >(); 
		int t=0;
		for(int j=0;j<s.size();j++)
		{
			
			String fileName = "D:\\Data_Driven_Java\\Selenium_DataDriven\\Data_Driven\\Resources\\Excel_Files\\"+s.get(j)+".xlsx";
			System.out.println(fileName);
			Excel_Reader Er = new Excel_Reader(fileName);
			String[][] TestCaseStringArray = Er.getSheetData("Test_Case_List", 0);
			int n=0;
			for(int i=0;i<TestCaseStringArray.length;i++)
			{
				
				if(TestCaseStringArray[i][3].equalsIgnoreCase("Y"))
				{
					
						x.add(new ArrayList<String>(Arrays.asList(TestCaseStringArray[i][0],TestCaseStringArray[i][1]
								,TestCaseStringArray[i][2],TestCaseStringArray[i][3],TestCaseStringArray[i][4])));
					
					 
				}
			}
			
		}
		return x;
	}
	
	public static ArrayList<String> ExecuteDataYesTestCases() throws IOException
	{
		ArrayList<ArrayList<String>> TestCaseExecutionlist = TCtoBeExecuted();
	
		int StringArraySize = TestCaseExecutionlist.size();
		ArrayList<String> TestDataTC = new ArrayList<String>();
		for(int i=0; i<StringArraySize;i++)
		{
			
			if(TestCaseExecutionlist.get(i).get(4).equalsIgnoreCase("Y"))
			{
				TestDataTC.add(TestCaseExecutionlist.get(i).get(1));
			}
			
		}
		System.out.println(TestDataTC);
		return TestDataTC;
		
	}
	
	public static ArrayList<String> ExecuteDataNoTestCases() throws IOException
	{
		ArrayList<ArrayList<String>> TestCaseExecutionlist = TCtoBeExecuted();
		
		int StringArraySize = TestCaseExecutionlist.size();
		ArrayList<String> NoTestDataTC = new ArrayList<String>();
		for(int i=0; i<StringArraySize;i++)
		{
			
			if(TestCaseExecutionlist.get(i).get(4).equalsIgnoreCase("N"))
			{
				NoTestDataTC.add(TestCaseExecutionlist.get(i).get(1));
			}
			
		}
		System.out.println(NoTestDataTC);
		return NoTestDataTC;
	}
	
}
