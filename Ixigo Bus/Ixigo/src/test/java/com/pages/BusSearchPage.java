package com.pages;


package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BusSearchPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//input[@placeholder='From']")
    WebElement fromStationInput;

    @FindBy(xpath = "//input[@placeholder='To']")
    WebElement toStationInput;

    @FindBy(xpath = "//button[text()='Search']")
    WebElement searchButton;

    public BusSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterFromStation(String fromStation) {
        fromStationInput.clear();
        fromStationInput.sendKeys(fromStation);
        selectFirstSuggestion();
    }

    public void enterToStation(String toStation) {
        toStationInput.clear();
        toStationInput.sendKeys(toStation);
        selectFirstSuggestion();
    }

    private void selectFirstSuggestion() {
        // Wait for dropdown suggestion and click first item
        WebElement firstSuggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li[1]")));
        firstSuggestion.click();
    }

    public void clickSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }
}
