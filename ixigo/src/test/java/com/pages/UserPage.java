package com.pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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



	public void clickView() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    // Wait for the first hotel card link to be clickable
	    WebElement viewButton = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("(//div[contains(@class,'shrink-0') and contains(@class,'rounded-xl') and contains(@class,'h-[258px]')]//a)[1]")
	    ));

	    // Click the hotel card link (this opens a new tab)
	    viewButton.click();

	    // Switch to the newly opened tab
	    BrowserUtils.switchToNewTab(driver);
	}
	


/*	


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

	@FindBy(css = "input[placeholder=\"Rooms & Guests\"]")
	private WebElement roomGuestInput;


	public void enterCheckInDate(String date) {
		checkInInput.sendKeys(date);
	}

	public void enterCheckOutDate(String date) {
		checkOutInput.sendKeys(date);
	}



	public void enterRoomGuestDetails(String rooms, String guests) {
		roomGuestInput.click();

	}

	@FindBy(css = "button.SearchForm_animated_btn__WTjFh > div.flex.items-center.gap-5.font-medium")
	private WebElement searchButton1;
	


*/




}


