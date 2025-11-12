//package com.pages;
//
////public class FoodOrderPage {
////
////}
//
//import java.time.Duration;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class FoodOrderPage {
//    WebDriver driver;
//
//    @FindBy(xpath="//a[contains(text(),'Order Food')]")
//    private WebElement orderFoodLink;
//
//    @FindBy(xpath="//h1[contains(text(),'Order Food')]")
//    private WebElement foodOptionsHeader;
//
//    public FoodOrderPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
//    void clickOrderFoodLink() {
//        new WebDriverWait(driver, Duration.ofSeconds(10))
//            .until(ExpectedConditions.elementToBeClickable("//div[text()='Order Food']"))
//            .click();
//    }
//
//    public void verifyFoodOptionsDisplayed() {
//        boolean isDisplayed = new WebDriverWait(driver, Duration.ofSeconds(10))
//            .until(ExpectedConditions.visibilityOf(foodOptionsHeader))
//            .isDisplayed();
//        if (!isDisplayed) {
//            throw new AssertionError("Order Food page not displayed!");
//        }
//    }
//}
package com.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FoodOrderPage {
    WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Order Food')]")
    private WebElement orderFoodLink;

    @FindBy(xpath = "//h1[contains(text(),'Order Food')]")
    private WebElement foodOptionsHeader;

    public FoodOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ✅ Corrected method
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
}