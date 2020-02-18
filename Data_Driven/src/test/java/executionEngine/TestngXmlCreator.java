package executionEngine;

import java.util.ArrayList;
import java.util.List;

import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import org.testng.xml.XmlClass;

public class TestngXmlCreator {
	
	public void xmlCreator()
	{
		XmlSuite suite = new XmlSuite();
		suite.setName("TmpSuite");
		
		XmlTest test = new XmlTest(suite);
		test.setName("TmpTest");
		
		List<XmlClass> classes = new ArrayList<XmlClass>();
		


	}
	

}
