package pomPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class RediffLoginPage {
	@FindBy(id="login1")
	WebElement username;
	//WebElement username=driver.findElement(By.id("login1"));
	@FindBy(id="password")
	WebElement password;
	@FindBy(name="proceed")
	WebElement signInBtn;
   @FindBy(linkText="Forgot Password?")
    WebElement forgotPwdLink;
    @FindBy(partialLinkText="Create a New")
    WebElement createNewACLink;
    @FindBy(id="remember")
    WebElement keepMeSignInCB;
    @FindBy(id="div_login_error")
    WebElement errorMsg;
    WebDriver driver;
    
    //Constructor
    public RediffLoginPage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);	
    }
    //methods
    public  void setUserName(String un) {
    	username.clear();
    	username.sendKeys(un);
    }
    public void setPassword(String pwd) {
        password.sendKeys(pwd);
    }
     public void clickOnSignIn() {
    	 signInBtn.click();
     }
     public void login(String un,String pwd) {
    	 username.sendKeys(un);
    	 password.sendKeys(pwd);
    	 signInBtn.click();
     }
     public void clickForgotPwd() {
    	forgotPwdLink.click(); 
     }
     public void clickCreateNewAC() {
    	 createNewACLink.click(); 
      }
      public String validateAlert() {
    	  signInBtn.click();
    	  Alert a=driver.switchTo().alert();
    	  String alertMsg=a.getText();
    	  a.accept();
    	  driver.switchTo().defaultContent();
    	  return alertMsg;
      }
      public String validateError() {
    	  //signInBtn.click();
    	  String msg=errorMsg.getText();
    	  return msg;
      }
     public void checkStatusKeepMeSignIN() {
       System.out.println("KeepMeSignInCheckBox displayed ?"+keepMeSignInCB.isDisplayed());	 
       System.out.println("KeepMeSignInCheckBox enabled ?"+keepMeSignInCB.isEnabled());
       System.out.println("KeepMeSignInCheckBox selected ?"+keepMeSignInCB.isSelected());
    }
    
    
    
}
