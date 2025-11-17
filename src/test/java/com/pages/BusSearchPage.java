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

import com.StepDefinitionTestNG.Hooks;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;
import com.setup.Reports;

public class BusSearchPage extends BaseSteps {

	private static ExtentTest test;
	//private static WebDriverWait wait;

	WebDriver driver;

	WebDriverWait wait;

	String fromStation;
	String toStation;
	String busType;

	public BusSearchPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test=test; 
		
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	// 2nd
	// scenario=====================================================================

	@FindBy(linkText = "Track Ticket")
	WebElement trackTicketLink;

	public void clickOnTrackTicket() {
		trackTicketLink.click();
		try {
			Reports.generateReport(driver, test, Status.PASS, "Track Ticket clicked");
	
		} catch (Exception e) {
	        Reports.generateReport(Hooks.driver, Hooks.test, Status.FAIL, "Track ticket verification failed");
	        throw e;
	    }
	}
	


	// 3rd
	// scenario====================================================================

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
		Reports.generateReport(driver, test, Status.PASS, "From Station entered");
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
		//Reports.generateReport(driver, test, Status.PASS, "To Station entered");
	}

	public void clickSearchButton() {
		wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
		//Reports.generateReport(driver, test, Status.PASS, "Search button clicked");
		
		
	}

// 4th  scenario ====================================================
	@FindBy(xpath = "//div[text()='Chennai']")
	WebElement fstation;
	@FindBy(xpath = "//div[text()='Vijayawada']")
	WebElement tstation;
	@FindBy(xpath = "//div[text()='Mumbai']")
	WebElement fstation1;
	@FindBy(xpath = "//div[text()='Pune']")
	WebElement tstation1;

	// ✅ Enter From Station dynamically
	public void enterFromStation(String fromStation) {
		wait.until(ExpectedConditions.elementToBeClickable(fromStationInput));
		fromStationInput.click();
		fromStationInput.clear();
		fromStationInput.sendKeys(fromStation);

		String dynamicXpath = String.format("//div[contains(text(),'%s')]", fromStation);
		WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXpath)));
		suggestion.click();
		//Reports.generateReport(driver, test, Status.PASS, "From Station entered");
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
		Reports.generateReport(driver, test, Status.PASS, "To Station entered ");
		//Reports.generateReport(driver, test, Status.PASS, "Buy tab is clicked");
	}

	// ✅ Click Search Button
	public void clickSearchButton1() {
		wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
		//Reports.generateReport(driver, test, Status.PASS, "Search button is clicked");
	}

	public boolean isBusDetailsPagedispayed() {
		//Reports.generateReport(driver, test, Status.PASS, "Detaila Page is Dispalyed");
		return false;
//
	}

	// 5th scenario===============================================
	@FindBy(xpath = "//span[text()='AC']")
	WebElement acFilter;

	@FindBy(xpath = "//label[contains(text(),'Non AC')]")
	WebElement nonAcFilter;

	// @FindBy(xpath = "//label[contains(text(),'Sleeper')]")
	WebElement sleeperFilter;

	/*
	 * Select Bus Type filter dynamically
	 * 
	 * @param busType - AC, Non AC, Sleeper
	 */
	public void selectBusTypeFilter(String busType) {
		String dynamicXpath = String.format("//label[contains(text(),'%s')]", busType);
		WebElement filterOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='AC']")));
		filterOption.click();

		//Reports.generateReport(driver, test, Status.PASS, "Bus type filter applied: " + busType);
}

	

	/*
	 * Verify bus list updated after filter (You can enhance this by checking bus
	 * cards contain the busType text)
	 */
	public boolean isBusListUpdated(String busType) {
		List<WebElement> busCards = driver.findElements(By.xpath("//div[contains(@class,'bus-card')]"));
		for (WebElement card : busCards) {
			if (!card.getText().toLowerCase().contains(busType.toLowerCase())) {
				//Reports.generateReport(driver, test, Status.PASS, "Bus list is updated ");
				return false; // Found a mismatch
			}
		}
		return true; // All match
	}

	// 6th scenario==============
	public void enterFromStation1() {
		Properties prop = PropertyReader.readProperty();
		String fromStation = prop.getProperty("FromStation2");

		wait.until(ExpectedConditions.elementToBeClickable(fromStationInput));
		fromStationInput.click();
		fromStationInput.clear();
		fromStationInput.sendKeys(fromStation);

		// Select first suggestion fromStation dropdown
		WebElement firstSuggestion = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Jammu']")));
		firstSuggestion.click();
		//Reports.generateReport(driver, test, Status.PASS, "From Station entered ");
	}

	public void enterToStation1() {
		Properties prop = PropertyReader.readProperty();
		String toStation = prop.getProperty("ToStation2");

		wait.until(ExpectedConditions.elementToBeClickable(toStationInput));
		toStationInput.click();
		toStationInput.clear();
		toStationInput.sendKeys(toStation);

		// Select first suggestion toStation dropdown
		WebElement firstSuggestion = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Ernakulam']")));
		firstSuggestion.click();
		//Reports.generateReport(driver, test, Status.PASS, "To Station entered ");
	}

	public void clickSearchButton2() {
		wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
		//Reports.generateReport(driver, test, Status.PASS, "Search button clicked");
	}

	public void isDisplayed() {
		//Reports.generateReport(driver, test, Status.PASS, "Page is Displayed");

	}

}
































