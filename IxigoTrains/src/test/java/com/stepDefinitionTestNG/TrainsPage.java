package com.stepDefinitionTestNG;

import com.pages.HomePage;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;

//import com.pages.FoodOrderPage;
import com.setup.BaseSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TrainsPage extends BaseSteps 
{

	Properties prop = PropertyReader.readProperty();
	HomePage homePage;
	//    FoodOrderPage foodOrderPage = new FoodOrderPage(driver);


	@Given("the user is on Ixigo home page")
	public void the_user_is_on_ixigo_home_page() {
		homePage = new HomePage(driver); // driver from BaseSteps
		//foodOrderPage = new FoodOrderPage(driver);
		// No need to call driver.get() because Hooks navigates to sourceUrl
	}

	@When("the user clicks on trains")
	public void the_user_clicks_on_trains() {
		homePage.clickTrainsLink();
	}

	@Then("user clicks on order food on train")
	public void user_clicks_on_order_food_on_train() {
		homePage.clickOrderFoodLink();
	}

	@Then("it should display on order food page")
	public void it_should_display_on_order_food_page() {
		homePage.verifyFoodOptionsDisplayed();
	}

	@Then("user clicks on Train platform Locator")
	public void user_clicks_on_train_platform_locator() {
		homePage.clickPlatformLocator();
	}

	@Then("verify the Train platform Page")
	public void verify_the_train_platform_page(){
		homePage.clickTrainPlatform();
		//Thread.sleep(2000);
	}

	//3rd Scenario Starts from here


	@Then("user click on input field")
	public void user_click_on_input_field()  {
		homePage.clickPnrNum();
		
		
	}

	@Then("user click on Enter you digit PNR number {int} {int}")
	public void user_click_on_enter_you_digit_pnr_number(Integer int1, Integer int2) throws IOException {
		String[] testData = ExcelReader.getRowData(int1, int2); // Column 0 = TestName
	    homePage.enterTest(testData);
	    System.out.println("DEBUG: Excel Data -> " + testData);
	}


	@Then("click on search")
	public void click_on_search() {
		homePage.clickSearch();
	}

	@Then("verify Available Stations")
	public void verify_available_stations() throws InterruptedException {
	   homePage.verifyAvailableStations();
	}
	
	// 4th Scenario starts from here
	
	@When("user clicks on Check Seat Availability")
	public void user_clicks_on_check_seat_availability() throws InterruptedException {
		homePage.clickSeatAvailability();
	}

	@When("User enters Source name from sheet {int} and row {int} and sourceCol {int}")
	public void user_enters_source_name_from_sheet_and_row_and_source_col(Integer sheetIndex, Integer rowIndex, Integer sourceCol) throws InterruptedException {
		String excelPathSO = prop.getProperty("excelpath");
		Thread.sleep(5000);	     // to fetch source from Excel
		String enteredSource = ExcelReader.getDataByRowCol(excelPathSO, sheetIndex, rowIndex, sourceCol);

		// Print  source value
		System.out.println("Source from Excel: " + enteredSource);

		Assert.assertNotNull(enteredSource, "source not found at sheet " + sheetIndex + ", row " + rowIndex);
		boolean statusSource = homePage.getSourceName(enteredSource);
		Thread.sleep(5000);
		Assert.assertTrue(statusSource);
	}

	@When("User enters Destination name from sheet {int} and row {int} and destinationCol {int}")
	public void user_enters_destination_name_from_sheet_and_row_and_destination_col(Integer sheetIndex, Integer rowIndex, Integer destinationCol) {
		String excelPathSO = prop.getProperty("excelpath");
	     
	     // to Fetch destination from Excel
	     String enteredDestination = ExcelReader.getDestination(excelPathSO, sheetIndex, rowIndex, destinationCol);
	     
	     // Print actual destination value
	     System.out.println("Destination from Excel: " + enteredDestination);
	     
	     Assert.assertNotNull(enteredDestination, "destination not found at sheet " + sheetIndex + ", row " + rowIndex);
	     boolean statusDestination = homePage.getDestinationName(enteredDestination);
	     Assert.assertTrue(statusDestination);
	}

	@When("user clicks on Check Availability")
	public void user_clicks_on_check_availability() {
		boolean status=homePage.click_On_search();
		 Assert.assertTrue(status);
	}

	@Then("verify Trains Availability Page")
	public void verify_trains_availability_page() {
		boolean status=homePage.verify_Train_Data_Page();
		 Assert.assertTrue(status);
	}
	
	// 5th Scenario starts from here
	
	@When("the user clicks on offers")
	public void the_user_clicks_on_offers() {
		homePage.clickOffersPage();
	    
	}

	@When("user clicks on TrainOffers")
	public void user_clicks_on_train_offers() throws InterruptedException {
		homePage.clicktrainoffers();
	    
	}

	@Then("verify offers availability")
	public void verify_offers_availability() throws InterruptedException {
		homePage.verifyTrainOffers();
	    
	}
	


}









































































