package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class FB {
	
public static RemoteWebDriver driver;
	
	@Given("^Launch the browser with expected url$")
	public void launch_the_browser_with_expected_url() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	    
	}

	@When("^Enter the valid userid and password$")
	public void enter_the_valid_userid_and_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(6000);
	    driver.findElementByXPath("//input[@id='email']").sendKeys("Praveen123");
	    driver.findElementByXPath("//input[@id='pass']").sendKeys("dummy@1234");
	    
	}

	@Then("^FB should login successfully$")
	public void fb_should_login_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElementByXPath("//input [@type='submit']").click();
	   
	}


}
