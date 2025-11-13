package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.parameters.PropertyReader;
import java.time.Duration;
import java.util.Properties;

public class BusSearchPage {
	WebDriver driver;
	WebDriverWait wait;

//    @FindBy(xpath = "//*[@id=\"search-from\"]/div/div/div/div/div[2]/input")
//    WebElement fromStationInput;
//
//    @FindBy(xpath = "//*[@id=\"search-to\"]/div/div/div/div/div[2]/input")
//    WebElement toStationInput;
//
//    @FindBy(xpath = "//*[@id=\"search-button\"]/button")
//    WebElement searchButton;

	@FindBy(xpath = "//input[@placeholder='From Station']")
	WebElement fromStationInput;

	@FindBy(xpath = "//input[@placeholder='To Station']")
	WebElement toStationInput;

	@FindBy(xpath = "//button[text()='Search']")
	WebElement searchButton;

	public BusSearchPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

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
		WebElement firstSuggestion = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[text()='Hyderabad']")));
		firstSuggestion.click();
	}

	public void clickSearchButton() {
		wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
	}
}

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
