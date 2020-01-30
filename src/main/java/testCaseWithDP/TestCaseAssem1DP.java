package testCaseWithDP;

import org.apache.poi.hssf.record.common.UnicodeString.PhRun;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.DataProviderForAssessment1;
import utils.ReportForAssessement1;
import wrappers.GenericWrappers;
import wrappers.ProjectWrappers;

public class TestCaseAssem1DP extends GenericWrappers{
	
	@Test(dataProvider="DPforAssessment1",dataProviderClass=DataProviderForAssessment1.class)
	
	public void dataProviderForAssem1(String NameofApplicant , String OrganizationName, String address,
			String mobileNo, String Email,  String originStation, String destnStation,
			String durationPeriod, String coachDetails, String NumberofPasseners, String NumberofPasseners1,
			String charterPurpose, String services) throws InterruptedException{
		
		//int numb = Integer.parseInt(mobileNo);
				
		invokeApp("chrome", "https://www.irctc.co.in/nget/train-search");
		//System.out.println("1ststep");
		
		
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/div[1]/div[3]/a/i");
		
				
		//*[@id="slide-menu"]/p-sidebar/div/nav/ul/li[4]/label
		
				
		clickByXpath("//*[@id='slide-menu']/p-sidebar/div/nav/ul/li[4]/label");
		
		clickByXpath("//*[@id='slide-menu']/p-sidebar/div/nav/ul/li[4]/ul/li[3]/a/span");
						
		
		switchToLastWindow();
		//sleep("/i[@class='fas fa-bars']");
		clickByXpath("//i[@class='fas fa-bars']");
		sleep("//*[contains(text(), 'Charter')]");
		clickByXpath("//*[contains(text(), 'Charter')]");
		
		sleep("//*[@id='Enquiry-tab-just']");
		tabFunction("//*[@id='Enquiry-tab-just']");
		clickByXpath("//*[@id='Enquiry-tab-just']");
		//clickByXpath("//a[contains(text(), 'Enquiry Form')]");
		sleep("//input[@name = 'name']");
		enterTextByXpath("//input[@name = 'name']", NameofApplicant);
		//sleep("//input[@name = 'organization']");
		tabFunction("//input[@name = 'organization']");
		enterTextByXpath("//input[@name = 'organization']", OrganizationName);
		enterTextByXpath("//input[@name = 'address']", address);
		enterTextByXpath("//input[@name = 'mobile']", mobileNo);
		enterTextByXpath("//input[@placeholder= 'Email']", Email);
		
		tabFunction("//select[@name='requestFor']");
		
		clickByXpath("//select[@name='requestFor']");
		sleep("//*[@id='Enquiry-just']/div/form/div/div[8]/select/option[2]");
		clickByXpath("//*[@id='Enquiry-just']/div/form/div/div[8]/select/option[2]");
		enterTextByXpath("//input[@name='originStation']", originStation);
		enterTextByXpath("//input[@name='destnStation']", destnStation);
		tabFunction("//input[@name='checkInDate']");
		clickByXpath("//input[@name='checkInDate']");
		//clickByXpath("//span[contains(text(), '28')]");
		clickByXpath("//*[@id='Enquiry-just']/div/form/div/div[11]/div/div/table/tbody/tr[5]/td[4]/span");
		tabFunction("//input[@name='checkOutDate']");
		clickByXpath("//input[@name='checkOutDate']");
		clickByXpath("//*[@id='Enquiry-just']/div/form/div/div[12]/div/div/table/tbody/tr[5]/td[5]/span");
		//clickByXpath("//*[@id='Enquiry-just']/div/form/div/div[12]/div/div/table/tbody/tr[5]/td[6]/span");	
		enterTextByXpath("//input[@name='durationPeriod']", durationPeriod);
		enterTextByXpath("//input[@name='coachDetails']", coachDetails);
		enterTextByXpath("//*[@id='Enquiry-just']/div/form/div/div[15]/input", NumberofPasseners);
		enterTextByXpath("//*[@id='Enquiry-just']/div/form/div/div[16]/input", NumberofPasseners1);
		enterTextByXpath("//textarea[@name='charterPurpose']", charterPurpose);
		enterTextByXpath("//textarea[@name='services']", services);
		clickByXpath("//button[contains(text(), 'Submit')]");
		
		
				
	}
	
	
	

}
