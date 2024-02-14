package amazon_PageObjectModel_Classes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class HomePage {
	
	WebDriver driver;
	WebElement ele;
    
	// logIn Page
	
    @FindBy(xpath ="//input[@id='twotabsearchtextbox']")  
	private WebElement searchTab;
    
    @FindBy(id ="nav-search-submit-button")  
  	private WebElement clickTosearchBar;
    
    
    @FindBy(xpath ="(//input[@type='text'])[2]") 
  	private WebElement selectMinValue;
    
    @FindBy(xpath ="//input[@id='high-price']") 
  	private WebElement selectMaxValue;
    
    @FindBy(xpath ="//input[@class='a-button-input']") 
  	private WebElement clickOnGoButton;
    
    // AddToCartPage
    
    @FindBy(xpath ="//input[@id='twotabsearchtextbox']") 
  	private WebElement searchBoxClick;
    
    @FindBy(id ="nav-search-submit-button")  
  	private WebElement searchButton;
    
    @FindBy( xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span")
 	private WebElement iphoneLink;
    
    @FindBy(xpath ="//a[@id=\"attach-close_sideSheet-link\"]")  
	private WebElement quitBtn;
    
    @FindBy(xpath ="//span[@class='nav-cart-icon nav-sprite']")  
	private WebElement cartIcon;
    
    @FindBy(xpath ="//input[@value='Delete']")  
	private WebElement removeproduct;
    
  //input[@value='Delete']
   
    
  
    public HomePage(WebDriver driver)
	
   	{
       this.driver=driver;
       this.ele=ele;
       
   	PageFactory.initElements(driver, this);
   	}
      
    public void clickToSearchTab()
    {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    searchTab.click();
    searchTab.sendKeys("Apple iPhone 13 (128GB) - Pink");
    clickTosearchBar.click();
    SoftAssert soft = new SoftAssert();
	String ActualText = "Apple iPhone 13 (128GB) - Pink";
	String ExpectedText="Apple iPhone 13 (128GB) - Pink";
    soft.assertEquals(ActualText, ExpectedText,"TC is failed actual title and expected title is not matched ");
    Reporter.log( "Searching mobile test case is pass",true);
    soft.assertAll();
    
    }
   
    public void VerifyFiler()
    {
    	
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       selectMinValue.click();
       selectMinValue.sendKeys("100");	
       selectMaxValue.click();
       selectMaxValue.sendKeys("1000");
       clickOnGoButton.click();
       
       List<WebElement> prices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
       System.out.println(prices);
       
       for(int i=0;i<prices.size();i++)
       {
    	  String aa=prices.get(i).getText();
    	  int convert = Integer.parseInt(aa);
    	 if(convert>100&&convert<1000)
    	 {
    	 System.out.println("product price is between the range");
    	 }
    	 else
    	 {
    	 System.out.println("product price is outside the range");
    	 }
    	 
    	 searchTab.clear();
       }
       
       }
        
        public void addToCart() throws InterruptedException
        {
        	
        	driver.manage().deleteAllCookies();
        	
        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        	
        	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iPhone 13 ");
        	driver.findElement(By.id("nav-search-submit-button")).click();
        	driver.get("https://www.amazon.in/Apple-iPhone-13-128GB-Midnight/dp/B09G9HD6PD/ref=sr_1_4?crid=2ZVYYEAU1IT59&dib=eyJ2IjoiMSJ9.OCoJgZ8ghdguKvc7Ozmt3Lsua8FLjHkgudzmYiS71BIBefl47ypX7ravkpgxirkX8ohI8BpyfVexO3q6OWC95d8t3ISCpvxal3E9x_rcid6xQOxo5wIa0-ZFkyGTgHEPNpS4BxygRBtq97Nb7Fq4KvqMVqQtFgNrm_2cVsuMNwuUcLAgXFELFAR1bo8sO5r2YRa7_K3tpSB3Sffx8P_unqoSlRObvZ-S0PKaimaVbp0.SvSXCrioJZaxcF5QvMxCLS1uWQ6vdHeHZT6V56USH2o&dib_tag=se&keywords=iphone+13&qid=1707899712&sprefix=i+phone13%2Caps%2C186&sr=8-4");
        	Thread.sleep(9000);
        	WebElement redColur = driver.findElement(By.xpath("//img[@alt='(PRODUCT) RED']"));
        	redColur.click();
        	Thread.sleep(9000);
            WebElement cart = driver.findElement(By.xpath("(//input[@name=\"submit.add-to-cart\"])[2]"));
            Thread.sleep(9000);
            cart.click();
            Thread.sleep(9000);
            quitBtn.click();
            Thread.sleep(20000);
            
            JavascriptExecutor js1 = (JavascriptExecutor)driver;
        	js1.executeScript("arguments[0].scrollIntoView(true);",cartIcon );
        	 Thread.sleep(10000);
            
            JavascriptExecutor j = (JavascriptExecutor) driver;
            j.executeScript("arguments[0].click();",cartIcon );
            Thread.sleep(25000);
            SoftAssert soft = new SoftAssert();
        	String ActualText =driver.findElement(By.xpath("//h1")).getText();
        	String ExpectedText="Shopping Cart";
            soft.assertEquals(ActualText, ExpectedText,"TC is failed actual title and expected title is not matched ");
            Reporter.log( "Successful add product into cart ",true);
            soft.assertAll();
            removeproduct.click();
            driver.quit();	
        	
        	

        	
        }
       
        }
