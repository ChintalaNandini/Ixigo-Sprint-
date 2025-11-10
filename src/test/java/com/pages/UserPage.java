package com.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;

public class UserPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest test;

    @FindBy(xpath="(//button[contains(@class,'text-brand') and text()='Log in/Sign up'])[1]")
    private WebElement selectFrom;
    
    /*@FindBy(xpath="(//button[contains(@class,'text-brand') and text()='Log in/Sign up'])[1]")
    private WebElement clickLogin;*/


    // Constructor
    public UserPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    // Action method for login button
    
}
