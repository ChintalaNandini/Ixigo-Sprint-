package com.stepDefinitionTestNG;



import org.openqa.selenium.By;
import org.testng.Assert;

import com.pages.BrowserUtils;
import com.pages.UserPage;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile extends BaseSteps {
    UserPage userPage;
    String destination, checkInLabel, checkOutLabel;
	String rooms;
	String guests;

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
    public void i_click_on_the_search_button_without_entering_any_details() {
        userPage.clickSearch();
    }

    @Then("I should remain on the Hotels page or see an appropriate validation message")
    public void i_should_remain_on_the_hotels_page_or_see_an_appropriate_validation_message() {
        String expectedUrl = prop.getProperty("targetUrl");
        String actualUrl = driver.getCurrentUrl();

        boolean isOnHotelsPage = actualUrl.contains(expectedUrl);
        boolean isValidationVisible = false;

        try {
            isValidationVisible = driver.findElement(By.cssSelector(".validation-message")).isDisplayed();
        } catch (Exception e) {
            // No validation message found
        }

        Assert.assertTrue(isOnHotelsPage || isValidationVisible,
            "Expected to remain on Hotels page or see validation message, but neither occurred.");
    }
    
    //=========================================================================
   
  
    @When("I click on the hotel")
    public void i_click_on_the_hotel() {
        userPage.clickView();
        BrowserUtils.switchToNewTab(driver);
    }
    
    
    @Then("I should navigate to the next page")
    public void i_should_navigate_to_the_next_page() {
        String expectedTitleKeyword = "Hotel"; // Adjust based on actual page title
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitleKeyword),
            "Expected to navigate to hotel details page, but got: " + actualTitle);
    }

  
    //========================================================

    @Given("the search functionality is available on the homepage")
    public void the_search_functionality_is_available_on_the_homepage() {
        //BaseSteps.launchBrowser();
        userPage = new UserPage(BaseSteps.driver);
        destination = prop.getProperty("destination");
        checkInLabel = prop.getProperty("checkInDateLabel");
        checkOutLabel = prop.getProperty("checkOutDateLabel");
        rooms = prop.getProperty("rooms");
        guests = prop.getProperty("guests");
       
        
    }

    @When("I enter a valid destination")
    public void i_enter_a_valid_destination() {
        //userPage.enterDestination(destination);
    }

    @When("I select check-in and check-out dates")
    public void i_select_check_in_and_check_out_dates() {
//        userPage.enterCheckInDate(checkInLabel);
//        userPage.enterCheckOutDate(checkOutLabel);
    }

    @When("I select the number of rooms and guests")
    public void i_select_the_number_of_rooms_and_guests() {
         //userPage.enterRoomGuestDetails(rooms, guests);
    }

    @When("I click on the search button")
    public void i_click_on_the_search_button() {
        //userPage.clickSearch();
    }

    @Then("I should see a list of available hotels matching the criteria")
    public void i_should_see_a_list_of_available_hotels_matching_the_criteria() {
//        boolean hotelListVisible = driver.findElements(By.cssSelector(".hotel-card")).size() > 0;
//        Assert.assertTrue(hotelListVisible, "Hotel results not displayed.");
    }
    
    
}