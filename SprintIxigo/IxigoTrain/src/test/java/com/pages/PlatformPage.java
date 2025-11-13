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
	private static WebElement click_Train_Platform;
    //train name search bar
    @FindBy(xpath="//*[@id=\"content\"]/div/div[1]/div/div/div[1]/div/div[1]/input")
   	private static WebElement enter_train_name; 
    @FindBy(xpath="//button[text()='Search Platform']")
   	private static WebElement click_Search_Platform;

    @FindBy(xpath="//span[contains(text(),'Avadh Exp')]")
   	private static WebElement train_platform_verify;
    //=============================second scenario==========================
    
    
   //on home page trains 
    @FindBy(xpath="/html/body/main/div[4]/div/div[1]/ul/li[3]/a/p[1]")
    private static WebElement train_homepage;
    // Search by station on train home page
    @FindBy(xpath="//div[@class='body-md text-primary items-center']/div[text()='Station']")
   	private static WebElement click_Search_By_Station;
    
//    //enter the station name 
//      @FindBy(css="input[type='text'][placeholder='Enter the station name or code']")
//      private static WebElement enter_station_name; 
    
    
    @FindBy(css = "input[type='text'][placeholder='Enter the station name or code']")
     private static WebElement enter_station_name;
    //click on search
     @FindBy(xpath="//*[@id=\"stationSearchForm\"]/div[2]/div[2]/button/div")
     private static WebElement click_Search;
     //verify station page
     @FindBy(xpath="//h2[text()='Trains from New Delhi (NDLS) Railway Station']")
     private static WebElement verify_Station_page;
     //click on book now button of a train
     @FindBy(xpath="//tr[.//a[contains(text(),'20433')]]//a[contains(text(),'Book Now')]")
     private static WebElement book_now_button;

