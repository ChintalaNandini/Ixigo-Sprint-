package com.stepDefinitionJunit;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.pages.UserPage;
import com.setup.BaseSteps;
import com.stepDefinitionTestNG.Hooks;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends BaseSteps{
	 WebDriver driver = BaseSteps.driver;
	 ExtentTest test = Hooks.test; //test is a static so we are calling with classname
	
	 UserPage userpage;
	
	@Given("Login functionality should be available")
	public void login_functionality_should_be_available() {
          userpage=new UserPage(driver,test);
//          boolean status=userpage.clickLoginButton();;
//  		 Assert.assertTrue(status);
        

	    
	}

	@When("I enter the country code and mobile number on the login page")
	public void i_enter_the_country_code_and_mobile_number_on_the_login_page() {
	    
	}

	@And("I click on Continue")
	public void i_click_on_continue() {
	    	}

	@And("I enter the correct OTP")
	public void i_enter_the_correct_otp() {
	    
	}

	@Then("I should be logged in successfully")
	public void i_should_be_logged_in_successfully() {
	    
	}

}
