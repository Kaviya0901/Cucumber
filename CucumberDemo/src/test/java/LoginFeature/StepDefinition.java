package LoginFeature;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pomPage.RediffLoginPage;


public class StepDefinition {
      WebDriver driver;
      RediffLoginPage rlp;
      
	@Given("login page is open")
	public void login_page_is_open() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32 (4)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		rlp=new RediffLoginPage(driver);//create page class object
	}
	@When("invalid data is entered in Username and Password")
	public void invalid_data_is_entered_in_username_and_password() {
	    rlp.setUserName("test1");
	    rlp.setPassword("test1");
	}
	@When("Signin button is clicked")
	public void signin_button_is_clicked() {
	   rlp.clickOnSignIn();
	}
	@Then("Error message should be displayed")
	public void error_message_should_be_displayed() {
	   String act=rlp.validateError();
	   Assert.assertEquals("Wrong username and password combination.", act);
	}
	

}
