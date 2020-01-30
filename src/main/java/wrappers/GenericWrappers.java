package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.functors.CatchAndRethrowClosure;
import org.apache.commons.io.FileUtils;
import org.apache.http.impl.conn.tsccm.WaitingThread;
import org.apache.http.impl.conn.tsccm.WaitingThreadAborter;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageTestCase4.IrctcHomePage;
import utils.ReportForAssessement1;

public class GenericWrappers extends ReportForAssessement1 implements Wrappers {
	public RemoteWebDriver driver;
	
	
	
	
	public void invokeApp(String browser, String url){	
		
		try {
			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				  driver = new ChromeDriver();
				 
			}
			//else if (browser.equalsIgnoreCase("firefox")){
				//System.setProperty("webdriver.gecko.exe", "./drivers/geckodriver.exe");
				 //FirefoxDriver driver = new FirefoxDriver();
							
			//}else if(browser.equalsIgnoreCase("ie")){
			//	System.setProperty("webdriver.ie.driver","./driver/IEDriverServer.exe");
			//	InternetExplorerDriver driver = new InternetExplorerDriver();
			//}
			
			driver.manage().window().maximize();
			driver.get(url);
			System.out.println("Browser luanched successfully");
			//reportStep("PASS", "Browser Launched sucessfully");	
			
			
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("Error in launching the browser");
			//reportStep("FAIL", "Browser closed due to unknown error");
		}
	}

	

	public void enterTextByXpath(String text, String data) throws ElementNotVisibleException {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(text).sendKeys(data);		
			System.out.println("The element sucessfully located:" +text);
			//reportStep("PASS","Element successfully loacted :" +text);
		} catch (NoSuchElementException e) {
			System.err.println("The element :+text is not available");
			// TODO Auto-generated catch block
			//reportStep("FAIL", "Element not available :" +text);
		} catch (ElementNotInteractableException e){
			System.err.println("The element is not interactable :" +text);
			//reportStep("FAIL", "Element is not intercatable :" +text);
		}catch(ElementNotSelectableException e){
			System.err.println("The element is not selectable: " +text);
			//reportStep("FAIL", "Element is not selectable :" +text);
						
		}catch (StaleElementReferenceException e) {
			System.out.println("The element is stale: " +text);
			//reportStep("FAIL" , "Element is stale :" +text);
		
		}
			
	}

	public void selectTextByXpath(String xpath, String value) {
		// TODO Auto-generated method stub
		try {
			  WebElement dropdown = driver.findElementByXPath(xpath);
			Select dropdown1 = new Select(dropdown);
			dropdown1 = selectByVisibleText(value);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The selected Element is not available: " +xpath);
			//reportStep("PASS" , "The selected Element is not available: " +xpath);
			
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The selected element is not interactable:" +xpath);
			//reportStep("FAIL" , "The selected element is not interactable:" +xpath);
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The selected element is not stable :" +xpath);
			//reportStep("FAIL" , "The selected element is not stable :" +xpath);
		}catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.err.println("The element is not selectable: "+xpath);
			//reportStep("FAIL" , "The element is not selectable: " +xpath);
		}catch (WebDriverException e) {
			// TODO: handle exception
		System.err.println("Browser got closed due to unknown error : " +xpath);
			//reportStep("FAIL" , "Browser got closed due to unknown error :" +xpath);
			
		}
		
		
	}

	private Select selectByVisibleText(String data) {
		// TODO Auto-generated method stub
		return null;
	}

	public void verifyTextByXpath(String text, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(text).getText();
			System.out.println("Text verified successfully");
			//reportStep("PASS", "Verified element is :" +text);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The selected element is not available: " +text);
			//reportStep("Fail", "Element is not present :" +text);
		}catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.out.println("The element is not selectable :" +text);
			//reportStep("FAIL", "The element is not selectable :" +text);
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element is not interactable :" +text);
			//reportStep("Fail", "The element is not interactable :" +text);
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element is not stable :" +text);
			//reportStep("Fail", "The element is not stable :" +text);
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("Browser got closed due to unknown error :" +text);
			//reportStep("FAIL","Browser got closed due to unknown error :" +text);
		}
		
		
	}

	public void clickByXpath(String Xpath) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(Xpath).click();
			System.out.println("Element is selected :" +Xpath);
			//reportStep("FAIL", "Element is selected :" +Xpath);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element is not available :" +Xpath);
			//reportStep("FAIL" , "The element is not available :" +Xpath);
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element is not interactable :" +Xpath);	
			//reportStep("Fail", "The element is not interactable :" +Xpath);
		}catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.err.println("The element was not able to selected: " +Xpath);
			//reportStep("Fail" , "The element was not able to selected: " +Xpath);
		 }catch (WebDriverException e) {
			// TODO: handle exception
			 System.err.println("Browser got closed due to unknown error :" +Xpath);
			 //reportStep("Fail" , "Browser got closed due to unknown error :" +Xpath);
		}
		
	}

	public void getTextByXpath(String data) {
		// TODO Auto-generated method stub
		String gTextxpath = null;
		try {
			gTextxpath = driver.findElementByXPath(data).getText();
			System.out.println("Element test is : " +data);
			//reportStep("PASS" , "Element test is : " +data);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element is not visible :" +data);
			//reportStep("FAIL" , "The element is not visible :" +data);
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element is not interactable :" +data);		
			//reportStep("FAIL" , "The element is not interactable :" +data);
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element is not stable");
			//reportStep("FAIL" , "The element is not stable");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element is not stable:" +data);
			//reportStep("FAIL" , "The element is not stable:" +data);
		}
				
	}

	public void mouseHoverByXpath(String xpath) {
		// TODO Auto-generated method stub
		try {
			WebElement mouse = driver.findElementByXPath(xpath);
			Actions obj = new Actions(driver);
			obj.moveToElement(mouse).perform();
			System.out.println("Element got focused using MouseHover :" +xpath);
			//reportStep("PASS" , "Element got focused using MouseHover :" +xpath);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The selected element is not visible");
			//reportStep("FAIL" , "The selected element is not visible" +xpath);
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element is not interactable: " +xpath);
			//reportStep("FAIL" , "The element is not interactable: " +xpath);
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("Browser got closed due to unknown error :" +xpath);
			//reportStep("FAIL" , "Browser got closed due ti unknown error :" +xpath);
		}		
		
		
	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		try {
			driver.close();
			System.out.println("All Browser are Closed Successfully");
			//reportStep("PASS" , "All Browser are Closed Successfully");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("Browser got closed due to unknown error ");
			//reportStep("FAIL" , "Browser not closed due to unknown error");
		}
		
	}

	public void geAttributesByXpath(String xPath, String Attribute) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xPath).getAttribute(Attribute);
			System.out.println("Attributes value was received succesfully "+xPath);
			//reportStep("PASS" , "Get the attribute :" +xPa th);
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element is not visible :" +xPath);
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element is not interactable : " +xPath);
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("Element is not stable: " +xPath);
			
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("Browser got closed due to unknown error :" +xPath);
		}
		
	}

	public void pageDownbyxPath(String xPath) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xPath).sendKeys(Keys.PAGE_DOWN);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("Browser got closed due to unknown error :" +xPath);
		}
		
	}

	public void tabkeys(String xPath) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xPath).sendKeys(Keys.TAB);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("Browser got closed due to unknown error :" +xPath);
		}
		
	}

	public void arrowDownbyxPath(String xPath) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xPath).sendKeys(Keys.ARROW_DOWN);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("Browser got closed due to unknown error");
		}
		
		
	}

	public void clearText(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(name).sendKeys(Keys.CLEAR);
			System.out.println("Text is cleared successfully");
			//reportStep("PASS" , "Text is cleared successfully :" +name );
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("Browser closed due to unknown error");
			//reportStep("FAIL" , "Browser closed due to unknown error");
		}
		
		
	}
	public void sleep(String xpath) throws InterruptedException{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
			System.out.println("Applied Explicitwait");
			//reportStep("PASS" , "Applied Explicitwait");
			
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("Browser fails to wait with error");
			//reportStep("FAIL" , "Applies Explicitwait");
			
		}
		
	}

	public void switchToParentWindow() {
		// TODO Auto-generated method stub
		
	}

	public void switchToLastWindow() {
		// TODO Auto-generated method stub
		
		try {
			Set<String> eachwinid = driver.getWindowHandles();
			for(String winid : eachwinid){
				driver.switchTo().window(winid);
				System.out.println("Browser switched to new window");
				//reportStep("PASS" , "Browser switched to new window");
			}
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.err.println("Window not present");
			//reportStep("FAIL" , "Window not present");
		}catch (SessionNotCreatedException e) {
			// TODO: handle exception
			System.err.println("Window session not created");
			//reportStep("FAIL" , "Window session not created");
		}catch (UnreachableBrowserException e) {
			// TODO: handle exception
			System.err.println("Browser ot reachable");
			//reportStep("FAIL" , "Not able reach the browser");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("Browser got closed without unknown error:");
			//reportStep("FAIL" , "Browser got closed without unknown error:");
		}
		
	}

	public void acceptAlert() {
		
		try {
			driver.switchTo().alert().accept();
			reportStep("PASS" , "Alert was accepted succsefully");
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.err.println("Alert is not present");
			//reportStep("FAIL" , "Alert not present in this window");
		}catch (UnhandledAlertException e) {
			// TODO: handle exception
			System.err.println("Alert is not handled");
			//reportStep("FAIL" , "Not able to handle the alert");
		}
		
		
	}

	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
			System.out.println("Cancel the alert");
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.err.println("Alert no present");
			//reportStep("FAIL", "Alert not present");
					
		}
				
	}

	public void getAlertText() {
		String galert = "";
		try {
			galert = driver.switchTo().alert().getText();
			System.out.println("Get the text displayed in alert successfully");
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.err.println("No alert present error");
			//reportStep("FAIL" , "Alert is not present");
			
		}
		// TODO Auto-generated method stub
		
	}

		public void scrollView(String xpath) throws ElementNotInteractableException{
			try {
				JavascriptExecutor je = (JavascriptExecutor)driver;
				WebElement element = driver.findElementByXPath(xpath);
				je.executeScript("0.scrollIntoView();",element);
			} catch (WebDriverException e) {
				// TODO Auto-generated catch block
				System.err.println("Browser closed due to unknown error");
			}
		}	
			public  void scrollDownThePage(String data){
				try {
					JavascriptExecutor js = (JavascriptExecutor)driver;
					WebElement element = driver.findElementByXPath(data);
					js.executeScript("scroll(0, 300);)",element);
				} catch (WebDriverException e) {
					// TODO Auto-generated catch block
					System.err.println("Browser closed due to unknow error");
				}
				
				}

			public void closeAdvertiseWindowByXpath(String x){
				
				try {
					driver.switchTo().alert().dismiss();
				} catch (WebDriverException e) {
					// TODO Auto-generated catch block
					System.err.println("Not able to interact alert window");
				}
			
			}
			public void waitByElementByXpath(String xpath){
				WebDriverWait wait = new WebDriverWait(driver, 200);
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
			}
		
			public void tabFunction(String value){
	 			driver.findElementByXPath(value).sendKeys(Keys.TAB);
					
 			}


			@Override
			public long takeSnap() {
				long number = 1000001;
				
				 try {
					File getscreen = driver.getScreenshotAs(OutputType.FILE);
					 File destFile = new File("./screenshotsAssm1/test1.png");
					 FileUtils.copyFile(getscreen, destFile);
					 System.out.println("Screen shot got captures succesfully");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.err.println("Screen shot not captured due to error");
				} catch (ScreenshotException e) {
					// TODO Auto-generated catch block
					System.err.println("screen shot not captured due to unknown error");
				}
				 return number;
				// TODO Auto-generated method stub
				
			}


			public void ImplicitWaitTillElementVisible(String xpath){
				WebDriverWait wait = new WebDriverWait(driver, 100);	
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("xpath")));
				
			}


			
			

			
			}
			
			




			
		

