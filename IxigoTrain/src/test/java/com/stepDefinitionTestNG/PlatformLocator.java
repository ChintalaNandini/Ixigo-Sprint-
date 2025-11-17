package com.stepDefinitionTestNG;
 
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.pages.PlatformPage;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Duration;
 
public class PlatformLocator extends BaseSteps{
	 WebDriver driver = BaseSteps.driver;
	 ExtentTest test = Hooks.test; //test is a static so we are calling with classname
	 Properties prop=PropertyReader.readProperty();
	 PlatformPage platformpage;
	 
//	 @Given("The user is on the trains home page of the Ixigo website.")
//	 public void the_user_is_on_the_platform_locator_page_of_the_ixigo_website() throws InterruptedException {
//		 platformpage=new PlatformPage(driver,test);
//		 String targeturl=prop.getProperty("targetUrl");
//	     driver.get(targeturl);
//		 Thread.sleep(7000);	 
//	 }
	 
	 @Given("The user is on the trains home page of the Ixigo website.")
	 public void the_user_is_on_the_platform_locator_page_of_the_ixigo_website() throws InterruptedException {
	     platformpage = new PlatformPage(driver, test);

	     // Get all window handles
	     Set<String> windowHandles = driver.getWindowHandles();
	     Iterator<String> iterator = windowHandles.iterator();

	     String parentWindow = iterator.next();
	     String childWindow = null;

	     // Assuming the trains page is opened in a new tab/window
	     if (iterator.hasNext()) {
	         childWindow = iterator.next();
	         driver.switchTo().window(childWindow);
	     } else {
	         // If no new window exists, open manually
	         String targetUrl = prop.getProperty("targetUrl");
	         ((JavascriptExecutor) driver).executeScript("window.open('" + targetUrl + "', '_blank');");
	         Thread.sleep(2000);

	         // Switch to the newly opened tab
	         Set<String> newHandles = driver.getWindowHandles();
	         for (String handle : newHandles) {
	             if (!handle.equals(parentWindow)) {
	                 driver.switchTo().window(handle);
	                 break;
	             }
	         }
	     }

	     Thread.sleep(5000); // Wait for page load
	 }
	 
	 
	 @When("the user clicks on platform locator")
	 public void clicks_platform_locator() {
		 boolean status=platformpage.getclick_Train_Platform();
		 Assert.assertTrue(status);  
	 }
	 @And("The user enters a validTrainNumber in the search input field.")
	 public void the_user_enters_a_in_the_search_input_field() {
		    String trainName=prop.getProperty("validTrainNumber");
		    System.out.println("Entered train number/aname:"+trainName);
			boolean status =platformpage.getTrainName(trainName);
			Assert.assertTrue(status);
	 }
	 @And("user clicks on Search")
	 public void clicks_search() {
		 boolean status=platformpage.getclick_Search_Platform();
		 Assert.assertTrue(status);    
	 }
 
