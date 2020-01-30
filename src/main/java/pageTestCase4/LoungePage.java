package pageTestCase4;

import org.openqa.selenium.remote.RemoteWebDriver;

import wrappers.GenericWrappers;

public class LoungePage extends GenericWrappers{

	public LoungePage clickOnMenuButton() throws InterruptedException{
		Thread.sleep(30000);
		clickByXpath("//i[@class='fas fa-bars']");
		Thread.sleep(3000);
		//System.err.println("Character menu failed");
		//clickByXpath("/html/body/app-root/homeheader/header/nav/div/div/a[2]/i");
		return this;
	}
	
	public LoungePage clickOnCharacter(){
		//clickByXpath("//a[@class='waves-effect tabhomemenu active'])]");
		clickByXpath("//*[contains(text( ), 'Charter')]");
		return this;
	}	
	public LoungePage(RemoteWebDriver argdriver){
		this.driver = argdriver;
	}
	public LoungePage waitBeforeClickOnCharter(){
		waitByElementByXpath("//div[@id='mySidenav']//following::ul/li[12]/a");
		return this;
	}
	
	public EnquiryFormPage windowToEnquiryForm(){
		switchToLastWindow();
		return new EnquiryFormPage(driver);
	}
	
	
	

}
