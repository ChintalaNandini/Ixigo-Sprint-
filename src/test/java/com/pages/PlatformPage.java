package com.pages;
 
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.Reports;
 
public class PlatformPage {
	private static WebDriver driver;
    private static WebDriverWait wait;
    private static ExtentTest test;
    //=============================first scenario==========================

    @FindBy(xpath="//div[text()='Train Platform']")
	private static WebElement trainPlatform;
    
    //train name search bar
    @FindBy(xpath="//*[@id=\"content\"]/div/div[1]/div/div/div[1]/div/div[1]/input")
   	private static WebElement trainNameInput; 
    
    @FindBy(xpath="//button[text()='Search Platform']")
   	private static WebElement clickSearchPlatform;

    @FindBy(xpath="//span[contains(text(),'Avadh Exp')]")
   	private static WebElement trainPlatformVerify;
    

// Constructor
    public PlatformPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }
    //method for to click on train platform locator
    public static boolean clickTrainPlatform()
    {
    	boolean actResult = true;
    	try {
        WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(trainPlatform));
		Reports.generateReport(driver, test, Status.PASS, "Train platform locator is clicked");
		trainPlatform.click();
    	}
    	catch (Exception e) 
    	{
    	    actResult = false;
    	    Reports.generateReport(driver, test, Status.FAIL, "Train platform locator is not clicked");
    	}
    	return actResult;
    }
    //Entering train name in input text field
    public static boolean enterTrainName(String train_name )
	{
		boolean actResult = true;
        try 
        {
          	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOf(trainNameInput));
            Reports.generateReport(driver, test, Status.PASS, "train name is entered");
            trainNameInput.sendKeys(train_name);
            trainNameInput.sendKeys(Keys.ENTER);
        } 
        catch (Exception e) {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "train name is not entered");
        }
        return actResult;
	}

    //method for to click on train platfrom locator
    public static boolean clickSearchPlatform()
    {
    	boolean actResult = true;
    	try {
        WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(clickSearchPlatform));
		Reports.generateReport(driver, test, Status.PASS, "Train platform locator is clicked");
		clickSearchPlatform.click();
    	}
    	catch (Exception e) 
    	{
    	    actResult = false;
    	    Reports.generateReport(driver, test, Status.FAIL, "Train platform locator is not clicked");
    	}
    	return actResult;
    }
    //verify train platform page or not
    public boolean verifyTrainPlatformPage() {
        try {
        //	WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(trainPlatformVerify));
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current Page URL: " + currentUrl);
            Reports.generateReport(driver, test, Status.PASS, "Train platform page is displayed");
            return currentUrl.contains("19037");
        } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Train platform page is NOT displayed");
            return false;
        }
    }
   
    
    
  //=============================second scenario============================================================
    
    
    //on home page trains 
     @FindBy(xpath="/html/body/main/div[4]/div/div[1]/ul/li[3]/a/p[1]")
     private static WebElement trainHomepage;
     
     // Search by station on train home page
     @FindBy(xpath="//div[@class='body-md text-primary items-center']/div[text()='Station']")
      private static WebElement clickSearchByStation;
     
     @FindBy(css = "input[type='text'][placeholder='Enter the station name or code']")
      private static WebElement enterStationName;
     
     //click on search
      @FindBy(xpath="//*[@id=\"stationSearchForm\"]/div[2]/div[2]/button/div")
      private static WebElement clickSearch;
      
      //verify station page
      @FindBy(xpath="//h2[text()='Trains from New Delhi (NDLS) Railway Station']")
      private static WebElement verifyStationPage;
     
      //click on book now button of a train
      @FindBy(xpath="(//tbody//td//a[contains(text(),'Book Now')])[1]")
      private static WebElement bookNowButton;
    
    
    public static boolean verifyUserOnTrainHomePage()
    {
    	boolean actResult = true;
        try 
        {
        	WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(trainHomepage));
            Reports.generateReport(driver, test, Status.PASS, "Train Home page  is displayed");
        } 
        catch (TimeoutException te) {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Train Home page functionality is not displayed");
        }
        return actResult;
    }
    //click on search by station
    public static boolean clickSearchByStation()
    {
    	boolean actResult = true;
    	try {
        WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(clickSearchByStation));
		Reports.generateReport(driver, test, Status.PASS, "search by station  is clicked");
		clickSearchByStation.click();
    	}
    	catch (Exception e) 
    	{
    	    actResult = false;
    	    Reports.generateReport(driver, test, Status.FAIL, "search by station is not clicked");
    	}
    	return actResult;
    }

  //Entering station name in input text field
    public static boolean enterStationName(String station_name )
	{
		boolean actResult = true;
        try 
        {
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(enterStationName));
            Reports.generateReport(driver, test, Status.PASS, "station name is entered");
            enterStationName.sendKeys(station_name);
            enterStationName.sendKeys(Keys.ENTER);
        } 
        catch (Exception e) {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "station name is not entered");
        }
        return actResult;
	}
  // click on search in station name search page
    public static boolean clickSearchStation()
    {
    	boolean actResult = true;
    	try {
        WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(clickSearch));
		Reports.generateReport(driver, test, Status.PASS, "search is clicked ");
		clickSearch.click();
    	}
    	catch (Exception e) 
    	{
    	    actResult = false;
    	    Reports.generateReport(driver, test, Status.FAIL, "search is not clicked");
    	}
    	return actResult;
    }
    //system should display a list of available trains
    public static boolean verifySearchByStationPage()
    {
    	boolean actResult = true;
    	try {
    	WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOf(verifyStationPage));
		Reports.generateReport(driver, test, Status.PASS, "Train names in particular station are displayed");
		verifyStationPage.click();
    	}
    	catch (Exception e) 
    	{
    	    actResult = false;
    	    Reports.generateReport(driver, test, Status.FAIL, "Train names in particular station are not displayed");
    	}
    	return actResult;
    }

  //After station names are displayed and now choosing one station and clicking on "book now"
    public static boolean clickBookNow()
    {
    	boolean actResult = true;
    	try {
    	WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(bookNowButton));
		Reports.generateReport(driver, test, Status.PASS, "Book Now is clicked");
		bookNowButton.click();
    	}
    	catch (Exception e) 
    	{
    	    actResult = false;
    	    Reports.generateReport(driver, test, Status.FAIL, "Book Now is not clicked");
    	}
    	return actResult;
    }
    public static boolean verifyBookingPage() {
        try {
        	WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(7));
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current Page URL: " + currentUrl);
            Reports.generateReport(driver, test, Status.PASS, "Booking Page is verified");
            // Just check if URL contains 'seat-availability'
            return currentUrl.contains("seat-availability");
        } catch (Exception e) {
            System.out.println("Error verifying booking page: " + e.getMessage());
            Reports.generateReport(driver, test, Status.FAIL, "Booking Page is not verified");
            return false;
        }
    }
    
    
    //================================================third scenario===========================================
    
    
   //running status
    @FindBy(xpath="//div[text()='Running']")
    private static WebElement runningStatus;
    
    
    //click on enter train name or number
    @FindBy(xpath="//input[@placeholder='Enter the train number or name']")
    private static WebElement enterTrainName;
    
    
 // click on suggestions
    @FindBy(xpath="//p[@class='body-md' and contains(text(),'12423')]")
    private static WebElement suggestionName;
    
  
  // check live status
    @FindBy(xpath="//button[normalize-space(text())='Check Live Status']")
    private static WebElement clickLive;
    
    
    //download prompt
    @FindBy(xpath="//button[normalize-space(text())='DOWNLOAD']")
    private static WebElement downloadPrompt;
    
    public static boolean clickRunningStatus()
    {
    	boolean actResult = true;
    	try {
    	WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(runningStatus));
		Reports.generateReport(driver, test, Status.PASS, "running status is clicked");
		runningStatus.click();
    	}
    	catch (Exception e) 
    	{
    	    actResult = false;
    	    Reports.generateReport(driver, test, Status.FAIL, "running status is not clicked");
    	}
    	return actResult;
    }
    
    
    public static boolean entertrain_Name(String t_name) {
        boolean actResult = true;
        try {
            // Wait for input field
        	WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(enterTrainName));
            Reports.generateReport(driver, test, Status.PASS, "Train name is entered");

            // Enter train name
            enterTrainName.clear();
            enterTrainName.sendKeys(t_name);

            // Wait for exact suggestion to appear and click it
            WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement exactTrain = suggestionWait.until(ExpectedConditions.elementToBeClickable(suggestionName));

            exactTrain.click();
            System.out.println("Selected exact train: " + t_name);

        } catch (Exception e) {
            actResult = false;
            System.out.println("Error selecting train: " + e.getMessage());
            Reports.generateReport(driver, test, Status.FAIL, "Train name is not entered");
        }
        return actResult;
    }

    
    //click on check live status
    public static boolean clickCheckLiveStatus()
    {
    	boolean actResult = true;
    	try {
    		
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
        wait.until(ExpectedConditions.visibilityOf(clickLive));
		Reports.generateReport(driver, test, Status.PASS, "check live status is clicked");
		clickLive.click();
    	}
    	catch (Exception e) 
    	{
    	    actResult = false;
    	    Reports.generateReport(driver, test, Status.FAIL, "check live status is not clicked");
    	}
    	return actResult;
    }
   
    //click on download prompt is visible or not and verify download prompt page  
    public static boolean verifyDownloadPromptPage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Wait for the download prompt to be visible
            wait.until(ExpectedConditions.visibilityOf(downloadPrompt));

            if (downloadPrompt.isDisplayed()) {
                System.out.println("Download prompt is visible on the Running Status page");

                // Get current page URL
                String currentUrl = driver.getCurrentUrl();
                System.out.println("Current Page URL: " + currentUrl);

                Reports.generateReport(driver, test, Status.PASS, "Download prompt is visible and page verified");

                // Check if URL contains train number (e.g., 12423)
                return currentUrl.contains("12423/running-status");
            } else {
                System.out.println("Download prompt is NOT visible on the Running Status page");
                Reports.generateReport(driver, test, Status.FAIL, "Download prompt is not visible");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error verifying download prompt: " + e.getMessage());
            Reports.generateReport(driver, test, Status.FAIL, "Download prompt verification failed");
            return false;
        }
    }
    
     
    
    
    //========================================fourth scenario=============================================
    
    
    //click on source
    @FindBy(css="input[placeholder='Enter Origin']")
    private static WebElement source;
    
    //click on destination
    @FindBy(css="input[placeholder='Enter Destination']")
    private static WebElement destination;
   

    //click on search
    @FindBy(xpath="//button[text()='Search']")
    private static WebElement search;
    
 
  //quick search
    @FindBy(xpath="//button[text()='Schedule']")
    private static WebElement shedule;
    
    
    public static boolean getSourceName(String sourceName )
   	{
   	   boolean actResult = true;
         try 
         {
       	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
             wait.until(ExpectedConditions.visibilityOf(source));
             Reports.generateReport(driver, test, Status.PASS, "source entered:"+sourceName);
             source.clear();
             source.click();
             source.sendKeys(sourceName);
             
             WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(10));
             By src1 = By.xpath("//div[@class='absolute z-20 top-[175px] left-20']//p[contains(normalize-space(text()),'"+sourceName+"')]");
          
             WebElement exactTrain = suggestionWait.until(ExpectedConditions.elementToBeClickable(src1));
             exactTrain.click();
            
         } 
         catch (Exception e) {
             actResult = false;
             Reports.generateReport(driver, test, Status.FAIL, "source is not entered:"+e.getMessage());
         }
         return actResult;
   	}
    
    
  //enter the destination in input text field 
    public static boolean getDestinationName(String destinationName )
  	{
  	   boolean actResult = true;
      try 
      {
       	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
          wait.until(ExpectedConditions.visibilityOf(destination));
          Reports.generateReport(driver, test, Status.PASS, "destination entered:"+destinationName);
          destination.clear();
          destination.sendKeys(destinationName);
          destination.sendKeys(Keys.ENTER);
          
          WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(10));
          By des1 = By.xpath("//div[@class='absolute z-20 top-[175px] left-[420px]']//p[contains(normalize-space(text()),'"+destinationName+"')]");
  
          WebElement exactTrain = suggestionWait.until(ExpectedConditions.elementToBeClickable(des1));
          exactTrain.click();
         
      } 
      catch (Exception e) {
          actResult = false;
          Reports.generateReport(driver, test, Status.FAIL, "destination is not entered:"+e.getMessage());
      }
      return actResult;
  	}

 
  
  //click on search  
  public static boolean clickOnSearch() {
      boolean actResult = true;
      try {
           wait.until(ExpectedConditions.visibilityOf(search)); 
           Reports.generateReport(driver, test, Status.PASS, "Clicked on search");
           search.click();
          
      } catch (Exception e) {
          actResult = false;
          Reports.generateReport(driver, test, Status.FAIL, "Not clicked on search ");
     }
      return actResult;
  }
  
  //verify search page
  public static boolean verifyTrainDataPage() {
      try {
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	  wait.until(ExpectedConditions.visibilityOf(shedule)); 
          String currentUrl = driver.getCurrentUrl();
          System.out.println("Current Page URL: " + currentUrl);
          Reports.generateReport(driver, test, Status.PASS, "Search Page is verified");
          // Just check if URL contains 'seat-availability'
          return currentUrl.contains("trains/search");
      } catch (Exception e) {
          System.out.println("Error verifying search page: " + e.getMessage());
          Reports.generateReport(driver, test, Status.FAIL, "Search Page is not verified");
          return false;
      }
  }
  
  
  //=====================================fifth scenario=====================================================
  
  
   //search by name or number
   @FindBy(xpath="//div[text()='Name/Number']")
   private static WebElement searchByNameOrNumber;
  
   //enter name or number
   @FindBy(css="input[placeholder='Search trains by name or number']")
   private static WebElement enterNameOrNumber;
   
   //view calender
     @FindBy(xpath="//a[text()='View 2 Months Calendar']")
     private static WebElement viewCalender;
   
   // click on search by name/number
   public static boolean clickNameNumber()
   {
   	boolean actResult = true;
   	try {
   	  WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.visibilityOf(searchByNameOrNumber));
      
		Reports.generateReport(driver, test, Status.PASS, "running status is clicked");
		searchByNameOrNumber.click();
   	}
   	catch (Exception e) 
   	{
   	    actResult = false;
   	    Reports.generateReport(driver, test, Status.FAIL, "running status is not clicked");
   	}
   	return actResult;
   }
   
 //Entering station name in input text field
   public static boolean enterTrainNameNumber(String trainNameOrNnumber )
	{
		boolean actResult = true;
       try 
       {
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
           wait.until(ExpectedConditions.visibilityOf(enterNameOrNumber));
          
           Reports.generateReport(driver, test, Status.PASS, "train name/number is entered");
           enterNameOrNumber.click();
           enterNameOrNumber.sendKeys(trainNameOrNnumber);
                      
           WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(10));
           WebElement exactTrain1 = suggestionWait.until(ExpectedConditions.elementToBeClickable(By.xpath
        		   ("//div[@class='py-10 px-20']//div[@class='py-10']//p[contains(normalize-space(text()),'"+trainNameOrNnumber+"')]")));
           
           exactTrain1.click();
           
           
       } 
       catch (Exception e) {
           actResult = false;
           Reports.generateReport(driver, test, Status.FAIL, "train name/number is not entered");
       }
       return actResult;
	}
   
   //user click on view calender
   public static boolean clickViewCalender()
   {
   	boolean actResult = true;
   	try {
   	    WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(viewCalender));
		Reports.generateReport(driver, test, Status.PASS, "view calender is clicked");
		viewCalender.click();
   	}
   	catch (Exception e) 
   	{
   	    actResult = false;
   	    Reports.generateReport(driver, test, Status.FAIL, "view calender is not clicked");
   	}
   	return actResult;
   }
   
   
 //verify seat availability page
   public static boolean verifySeatAvailabilityPage() {
       try {
    	   WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(15)); 
           String currentUrl = driver.getCurrentUrl();
           System.out.println("Current Page URL: " + currentUrl);
           Reports.generateReport(driver, test, Status.PASS, "seat availability page is verified");
           // Just check if URL contains 'seat-availability'
           return currentUrl.contains("seat-availability");
       } catch (Exception e) {
           System.out.println("Error verifying search page: " + e.getMessage());
           Reports.generateReport(driver, test, Status.FAIL, "seat availability page is not verified");
           return false;
       }
   }
   
   //============================================six scenario=============================================
   
 //Error message
   @FindBy(xpath="//div[text()='Source and destination cannot be the same']")
   private static WebElement errorMessage;
   
  
   
   public static boolean verifyErrorMessage() {
       try {
    	   WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(15)); 
           String currentUrl = driver.getCurrentUrl();
           System.out.println("Current Page URL: " + currentUrl);
           System.out.println("Error message: " + errorMessage.getText());
           Reports.generateReport(driver, test, Status.PASS, "Train page is verified");
           // Just check if URL contains 'trains'
           return currentUrl.contains("trains");
       } catch (Exception e) {
           System.out.println("Error verifying search page: " + e.getMessage());
           Reports.generateReport(driver, test, Status.FAIL, "Train page is not verified");
           return false;
       }
   }
   
   //=====================================seven scenario====================================================
   
 
  
   // vande bharath Express
   @FindBy(xpath="//div[text()='Vande Bharat']")
   private static WebElement vandeBharathExpress;
   
   