	 @Then("user is navigated to train platform locator displayed page.")
	 public void the_platform_number_for_the_entered_train_should_be_displayed() {
		 boolean status= platformpage.verifyTrainPlatformpage();
		 Assert.assertTrue(status);

	 }
	 //=====================second scenario methods===================
	 @Given("the user is on the Train Home page")
	 public void the_user_is_on_the_train_home_page() throws InterruptedException {
		 platformpage=new PlatformPage(driver,test);
		 Thread.sleep(7000);
		 String targeturl=prop.getProperty("targetUrl");
	    
	     // Get current window handle
	     String parentWindow = driver.getWindowHandle();

	     // Open trains page in a new tab
	     ((JavascriptExecutor) driver).executeScript("window.open('" + targeturl + "', '_blank');");

	     // Switch to the new tab
	     Set<String> allWindows = driver.getWindowHandles();
	     for (String handle : allWindows) {
	         if (!handle.equals(parentWindow)) {
	             driver.switchTo().window(handle);
	             break;
	         }
	     }
	     
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
		 System.out.println("Entered station name:"+station_Name);
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
//	 @Given("User is on Ixigo website and clicks on Trains tab")
//	 public void user_is_on_ixigo_website_and_clicks_on_trains_tab() throws InterruptedException {
//		 platformpage=new PlatformPage(driver,test);
//		 Thread.sleep(7000);
//		 String targeturl=prop.getProperty("targetUrl");
//	     driver.get(targeturl);
//		 boolean status=platformpage.verify_user_on_train_home_page();
//		 Assert.assertTrue(status);
//	     
//	 }
	 
	 
	 @Given("User is on Ixigo website and clicks on Trains tab")
	 public void user_is_on_ixigo_website_and_clicks_on_trains_tab() throws InterruptedException {
	     platformpage = new PlatformPage(driver, test);
	     Thread.sleep(7000);

	     String targetUrl = prop.getProperty("targetUrl");

	     // Get current window handle
	     String parentWindow = driver.getWindowHandle();

	     // Open trains page in a new tab
	     ((JavascriptExecutor) driver).executeScript("window.open('" + targetUrl + "', '_blank');");

	     // Switch to the new tab
	     Set<String> allWindows = driver.getWindowHandles();
	     for (String handle : allWindows) {
	         if (!handle.equals(parentWindow)) {
	             driver.switchTo().window(handle);
	             break;
	         }
	     }

	     boolean status = platformpage.verify_user_on_train_home_page();
	     Assert.assertTrue(status);
	 }


	 @When("User clicks on Running Status")
	 public void user_clicks_on_running_status() {
		 boolean status=platformpage. click_running_status();
		 Assert.assertTrue(status);    
	 }

	 @And("User enters train number or name")
	 public void user_enters_train_number_or_name() throws InterruptedException {
		 Thread.sleep(3000);
		  String station_Name=prop.getProperty("trainNumber");
		  System.out.println("Entered name or number:"+station_Name);
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
	 
	 //==============================================fifth scenario===========================================
	 
	 @Given("user is on the ixigo home page and clicks on trains tab")
	 public void user_is_on_the_ixigo_home_page_and_clicks_on_trains_tab() throws InterruptedException {
		 platformpage=new PlatformPage(driver,test);
		 
		 String targetUrl = prop.getProperty("targetUrl");

	     // Get current window handle
	     String parentWindow = driver.getWindowHandle();

	     // Open trains page in a new tab
	     ((JavascriptExecutor) driver).executeScript("window.open('" + targetUrl + "', '_blank');");

	     // Switch to the new tab
	     Set<String> allWindows = driver.getWindowHandles();
	     for (String handle : allWindows) {
	         if (!handle.equals(parentWindow)) {
	             driver.switchTo().window(handle);
	             break;
	         }
	     }
		 boolean status=platformpage.verify_user_on_train_home_page();
		    Thread.sleep(5000);
		 Assert.assertTrue(status);
	     
	 }

	 @When("user clicks on Search By Name\\/Number")
	 public void user_clicks_on_search_by_name_number() { 
		 boolean status=platformpage.click_name_number();
		 Assert.assertTrue(status); 
	    
	 }
	 @And("user enters trainNameOrNumber from sheet {int} and row {int} and trainCol {int}")
	 public void user_enters_train_name_or_number_from_sheet_and_row_and_train_col(int sheetIndex, int  rowIndex, int trainCol) {
		     String excelPathSO = prop.getProperty("ExcelPath");
			// to Fetch destination from Excel
		     String enteredTrainName = ExcelReader.getSource(excelPathSO, sheetIndex, rowIndex, trainCol);
		     
		  // Print actual destination value
		     System.out.println("Train name from Excel: " + enteredTrainName);
		     
		     Assert.assertNotNull(enteredTrainName, "train name not found at sheet " + sheetIndex + ", row " + rowIndex);
		     boolean statusTrain = platformpage.enter_train_Name_Number(enteredTrainName);
		     Assert.assertTrue(statusTrain);
	 }

	 @And("user clicks on view calendar")
	 public void user_clicks_on_view_calendar() {
		 boolean status=platformpage.click_view_calender();
		 Assert.assertTrue(status); 
	    
	 }

	 @Then("user is navigated to seat availability page")
	 public void user_is_navigated_to_seat_availability_page() {
		 
		 boolean status=platformpage.verify_seat_availability_Page();
		 Assert.assertTrue(status); 
	    
	 }
	 //======================================six scenario======================================================
	 
	 
	 @When("User enters Source  from sheet {int} and row {int} and sourceCol {int}")
	   public void user_enters_source_from_sheet_and_row_and_source_col( int sheetIndex, int rowIndex, int sourceCol) throws InterruptedException {
		 String excelPathSO = prop.getProperty("ScenarioOutlineExcelPath1");
	     Thread.sleep(5000);	     // to fetch source from Excel
	     String enteredSource = ExcelReader.getSource(excelPathSO, sheetIndex, rowIndex, sourceCol);
	     
	     // Print  source value
	     System.out.println("Source from Excel: " + enteredSource);
	    
	     Assert.assertNotNull(enteredSource, "source not found at sheet " + sheetIndex + ", row " + rowIndex);
	     boolean statusSource = platformpage.getSourceName(enteredSource);
	     Thread.sleep(5000);
	     Assert.assertTrue(statusSource);
	       
	   }

	   @And("User enters Destination  from sheet {int} and row {int} and destinationCol {int}")
	   public void user_enters_destination_from_sheet_and_row_and_destination_col(int sheetIndex, int rowIndex, int destinationCol) {
		   String excelPathSO = prop.getProperty("ScenarioOutlineExcelPath1");
		     
		     // to Fetch destination from Excel
		     String enteredDestination = ExcelReader.getDestination(excelPathSO, sheetIndex, rowIndex, destinationCol);
		     
		     // Print actual destination value
		     System.out.println("Destination from Excel: " + enteredDestination);
		     
		     Assert.assertNotNull(enteredDestination, "destination not found at sheet " + sheetIndex + ", row " + rowIndex);
		     boolean statusDestination = platformpage.getDestinationName(enteredDestination);
		     Assert.assertTrue(statusDestination);
	      
	   }
	 
	 @Then("Error messaged is displayed on the same search page.")
	 public void error_meassaged_is_displayed_on_the_same_search_page() {
		 boolean status=platformpage.verify_Error_Message();
		 Assert.assertTrue(status); 
	     
	 }
	 
	 //=======================================seven scenario===========================================
	 
	 
	 @When("the user clicks on Vande Bharath Express on the trains home page")
	 public void the_user_clicks_on_vande_bharath_express_on_the_trains_home_page() {
		 boolean status=platformpage.click_Vande_Bharath();
		 Assert.assertTrue(status); 
	    
	 }

	 @And("the user enters the Source in the input text field")
	 public void the_user_enters_the_source_in_the_input_text_field() throws InterruptedException {
		  Thread.sleep(3000);
		  String from_loc=prop.getProperty("fromLocation");
		  System.out.println("Entered from location :"+from_loc);
	      boolean status =platformpage.fromLocation(from_loc);
		  Assert.assertTrue(status); 
	     
	 }

	 @And("the user enters the Destination in the input text field")
	 public void the_user_enters_the_destination_in_the_input_text_field() throws InterruptedException {
		 Thread.sleep(3000);
		  String to_loc=prop.getProperty("toLocation");
		  System.out.println("Entered to location:"+to_loc);
	      boolean status =platformpage.toLocation(to_loc);
		  Assert.assertTrue(status); 
	     
	 }
	 
	 @And("the user clicks on Search in search page")
	 public void the_user_clicks_on_search_in_search_page() {
		 boolean status=platformpage.click_search();
		 Assert.assertTrue(status); 
	 }

	 @And("the user clicks on Arrival Time")
	 public void the_user_clicks_on_arrival_time() {
		
		 boolean status=platformpage.click_arrival_time();
		 Assert.assertTrue(status); 
	    
	 }

	 @Then("the list of trains should be displayed sorted by Arrival Time")
	 public void the_list_of_trains_should_be_displayed_sorted_by_arrival_time() {
		
				 boolean status=platformpage.verify_sort_page();
				 Assert.assertTrue(status); 
	     
	 }



} 
