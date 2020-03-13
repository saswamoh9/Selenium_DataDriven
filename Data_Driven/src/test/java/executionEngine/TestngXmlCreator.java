package executionEngine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import org.testng.ITestNGListener;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;

public class TestngXmlCreator {
	
	static ArrayList<String> suiteList = null;
	Map<String, ArrayList<String>>  TCYesDataExecute = null;
	Map<String, ArrayList<String>> TCNoDataExecute = null;
	@SuppressWarnings("unlikely-arg-type")
	public void xmlCreator() throws IOException
	{
		ArrayList<String> suiteList = ExecutionEngineRun.TestSuiteToBeExecuted();
		Map<String, ArrayList<String>> TCYesDataExecute = ExecutionEngineRun.ExecuteDataYesTestCases();
		System.out.println("****************************");
		System.out.println(TCYesDataExecute);
		//Map<String, ArrayList<String>> TCNoDataExecute = ExecutionEngineRun.ExecuteDataNoTestCases();
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
			
			/*for(int j=0;j<TCNoDataExecute.size();j++)
			{
				classes.add(new XmlClass("testCases."+suiteList.get(i)+"_Test_Cases."+suiteList.get(i).toString()+"_"+TCNoDataExecute.get(j)));
			}*/
			Set<String> keys = TCYesDataExecute.keySet();
			List<String> classList = keys.stream().collect(Collectors.toList());
			for(int k=0;k<TCYesDataExecute.size();k++)
			{
				classes.add(new XmlClass("testCases."+suiteList.get(i)+"_Test_Cases."+suiteList.get(i).toString()+"_"+classList.get(k)));
				int methodlistlen = TCYesDataExecute.get(classList.get(k)).size();
				System.out.println(methodlistlen);
				List<XmlInclude> methods = new ArrayList<XmlInclude>();
				for(int m=0; m<methodlistlen; m++)
				{
					methods.add(new XmlInclude(TCYesDataExecute.get(classList.get(k)).get(m).toString()));
				}
				classes.get(k).setIncludedMethods(methods);
				
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
