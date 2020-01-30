package wrappers;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class ProjectWrappers extends GenericWrappers {
	
	@BeforeSuite
	public void beforeSuit(){
		startReport();
	}
	
	public void beforeTest(){
	//reserved	
	}
	
	@BeforeMethod
		public void saloonPage(){
		startTest("testCaseName","testdescription");
		invokeApp("chrome", "https://www.irctc.co.in/nget/train-search");
			
		}
	
	@AfterMethod
	public void closeIrctc(){
		closeAllBrowsers();
	}
	
	@AfterClass
	public void afterClass(){
		endTest();
		
	}
	@AfterTest
	public void afterTest(){
		
	}
	@AfterSuite
	public void afterSuite(){
		endReport();
	}
	
}
