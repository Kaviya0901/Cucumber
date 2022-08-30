package LoginFeatureDDTUsingCSV;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import au.com.bytecode.opencsv.CSVReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pomPage.RediffLoginPage;


public class StepDefinition {
      WebDriver driver;
      RediffLoginPage rlp;
      CSVReader reader;
      String csvPath="D:\\SeleniumLTI\\CucumberDemo\\data.csv";
	@Given("login page is open")
	public void login_page_is_open() throws FileNotFoundException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32 (4)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		rlp=new RediffLoginPage(driver);//create page class object
		reader=new CSVReader(new FileReader(csvPath));
	}
	@When("invalid data is entered in Username and Password")
	public void invalid_data_is_entered_in_username_and_password() throws IOException {
		String [] data;
		while((data=reader.readNext())!=null) {
			String un=data[0];
			String pwd=data[1];
	    rlp.setUserName(un);
	    rlp.setPassword(pwd);
	    }
		reader.close();
	}
	@When("Signin button is clicked")
	public void signin_button_is_clicked() {
	   rlp.clickOnSignIn();
	}
	@Then("Error message should be displayed")
	public void error_message_should_be_displayed() {
	   String act=rlp.validateError();
	 //  Assert.assertEquals("Wrong username and password combination.", act);
	   System.out.println(act);
	}
	
}
