package Multilogin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import au.com.bytecode.opencsv.CSVReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Stepdefinition {
	WebDriver driver;
	CSVReader reader;
	String csvpath="C:\\Users\\10699082\\eclipse-workspace\\Cucumber-Demo\\data.csv";

	@Given("^Open the chrome and launch the application$")
	public void open_the_chrome_and_launch_the_application() throws FileNotFoundException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
    	reader = new CSVReader(new FileReader(csvpath));
	}
	@When("^Login page is open$")
	public void login_page_is_open() throws IOException, InterruptedException {
		
    	String [] data;
    	while((data=reader.readNext())!=null) {
    	String un=data[0];
    	String pwd=data[1];
    	driver.findElement(By.id("user-name")).sendKeys(un);
        driver.findElement(By.id("password")).sendKeys(pwd);
        driver.findElement(By.id("login-button")).click();	
		Thread.sleep(1000);
	}	
    	reader.close();
	}
	
	@Then("^Error Message should be displayed$")
	public void Error_Message_should_be_displayed() throws Throwable{
		driver.findElement(By.cssSelector("[data-test='error']")).isDisplayed();
		 String error = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"))
				 .getAttribute("innerText");

		 Reporter.log("The Error Message are " + error,true);
		 String Expected = "Epic sadface: Username and password do not match any user in this service";
		 Assert.assertEquals(Expected,error);
		 System.out.println(error);
		 File srcfile12 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	     File inValidLogin = new File("src\\test\\resources\\inValidLogin.png");
         FileUtils.copyFile(srcfile12, inValidLogin);	
        
         driver.close();

}
}
