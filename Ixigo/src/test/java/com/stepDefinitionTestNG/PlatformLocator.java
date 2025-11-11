package com.stepDefinitionTestNG;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.pages.PlatformPage;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlatformLocator extends BaseSteps{
	 WebDriver driver = BaseSteps.driver;
	 ExtentTest test = Hooks.test; //test is a static so we are calling with classname
	
	 PlatformPage platformpage;
	 
	 @Given("The user is on the Platform Locator page of the Ixigo website.")
	 public void the_user_is_on_the_platform_locator_page_of_the_ixigo_website() {
		 
		 platformpage=new PlatformPage(driver,test);
		 boolean status=platformpage.getclick_Train_Platform();
		 Assert.assertTrue(status);
	 }
	     
	 @When("The user enters a {string} in the search input field.")
	 public void the_user_enters_a_in_the_search_input_field(String trainName) {
		 
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

	 @And("the user enters a valid {string}")
	 public void the_user_enters_a_valid(String station_Name) {
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
	     
	 }
//
//	 @Then("user is navigated to Booking page")
//	 public void user_is_navigated_to_booking_page() {
//	     
//	 }
//
//
//	 
	 
} 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
