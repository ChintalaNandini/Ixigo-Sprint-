package com.StepDefinitionTestNG;

import org.testng.Assert;

import com.pages.BusSearchPage;
import com.pages.OffersPage;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile extends BaseSteps {
	
	BusSearchPage busSearchPage;
	OffersPage offerspage;
	
	
	@Given("User launches Ixigo website")
	public void user_launches_ixigo_website() {
		
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("Validate Ixigo home page is displayed")
	public void validate_ixigo_home_page_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("User navigates to Offers page")
	public void user_navigates_to_offers_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("Validate Offers page is opened successfully")
	public void validate_offers_page_is_opened_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@Then("Print and validate title of the webpage")
	public void print_and_validate_title_of_the_webpage() {
	    String title = BaseSteps.driver.getTitle();
	    System.out.println("Page Title: " + title);
	    Assert.assertTrue(title.toLowerCase().contains("offers"), "Page title does not contain 'offers'");
	}
	
	//2nd scenario====================================================================================
	@Given("User launches  the Ixigo website")
	public void user_launches_the_ixigo_website() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	
	@Then("the user clicks on the Track Ticket option")
	public void the_user_clicks_on_the_track_ticket_option() {
	    // Initialize OffersPage before using it
	    offerspage = new OffersPage(driver);  // OR use PageFactory if you prefer
	    offerspage.clickOnTrackTicket();
	
	}

	@Then("the Track Ticket page should be displayed")
	public void the_track_ticket_page_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}

	@Then("the page title should be Enter Ticket Details")
	public void the_page_title_should_be_enter_ticket_details() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see input fields for Booking ID and Mobile Number")
	public void the_user_should_see_input_fields_for_booking_id_and_mobile_number() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}

	@Then("a Track Details button should be visible")
	public void a_track_details_button_should_be_visible() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("the Frequently Asked Questions section should be displayed")
	public void the_frequently_asked_questions_section_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		}


//3RD Scenario=============================================
	 BusSearchPage bussearchpage=new BusSearchPage(driver);
	

@Given("User launches the Ixigo Website")
    public void user_launches_the_ixigo_website1() {
        // Initialize page object after driver is launched
        busSearchPage = new BusSearchPage(driver);
    }

	@When("user navigates to the offers page")
public void user_navigates_to_the_offers_page() {
    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
}

    @When("user enters from station FromStation")
    public void user_enters_from_station_from_station() {
        busSearchPage.enterFromStation();
    }


@And("user enters to station ToStation")
    public void user_enters_to_station_to_station() {
//	bussearchpage.clickFromStation(); 
	busSearchPage.enterToStation();
    }

    @And("user clicks on search")
    public void user_clicks_on_search() {
        busSearchPage.clickSearchButton();
    }

//@When("user enters from station {string}")
//public void user_enters_from_station() {
//	busSearchPage = new BusSearchPage(Hooks.driver);
//	String fromStation = PropertyReader.readProperty().getProperty("FromStation");
//    busSearchPage.selectFromStation(fromStation);
//}
//
//@And("user enters to station {string}")
//public void user_enters_to_station() {
//	 String toStation = PropertyReader.readProperty().getProperty("ToStation");
//    busSearchPage.selectToStation(toStation);
//}

//@And("user clicks on search")
//public void user_clicks_on_search() {
//    busSearchPage.clickSearchButton();
//}


@Then("search results should be displayed")
    public void search_results_should_be_displayed() {
       // Assert.assertTrue(driver.getCurrentUrl().contains("search"), "Search results page not displayed!");
   // System.out.println("Search results page loaded successfully.");
    }
}

//	}
//
//   public void clickOnSearch() {
//		busSearchPage.clickSearchButton();
//	}
//	
//	@Then("search results should be displayed")
//	public void search_results_should_be_displayed() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//		
//	}
//	
//	}
//		
		
	






















//3rd scenario outline===========================================================================
	
