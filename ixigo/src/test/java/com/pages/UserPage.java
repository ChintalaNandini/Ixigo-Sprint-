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
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.collect.Table.Cell;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;

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

	

	public static void enterInput() throws Exception
	{
		ExcelReader reader = new ExcelReader(System.getProperty("user.dir") + "/src/test/resources/ExcelData/Search_input.xlsx");
	    List<String> destinations = reader.getColumnData(0, 0); // Sheet 0, Column 0

	    WebDriver driver = BaseSteps.driver;
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    for (String destination : destinations) {
	        WebElement destinationInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.cssSelector("div.flex-1 > input[data-testid='location-input-web']")));
	        destinationInput.clear();
	        destinationInput.sendKeys(destination);

	        // Wait for suggestions to appear
	        try {
	            wait.until(ExpectedConditions.presenceOfElementLocated(
	                By.xpath("//ul[contains(@class,'suggestion-list')]")));

	            WebElement firstSuggestion = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//ul[contains(@class,'suggestion-list')]//li[1]")));

	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstSuggestion);
	        } catch (TimeoutException e) {
	            // Fallback: use keyboard navigation if suggestions don't appear
	            destinationInput.sendKeys(Keys.ARROW_DOWN);
	            destinationInput.sendKeys(Keys.ENTER);
	        }
	    }
	}
	public static void enterinputSearch()
	{
		WebDriver driver = BaseSteps.driver;
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("button[data-testid='search-hotels']")));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchButton);


	}






	//===============================================================
	
	public static void searcchhotelss() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for modal to disappear
		By modalLocator = By.xpath("//div[@data-testid='bpg-home-modal']");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(modalLocator));

		// Now click the Search Hotels button
		WebElement searchHotelsBtn = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@data-testid='search-hotels']//div[@class='flex items-center gap-5 font-medium']")));
		searchHotelsBtn.click();


	}

	public static boolean clickcheckbox1()
		{
			boolean actResult = true;
			try
			{
				WebElement firstcheck = wait.until(ExpectedConditions.elementToBeClickable(
			            By.xpath("//button[@data-testid='search-hotels']//div[@class='flex items-center gap-5 font-medium']")));

			}
			catch (TimeoutException te)
			{
				actResult = false;
				//Reports.generateReport(driver, test, Status.FAIL, "Check box is not found");
			}
			return actResult;


		}
}



//	private static By name=By.xpath("//div[@role='listitem']//input[@type='checkbox' and @value='MP_FC']");
//	public boolean clickcheckbox1() {
//		try {
//			//By name=By.xpath("//button[@data-testid='search-hotels']//div[@class='flex items-center gap-5 font-medium']");
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//			WebElement checkbox1 = wait.until(ExpectedConditions.elementToBeClickable(name));
////			checkbox1.click();
//
//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox1);
//			((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox1);
//			checkbox1.click();
//
//			//            // Use your locator variable
//			//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox1);
//			//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox1);
//			//            
//			            return true;
//		} catch (Exception e) {
//			System.out.println("Failed to click checkbox1: " + e.getMessage());
//
//		}
//		return false;
//	}
//
//	private static By modalLocator = By.xpath("//input[@type='radio' and @value='UR_7.0']");
//	public static boolean clickcheckbox2() {
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//
//			// Step 1: Wait for modal to disappear
//
//			wait.until(ExpectedConditions.invisibilityOfElementLocated(modalLocator));
//			driver.findElement(modalLocator).click();
//			//            // Step 2: Define locator
//			//            By locator = By.xpath("//input[@type='radio' and @value='UR_7.0']");
//			//
//			//            // Step 3: Wait for presence
//			//            WebElement radio = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//			//
//			//            // Step 4: Scroll into view
//			//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radio);
//			//
//			//            // Step 5: Wait for clickability
//			//            wait.until(ExpectedConditions.elementToBeClickable(radio));
//			//
//			//            // Step 6: Click if not selected
//			//            if (!radio.isSelected()) {
//			//                radio.click();
//			//            }
//			//
//			//            return true;
//			//
//		} catch (Exception e) {
//			System.err.println("Failed to click checkbox2: " + e.getMessage());
//
//		}
//		return false;
//	}
//}
//}
//   