//	//From here it starts 3rd Scenario
//	
//	@When("user clicks on Check Seat Availability")
//	public void user_clicks_on_check_seat_availability() {
//	    homePage.clickCheckSeatAvailability();
//	}
//
//	@When("user enters data of From {int} {int}")
//	public void user_enters_data_of_from(Integer sheetNo, Integer rowNum) {
//	    ExcelReader reader = new ExcelReader("src/test/resources/ExcelData/Book4.xlsx");
//	    String fromStation = reader.getCellData(sheetNo, rowNum, 0);
//	    homePage.enterFromStation(fromStation);
//	}
//
//	@When("user enters data of To {int} {int}")
//	public void user_enters_data_of_to(Integer sheetNo, Integer rowNum) {
//	    ExcelReader reader = new ExcelReader("src/test/resources/ExcelData/Book4.xlsx");
//	    String toStation = reader.getCellData(sheetNo, rowNum, 1);
//	    homePage.enterToStation(toStation);
//	}
//
//	@When("user clicks on Check Availability")
//	public void user_clicks_on_check_availability() {
//	    homePage.clickCheckAvailability();
//	}
//
//	@Then("verify Trains Availability Page")
//	public void verify_trains_availability_page() {
//	    homePage.verifyTrainsAvailabilityPage();
//	}























//	@When("user clicks on Check Seat Availability")
//	public void user_clicks_on_check_seat_availability() {
//
//	}
//
//	@When("user enters data of From {int} {int} {int}")
//	public void user_enters_data_of_from(Integer int1, Integer int2, Integer int3) {
//
//	}
//
//	@When("user enters data of To {int} {int} {int}")
//	public void user_enters_data_of_to(Integer int1, Integer int2, Integer int3) {
//
//	}
//
//	@When("user clicks on Check Availability")
//	public void user_clicks_on_check_availability() {
//
//	}
//
//	@Then("verify Trains Availability Page")
//	public void verify_trains_availability_page() {
//
//	}













































