package com.stepDefinitionTestNG;



import com.pages.UserPage;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile extends BaseSteps{
    UserPage userPage;
    String destination, checkIn, checkOut, rooms, guests;

    @Given("I am on the Ixigo homepage")
    public void i_am_on_the_ixigo_homepage() {
        //BaseSteps.launchBrowser();
        userPage = new UserPage(BaseSteps.driver);
    }

    @When("I click on the Hotels tab")
    public void i_click_on_the_hotels_tab() {
//        //userPage.
//        String newurl=prop.getProperty("targetUrl");
//        driver.get(newurl);
//        driver.manage().window().maximize();
    }

    @When("I click on the Search button without entering any details")
    public void i_click_on_the_search_button_without_entering_any_details() {
        userPage.clickSearch();
    }

    @Then("I should remain on the Hotels page or see an appropriate validation message")
    public void i_should_remain_on_the_hotels_page_or_see_an_appropriate_validation_message() {
        // Add assertion logic here
    }

    @Given("the search functionality is available on the homepage")
    public void the_search_functionality_is_available_on_the_homepage() {
        BaseSteps.launchBrowser();
        userPage = new UserPage(BaseSteps.driver);
        destination = BaseSteps.prop.getProperty("destination");
        checkIn = BaseSteps.prop.getProperty("checkInDate");
        checkOut = BaseSteps.prop.getProperty("checkOutDate");
//        rooms = BaseSteps.prop.getProperty("rooms");
//        guests = BaseSteps.prop.getProperty("guests");
    }

    @When("I enter a valid destination")
    public void i_enter_a_valid_destination() {
          userPage.enterDestination(destination);
    }

    
    @When("I select check-in and check-out dates")
    public void i_select_check_in_and_check_out_dates() {
        userPage.enterCheckInDate(checkIn);
        userPage.enterCheckOutDate(checkOut);
    }

    @When("I select the number of rooms and guests")
    public void i_select_the_number_of_rooms_and_guests() {
        //userPage.enterRoomGuestDetails(rooms, guests);
    }

    @When("I click on the search button")
    public void i_click_on_the_search_button() {
        userPage.clickSearch();
    }

    @Then("I should see a list of available hotels matching the criteria")
    public void i_should_see_a_list_of_available_hotels_matching_the_criteria() {
        // Add assertion logic here
    }
}