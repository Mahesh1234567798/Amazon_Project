package amazon_PageObjectModel_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	
	    WebDriver driver;
	    
	    @FindBy(id ="nav-link-accountList-nav-line-1")  
		private WebElement signinLink;
	  
        @FindBy(xpath ="//input[@id='ap_email']")  
		private WebElement mobileNumber;
	
		@FindBy(xpath ="//input[@id='continue']")  
		private WebElement continueButton;
		
		@FindBy(xpath="//input[@name='password']")
		private WebElement password;
		
		@FindBy(xpath="(//input[@class='a-button-input'])[1]")
		private WebElement signInButton;
		
		
	
	
   public LogInPage(WebDriver driver)
	
	{
    this.driver=driver;
    
	PageFactory.initElements(driver, this);
	}
   
   public void clickToSignInLink()
   {
	   signinLink.click();
   }
   
   public void sentMobileNumber(String mNumber)
   {
	   mobileNumber.sendKeys(mNumber);  
   }
   
   public void clickToContinueButton()
   {
	   continueButton.click(); 
   }
	
   public void sendPassword(String pass)
   {
	   password.sendKeys(pass);  
   }
   public void clickOnSignInButton()
   {
	   signInButton.click();    
   }
   

}
