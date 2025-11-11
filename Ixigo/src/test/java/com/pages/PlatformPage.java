package com.pages;

import java.time.Duration;

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
    
    
  //After station names are displayed and now chhosing one station and clicking on "book now"
    public static boolean click_On_Book_Now_()
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
    
 
}




