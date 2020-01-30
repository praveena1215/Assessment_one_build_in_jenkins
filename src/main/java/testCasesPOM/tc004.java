package testCasesPOM;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageTestCase4.IrctcHomePage;
import wrappers.ProjectWrappers;

public class tc004 extends ProjectWrappers {
	
	@BeforeClass
	
	public void beforeClass(){	
		
		testCaseName = "tc004";
		testCaseDescription = "Assessment 1";
		author = "Praveen";
		categoryName = "Smoke";
		
	}
	
		@Test
	public void assementTestCase004() throws InterruptedException{
			
		new IrctcHomePage(driver)
		.sleepHomePage()
		.closeAdvtWind()
		.clickOnAgentLoginMenu()			
		.clickOnStaysOption()
		//.waitBeforeClickOnLounge()
		.clickOnLounge()
		.switchWindToLoungePage()
		.clickOnMenuButton()	
		.clickOnCharacter()
		.windowToEnquiryForm()
		.clickOnEnquiryFormByElement()
		.clickOnEnquiryForm()
		.enterNameOfApp("Dummy")
		.enterNameofOrganization("ABC Corp")
		.enterAddress("20 Gods name street, New Country")
		.enterMobileNumber("98844335567")
		.enterEmailId("dummy123@gamil.com")
		.tabAtEmail()
		.clickRequestFor()
		.clickOnsaloonCharter()
		.waitTillOriginStation()
		.originatingStation("Chennai")
		.destinationStations("Central")
		.checkInDate()
		.checkOutDate()		
		.durationPeriod("10")
		.coachDetails("S12")
		.numOfPassangers("12")
		.purposeOfCharacter("Tourism")
		.additionalServiceRequired("Yes")
			
		.sleep()
		.clickOnSubmit()
		.getMobileNumber();		
			
	}

}
