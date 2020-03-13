package executionEngine;



import java.io.IOException;
import java.util.ArrayList;
import utilities.Excel_Reader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
		  ArrayList<ArrayList<String> > x = new ArrayList<ArrayList<String> >(); 
		for(int j=0;j<s.size();j++)
		{
			
			String fileName = "D:\\Data_Driven_Java\\Selenium_DataDriven\\Data_Driven\\Resources\\Excel_Files\\"+s.get(j)+".xlsx";
			System.out.println(fileName);
			Excel_Reader Er = new Excel_Reader(fileName);
			String[][] TestCaseStringArray = Er.getSheetData("Test_Case_List", 0);
			for(int i=0;i<TestCaseStringArray.length;i++)
			{
				
				if(TestCaseStringArray[i][5].equalsIgnoreCase("Y"))
				{
					
						x.add(new ArrayList<String>(Arrays.asList(TestCaseStringArray[i][0],TestCaseStringArray[i][1]
								,TestCaseStringArray[i][2],TestCaseStringArray[i][3],TestCaseStringArray[i][4],
								TestCaseStringArray[i][5],TestCaseStringArray[i][6])));
					
					 
				}
			}
			
		}
		System.out.println(x);
		return x;
	}
	
	public static Map<String, ArrayList<String>> ExecuteDataYesTestCases() throws IOException
	{
		ArrayList<ArrayList<String>> TestCaseExecutionlist = TCtoBeExecuted();
		int StringArraySize = TestCaseExecutionlist.size();
		HashMap<String, ArrayList<String>> MapTestDataTC = new HashMap<String, ArrayList<String>>();
		ArrayList<String> TestDataTC = new ArrayList<String>();
		String index=TestCaseExecutionlist.get(0).get(1);
		ArrayList<String> distinctClass = new ArrayList<>();
		//TestDataTC.add(TestCaseExecutionlist.get(0).get(4));
		//MapTestDataTC.put(index, TestDataTC);
		//This function list all the distinct class names
		for(int i=1; i<StringArraySize;i++)
		{	
			if(index.equalsIgnoreCase(TestCaseExecutionlist.get(i).get(1))&&i!=StringArraySize)
			{
				continue;
			}
			else if(index!=TestCaseExecutionlist.get(i).get(1)&&i!=StringArraySize)
			{
				distinctClass.add(index);
				index = TestCaseExecutionlist.get(i).get(1);
			}
			
		}
		distinctClass.add(index);
		
		System.out.println("Distinct Classes");
		System.out.println(distinctClass);
		int j=0;
		for(int i=0;i<distinctClass.size();i++)
		{
			ArrayList<String> val = new ArrayList<String>();
			MapTestDataTC.put(distinctClass.get(i), val);
			while(j<StringArraySize)
			{
				if(distinctClass.get(i).equalsIgnoreCase(TestCaseExecutionlist.get(j).get(1)))
				{
					val.add(TestCaseExecutionlist.get(j).get(4));
					j++;
				}
				else
				{
					break;
				}
			}
		}
		System.out.println(MapTestDataTC);
		return MapTestDataTC;
		
	}
	
	/*public static Map<String, ArrayList<String>> ExecuteDataNoTestCases() throws IOException
	{
		ArrayList<ArrayList<String>> TestCaseExecutionlist = TCtoBeExecuted();
		
		int StringArraySize = TestCaseExecutionlist.size();
		Map<String, ArrayList<String>> MapNoTestDataTC = new HashMap<>();
		ArrayList<String> NoTestDataTC = new ArrayList<String>();
		for(int i=0; i<StringArraySize;i++)
		{
			if(TestCaseExecutionlist.get(i).get(1).equalsIgnoreCase(TestCaseExecutionlist.get(i+1).get(1)))
			{
				NoTestDataTC.clear();
				i++;
				NoTestDataTC.add(TestCaseExecutionlist.get(i).get(4));
			}
			MapNoTestDataTC.put(TestCaseExecutionlist.get(i).get(1), NoTestDataTC);
			
		}
		System.out.println("Test Case With No Test Data");
		System.out.println(NoTestDataTC);
		return MapNoTestDataTC;
	}*/
	
	
	
	
	
}
