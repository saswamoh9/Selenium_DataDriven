package executionEngine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import org.testng.ITestNGListener;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlClass;

public class TestngXmlCreator {
	
	public void xmlCreator() throws IOException
	{
		ArrayList<String> suiteList = ExecutionEngineRun.TestSuiteToBeExecuted();
		//ArrayList<String> TCYesDataExecute = ExecutionEngineRun.ExecuteDataYesTestCases();
		ArrayList<String> TCNoDataExecute = ExecutionEngineRun.ExecuteDataNoTestCases();
		XmlSuite suite = null;
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		List<Class<? extends ITestNGListener>> ls = new ArrayList<Class<? extends ITestNGListener>>();
		for(int i=0;i<suiteList.size();i++)
		{
			suite = new XmlSuite();
			suite.setName(suiteList.get(i));
			
			
			
			
			XmlTest test = new XmlTest(suite);
			test.setName("TmpTest");
			List<XmlClass> classes = new ArrayList<XmlClass>();
			for(int j=0;j<TCNoDataExecute.size();j++)
			{
				classes.add(new XmlClass("testCases."+suiteList.get(i)+"_Test_Cases."+suiteList.get(i).toString()+"_"+TCNoDataExecute.get(j).toString()));
			}
			ls.add(helperClasses.Listeners.class);
			test.setXmlClasses(classes) ;
			suites.add(suite);
			System.out.println(suite.toXml());
			
		}	
		
		TestNG tng = new TestNG();
		tng.setXmlSuites(suites);
		tng.setListenerClasses(ls);
		tng.run();
	}
	
	public static void main(String[] args) throws IOException
	{
		TestngXmlCreator Txg = new TestngXmlCreator();
		Txg.xmlCreator();
	}
}
