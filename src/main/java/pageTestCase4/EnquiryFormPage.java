package pageTestCase4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import wrappers.GenericWrappers;

public class EnquiryFormPage extends GenericWrappers {
 public EnquiryFormPage clickOnEnquiryForm(){
	 clickByXpath("//*[contains(text(),'Enquiry Form')]");
	 return this;
 }
 
 public EnquiryFormPage enterNameOfApp(String appName){
	 enterTextByXpath("//input[@name='name']",appName);
	 return this;
 }
 public EnquiryFormPage enterNameofOrganization(String companyName){
	  enterTextByXpath("//input[@name='organization']",companyName);
	 return this;
 }

 public EnquiryFormPage enterAddress(String address){
	  enterTextByXpath("//input[@name='address']",address);
	 return this;
 }
 
 public EnquiryFormPage enterMobileNumber(String mbno){
	 enterTextByXpath("//input[@name = 'mobile']", mbno);
	 return this;
 }

 public EnquiryFormPage enterEmailId(String EmailId){
	 enterTextByXpath("//input[@placeholder='Email']", EmailId);
	 return this;
 }
 public EnquiryFormPage clickRequestFor() throws InterruptedException{
	 	 clickByXpath("//select[@name='requestFor']");
	 
	 return this;
 }
	 public EnquiryFormPage clickOnsaloonCharter(){
		 clickByXpath("//*[contains(text(), 'Saloon Charter')]");
		 return this;
	 }
	 
 
 public EnquiryFormPage purposeOfCharacter(String Character){
	 enterTextByXpath("//textarea[@name='charterPurpose']", Character);
	 return this;
 }
 
 public EnquiryFormPage additionalServiceRequired(String Required){
	 enterTextByXpath("//textarea[@name='services']", Required);
 return this;
 }
 public EnquiryFormPage originatingStation(String OrgStation){
	 enterTextByXpath("//input[@name='originStation']", OrgStation);
	 return this;
 }
 public EnquiryFormPage destinationStations(String DestStat){
	 enterTextByXpath("//input[@name='destnStation']", DestStat);
	 return this;
 }
 public EnquiryFormPage checkInDate(){
	 enterTextByXpath("//input[@name='checkInDate']", "26-07-2019");
	 return this;
 }
 public EnquiryFormPage checkOutDate(){
	 enterTextByXpath("//input[@name='checkOutDate']", "28-07-2019");
	 return this;
 }
 public EnquiryFormPage durationPeriod(String data){
	 enterTextByXpath("//input[@name='durationPeriod']", data);
	 return this;
 }
 public EnquiryFormPage coachDetails(String data){	
	 enterTextByXpath("//input[@name='coachDetails']", data);
 return this;
 }
 public EnquiryFormPage numOfPassangers(String data){
	 enterTextByXpath("//input[@name='numPassenger']",data);
	 return this;
 }
 
 public EnquiryFormPage clickOnSubmit(){
	 clickByXpath("//button[@type='submit']");
	 return this;
	 
 }
 
 public EnquiryFormPage getMobileNumber(){
	 getTextByXpath("//*[contains(text(),'Mobile field is required')]");
	 return this;
 }
 public EnquiryFormPage(RemoteWebDriver argDriver){
	 this.driver = argDriver;
	 
 }
	public EnquiryFormPage clickOnEnquiryFormByElement(){
		waitByElementByXpath("//a[contains(text(),'Enquiry Form')]");
	return this;
	}

 public EnquiryFormPage sleep() throws InterruptedException{
	 Thread.sleep(5000);
	return this;
 }

 public EnquiryFormPage waitTillOriginStation(){
	WebDriverWait wait = new WebDriverWait(driver , 100);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='originStation']")));
return this;	
	 
 }
 
 public EnquiryFormPage tabAtEmail(){
	 tabFunction("//input[@placeholder='Email']");
	return this;
 }
 
 
}
