package com.stepDefinitionTestNG;



import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
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
    String excelPath = "src/test/resources/ExcelData/checkboxes.xlsx";
	
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

	@Given("I am on the Hotels Page")
	public void i_am_on_the_hotels_page() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		userPage = new UserPage(BaseSteps.driver);
		
	}

	@When("I click on the offers")
	public void i_click_on_the_offers() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		userPage.clickoffers();
		
	}

	@When("click on the Search Hotels")
	public void click_on_the_search_hotels() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		userPage.clicksearchhotels();
	}
	
	@When("click on the Hotelpage search")
	public void click_on_the_hotelpage_search() {
		userPage.clickhotelssearch();
	}

	@Then("I should the get the list of hotels")
	public void i_should_the_get_the_list_of_hotels() {
		
	}
	
	//===========================================================
/*
	@Given("I am on the Hotels page1")
    public void i_am_on_the_hotels_page1() {
        userPage = new UserPage(BaseSteps.driver);
        //excelReader = new ExcelReader();
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

	@When("I click the Search Hotels button")
	public void i_click_the_search_hotels_button() throws InterruptedException {
		userPage.searcchhotelss();
	}
	
	
	
	//@When("I apply the checkbox filter with <sheet> and <row>")
	@When("I apply the checkbox filter with {int} and {int}")
	public void i_apply_the_checkbox_filter_with_and(Integer sheet, Integer row) throws Exception {
	    //String excelPath = System.getProperty("user.dir") + "/src/test/resources/ExcelData/checkboxes.xlsx";
		String path = prop.getProperty("excelpath");
		
	

	    ExcelReader excelReader = new ExcelReader(path);

	    List<String> filters = excelReader.getRowData(row, sheet);
	    Assert.assertNotNull(filters,"Locality not found at sheet"+ sheet+", row "+row);
	    
	    boolean status = false;
	    
		// Decide action based on rowIndex
		if (row == 0) {
			// First brand (Petkit)
			status = userPage.clickcheckbox1(); // Method for Petkit
		} else if (row == 1) {
			// Second brand (Petkit again or another)
			status = userPage.clickcheckbox2(); // Method for second brand
		
		} else {
			throw new IllegalArgumentException("Unsupported row index: " + row);
		}
		Assert.assertTrue(status);
	
}
	
	
	@Then("I should see a list of filtered hotels")
	public void i_should_see_a_list_of_filtered_hotels() {
//	    List<WebElement> filteredHotels = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
//	        By.cssSelector(".hotel-card"))); // Replace with actual class used for hotel listings
//	    Assert.assertTrue(filteredHotels.size() > 0, "Filtered hotel list should be visible");
	}
*/

	//==================================================================
	
	
	
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
		//tring destination = currentRowData;
		System.out.println(destination);
		userPage.clickAndEnterHotelDestination(destination);
		userPage.selectFirstHotelSuggestion();
	    
    	}


	@When("the user clicks on the search button")
	public void the_user_clicks_on_the_search_button() {
	    userPage.searchdestination();
	}

	@Then("the user should see a list of available hotels displayed")
	public void the_user_should_see_a_list_of_available_hotels_displayed() {
	    WebDriver driver = BaseSteps.driver;
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement hotelList = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.cssSelector("h6.h6.flex-1.truncate.break-all.capitalize.font-medium"))); // Adjust selector as needed
	    Assert.assertTrue(hotelList.isDisplayed());
	}
}

    
    