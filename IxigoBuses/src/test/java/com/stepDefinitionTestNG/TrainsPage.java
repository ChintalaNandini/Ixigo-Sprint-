package com.stepDefinitionTestNG;

import com.pages.HomePage;
import com.pages.FoodOrderPage;
import com.setup.BaseSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TrainsPage extends BaseSteps {

    HomePage homePage;
    FoodOrderPage foodOrderPage = new FoodOrderPage(driver);


    @Given("the user is on Ixigo home page")
    public void the_user_is_on_ixigo_home_page() {
        homePage = new HomePage(driver); // driver from BaseSteps
        foodOrderPage = new FoodOrderPage(driver);
        // No need to call driver.get() because Hooks navigates to sourceUrl
    }

    @When("the user clicks on trains")
    public void the_user_clicks_on_trains() {
        homePage.clickTrainsLink();
    }

    @Then("user clicks on order food on train")
    public void user_clicks_on_order_food_on_train() {
        foodOrderPage.clickOrderFoodLink();
    }

    @Then("it should display on order food page")
    public void it_should_display_on_order_food_page() {
        foodOrderPage.verifyFoodOptionsDisplayed();
    }
}