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
//	@FindBy(css = ".container .sticky .mb-20.cursor-pointer.rounded-10.bg-primary.text-center")
//	private WebElement googleM;
	@FindBy(css = ".sticky .mb-20 .body-md.py-10.text-brand")
	private WebElement googleM;
	
	

	public void clickSearch() throws InterruptedException {
		searchButton.click();
		Thread.sleep(2000);
	}
	
	public void googleMap() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Thread.sleep(2000); // Not ideal, but can help in flaky UI
		driver.findElement(By.cssSelector("p.body-md.py-10.text-brand")).click();
	}

	//second scenario
	
	@FindBy(xpath = "//button//div[contains(@class,\"relative\") and contains(@class,\"h-[160px]\")]")
	private WebElement clickhotel;
	@FindBy(xpath = "//button[contains(@class,'body-sm') and contains(@class,'text-brand')]")
	private WebElement hotelsMap;

	public boolean clickView()
	{
		try
		{
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(clickhotel)).click();
			String originalWindow = driver.getWindowHandle();
			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			return true;
		} catch (Exception e) {
			System.out.println("Error clicking property type: " + e.getMessage());
			return false;
		}
	}
	
	
	public void hotelMap() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(hotelsMap)).click();
		Thread.sleep(2000);
	}
	


	//third scenario

	@FindBy(xpath = "//img[@class=\"object-cover\" and @alt=\"WELCOME WEB\"]")
	private WebElement offersbtn;

	@FindBy(xpath = "//div[contains(@class,\"sticky\") and contains(@class,\"bottom-0\")]//button[contains(@class,\"bg-brand-solid\")]")
	private WebElement searchbtn;
	
	@FindBy(xpath = "//button[@data-testid=\"search-hotels\"]")
	private WebElement searchbtn1;


	public void clickoffers() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		wait.until(ExpectedConditions.elementToBeClickable(offersbtn)).click();
	    Thread.sleep(2000);
	}

	public void clicksearchhotels() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	
		wait.until(ExpectedConditions.elementToBeClickable(searchbtn)).click();
		Thread.sleep(2000);

	}
	public void clickhotelssearch() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.elementToBeClickable(searchbtn1)).click();
		Thread.sleep(2000);

	}
	

	//fourth
	//======================================================

	@FindBy(xpath = "//input[@placeholder='Enter city, area or property name']")
	private WebElement hotelInputLocator;
	
	public boolean clickAndEnterHotelDestination(String destination) {
	    boolean actResult = true;
	    try {
	        //By hotelInputLocator = By.xpath("//input[@placeholder='Enter city, area or property name']");
	        WebElement hotelInput = wait.until(ExpectedConditions.elementToBeClickable(hotelInputLocator));
	        hotelInput.click();
	        System.out.println("clicked");
	        Thread.sleep(2000); // Optional: allow UI to stabilize
	        hotelInput.clear();
	        hotelInput.sendKeys(destination);
	        Thread.sleep(3000); // Allow suggestions to load

	        
	    } catch (Exception e) {
	        actResult = false;
	    }
	    return actResult;
	}
	

	@FindBy(xpath = "//div[@data-testid='Bengaluru']//div[contains(@class,'item-center')]")
	private WebElement suggestionLocator;
	
	public boolean selectFirstHotelSuggestion() {
	    boolean actResult = true;
	    try {
	   
	        WebElement firstSuggestion = wait.until(ExpectedConditions.elementToBeClickable(suggestionLocator));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstSuggestion);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstSuggestion);
	        firstSuggestion.click();
	       
	    } catch (Exception e) {
	        actResult = false;
	        
	    }
	    return actResult;
	}
	
	
	@FindBy(xpath = "//button[@data-testid='search-hotels']")
	private WebElement viewButton2;
	
	public void searchdestination() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Wait for the first hotel card link to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(viewButton2)).click();
		Thread.sleep(2000);

	}
	


//===============================================
	@FindBy(css = ".body-sm.text-xl.text-primary")
	private WebElement hotels;
	@FindBy(xpath = "//button//div[contains(@class,\"relative\") and contains(@class,\"h-[160px]\")]")
	private WebElement clickhotel1;
	@FindBy(xpath = "//div[@class=\"login-form\"]//input[@placeholder=\"Enter Mobile Number\"]")
	private WebElement numberInputLocator;
	@FindBy(xpath = "//div[@class=\"login-form\"]/button[contains(@class,\"bg-brand-solid\")]")
	private WebElement continuebtn;
	
	public void hotels()
	{
		hotels.click();
	}
	
	public boolean clickViewhotel()
	{
		try
		{
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			wait.until(ExpectedConditions.elementToBeClickable(clickhotel1)).click();
			String originalWindow = driver.getWindowHandle();
			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}
			//URL to change
			wait.until(ExpectedConditions.urlContains("localities"));
			
			return true;
		} catch (Exception e) {
			System.out.println("Error clicking property type: " + e.getMessage());
			return false;
		}
	}
	
	
	public void clickReserveRoom() throws InterruptedException 
	{
		By reserveButtonLocator = By.xpath("//div[contains(@class,'dropdownWrapper')]//button[contains(@class,'inline-flex') and contains(@class,'text-brand') and contains(@class,'button-md')]");
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement reserveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(reserveButtonLocator));
	    // Scroll into view using JavaScript
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", reserveButton);
	    wait.until(ExpectedConditions.elementToBeClickable(reserveButton)).click();
	}
	

	public boolean clickAndentermobilenumber(String number) 
	{
	    boolean actResult = true;
	    try {
	      	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        WebElement numberInput = wait.until(ExpectedConditions.elementToBeClickable(numberInputLocator));
	        numberInput.click();
	        Thread.sleep(4000);
	        numberInput.sendKeys(number);
	    } catch (Exception e) {
	        actResult = false;
	    }
	    return actResult;
	}
	
	
	public void clickLogincontinue() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		// Wait for the button link to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(continuebtn)).click();
		Thread.sleep(4000);
	}
}
	






