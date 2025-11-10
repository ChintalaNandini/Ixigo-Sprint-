package com.stepDefinitionTestNG;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.pages.UserPage;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search extends BaseSteps{
	
	WebDriver driver = BaseSteps.driver;
	ExtentTest test = Hooks.test;
	 
	UserPage userpage;
	@Given("I am on the flight search page")
	public void i_am_on_the_flight_search_page() {
		userpage=new UserPage(driver,test);	
		BaseSteps.switchURL();
	}

	@When("I enter From location {string} {int}")
	public void i_enter_from_location(String path, int sheetno) {
		/*ExcelReader excel = new ExcelReader(path);
		String var = excel.getCellData(sheetno, 1, 0);
		boolean status =userpage.getuname(var);
		Assert.assertTrue(status);*/
	}
	    

	@When("I enter To location {string} {int}")
	public void i_enter_to_location(String string, Integer int1) {
	    
	}

	@When("I enter departure date {string} {int}")
	public void i_enter_departure_date(String string, Integer int1) {
	    
	}

	@When("I select passengers {string} {int}")
	public void i_select_passengers(String string, Integer int1) {
	    
	}

	@When("I select class from dropdown {string} {int}")
	public void i_select_class_from_dropdown(String string, Integer int1) {
	    
	}

	@When("I click on the search button")
	public void i_click_on_the_search_button() {
	    
	}

	@Then("I should see the list of available flights")
	public void i_should_see_the_list_of_available_flights() {
	    
	}


}