//
//@When("user selects the default date")
//public void user_selects_the_default_date() {
//    // Write code here that turns the phrase above into concrete actions
//    //throw new io.cucumber.java.PendingException();
//
//	@Given("User launches the Ixigo website")
//	public void user_launches_the_ixigo_website1() {
//    // Write code here that turns the phrase above into concrete actions
//    //throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User navigates to the Offers page")
//	public void user_navigates_to_the_offers_page() {
//	    // Write code here that turns the phrase above into concrete actions
//	   // throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User fetches data from Excel BusData and row {int}")
//	public void user_fetches_data_from_excel_bus_data_and_row(Integer int1) {
//	    // Write code here that turns the phrase above into concrete actions
//	   // throw new io.cucumber.java.PendingException();
//	}
//
//	
//	@When("User keeps the travel date as default")
//	public void user_keeps_the_travel_date_as_default() {
//	    // Write code here that turns the phrase above into concrete actions
//	   // throw new io.cucumber.java.PendingException();
//	}
//	
//	@When("User clicks on Search")
//	public void user_clicks_on_search() {
//	    // Write code here that turns the phrase above into concrete actions
//	   // throw new io.cucumber.java.PendingException();
//	}
//	
//	@Then("The search results page should be displayed successfully")
//	public void the_search_results_page_should_be_displayed_successfully() {
//	    // Write code here that turns the phrase above into concrete actions
//	   // throw new io.cucumber.java.PendingException();
//	}
//	}
//	
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//@Given("the user launches the webbrowser")
//public void the_user_launches_the_webbrowser() {
//    // Write code here that turns the phrase above into concrete actions
//    //throw new io.cucumber.java.PendingException();
//}
//
//@When("the user navigates to the Bus Offers page")
//public void the_user_navigates_to_the_bus_offers_page() {
//    // Write code here that turns the phrase above into concrete actions
//   // throw new io.cucumber.java.PendingException();
//}
//
//@When("then navigates to the Buses search page")
//public void then_navigates_to_the_buses_search_page() {
//
//boolean isDisplayed = driver.findElements(By.xpath("//div[contains(text(),'Search Results')]")).size() > 0;
//    assert isDisplayed : "Search results page not displayed!";
//}
//
//
//
//
//    // Write code here that turns the phrase above into concrete actions
//    //throw new io.cucumber.java.PendingException();
//
//@When("enters {string} as From Station and {string} as To Station")
//public void enters_as_from_station_and_as_to_station(String string, String string2) {
//    // Write code here that turns the phrase above into concrete actions
//    //throw new io.cucumber.java.PendingException();
//	
//
//}
//
//
//
//
////@When("enters {string} as From Station and {string} as To Station")
////public void enterStations(String fromStation, String toStation) {
//
//
//
//
//
//
//@When("keeps the travel date as default")
//public void keeps_the_travel_date_as_default() {
//    // Write code here that turns the phrase above into concrete actions
//   // throw new io.cucumber.java.PendingException();
//}
//
//@When("clicks on Search")
//public void clicks_on_search() {
//
//if (busSearchPage == null) {
//        busSearchPage = new BusSearchPage(driver);
//    }
//    busSearchPage.clickSearch();
//}
//
//    // Write code here that turns the phrase above into concrete actions
//   // throw new io.cucumber.java.PendingException();
//
//
//
//@Then("the search results page should be displayed successfully")
//public void the_search_results_page_should_be_displayed_successfully() {
//    // Write code here that turns the phrase above into concrete actions
//   // throw new io.cucumber.java.PendingException();
//
//boolean isDisplayed = driver.getCurrentUrl().contains("search");
//        assert isDisplayed : "Search results page not displayed!";
//    }
//
//
//}








//	@Given("the user launches the browser")
//	public void the_user_launches_the_browser() {
//	    // Write code here that turns the phrase above into concrete actions
//	   // throw new io.cucumber.java.PendingException();
//	}
//
//	@When("the user navigates to the Bus Offers page")
//	public void the_user_navigates_to_the_bus_offers_page() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//	}
//
//	@When("then navigates to the Buses search page")
//	public void then_navigates_to_the_buses_search_page() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//	}
//
//	@When("enters FromStation as From Station and ToStation as To Station")
//	public void enters_from_station_as_from_station_and_to_station_as_to_station() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//	}	
//	@When("keeps the travel date as default")
//	public void keeps_the_travel_date_as_default() {
//	    // Write code here that turns the phrase above into concrete actions
//	   // throw new io.cucumber.java.PendingException();
//	}
//
//	@When("clicks on Search")
//	public void clicks_on_search() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("the search results page should be displayed successfully")
//	public void the_search_results_page_should_be_displayed_successfully() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//	}
//
//
//
//}
//
//







































//	public void navigates_to_ixigo() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("the user enters phone number and waits for OTP")
//	public void the_user_enters_phone_number_and_waits_for_otp() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//	}
//
//
//}
//	/*@Given("User is on the Ixigo homepage")
//	public void user_is_on_the_ixigo_homepage() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User clicks on the Login\\/signup icon")
//	public void user_clicks_on_the_login_signup_icon() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User enters the phone number")
//	public void user_enters_the_phone_number() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//	}
//
//	@When("User waits for OTP and click on continue")
//	public void user_waits_for_otp_and_click_on_continue() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("User should be logged in successfully")
//	public void user_should_be_logged_in_successfully() {
//	    // Write code here that turns the phrase above into concrete actions
//	   // throw new io.cucumber.java.PendingException();
//	}
//
//
//}
//	
//	/*@Given("the browser opens the bus search results page")
//	public void the_browser_opens_the_bus_search_results_page() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//		BaseSteps.launchBrowser(); // Launches browser and navigates to https://bus.ixigo.com/
//
//	}
//
//	@When("the login popup appears")
//	public void the_login_popup_appears() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("the user should close the login popup or perform login action")
//	public void the_user_should_close_the_login_popup_or_perform_login_action() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//	}
//
//	///
//	@Given("the user is on the ixigo search page")
//	public void the_user_is_on_the_ixigo_search_page() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//	}
//
//	@When("the user enters valid source and destination")
//	public void the_user_enters_valid_source_and_destination() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//	}
//
//	@When("selects a valid travel date")
//	public void selects_a_valid_travel_date() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//	}
//
//	@When("click on Search")
//	public void click_on_search() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("the system should display a list of available buses.")
//	public void the_system_should_display_a_list_of_available_buses() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//	}
//
//
//
//}*/
