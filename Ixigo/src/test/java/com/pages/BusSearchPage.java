package com.pages;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.parameters.PropertyReader;

public class BusSearchPage {
	WebDriver driver;
	WebDriverWait wait;

	String fromStation;
	String toStation;
	String busType;
	
	public BusSearchPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Track Ticket")
    WebElement trackTicketLink;
	
	 public void clickOnTrackTicket() {
	        trackTicketLink.click();
	    }
	 
	 

	@FindBy(xpath = "//input[@placeholder='From Station']")
	WebElement fromStationInput;

	@FindBy(xpath = "//input[@placeholder='To Station']")
	WebElement toStationInput;

	@FindBy(xpath = "//button[text()='Search']")
	WebElement searchButton;

	

	public void enterFromStation() {
		Properties prop = PropertyReader.readProperty();
		String fromStation = prop.getProperty("FromStation1");

		wait.until(ExpectedConditions.elementToBeClickable(fromStationInput));
		fromStationInput.click();
		fromStationInput.clear();
		fromStationInput.sendKeys(fromStation);

		// Select first suggestion fromStation dropdown
		WebElement firstSuggestion = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Bangalore']")));
		firstSuggestion.click();
	}

	public void enterToStation() {
		Properties prop = PropertyReader.readProperty();
		String toStation = prop.getProperty("ToStation1");

		wait.until(ExpectedConditions.elementToBeClickable(toStationInput));
		toStationInput.click();
		toStationInput.clear();
		toStationInput.sendKeys(toStation);

		// Select first suggestion toStation dropdown
		WebElement firstSuggestion = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Hyderabad']")));
		firstSuggestion.click();
	}

	public void clickSearchButton() {
		wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
	}

//=============== 4th  scenario
	@FindBy(xpath = "//div[text()='Chennai']")
	WebElement fstation;
	@FindBy(xpath = "//div[text()='Vijayawada']")
	WebElement tstation;
	@FindBy(xpath = "//div[text()='Mumbai']")
	WebElement fstation1;
	@FindBy(xpath = "//div[text()='Pune']")
	WebElement tstation1;

//	  // ✅ Enter From Station and select from dropdown
//	    public void enterFromStation(String fromStation) {
//	        wait.until(ExpectedConditions.elementToBeClickable(fromStationInput));
//	        fromStationInput.click();
//	        fromStationInput.clear();
//	        fromStationInput.sendKeys(fromStation);
//
//	        // Wait for dropdown suggestions
//	        List<WebElement> suggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
//	            By.xpath("//div[text()='Chennai']")));
//
//	        boolean clicked = false;
//	        for (WebElement suggestion : suggestions) {
//	            String suggestionText = suggestion.getText().toLowerCase();
//	            if (suggestionText.contains(fromStation.toLowerCase())) {
//	                new Actions(driver).moveToElement(suggestion).click().perform(); // Reliable click
//	                clicked = true;
//	                break;
//	            }
//	        }
//	        if (!clicked) {
//	            throw new RuntimeException("No matching suggestion found for: " + fromStation);
//	        }
//	    }
//
//	    // ✅ Enter To Station and select from dropdown
//	    public void enterToStation(String toStation) {
//	        wait.until(ExpectedConditions.elementToBeClickable(toStationInput));
//	        toStationInput.click();
//	        toStationInput.clear();
//	        toStationInput.sendKeys(toStation);
//
//	        List<WebElement> suggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
//	            By.xpath("//div[text()='Vijayawada']")));
//
//	        boolean clicked = false;
//	        for (WebElement suggestion : suggestions) {
//	            String suggestionText = suggestion.getText().toLowerCase();
//	            if (suggestionText.contains(toStation.toLowerCase())) {
//	                new Actions(driver).moveToElement(suggestion).click().perform();
//	                clicked = true;
//	                break;
//	            }
//	        }
//	        if (!clicked) {
//	            throw new RuntimeException("No matching suggestion found for: " + toStation);
//	        }
//	    }
//
//	    public void clickSearchButton1() {
//	        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
//	        searchButton.click();
//	    }
//	    

