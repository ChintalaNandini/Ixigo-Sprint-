package com.pages;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.IDynamicGraph.Status;

import com.google.common.collect.Table.Cell;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;
import com.setup.Reports;

import net.masterthought.cucumber.json.Row;


public class UserPage extends BaseSteps {
	private static WebDriver driver;
	private static WebDriverWait wait;
	private ExcelReader excelReader;

	public UserPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
	}
	


	//first scenario

	@FindBy(css = "button[data-testid=\"search-hotels\"] > div.flex.items-center.gap-5.font-medium")
	private WebElement searchButton;

	public void clickSearch() {
		searchButton.click();
	}

	//second

	public boolean clickView()
	{
		try
		{
			Thread.sleep(2000);
			By clickhotel = By.xpath("//button//div[contains(@class,\"relative\") and contains(@class,\"h-[160px]\")]");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(clickhotel)).click();
			String originalWindow = driver.getWindowHandle();
			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			// Wait for URL to change
			wait.until(ExpectedConditions.urlContains("localities"));

			return true;
		} catch (Exception e) {
			System.out.println("Error clicking property type: " + e.getMessage());
			return false;
		}
	}




	//third

	@FindBy(css = "div.overflow-hidden > img.object-cover")
	private WebElement offersbtn;

	@FindBy(css = "div.sticky.bottom-0 button.inline-flex.justify-center.items-center.bg-brand-solid")
	private WebElement searchbtn;



	public void clickoffers() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Wait for the first hotel card link to be clickable
		WebElement viewButton = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//img[@class=\"object-cover\" and @alt=\"WELCOME WEB\"]")
				));

		// Click the hotel card link (this opens a new tab)
		viewButton.click();
	}

	public void clicksearchhotels() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Wait for the first hotel card link to be clickable
		WebElement viewButton = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[contains(@class,\"sticky\") and contains(@class,\"bottom-0\")]//button[contains(@class,\"bg-brand-solid\")]")
				));

		// Click the hotel card link (this opens a new tab)
		viewButton.click();

	}
	public void clickhotelssearch() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Wait for the first hotel card link to be clickable
		WebElement viewButton = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@data-testid=\"search-hotels\"]")
				));

		// Click the hotel card link (this opens a new tab)
		viewButton.click();

	}

	//fourth
	//======================================================
	private static By secondcheck = By.xpath("//input[@type='checkbox' and @value='MP_CF' and @name='sort']");

	public static boolean clickcheckbox2() {
	    try {
	        WebElement second = wait.until(ExpectedConditions.elementToBeClickable(secondcheck));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", second);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", second);

	        WebDriverWait dynamicWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        boolean stateChanged = dynamicWait.until(driver -> {
	            String ariaChecked = second.getAttribute("aria-checked");
	            String classAttr = second.getAttribute("class");
	            return second.isSelected() || "true".equalsIgnoreCase(ariaChecked) || (classAttr != null && classAttr.contains("checked"));
	        });

	        return stateChanged;
	    } catch (TimeoutException te) {
	        return false;
	    }
	}

	
//==================================================
	//=================fifth===========================
	
	public boolean clickAndEnterHotelDestination(String destination) {
	    boolean actResult = true;
	    try {
	        By hotelInputLocator = By.xpath("//input[@placeholder='Enter city, area or property name']");
	        WebElement hotelInput = wait.until(ExpectedConditions.elementToBeClickable(hotelInputLocator));
	        hotelInput.click();
	        System.out.println("clicked");
	        Thread.sleep(2000); // Optional: allow UI to stabilize
	        hotelInput.clear();
	        hotelInput.sendKeys(destination);
	        Thread.sleep(3000); // Allow suggestions to load

	        //Reports.generateReport(driver, test, Status.PASS, "Entered hotel destination: " + destination);
	    } catch (Exception e) {
	        actResult = false;
	        //Reports.generateReport(driver, test, Status.FAIL, "Failed to enter hotel destination: " + e.getMessage());
	    }
	    return actResult;
	}

	public boolean selectFirstHotelSuggestion() {
	    boolean actResult = true;
	    try {
	      	
	        //By suggestionLocator = By.xpath("//div[@data-testid='Chennai']");
	        By suggestionLocator = By.xpath("//div[@data-testid='Bengaluru']//div[contains(@class,'item-center')]");
	        WebElement firstSuggestion = wait.until(ExpectedConditions.elementToBeClickable(suggestionLocator));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstSuggestion);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstSuggestion);
	        firstSuggestion.click();
	        //driver.findElement(click);
	        //Reports.generateReport(driver, test, Status.PASS, "Selected first hotel suggestion from dropdown.");
	    } catch (Exception e) {
	        actResult = false;
	        //Reports.generateReport(driver, test, Status.FAIL, "Failed to select hotel suggestion: " + e.getMessage());
	    }
	    return actResult;
	}
	
	public static void searchdestination()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Wait for the first hotel card link to be clickable
		WebElement viewButton2 = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@data-testid='search-hotels']")
				));

		// Click the hotel card link (this opens a new tab)
		viewButton2.click();
	}

	
}
	

//===============================================
	
	






