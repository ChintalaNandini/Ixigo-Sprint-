package com.stepDefinitionTestNG;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.pages.UserPage;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search extends BaseSteps{
	 WebDriver driver = BaseSteps.driver;
	 ExtentTest test = Hooks.test; //test is a static so we are calling with classname
	 UserPage userpage;
	 
//	 @Given("I am on the train search page")
//	 public void i_am_on_the_train_search_page() {
//		 userpage=new UserPage(driver,test);	
//	    
//	 }
//
//	 @When("I enter the valid Excel source {string} {int}")
//	 public void i_enter_the_valid_excel_source(String path, int sheetno) {
//		    ExcelReader excel = new ExcelReader(path);
//			String var = excel.getCellData(sheetno, 0, 0);
//			boolean status =userpage.getSource(var);
//			Assert.assertTrue(status);
//	     
//	 }
//
//	 @And("I enter the valid Excel destination {string} {int}")
//	 public void i_enter_the_valid_excel_destination(String path, int sheetno) {
//		    ExcelReader excel = new ExcelReader(path);
//			String var = excel.getCellData(sheetno, 1, 0);
//			boolean status =userpage.getDestination(var);
//			Assert.assertTrue(status);
//	 
//	 }
//	 
//	 @And("I enter the valid Excel date {string} {int}")
//	 public void i_enter_the_valid_excel_date(String path, int sheetno) {
//	     ExcelReader excel = new ExcelReader(path);
//	     String date = excel.getCellData(sheetno, 2, 0);
//	     boolean status = userpage.selectDateFromExcel(path, sheetno, 2, 0);
//	     Assert.assertTrue(status);
//	 }
//
//
//	 @And("I click on Search")
//	 public void i_click_on_search() {
//	     
//	 }
//
//	 @Then("I should see a list of available trains based on the given data")
//	 public void i_should_see_a_list_of_available_trains_based_on_the_given_data() {
//	     
//	 }
}

