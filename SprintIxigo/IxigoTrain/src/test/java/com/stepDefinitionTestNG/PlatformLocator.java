package com.stepDefinitionTestNG;
 
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.pages.PlatformPage;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class PlatformLocator extends BaseSteps{
	 WebDriver driver = BaseSteps.driver;
	 ExtentTest test = Hooks.test; //test is a static so we are calling with classname
	 Properties prop=PropertyReader.readProperty();
	 PlatformPage platformpage;
	 @Given("The user is on the Platform Locator page of the Ixigo website.")
	 public void the_user_is_on_the_platform_locator_page_of_the_ixigo_website() {
		 platformpage=new PlatformPage(driver,test);
		 boolean status=platformpage.getclick_Train_Platform();
		 Assert.assertTrue(status);
	 }
	 @When("The user enters a validTrainNumber in the search input field.")
	 public void the_user_enters_a_in_the_search_input_field() {
		 String trainName=prop.getProperty("validTrainNumber");
			boolean status =platformpage.getTrainName(trainName);
			Assert.assertTrue(status);
	 }
	 @When("clicks Search")
	 public void clicks_search() {
		 boolean status=platformpage.getclick_Search_Platform();
		 Assert.assertTrue(status);    
	 }
 
	 @Then("The platform number for the entered train should be displayed")
	 public void the_platform_number_for_the_entered_train_should_be_displayed() {
		 Assert.assertTrue(platformpage.verifyTrainPlatformpage());

	 }
	 //=====================second scenario methods===================
	 @Given("the user is on the Train Home page")
	 public void the_user_is_on_the_train_home_page() {
		 platformpage=new PlatformPage(driver,test);
		 boolean status=platformpage.verify_user_on_train_home_page();
		 Assert.assertTrue(status);
	 }
 
	 @When("the user clicks on Search by Station")
	 public void the_user_clicks_on_search_by_station() {
		 boolean status=platformpage.getclick_Search_Station();
		 Assert.assertTrue(status);   
	 }
 
	 @And("the user enters a valid stationName")
	 public void the_user_enters_a_valid() {
		 String station_Name=prop.getProperty("stationName");
	      boolean status =platformpage.enter_Station_Name(station_Name);
		 Assert.assertTrue(status);  
	 }
 
	 @And("the user clicks on Search")
	 public void the_user_clicks_on_search() {
		 boolean status=platformpage.click_Search_Station();
		 Assert.assertTrue(status);  
	 }
 
	 @Then("the system should display a list of available trains")
	 public void the_system_should_display_a_list_of_available_trains() {
		 boolean status=platformpage.verify_Search_By_Station_Page();
		 Assert.assertTrue(status);
	 }
 
	 @And("click on Book Now button")
	 public void click_on_book_now_button() {
		 boolean status=platformpage.click_On_Book_Now();
		 Assert.assertTrue(status);
	 }
 
	 @Then("user is navigated to Booking page")
	 public void user_is_navigated_to_booking_page() {
		 boolean status = platformpage.verifyBookingPage();
	     Assert.assertTrue(status);
	 }

	 
	 
	 //=======================================Third scenario============================================
	 @Given("User is on Ixigo website and clicks on Trains tab")
	 public void user_is_on_ixigo_website_and_clicks_on_trains_tab() {
		 platformpage=new PlatformPage(driver,test);
		 boolean status=platformpage.verify_user_on_train_home_page();
		 Assert.assertTrue(status);
	     
	 }

	 @When("User clicks on Running Status")
	 public void user_clicks_on_running_status() {
		 boolean status=platformpage. click_running_status();
		 Assert.assertTrue(status);    
	 }

	 @And("User enters train number or name")
	 public void user_enters_train_number_or_name() {	
		  String station_Name=prop.getProperty("trainNumber");
	      boolean status =platformpage.entertrain_Name(station_Name);
		  Assert.assertTrue(status);      
	 }

	 @And("User clicks on check status button")
	 public void user_clicks_on_check_status_button() {
		 boolean status=platformpage.click_checklive_status();
		 Assert.assertTrue(status);   
	 }

	 @Then("Download prompt should appear allowing user to save train data")
	 public void download_prompt_should_appear_allowing_user_to_save_train_data() {
		 boolean status=platformpage.verifyDownloadPromptPage();
		 Assert.assertTrue(status);  
	     
	 }
    
	 //=====================================fourth scenario==================================================
	 
	 
	 @When("User enters Source name from sheet {int} and row {int} and sourceCol {int}")
	 public void user_enters_source_name_from_sheet_and_row_and_source_col(int sheetIndex, int  rowIndex, int sourceCol) throws InterruptedException {
        String excelPathSO = prop.getProperty("ScenarioOutlineExcelPath");
	     Thread.sleep(5000);	     // to fetch source from Excel
	     String enteredSource = ExcelReader.getSource(excelPathSO, sheetIndex, rowIndex, sourceCol);
	     
	     // Print  source value
	     System.out.println("Source from Excel: " + enteredSource);
	    
	     Assert.assertNotNull(enteredSource, "source not found at sheet " + sheetIndex + ", row " + rowIndex);
	     boolean statusSource = platformpage.getSourceName(enteredSource);
	     Thread.sleep(5000);
	     Assert.assertTrue(statusSource);
	     
	 }

	 @And("User enters Destination name from sheet {int} and row {int} and destinationCol {int}")
	 public void user_enters_destination_name_from_sheet_and_row_and_destination_col(int sheetIndex, int  rowIndex, int destinationCol) {
         String excelPathSO = prop.getProperty("ScenarioOutlineExcelPath");
	     
	     // to Fetch destination from Excel
	     String enteredDestination = ExcelReader.getDestination(excelPathSO, sheetIndex, rowIndex, destinationCol);
	     
	     // Print actual destination value
	     System.out.println("Destination from Excel: " + enteredDestination);
	     
	     Assert.assertNotNull(enteredDestination, "destination not found at sheet " + sheetIndex + ", row " + rowIndex);
	     boolean statusDestination = platformpage.getDestinationName(enteredDestination);
	     Assert.assertTrue(statusDestination);
	     
	 }

	 @And("User clicks on Search for train data")
	 public void user_clicks_on_search_for_train_data() {
		 boolean status=platformpage.click_On_search();
		 Assert.assertTrue(status); 
 
	 }

	 @Then("user is navigated to train data displayed page")
	 public void user_is_navigated_to_train_data_displayed_page() {
		 boolean status=platformpage.verify_Train_Data_Page();
		 Assert.assertTrue(status); 
	     
	 }

} 
