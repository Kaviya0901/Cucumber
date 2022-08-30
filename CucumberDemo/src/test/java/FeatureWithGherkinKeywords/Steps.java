package FeatureWithGherkinKeywords;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;

public class Steps {
	WebDriver driver;
	
	@Given("login page is open")
	public void login_page_is_open() {
	  System.out.println("login page is open");
	}
	@Given("invalid data is entered in Username and Password")
	public void invalid_data_is_entered_in_username_and_password() {
	    System.out.println("invalid data is entered in Username and Password");
	}
	@Given("Signin button is clicked")
	public void signin_button_is_clicked() {
	  System.out.println("Signin button is clicked");
	}
	@Given("Error message should be displayed")
	public void error_message_should_be_displayed() {
	  System.out.println("Error message should be displayed");
	}



}
