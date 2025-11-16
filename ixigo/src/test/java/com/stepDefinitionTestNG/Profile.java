package com.stepDefinitionTestNG;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pages.BrowserUtils;
import com.pages.UserPage;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile extends BaseSteps {
	UserPage userPage;
	
	private ExcelReader excelReader;
    private WebDriverWait wait;
   
	String destination;
	String number;
	
	//first scenario
	
	@Given("I am on the Ixigo homepage")
	public void i_am_on_the_ixigo_homepage() {
		userPage = new UserPage(BaseSteps.driver);
	}

	@When("I click on the Hotels tab")
	public void i_click_on_the_hotels_tab() {
		String newurl = prop.getProperty("targetUrl");
		driver.get(newurl);
		driver.manage().window().maximize();
	}

	@When("I click on the Search button without entering any details")
	public void i_click_on_the_search_button_without_entering_any_details() throws InterruptedException {
		userPage.clickSearch();
	}
	
	@When("I click on the Google Map")
	public void i_click_on_the_Google_Map() throws InterruptedException
	{
		userPage.googleMap();
	}

	@Then("I should remain on the Hotels page or see a Googlemap")
	public void i_should_remain_on_the_hotels_page_or_see_a_Googlemap() {
		String expectedUrl = prop.getProperty("FirstscenarioURL");
		String actualUrl = driver.getCurrentUrl();

		boolean isOnGoogleMap = actualUrl.contains(expectedUrl);
		boolean isValidationVisible = false;

		try {
			isValidationVisible = driver.findElement(By.cssSelector(".mb-20")).isDisplayed();
		} catch (Exception e) {
			
		}

		Assert.assertTrue(isOnGoogleMap || isValidationVisible,"failed.");
	}
	


	//=========================================================================

    //second scenario
	
	@Given("I am on the Ixigo website homepage")
	public void i_am_on_the_ixigo_website_homepage() {
		userPage = new UserPage(BaseSteps.driver);
	}

	@When("I switch to the Hotel tab")
	public void i_switch_to_the_hotel_tab() {
		String newurl = prop.getProperty("targetUrl");
		driver.get(newurl);
		driver.manage().window().maximize();
	}

	@When("I click on the hotel")
	public void i_click_on_the_hotel() throws InterruptedException {
		userPage.clickView();
		BrowserUtils.switchToNewTab(driver);
		
	}


	@Then("I should navigate to the next page")
	public void i_should_navigate_to_the_next_page() {
		String expectedTitleKeyword = prop.getProperty("Hotel"); // Adjust based on actual page title
		String actualTitle = driver.getTitle();
		Assert.assertTrue(actualTitle.contains(expectedTitleKeyword),
				"Expected to navigate to hotel details page, but got: " + actualTitle);
	}


	//========================================================
	
	//third scenario

	@Given("I am on the Hotels Page")
	public void i_am_on_the_hotels_page() {
		userPage = new UserPage(BaseSteps.driver);
		
	}

	@When("I click on the offers")
	public void i_click_on_the_offers() throws InterruptedException {
		userPage.clickoffers();
		
	}

	@When("click on the Search Hotels")
	public void click_on_the_search_hotels() throws InterruptedException {
		userPage.clicksearchhotels();
	}
	
	@When("click on the Hotelpage search")
	public void click_on_the_hotelpage_search() throws InterruptedException {
		userPage.clickhotelssearch();
	}

	@Then("I should the get the list of hotels")
	public void i_should_the_get_the_list_of_hotels() {
	    boolean isDisplayed = driver.findElement(By.cssSelector(".mb-20")).isDisplayed();
	    Assert.assertTrue(isDisplayed, "Hotel list is not displayed.");
	    System.out.println("Hotel list is displayed successfully.");
	}


	//==================================================================
	//fourth scenario
	
	
	@Given("the user is on the Ixigo homepage")
	public void the_user_is_on_the_ixigo_homepage() {
	    userPage = new UserPage(BaseSteps.driver);
	}

	@When("the user clicks on the hotels tab")
	public void the_user_clicks_on_the_hotels_tab() {
	    //userPage.clickSearch();
	}

	@When("the user enters a {int}{int} destination in the search field")
	public void the_user_enters_a_destination_in_the_search_field(Integer sheet,Integer row) throws Exception {
		destination = ExcelReader.readData(sheet, row);
		System.out.println(destination);
		userPage.clickAndEnterHotelDestination(destination);
		userPage.selectFirstHotelSuggestion();
    	}


	@When("the user clicks on the search button")
	public void the_user_clicks_on_the_search_button() throws InterruptedException {
	    userPage.searchdestination();
	}

	@Then("the user should see a list of available hotels displayed")
	public void the_user_should_see_a_list_of_available_hotels_displayed() {
		boolean isDisplayed = driver.findElement(By.xpath("//h6")).isDisplayed();
	    Assert.assertTrue(isDisplayed, "failed");
	}
	
	//=================================================================
	//fifth scenario
	
	@Given("User is on the Hotels homepage")
	public void user_is_on_the_hotels_homepage() {
		userPage = new UserPage(BaseSteps.driver);
	    
	}
	@When("User clicks on the selected hotel")
	public void user_clicks_on_the_selected_hotel() {
		userPage.hotels();
		userPage.clickViewhotel();
		BrowserUtils.switchToNewTab(driver);
	    
	}
	@When("User try to reserve one room")
	public void user_try_to_reserve_one_room() throws InterruptedException {
		userPage.clickReserveRoom();
	    
	}
	
	@When("User enters the {int}{int} mobile number to login")
	public void user_enters_the_mobile_number_to_login(Integer sheet, Integer row) throws Exception {
		number = ExcelReader.readData1(sheet, row);
		System.out.println(number);
		userPage.clickAndentermobilenumber(number);
	    
	}
	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() throws InterruptedException {
		userPage.clickLogincontinue();
	}
	
	@Then("the login through mobile number is verified")
	public void the_login_through_mobile_number_is_verified() {
		System.out.println("Current URL: " + driver.getCurrentUrl());
		String ExpectedURL = prop.getProperty("fifthscenarioURL");
		Assert.assertTrue(driver.getCurrentUrl().equals(ExpectedURL));
	
	}
}

    
    