	// 2nd input===================

	// ✅ Enter From Station dynamically
	public void enterFromStation(String fromStation) {
		wait.until(ExpectedConditions.elementToBeClickable(fromStationInput));
		fromStationInput.click();
		fromStationInput.clear();
		fromStationInput.sendKeys(fromStation);

		String dynamicXpath = String.format("//div[contains(text(),'%s')]", fromStation);
		WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXpath)));
		suggestion.click();
	}

	// ✅ Enter To Station dynamically
	public void enterToStation(String toStation) {
		wait.until(ExpectedConditions.elementToBeClickable(toStationInput));
		toStationInput.click();
		toStationInput.clear();
		toStationInput.sendKeys(toStation);

		String dynamicXpath = String.format("//div[contains(text(),'%s')]", toStation);
		WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXpath)));
		suggestion.click();
	}

	// ✅ Click Search Button
	public void clickSearchButton1() {
		wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
	}

	// 5th scenario=======
	@FindBy(xpath = "//span[text()='AC']")
	WebElement acFilter;

	@FindBy(xpath = "//label[contains(text(),'Non AC')]")
	WebElement nonAcFilter;

	// @FindBy(xpath = "//label[contains(text(),'Sleeper')]")
	WebElement sleeperFilter;

//	 public void enterFromStation1(String fromStation) {
//	        wait.until(ExpectedConditions.elementToBeClickable(fromStationInput));
//	        fromStationInput.click();
//	        fromStationInput.clear();
//	        fromStationInput.sendKeys(fromStation);
//
//	        String dynamicXpath = String.format("//div[contains(text(),'%s')]", fromStation);
//	        WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXpath)));
//	        suggestion.click();
//	    }
//
//	    // ✅ Enter To Station dynamically
//	    public void enterToStation1(String toStation) {
//	        wait.until(ExpectedConditions.elementToBeClickable(toStationInput));
//	        toStationInput.click();
//	        toStationInput.clear();
//	        toStationInput.sendKeys(toStation);
//
//	        String dynamicXpath = String.format("//div[contains(text(),'%s')]", toStation);
//	        WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXpath)));
//	        suggestion.click();
//	        }

	/*
	 * Select Bus Type filter dynamically
	 * 
	 * @param busType - AC, Non AC, Sleeper
	 */
	public void selectBusTypeFilter(String busType) {
		String dynamicXpath = String.format("//label[contains(text(),'%s')]", busType);
		WebElement filterOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='AC']")));
		filterOption.click();
	}

	/*
	 * Verify bus list updated after filter (You can enhance this by checking bus
	 * cards contain the busType text)
	 */
	public boolean isBusListUpdated(String busType) {
		List<WebElement> busCards = driver.findElements(By.xpath("//div[contains(@class,'bus-card')]"));
		for (WebElement card : busCards) {
			if (!card.getText().toLowerCase().contains(busType.toLowerCase())) {
				return false; // Found a mismatch
			}
		}
		return true; // All match
	}
}



















//@FindBy(xpath = "//*[@id=\"search-from\"]/div/div/div/div/div[2]/input")
//WebElement fromStationInput;
//
//@FindBy(xpath = "//*[@id=\"search-to\"]/div/div/div/div/div[2]/input")
//WebElement toStationInput;
//
//@FindBy(xpath = "//*[@id=\"search-button\"]/button")
//WebElement searchButton;

//    public void selectFromStation(String stationName) {
//        fromStationInput.click();
//        WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(
//            By.xpath("//div[contains(text(),'" + stationName + "')]")));
//        suggestion.click();
//    }
//
//    public void selectToStation(String stationName) {
//        toStationInput.click();
//        WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(
//            By.xpath("//div[contains(text(),'" + stationName + "')]")));
//        suggestion.click();
//    }
//
//    public void clickSearchButton() {
//        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
//        searchButton.click();
//    }
//    }

//fromStationInput.clear();
//fromStationInput.sendKeys(fromstation);
//this.driver = driver;
//toStationInput.clear();
//toStationInput.sendKeys(tostation);
