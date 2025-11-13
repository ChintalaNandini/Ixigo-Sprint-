package com.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.parameters.PropertyReader;

public class HomePage {
	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest test;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//p[contains(text(),'Trains')])[2]")
	private WebElement trainslink;

	@FindBy(xpath = "//a[contains(text(),'Order Food')]")
	private WebElement orderFoodLink;

	@FindBy(xpath = "//h1[contains(text(),'Order Food')]")
	private WebElement foodOptionsHeader;

	@FindBy(xpath="//h2[text()='Explore More With ixigo']")
	private WebElement text;

	@FindBy(xpath = "(//div[@class='body-md text-primary items-center'])[6]")
	private WebElement trainPlatform;

	@FindBy(xpath="//h1[text()='Platform Locator']")
	private WebElement platformLocator;

	// 4th Scenario starts from here
	
	@FindBy(xpath = "//input[@id='pnr-input' and @name='pnr' and @type='text']")
	private WebElement pnrInputField;

//	@FindBy(xpath = "//button[text()='Order Now']")
	//@FindBy(xpath="/html/body/div[1]/div[4]/main/div[1]/section[1]/div[2]/form/button")
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchButton;

	@FindBy(xpath = "//img[@class='h-100 w-100 object-cover' and @alt='error' and @src='https://cdn.confirmtkt.com/img/native_food_order/ic_err_pnr_unavailable.svg']")
	private WebElement popupErrorImage;

	@FindBy(xpath = "//button[contains(@class,'inline-flex') and normalize-space(text())='Okay']")
	private WebElement okayButton;

//	@FindBy(xpath = "//input[@id='pnr-input' and @name='pnr' and @type='text']")
//	private WebElement pnrInputField;
//
//	@FindBy(xpath = "//button[@type='submit' and contains(@class,'_search-cta_qsmjh_8') and text()='Search']")
//	private WebElement searchButton;
//
//	@FindBy(xpath = "//img[@class='h-100 w-100 object-cover' and @alt='error' and @src='https://cdn.confirmtkt.com/img/native_food_order/ic_err_pnr_unavailable.svg']")
//	private WebElement popupErrorImage;
//
//	@FindBy(xpath = "//button[contains(@class,'inline-flex') and normalize-space(text())='Okay']")
//	private WebElement okayButton;





	//
	//	@FindBy(xpath="(//div[@class='body-md text-primary items-center'])[3]")
	//	private WebElement checkSeatAvailabilityBtn;
	//
	//	@FindBy(xpath="//label[text()='From']/following-sibling::input")
	//	private WebElement fromStationInput;
	//
	//	@FindBy(xpath="//label[text()='To']/following-sibling::input")
	//	private WebElement toStationInput;
	//
	//	@FindBy(xpath="/html/body/div[1]/div[4]/div[2]/div[2]/div[1]/button")
	//	private WebElement checkAvailabilityBtn;
	//
	//	@FindBy(xpath="//h4[@class='h4 mb-5']")
	//	private WebElement trainsAvailabilityHeader;



	public HomePage(WebDriver driver , ExtentTest test) {

		this.driver = driver;
		this.test =test;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	public void clickTrainsLink() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(trainslink))
		.click();
	}

	public void clickOrderFoodLink() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(orderFoodLink))
		.click();
	}

	public void verifyFoodOptionsDisplayed() {
		boolean isDisplayed = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(foodOptionsHeader))
				.isDisplayed();
		if (!isDisplayed) {
			throw new AssertionError("Order Food page not displayed!");
		}
	}

	public void exploreMore() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(text))
		.click();
	}
	public void clickPlatformLocator() {

		Properties props = PropertyReader.readProperty();
		String trainPlatformXpath = props.getProperty("trainPlatform.link.xpath");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(trainPlatformXpath)));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", trainPlatform);
		wait.until(ExpectedConditions.elementToBeClickable(trainPlatform)).click();


		//    	   //wait.until(ExpectedConditions.visibilityOf(trainPlatform));
		//           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//    	   //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", trainPlatform);
		//           ((JavascriptExecutor) driver).executeScript("arguments[0].click();", trainPlatform);
		//           wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(trainPlatform)));
		//           //wait.until(ExpectedConditions.elementToBeClickable(platformLocator)).click();
	}

	public void clickTrainPlatform() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(platformLocator));
	}

	//4th Scenario Methods starts from here
	
	Map<String, String> formData;
	public void clickPnrNum() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(pnrInputField));
		
	}
	
	public void enterTest(String[] TestName) throws IOException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", pnrInputField);
		pnrInputField.sendKeys(TestName);
		System.out.println("DEBUG: Sent to search box -> " + TestName);
		
	}
	
	public void clickSearch() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(searchButton));
	}
	
	
