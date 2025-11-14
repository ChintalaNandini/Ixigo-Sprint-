package com.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.parameters.PropertyReader;

public class HomePage {
	private static WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest test;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//p[contains(text(),'Trains')])[2]")
	private WebElement trainslink;

	@FindBy(xpath = "//a[contains(text(),'Order Food')]")
	private WebElement orderFoodLink;

	@FindBy(xpath = "//h1[contains(text(),'Order Food')]")
	private WebElement foodOptionsHeader;

	@FindBy(xpath="//h2[text()='Explore More With ixigo']")
	private WebElement text;

//	@FindBy(xpath = "(//div[@class='body-md text-primary items-center'])[6]")
	@FindBy(xpath = "//a[@href='/trains/platform-locator']/parent::div")
	private WebElement trainPlatform;

	@FindBy(xpath="//h1[text()='Platform Locator']")
	private WebElement platformLocator;

	// 3rd Scenario starts from here
	
	@FindBy(xpath = "//input[@id='pnr-input' and @name='pnr' and @type='text']")
	private WebElement pnrInputField;

	@FindBy(xpath = "//button[text()='Order Now']")
	private WebElement searchButton;

	@FindBy(xpath = "//img[@class='h-100 w-100 object-cover' and @alt='error' and @src='https://cdn.confirmtkt.com/img/native_food_order/ic_err_pnr_unavailable.svg']")
	private WebElement popupErrorImage;

	@FindBy(xpath = "//button[contains(@class,'inline-flex') and normalize-space(text())='Okay']")
	private WebElement okayButton;

	@FindBy(xpath = "//h5[text()='Available Stations']")
	private WebElement searchStations;

     // 4th Scenario starts from here
	@FindBy(xpath = "//div[text()='Train Seat']/ancestor::a")
	private static WebElement seatAvailability;
	
	//click on source
    @FindBy(xpath = "//input[@placeholder='Enter Origin']")
    private static WebElement source;
    
    //click on destination
    @FindBy(xpath = "//input[@placeholder='Enter Destination']")
    private static WebElement destination;
   
 
    //click on search
    @FindBy(xpath= "//button[text()='Check Availability']")
    private static WebElement search;
  
     
  //click on src
    @FindBy(xpath="//div[contains(@class,'flex') and contains(@class,'flex-col')]//p[text()='New Delhi (NDLS)']")
    private static WebElement src;
    
  //click on destination
    @FindBy(xpath="//p[@class='body-md flex group-[.list-lg]:body-lg text-primary' and normalize-space(text())='Lokmanyatilak T (LTT)']")
    private static WebElement des;
       
  //quick search
    @FindBy(xpath="//button[text()='Search']")
    private static WebElement quick_search;
    
    @FindBy(xpath="//p[text()='Quick Filters']")
    private static WebElement verify_Trains_Availability_Page;
    
    // 5th Scenario starts from here
    
    
    @FindBy(xpath="(//p[text()='Offers'])[1]")
    private static WebElement click_offers;
    
    @FindBy(xpath="//*[@id=\"__next\"]/div[1]/div[3]/div[1]/div[1]/div/div[3]/a")
    private static WebElement click_trains;
    
    @FindBy(xpath="//h2[text()='Trains']")
    private static WebElement verify_offers;
    
    
    
    
	public HomePage(WebDriver driver , ExtentTest test) {

		this.driver = driver;
		this.test =test;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	public void clickTrainsLink() {
		new WebDriverWait(driver, Duration.ofSeconds(15))
		.until(ExpectedConditions.elementToBeClickable(trainslink))
		.click();
	}

	public void clickOrderFoodLink() {
		new WebDriverWait(driver, Duration.ofSeconds(15))
		.until(ExpectedConditions.elementToBeClickable(orderFoodLink))
		.click();
	}

	public void verifyFoodOptionsDisplayed() {
		boolean isDisplayed = new WebDriverWait(driver, Duration.ofSeconds(15))
				.until(ExpectedConditions.visibilityOf(foodOptionsHeader))
				.isDisplayed();
		if (!isDisplayed) {
			throw new AssertionError("Order Food page not displayed!");
		}
	}

	public void exploreMore() {
		new WebDriverWait(driver, Duration.ofSeconds(15))
		.until(ExpectedConditions.elementToBeClickable(text))
		.click();
	}
	
	// 2nd start from here 
	
	public void clickPlatformLocator() {

		Properties props = PropertyReader.readProperty();
		String trainPlatformXpath = props.getProperty("trainPlatform.link.xpath");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(trainPlatformXpath)));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", trainPlatform);
		wait.until(ExpectedConditions.elementToBeClickable(trainPlatform)).click();