// from
   @FindBy(xpath="//input[@placeholder='Leaving from']")
   private static WebElement fromLocation;
   
// to
   @FindBy(xpath="//input[@placeholder='Going to']")
   private static WebElement toLocation;
   
   //search
   @FindBy(xpath="//button[normalize-space(text())='Search']")
   private static WebElement click_Search;
   
   //arrival time
   @FindBy(xpath="//span[text()='ARRIVAL TIME']")
   private static WebElement arrivalTime;
   
   
   //the user clicks on Vande Bharath Express   
   public static boolean clickVandeBharath()
   {
   	boolean actResult = true;
   	try {
   	  WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.visibilityOf(vandeBharathExpress));
      
		Reports.generateReport(driver, test, Status.PASS, "Vande Bharath Express is clicked");
		vandeBharathExpress.click();
   	}
   	catch (Exception e) 
   	{
   	    actResult = false;
   	    Reports.generateReport(driver, test, Status.FAIL, "Vande Bharath Express is not clicked");
   	}
   	return actResult;
   }
   
   //enter "from" location
   public static boolean fromLocation(String from_loc )
  	{
  	   boolean actResult = true;
        try 
        {
      	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(fromLocation));
            Reports.generateReport(driver, test, Status.PASS, "from location entered:"+from_loc);
          //  from_location.clear();
            fromLocation.click();
            fromLocation.sendKeys(from_loc);
            
            WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            By from = By.xpath("//div[@class='autocompleter-scroll-cntr']//div[contains(normalize-space(text()),'"+from_loc+"')]");
         
            WebElement exactTrain = suggestionWait.until(ExpectedConditions.elementToBeClickable(from));
            exactTrain.click();
           
        } 
        catch (Exception e) {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "from location is not entered:"+e.getMessage());
        }
        return actResult;
  	}
   
   //enter "to" location 
   public static boolean toLocation(String to_loc )
  	{
  	   boolean actResult = true;
        try 
        {
      	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(toLocation));
            Reports.generateReport(driver, test, Status.PASS, "to location entered:"+to_loc);
           // to_location.clear();
            toLocation.click();
            toLocation.sendKeys(to_loc);
            
            WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            By to = By.xpath("//div[@class='autocompleter-scroll-cntr']//div[contains(normalize-space(text()),'"+to_loc+"')]");
         
            WebElement exactTrain = suggestionWait.until(ExpectedConditions.elementToBeClickable(to));
            exactTrain.click();
           
        } 
        catch (Exception e) {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "to location is not entered:"+e.getMessage());
        }
        return actResult;
  	}
   
 //user click on search
   public static boolean clickSearch()
   {
   	boolean actResult = true;
   	try {
   	    WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(click_Search));
		Reports.generateReport(driver, test, Status.PASS, "searched is clicked");
		click_Search.click();
   	}
   	catch (Exception e) 
   	{
   	    actResult = false;
   	    Reports.generateReport(driver, test, Status.FAIL, "searched is not clicked");
   	}
   	return actResult;
   }
   
   
 //user click on arrival time
   public static boolean clickArrivalTime()
   {
   	boolean actResult = true;
   	try {
   	    WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(arrivalTime));
		Reports.generateReport(driver, test, Status.PASS, "arrival time is clicked");
		arrivalTime.click();
   	}
   	catch (Exception e) 
   	{
   	    actResult = false;
   	    Reports.generateReport(driver, test, Status.FAIL, "arrival time is not clicked");
   	}
   	return actResult;
   
   }
   //verify sorting page 
    public static boolean verifySortPage() {
        try {
     	   WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(15)); 
     	   wait.until(ExpectedConditions.visibilityOf(arrivalTime));
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current Page URL: " + currentUrl);
            Reports.generateReport(driver, test, Status.PASS, "Train arrival page is verified");
            // Just check if URL contains 'result'
            return currentUrl.contains("result");
        } catch (Exception e) {
            System.out.println("Error verifying sort page: " + e.getMessage());
            Reports.generateReport(driver, test, Status.FAIL, "Train arrival page is not verified");
            return false;
        }
   
 	}
   
}
 