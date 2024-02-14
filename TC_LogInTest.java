package amazon_TestClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import amazon_PageObjectModel_Classes.HomePage;
import amazon_PageObjectModel_Classes.LogInPage;

public class TC_LogInTest extends Base_Class {

	
	WebDriver driver;
	HomePage hp;
	
	@Test (priority=1)
	
	public void LogInTest() throws InterruptedException
	{
	driver = super.driverInitialization();
	driver.manage().window().maximize();
	LogInPage lp = new LogInPage(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	lp.clickToSignInLink();
	lp.sentMobileNumber(mobileNumber);
	lp.clickToContinueButton();
	lp.sendPassword(password);
	Thread.sleep(20000);
	lp.clickOnSignInButton();
	
	}
	
	@Test(priority=2)
	
	public void HomepageVerify() throws InterruptedException
	{
		driver = super.driverInitialization();
		driver.manage().window().maximize();
		HomePage hp = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		hp.clickToSearchTab();
		Thread.sleep(20000);
		hp.VerifyFiler();
		
	}

	@Test(priority=3)
	public void productAddIntoCart() throws InterruptedException
	{
		
		driver = super.driverInitialization();
		driver.manage().window().maximize();
		HomePage hp = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		hp.addToCart();
	
	}
	
	
	
	
	
}

	

