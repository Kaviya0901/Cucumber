package FeaturesWithBackground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	WebDriver driver;
	@Given("Google page is open")
	public void google_page_is_open() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32 (4)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
	}
	@When("Advertising link is clicked")
	public void advertising_link_is_clicked() {
	 driver.findElement(By.linkText("Advertising")).click();
	}
	@Then("It should navigate to Google Ads page")
	public void it_should_navigate_to_google_ads_page() {
	   System.out.println("Title is "+driver.getTitle());
	}
	@When("About link is clicked")
	public void about_link_is_clicked() {
	    driver.findElement(By.linkText("About")).click();
	}
	@When("Business link is clicked")
	public void business_link_is_clicked() {
	     driver.findElement(By.linkText("Business")).click();
	}
	@Then("It should navigate to Google Business page")
	public void it_should_navigate_to_google_business_page() {
		System.out.println("Title is "+driver.getTitle());
	}

	@Then("It should navigate to About Google  page")
	public void it_should_navigate_to_about_google_page() {
		System.out.println("Title is "+driver.getTitle());
	}





}