// Constructor
    public PlatformPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }
    //method for to click on train platform locator
    public static boolean getclick_Train_Platform()
    {
    	boolean actResult = true;
    	try {
        wait.until(ExpectedConditions.visibilityOf(click_Train_Platform));
		Reports.generateReport(driver, test, Status.PASS, "Train platform locator is clicked");
		click_Train_Platform.click();
    	}
    	catch (Exception e) 
    	{
    	    actResult = false;
    	    Reports.generateReport(driver, test, Status.FAIL, "Train platform locator is not clicked");
    	}
    	return actResult;
    }
    //Entering train name in input text field
    public static boolean getTrainName(String train_name )
	{
		boolean actResult = true;
        try 
        {
          	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(enter_train_name));
            Reports.generateReport(driver, test, Status.PASS, "train name is entered");
            enter_train_name.sendKeys(train_name);
            enter_train_name.sendKeys(Keys.ENTER);
        } 
        catch (Exception e) {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "train name is not entered");
        }
        return actResult;
	}

    //method for to click on train platfrom locator
    public static boolean getclick_Search_Platform()
    {
    	boolean actResult = true;
    	try {
        wait.until(ExpectedConditions.visibilityOf(click_Search_Platform));
		Reports.generateReport(driver, test, Status.PASS, "Train platform locator is clicked");
		click_Search_Platform.click();
    	}
    	catch (Exception e) 
    	{
    	    actResult = false;
    	    Reports.generateReport(driver, test, Status.FAIL, "Train platform locator is not clicked");
    	}
    	return actResult;
    }
    //verify train platform page or not
    public boolean verifyTrainPlatformpage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(train_platform_verify));
            Reports.generateReport(driver, test, Status.PASS, "Train platform page is displayed");
            return true;
        } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Train platform page is NOT displayed");
            return false;
        }
    }
    //==========================second scenario methods========================================
    
    
    public static boolean verify_user_on_train_home_page()
    {
    	boolean actResult = true;
        try 
        {
            wait.until(ExpectedConditions.visibilityOf(train_homepage));
            Reports.generateReport(driver, test, Status.PASS, "Train Home page  is displayed");
        } 
        catch (TimeoutException te) {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Train Home page functionality is not displayed");
        }
        return actResult;
    }
    //click on search by station
    public static boolean getclick_Search_Station()
    {
    	boolean actResult = true;
    	try {
        wait.until(ExpectedConditions.visibilityOf(click_Search_By_Station));
		Reports.generateReport(driver, test, Status.PASS, "search by station  is clicked");
		click_Search_By_Station.click();
    	}
    	catch (Exception e) 
    	{
    	    actResult = false;
    	    Reports.generateReport(driver, test, Status.FAIL, "search by station is not clicked");
    	}
    	return actResult;
    }

  //Entering station name in input text field
    public static boolean enter_Station_Name(String station_name )
	{
		boolean actResult = true;
        try 
        {
//        	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(enter_station_name));
            Reports.generateReport(driver, test, Status.PASS, "station name is entered");
            enter_station_name.sendKeys(station_name);
            enter_station_name.sendKeys(Keys.ENTER);
        } 
        catch (Exception e) {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "station name is not entered");
        }
        return actResult;
	}
  // click on search in station name search page
    public static boolean click_Search_Station()
    {
    	boolean actResult = true;
    	try {
        wait.until(ExpectedConditions.visibilityOf(click_Search));
		Reports.generateReport(driver, test, Status.PASS, "search is clicked ");
		click_Search.click();
    	}
    	catch (Exception e) 
    	{
    	    actResult = false;
    	    Reports.generateReport(driver, test, Status.FAIL, "search is not clicked");
    	}
    	return actResult;
    }
    //system should display a list of available trains
    public static boolean verify_Search_By_Station_Page()
    {
    	boolean actResult = true;
    	try {
        wait.until(ExpectedConditions.visibilityOf(verify_Station_page));
		Reports.generateReport(driver, test, Status.PASS, "Train names in particular station are displayed");
		verify_Station_page.click();
    	}
    	catch (Exception e) 
    	{
    	    actResult = false;
    	    Reports.generateReport(driver, test, Status.FAIL, "Train names in particular station are not displayed");
    	}
    	return actResult;
    }

  //After station names are displayed and now choosing one station and clicking on "book now"
    public static boolean click_On_Book_Now()
    {
    	boolean actResult = true;
    	try {
        wait.until(ExpectedConditions.visibilityOf(book_now_button));
		Reports.generateReport(driver, test, Status.PASS, "Book Now is clicked");
		book_now_button.click();
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
    private static WebElement running_status;
    
    
    //click on enter train name or number
    @FindBy(xpath="//input[@placeholder='Enter the train number or name']")
    private static WebElement enter_train;
    
    
 // click on suggestions
    @FindBy(xpath="//p[@class='body-md' and contains(text(),'12423')]")
    private static WebElement suggestion_name;
    
  
  // check live status
    @FindBy(xpath="//button[normalize-space(text())='Check Live Status']")
    private static WebElement click_live;
    
    
    //download prompt
    @FindBy(xpath="//button[normalize-space(text())='DOWNLOAD']")
    private static WebElement download_prompt;
    
    public static boolean click_running_status()
    {
    	boolean actResult = true;
    	try {
        wait.until(ExpectedConditions.visibilityOf(running_status));
		Reports.generateReport(driver, test, Status.PASS, "running status is clicked");
		running_status.click();
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
            wait.until(ExpectedConditions.visibilityOf(enter_train));
            Reports.generateReport(driver, test, Status.PASS, "Train name is entered");

            // Enter train name
            enter_train.clear();
            enter_train.sendKeys(t_name);

            // Wait for exact suggestion to appear and click it
            WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement exactTrain = suggestionWait.until(ExpectedConditions.elementToBeClickable(suggestion_name));

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
    public static boolean click_checklive_status()
    {
    	boolean actResult = true;
    	try {
        wait.until(ExpectedConditions.visibilityOf(click_live));
		Reports.generateReport(driver, test, Status.PASS, "check live status is clicked");
		click_live.click();
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
            wait.until(ExpectedConditions.visibilityOf(download_prompt));

            if (download_prompt.isDisplayed()) {
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
  
     
  //click on src
    @FindBy(xpath="//p[text()='New Delhi (NDLS)']")
    private static WebElement src;
    
  //click on destination
    @FindBy(xpath="//p[text()='Faizabad Jn (FD)']")
    private static WebElement des;
       
  //quick search
    @FindBy(xpath="//p[text()='Quick Filters']")
    private static WebElement quick_search;
    
    //enter the source in input text field 
    public static boolean getSourceName(String source_name )
	{
	   boolean actResult = true;
      try 
      {
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
          wait.until(ExpectedConditions.visibilityOf(source));
          Reports.generateReport(driver, test, Status.PASS, "source entered:"+source_name);
          source.clear();
          source.click();
          source.sendKeys(source_name);
       
          WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(5));
          WebElement exactTrain = suggestionWait.until(ExpectedConditions.elementToBeClickable(src));
          exactTrain.click();
         
      } 
      catch (Exception e) {
          actResult = false;
          Reports.generateReport(driver, test, Status.FAIL, "source is not entered:"+e.getMessage());
      }
      return actResult;
	}
  
  //enter the destination in input text field 
  public static boolean getDestinationName(String destination_name )
	{
	   boolean actResult = true;
    try 
    {
 //     	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(destination));
        Reports.generateReport(driver, test, Status.PASS, "destination entered:"+destination_name);
        destination.clear();
        destination.sendKeys(destination_name);
        destination.sendKeys(Keys.ENTER);
        
        WebDriverWait suggestionWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement exactTrain1 = suggestionWait.until(ExpectedConditions.elementToBeClickable(des));
        exactTrain1.click();
       
    } 
    catch (Exception e) {
        actResult = false;
        Reports.generateReport(driver, test, Status.FAIL, "destination is not entered:"+e.getMessage());
    }
    return actResult;
	}

  //click on search  
  public static boolean click_On_search() {
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
  public static boolean verify_Train_Data_Page() {
      try {
    	  wait.until(ExpectedConditions.visibilityOf(quick_search)); 
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
  
  
  
  
  
}
 