//	@When("user clicks on Check Seat Availability")
//	public void user_clicks_on_check_seat_availability() {
//	    homePage.clickCheckSeatAvailability();
//	}
//
//	@When("user enters data of From {int} {int}")
//	public void user_enters_data_of_from(Integer sheetNo, Integer rowNum) {
//	    ExcelReader reader = new ExcelReader("src/test/resources/ExcelData/Book4.xlsx");
//	    String fromStation = reader.getCellData(sheetNo, rowNum, 0);
//	    homePage.enterFromStation(fromStation);
//	}
//
//	@When("user enters data of To {int} {int}")
//	public void user_enters_data_of_to(Integer sheetNo, Integer rowNum) {
//	    ExcelReader reader = new ExcelReader("src/test/resources/ExcelData/Book4.xlsx");
//	    String toStation = reader.getCellData(sheetNo, rowNum, 1);
//	    homePage.enterToStation(toStation);
//	}
//
//	@When("user clicks on Check Availability")
//	public void user_clicks_on_check_availability() {
//	    homePage.clickCheckAvailability();
//	}
//
//	@Then("verify Trains Availability Page")
//	public void verify_trains_availability_page() {
//	    homePage.verifyTrainsAvailabilityPage();
//	}
//	
//	
////	 @When("user clicks on Check Seat Availability")
////	 public void user_clicks_on_check_seat_availability() {
////	     
////	 }
////	 @When("user enters data of From {int} {int}")
////	 public void user_enters_data_of_from(Integer int1, Integer int2) {
////	   
////	 }
////	 @When("user enters data of To {int} {int}")
////	 public void user_enters_data_of_to(Integer int1, Integer int2) {
////	     
////	 }
////	 @When("user clicks on Check Availability")
////	 public void user_clicks_on_check_availability() {
////	    
////	 }
////	 @Then("verify Trains Availability Page")
////	 public void verify_trains_availability_page() {
////	    
////	 }
//














































//package com.stepDefinitionTestNG;
//
//import com.pages.FoodOrderPage;
//import com.pages.HomePage;
//import com.parameters.PropertyReader;
//import com.setup.BaseSteps;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class TrainsPage extends BaseSteps {
//
//    HomePage homePage;
//    FoodOrderPage foodOrderPage = new FoodOrderPage(driver);
//
//
//    @Given("the user is on Ixigo home page")
//    public void the_user_is_on_ixigo_home_page() {
//BaseSteps.driver.get(PropertyReader.getProperty("base.url"));
//    	homePage = new HomePage(BaseSteps.driver); // driver from BaseSteps
//     //   foodOrderPage = new FoodOrderPage(driver);
//        // No need to call driver.get() because Hooks navigates to sourceUrl
//    }
//
//    @When("the user clicks on trains")
//    public void the_user_clicks_on_trains() {
//        homePage.clickTrainsLink();
//    }
//
//    @Then("user clicks on order food on train")
//    public void user_clicks_on_order_food_on_train() {
//        foodOrderPage.clickOrderFoodLink();
//    }
//
//    @Then("it should display on order food page")
//    public void it_should_display_on_order_food_page() {
//        foodOrderPage.verifyFoodOptionsDisplayed();
//    }
//}




































































//package com.stepDefinitionTestNG;
//
//import org.openqa.selenium.WebDriver;
//
//import com.aventstack.extentreports.ExtentTest;
//import com.pages.FoodOrderPage;
//import com.pages.HomePage;
//import com.setup.BaseSteps;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class TrainsPage extends BaseSteps {
//	WebDriver driver= BaseSteps.driver;
//	ExtentTest test = Hooks.test;
//	
//
//    HomePage homePage;
//    FoodOrderPage foodOrderPage = new FoodOrderPage(driver);
//
//
//    @Given("the user is on Ixigo home page")
//    public void the_user_is_on_ixigo_home_page() {
//        homePage = new HomePage(driver, test); // driver from BaseSteps
//        foodOrderPage = new FoodOrderPage(driver);
//        // No need to call driver.get() because Hooks navigates to sourceUrl
//    }
//
//    @When("the user clicks on trains")
//    public void the_user_clicks_on_trains() {
//        homePage.clickTrainsLink();
//    }
//
//    @Then("user clicks on order food on train")
//    public void user_clicks_on_order_food_on_train() {
//        foodOrderPage.clickOrderFoodLink();
//    }
//
//    @Then("it should display on order food page")
//    public void it_should_display_on_order_food_page() {
//        foodOrderPage.verifyFoodOptionsDisplayed();
//    }
//    
//    @Then("user navigates to train platform locator page")
//    public void user_navigates_to_train_platform_locator_page() {
//    	foodOrderPage.clickTrainLocator();
//    }
//}