//private static By display=By.xpath("//*[@id=\\\"not-found-container\\\"]/div/h5 | //*[@id=\"root\"]/div/div");

//WebElement display=wait.until(ExpectedConditions.visibilityOfElementLocated("//*[@id=\"not-found-container\"]/div/h5"));
	 //WebElement displaytext=wait.until(ExpectedConditions.elementToBeClickable(display));
		//displaytext.isDisplayed();

//WebElement display=wait.until(ExpectedConditions.visibilityOfElementLocated("//*[@id=\"not-found-container\"]/div/h5"));
	 //WebElement displaytext=wait.until(ExpectedConditions.elementToBeClickable(display));
		//displaytext.isDisplayed();
//private static By display=By.xpath("//*[@id=\\\"not-found-container\\\"]/div/h5 | //*[@id=\"root\"]/div/div");
//5 th one extra==============
//public void enterFromStation1(String fromStation) {
//wait.until(ExpectedConditions.elementToBeClickable(fromStationInput));
//fromStationInput.click();
//fromStationInput.clear();
//fromStationInput.sendKeys(fromStation);
//
//String dynamicXpath = String.format("//div[contains(text(),'%s')]", fromStation);
//WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXpath)));
//suggestion.click();
//}
//
//// ✅ Enter To Station dynamically
//public void enterToStation1(String toStation) {
//wait.until(ExpectedConditions.elementToBeClickable(toStationInput));
//toStationInput.click();
//toStationInput.clear();
//toStationInput.sendKeys(toStation);
//
//String dynamicXpath = String.format("//div[contains(text(),'%s')]", toStation);
//WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXpath)));
//suggestion.click();
//}

//4th one extra=========================

//// ✅ Enter From Station and select from dropdown
//public void enterFromStation(String fromStation) {
//    wait.until(ExpectedConditions.elementToBeClickable(fromStationInput));
//    fromStationInput.click();
//    fromStationInput.clear();
//    fromStationInput.sendKeys(fromStation);
//
//    // Wait for dropdown suggestions
//    List<WebElement> suggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
//        By.xpath("//div[text()='Chennai']")));
//
//    boolean clicked = false;
//    for (WebElement suggestion : suggestions) {
//        String suggestionText = suggestion.getText().toLowerCase();
//        if (suggestionText.contains(fromStation.toLowerCase())) {
//            new Actions(driver).moveToElement(suggestion).click().perform(); // Reliable click
//            clicked = true;
//            break;
//        }
//    }
//    if (!clicked) {
//        throw new RuntimeException("No matching suggestion found for: " + fromStation);
//    }
//}
//
//// ✅ Enter To Station and select from dropdown
//public void enterToStation(String toStation) {
//    wait.until(ExpectedConditions.elementToBeClickable(toStationInput));
//    toStationInput.click();
//    toStationInput.clear();
//    toStationInput.sendKeys(toStation);
//
//    List<WebElement> suggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
//        By.xpath("//div[text()='Vijayawada']")));
//
//    boolean clicked = false;
//    for (WebElement suggestion : suggestions) {
//        String suggestionText = suggestion.getText().toLowerCase();
//        if (suggestionText.contains(toStation.toLowerCase())) {
//            new Actions(driver).moveToElement(suggestion).click().perform();
//            clicked = true;
//            break;
//        }
//    }
//    if (!clicked) {
//        throw new RuntimeException("No matching suggestion found for: " + toStation);
//    }
//}
//
//public void clickSearchButton1() {
//    wait.until(ExpectedConditions.elementToBeClickable(searchButton));
//    searchButton.click();
//}
//

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
