package amazon_TestClasses;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Base_Class {
	
	public static WebDriver driver;
	
	
	public String baseURL="https://www.amazon.in/";
	public String mobileNumber="917875121363";
	public String password="7875121363";
	
	@BeforeClass
	
	public WebDriver driverInitialization()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Mahesh\\IntBankingv1\\driver\\chromedriver.exe");
	    
		WebDriver driver = new ChromeDriver();
		
	    driver.get(baseURL);
		
		return driver;
	}
	
	
	@AfterClass
	
	public void tearDown()
	{
	driver.quit();
	}
	
}
