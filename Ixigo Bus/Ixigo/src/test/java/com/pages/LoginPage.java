package com.pages;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.parameters.ExcelReader;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    By phoneInput = By.xpath("//input[@type='tel']");
    By continueButton = By.xpath("//button[contains(text(),'Continue')]");

    public void loginWithPhoneNumber() throws Exception {
        String phone = ExcelReader.getCellData("Login", 0, 0);
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput)).sendKeys(phone);
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
        Thread.sleep(120000); // Wait 2 minutes for OTP
    }
}
	












































//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.parameters.ExcelReader;
//
//public class LoginPage {
//
//    WebDriver driver;
//    WebDriverWait wait;
//
//    public LoginPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//    }
//
//    // Locators inside iframe
//    By iframeLocator = By.xpath("//iframe[contains(@src, 'login') or contains(@id, 'portal-root')]");
//    By phoneInput = By.xpath("//input[@type='tel' or @placeholder='Enter phone number']");
//    By continueButton = By.xpath("//button[contains(text(),'Continue') or contains(text(),'Verify')]");
//
//    public void handleLoginPopup() throws Exception {
//        // Wait for phone input to appear
//        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput));
//
//
//        // Enter phone number from Excel
//        String phone = ExcelReader.getCellData("Login", 0, 0);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput)).sendKeys(phone);
//
//        // Click Continue
//        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
//
//        // Optional: wait for OTP manually
//        Thread.sleep(5000);
//
//        // Switch back to main page
//        driver.switchTo().defaultContent();
//    }
//}