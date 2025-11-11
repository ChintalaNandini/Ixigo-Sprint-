package com.pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.setup.BaseSteps;

public class UserPage extends BaseSteps {
	private WebDriver driver;
	private WebDriverWait wait;

	public UserPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
	}


	@FindBy(css = "button[data-testid=\"search-hotels\"] > div.flex.items-center.gap-5.font-medium")
	private WebElement searchButton;
	
	public void clickSearch() {
		searchButton.click();
	}




	//private By availabilityCheckInDate = By.xpath("//div[@data-placeholder='Check-in']");
	//private By availabilityCheckOutDate = By.xpath("//div[@data-placeholder='Check-out']");




	public void enterDestination(String destination) {
		WebElement destinationInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("div.flex-1 > input[data-testid='location-input-web']")));
		destinationInput.clear();
		destinationInput.sendKeys(destination);

		// Handle suggestion
		WebElement firstSuggestion = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//ul[contains(@class,'suggestion-list')]/li[1]")));
		firstSuggestion.click();
	}



	    @FindBy(css = "input[data-testid='checkin-input']")
	    private WebElement checkInInput;

	    @FindBy(css = "input[data-testid='checkout-input']")
	    private WebElement checkOutInput;

	//    @FindBy(css = "input[placeholder=\"Rooms & Guests\"]")
	//    private WebElement roomGuestInput;

	//    public void clickHotelsTab() {
	//        hotelsTab.click();
	//    }

	

//	    public void enterDestination(String destination) {
//	        destinationInput.sendKeys(destination);
//	    }


	    public void enterCheckInDate(String date) {
	        checkInInput.sendKeys(date);
	    }

	    public void enterCheckOutDate(String date) {
	        checkOutInput.sendKeys(date);
	    }

	//    public void enterRoomGuestDetails(String rooms, String guests) {
	//        roomGuestInput.click();
	//        // Add logic to select rooms and guests from dropdown
	//    }

	//    public void clickSearch1() {
	//        searchButton.click();
	//    }
}