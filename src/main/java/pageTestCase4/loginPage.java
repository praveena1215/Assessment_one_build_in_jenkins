package pageTestCase4;

import org.openqa.selenium.remote.RemoteWebDriver;

import wrappers.GenericWrappers;

public class loginPage extends GenericWrappers {
	
	public loginPage(RemoteWebDriver argdriver){
		this.driver = argdriver;
	}
	
	public loginPage mouseHoverOnToursim() throws InterruptedException{
		Thread.sleep(5000);
		mouseHoverByXpath("//*[contains(text(),'Tourism')]");
		Thread.sleep(5000);
		return this;
					
	}
	
	public loginPage mouseHoverOnStays() throws InterruptedException{
		mouseHoverByXpath("//*[contains(text(),'Stays')]");		
		Thread.sleep(3000);
		return this ;
			
	}
	
	public loginPage clickOnLounge() throws InterruptedException{
		Thread.sleep(3000);
		//mouseHoverByXpath("//a[contains(text(),'Lounge')]");
		clickByXpath("//a[text()='Lounge']");
		return this;
	}
	
	
	public LoungePage switchWindToLoungePage() throws InterruptedException{
		switchToLastWindow();
		Thread.sleep(3000);
		return new LoungePage(driver);
	}
public loginPage waitBeforeClickOnLounge(){
	waitByElementByXpath("//a[contains(text(),'Lounge')]");
	return this;
}
	
			
	
}
	

