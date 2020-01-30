package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class ReportForAssessement1 {
	
	public static ExtentReports report;
	
	public static ExtentTest test;
	
	public  String testCaseName, testCaseDescription;
	
	 public  String author, categoryName;
	
	public static void startReport(){
		report = new ExtentReports("./reportsForAssessement1/results.html", false);
		
	}
	
	public  void startTest(String testname, String testdescription){
		test = report.startTest(testname, testdescription);
		test.assignAuthor(author);
		test.assignCategory(categoryName);
		
	}
	
	public void reportStep(String status, String description){
		
		long snapNumber = 1000001;
		snapNumber = takeSnap();
		
		if(status.equalsIgnoreCase("PASS")){
			test.log(LogStatus.PASS, description+test.addScreenCapture("../screenshotsAssessment1/snap"+snapNumber+".png"));
		} 
			else if (status.equalsIgnoreCase("FAIL")){
				test.log(LogStatus.FAIL, description);
				
			}else if (status.equalsIgnoreCase("SKIP")){
				test.log(LogStatus.SKIP, description);
					
		}else if (status.equalsIgnoreCase("WARN")){
			test.log(LogStatus.WARNING, description);
		}
		
	}
	public  abstract long takeSnap();
	
	public void endTest(){
		report.endTest(test);
	}
	
	public void endReport(){
		report.flush();
	}
	
}
