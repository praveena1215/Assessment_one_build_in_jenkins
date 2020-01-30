package pageTestCase4;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import wrappers.GenericWrappers;

public class IrctcHomePage extends GenericWrappers{
	

	public IrctcHomePage clickOnAgentLoginMenu(){	
			
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[1]/a[8]/span");
		return this;
		
	}
	
	public IrctcHomePage sleepHomePage() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 100);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='corover-close-btn']")));
		return this;
	}
	
	public IrctcHomePage clickOnStaysOption() throws InterruptedException{
		//clickByXpath("//span[@class='ng-star-inserted']");
		//clickByXpath("//*[@id='slide-menu']/p-sidebar/div/nav/ul/li[14]/a/label/span");
		//Thread.sleep(5000);
		//clickByXpath("//span[contains(text(),'AGENT LOGIN')]");
		//clickByXpath("//*[@id='slide-menu']/p-sidebar/div/nav/ul/li[14]/a/label/span");
		//Thread.sleep(5000);
		clickByXpath("//label[contains(text(), 'STAYS')]");
		return this;
		
	}
	 public IrctcHomePage clickOnLounge(){
		 clickByXpath("//*[@id='slide-menu']/p-sidebar/div/nav/ul/li[4]/ul/li[3]/a/span");
		 return this;
		 
	 }
	
	public IrctcHomePage(RemoteWebDriver argDriver){
		this.driver = argDriver;
		
	}
	public IrctcHomePage pageDown(){
		pageDownbyxPath("//ul[@class='ng-star-inserted']");
		return this;
	}
	
	public IrctcHomePage scrollPageDown(){
	scrollView("//span[@class='ng-star-inserted']");
	
	return this;
	}
	
	public IrctcHomePage scrollVeritcal(){
		scrollDownThePage("//div[@class='ng-tns-c7-3 ng-trigger ng-trigger-panelState ui-sidebar ui-widget ui-widget-content ui-shadow ui-sidebar-active ui-sidebar-right']");
	return this;
	}
	
	public IrctcHomePage closeAdvtWind(){
		clickByXpath("//div[@id='corover-close-btn']");
		return this;
	}

	public LoungePage switchWindToLoungePage(){
		switchToLastWindow();
		return new LoungePage(driver);
	
	}
	
	
}