		//    	   //wait.until(ExpectedConditions.visibilityOf(trainPlatform));
		//           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//    	   //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", trainPlatform);
		//           ((JavascriptExecutor) driver).executeScript("arguments[0].click();", trainPlatform);
		//           wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(trainPlatform)));
		//           //wait.until(ExpectedConditions.elementToBeClickable(platformLocator)).click();
	}

	public void clickTrainPlatform() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(platformLocator));
	}

	//3rd Scenario Methods starts from here
	
	Map<String, String> formData;
	public void clickPnrNum() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(pnrInputField));
		
	}
	
	public void enterTest(String[] TestName) throws IOException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", pnrInputField);
		pnrInputField.sendKeys(TestName);
		System.out.println("DEBUG: Sent to search box -> " + TestName);
		
	}
	
	public void clickSearch() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
	}
	
	public void verifyAvailableStations() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(searchStations));
		Thread.sleep(2000);
	}
	
	
	
	//4th Scenario starts from here
	public void clickSeatAvailability() throws InterruptedException {
		//wait.until(ExpectedConditions.elementToBeClickable(seatAvailability));
		//seatAvailability.click();
//		WebElement seat = (WebElement) driver.findElements(By.xpath("//span[text()='Seat Availability']"));
//		((JavascriptExecutor)driver).executeScript("arguments[0].click();", seat);
//		seat.click();
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(seatAvailability))
		.click();
		Thread.sleep(3000);
	}
    //enter the source in input text field
    public boolean getSourceName(String source_name )
	{
	   boolean actResult = true;
      try
      {
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
          wait.until(ExpectedConditions.visibilityOf(source));
          //Reports.generateReport(driver, test, Status.PASS, "source entered:"+source_name);
          source.clear();
          ((JavascriptExecutor)driver).executeScript("arguments[0].click();", source);
          source.click();
          source.sendKeys(source_name);
       
          WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(5));
          WebElement exactTrain = suggestionWait.until(ExpectedConditions.elementToBeClickable(src));
          exactTrain.click();
         
      }
      catch (Exception e) {
          actResult = false;
          //Reports.generateReport(driver, test, Status.FAIL, "source is not entered:"+e.getMessage());
      }
      return actResult;
	}
  
  //enter the destination in input text field
  public static boolean getDestinationName(String destination_name )
	{
	   boolean actResult = true;
    try
    {
     	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(destination));
        //Reports.generateReport(driver, test, Status.PASS, "destination entered:"+destination_name);
        destination.clear();
        destination.sendKeys(destination_name);
        destination.sendKeys(Keys.ENTER);
        
        WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement exactTrain1 = suggestionWait.until(ExpectedConditions.elementToBeClickable(des));
        exactTrain1.click();
       
    }
    catch (Exception e) {
        actResult = false;
        //Reports.generateReport(driver, test, Status.FAIL, "destination is not entered:"+e.getMessage());
    }
    return actResult;
	}
 
  //click on search  
  public static boolean click_On_search() {
      boolean actResult = true;
      try {
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
           wait.until(ExpectedConditions.visibilityOf(search));
           //Reports.generateReport(driver, test, Status.PASS, "Clicked on search");
           search.click();
          
      } catch (Exception e) {
          actResult = false;
          //Reports.generateReport(driver, test, Status.FAIL, "Not clicked on search ");
     }
      return actResult;
  }
  
  //verify search page
  public static boolean verify_Train_Data_Page() {
      try {
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	  wait.until(ExpectedConditions.visibilityOf(verify_Trains_Availability_Page));
          String currentUrl = driver.getCurrentUrl();
          System.out.println("Current Page URL: " + currentUrl);
         // Reports.generateReport(driver, test, Status.PASS, "Search Page is verified");
          // Just check if URL contains 'seat-availability'
          return currentUrl.contains("trains/search");
      } catch (Exception e) {
          System.out.println("Error verifying search page: " + e.getMessage());
         // Reports.generateReport(driver, test, Status.FAIL, "Search Page is not verified");
          return false;
      }
  }
  
  
      
      // 5th Scenario starts from here
      
      public void clickOffersPage() {
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
  		wait.until(ExpectedConditions.elementToBeClickable(click_offers));
  		click_offers.click();
  		}
      
      public void clicktrainoffers() throws InterruptedException {
    	  Thread.sleep(5000);
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
  		wait.until(ExpectedConditions.elementToBeClickable(click_trains));
  		click_trains.click();
      }
      
      public void verifyTrainOffers() throws InterruptedException {
  		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
  		wait.until(ExpectedConditions.elementToBeClickable(verify_offers));
  		Thread.sleep(5000);
  	}
      
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public void enterTest(String[] TestName) throws IOException   {
//		 
//		
//	}
	
	
	
	


































































//3rd Scenario Methods starts from here 

//	public void clickCheckSeatAvailability() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='body-md text-primary items-center'])[3]")));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkSeatAvailabilityBtn);
//		try {
//			wait.until(ExpectedConditions.elementToBeClickable(checkSeatAvailabilityBtn)).click();
//		} catch (org.openqa.selenium.ElementClickInterceptedException e) {
//			((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkSeatAvailabilityBtn);
//		}
//	}
//
//	public void enterFromStation(String from) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.visibilityOf(fromStationInput)).sendKeys(from);
//		fromStationInput.sendKeys(Keys.ENTER);
//	}
//
//	public void enterToStation(String to) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.visibilityOf(toStationInput)).sendKeys(to);
//		toStationInput.sendKeys(Keys.ENTER);
//	}
//
//	public void clickCheckAvailability() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[4]/div[2]/div[2]/div[1]/button")));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkAvailabilityBtn);
//		try {
//			wait.until(ExpectedConditions.elementToBeClickable(checkAvailabilityBtn)).click();
//		} catch (org.openqa.selenium.ElementClickInterceptedException e) {
//			((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkAvailabilityBtn);
//		}
//	}
//
//	public void verifyTrainsAvailabilityPage() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		try {
//			WebElement header = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[@class='h4 mb-5']")));
//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", header);
//			System.out.println("Trains Availability Page displayed successfully!");
//		} catch (Exception e) {
//			throw new AssertionError("Trains Availability Page not displayed! Check XPath or page load.");
//		}
//	}
















































































//	public void clickCheckSeatAvailability() {
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='body-md text-primary items-center'])[3]")));
//	    
//	    // Scroll into view before clicking
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkSeatAvailabilityBtn);
//	    
//	    wait.until(ExpectedConditions.elementToBeClickable(checkSeatAvailabilityBtn)).click();
//	}
//	
////	public void clickCheckSeatAvailability() {
////		new WebDriverWait(driver, Duration.ofSeconds(10))
////		.until(ExpectedConditions.elementToBeClickable(checkSeatAvailabilityBtn))
////		.click();
////	}
//	
//
//public void enterFromStation(String from) {
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//    wait.until(ExpectedConditions.visibilityOf(fromStationInput)).sendKeys(from);
//    fromStationInput.sendKeys(Keys.ENTER); // Select suggestion
//}
//
//public void enterToStation(String to) {
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//    wait.until(ExpectedConditions.visibilityOf(toStationInput)).sendKeys(to);
//    toStationInput.sendKeys(Keys.ENTER); // Select suggestion
//}
//
//
////	public void enterFromStation(String from) {
////		new WebDriverWait(driver, Duration.ofSeconds(10))
////		.until(ExpectedConditions.visibilityOf(fromStationInput))
////		.sendKeys(from);
////	}
////
////	public void enterToStation(String to) {
////		new WebDriverWait(driver, Duration.ofSeconds(10))
////		.until(ExpectedConditions.visibilityOf(toStationInput))
////		.sendKeys(to);
////	}
//	
//
//public void clickCheckAvailability() {
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[4]/div[2]/div[2]/div[1]/button")));
//    
//    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkAvailabilityBtn);
//    
//    wait.until(ExpectedConditions.elementToBeClickable(checkAvailabilityBtn)).click();
//}
//
//
////	public void clickCheckAvailability() {
////		new WebDriverWait(driver, Duration.ofSeconds(10))
////		.until(ExpectedConditions.elementToBeClickable(checkAvailabilityBtn))
////		.click();
////	}
//
//	public void verifyTrainsAvailabilityPage() {
//		boolean isDisplayed = new WebDriverWait(driver, Duration.ofSeconds(10))
//				.until(ExpectedConditions.visibilityOf(trainsAvailabilityHeader))
//				.isDisplayed();
//		if (!isDisplayed) {
//			throw new AssertionError("Trains Availability Page not displayed!");
//		}
//	}
//


