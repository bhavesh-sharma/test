package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.CommonFunctions.CommonFunc;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SmokeTest {
	
	WebDriver driver;
	CommonFunc f = new CommonFunc();
	
	@Given("Open Safari and start application")
	public void open_Safari_and_start_application() {
		
//		driver = f.launchSafariBrowser();

		driver = f.launchChromeBrowser();
		f.maxWindow(driver);
		driver.get("https://en-gb.facebook.com/login/");
	    
	}

//	@When("I entered valid username and password")
	@When("I entered valid {string} and {string}")
	public void i_entered_valid_and(String uname, String upass) throws InterruptedException {
		
	    driver.findElement(By.xpath("//*[@id=\'email\']")).sendKeys(uname);
	    
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id='pass']")).sendKeys(upass);
	    
	    Thread.sleep(2000);
	    
	}

	@Then("User should be able to login successfully")
	public void user_should_be_able_to_login_successfully() throws InterruptedException {
		
	    driver.findElement(By.id("loginbutton")).click();
	    
	    Thread.sleep(2000);
	    
	    driver.quit();
	    
	}	

}