//	public void enterTest(String[] TestName) throws IOException   {
//		 
//		
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


//	public void enterPNRNumber(String pnr) {
//		wait.until(ExpectedConditions.visibilityOf(pnrInputField)).clear();
//		pnrInputField.sendKeys(pnr);
//	}
//
//	public void clickSearchButton() {
//		wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
//	}
//
//	public void verifyPopupDisplayed() {
//		boolean isDisplayed = wait.until(ExpectedConditions.visibilityOf(popupErrorImage)).isDisplayed();
//		if (!isDisplayed) {
//			throw new AssertionError("Popup not displayed!");
//		}
//	}
//
//	public void clickOkayButton() {
//		wait.until(ExpectedConditions.elementToBeClickable(okayButton)).click();
//	}


}
































































//3rd Scenario Methods starts from here 

//	public void clickCheckSeatAvailability() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='body-md text-primary items-center'])[3]")));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkSeatAvailabilityBtn);
//		try {
//			wait.until(ExpectedConditions.elementToBeClickable(checkSeatAvailabilityBtn)).click();
//		} catch (org.openqa.selenium.ElementClickInterceptedException e) {
//			((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkSeatAvailabilityBtn);
//		}
//	}
//
//	public void enterFromStation(String from) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.visibilityOf(fromStationInput)).sendKeys(from);
//		fromStationInput.sendKeys(Keys.ENTER);
//	}
//
//	public void enterToStation(String to) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.visibilityOf(toStationInput)).sendKeys(to);
//		toStationInput.sendKeys(Keys.ENTER);
//	}
//
//	public void clickCheckAvailability() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[4]/div[2]/div[2]/div[1]/button")));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkAvailabilityBtn);
//		try {
//			wait.until(ExpectedConditions.elementToBeClickable(checkAvailabilityBtn)).click();
//		} catch (org.openqa.selenium.ElementClickInterceptedException e) {
//			((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkAvailabilityBtn);
//		}
//	}
//
//	public void verifyTrainsAvailabilityPage() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		try {
//			WebElement header = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[@class='h4 mb-5']")));
//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", header);
//			System.out.println("Trains Availability Page displayed successfully!");
//		} catch (Exception e) {
//			throw new AssertionError("Trains Availability Page not displayed! Check XPath or page load.");
//		}
//	}
















































































//	public void clickCheckSeatAvailability() {
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='body-md text-primary items-center'])[3]")));
//	    
//	    // Scroll into view before clicking
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkSeatAvailabilityBtn);
//	    
//	    wait.until(ExpectedConditions.elementToBeClickable(checkSeatAvailabilityBtn)).click();
//	}
//	
////	public void clickCheckSeatAvailability() {
////		new WebDriverWait(driver, Duration.ofSeconds(10))
////		.until(ExpectedConditions.elementToBeClickable(checkSeatAvailabilityBtn))
////		.click();
////	}
//	
//
//public void enterFromStation(String from) {
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//    wait.until(ExpectedConditions.visibilityOf(fromStationInput)).sendKeys(from);
//    fromStationInput.sendKeys(Keys.ENTER); // Select suggestion
//}
//
//public void enterToStation(String to) {
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//    wait.until(ExpectedConditions.visibilityOf(toStationInput)).sendKeys(to);
//    toStationInput.sendKeys(Keys.ENTER); // Select suggestion
//}
//
//
////	public void enterFromStation(String from) {
////		new WebDriverWait(driver, Duration.ofSeconds(10))
////		.until(ExpectedConditions.visibilityOf(fromStationInput))
////		.sendKeys(from);
////	}
////
////	public void enterToStation(String to) {
////		new WebDriverWait(driver, Duration.ofSeconds(10))
////		.until(ExpectedConditions.visibilityOf(toStationInput))
////		.sendKeys(to);
////	}
//	
//
//public void clickCheckAvailability() {
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[4]/div[2]/div[2]/div[1]/button")));
//    
//    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkAvailabilityBtn);
//    
//    wait.until(ExpectedConditions.elementToBeClickable(checkAvailabilityBtn)).click();
//}
//
//
////	public void clickCheckAvailability() {
////		new WebDriverWait(driver, Duration.ofSeconds(10))
////		.until(ExpectedConditions.elementToBeClickable(checkAvailabilityBtn))
////		.click();
////	}
//
//	public void verifyTrainsAvailabilityPage() {
//		boolean isDisplayed = new WebDriverWait(driver, Duration.ofSeconds(10))
//				.until(ExpectedConditions.visibilityOf(trainsAvailabilityHeader))
//				.isDisplayed();
//		if (!isDisplayed) {
//			throw new AssertionError("Trains Availability Page not displayed!");
//		}
//	}
//


