package com.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath="(//p[contains(text(),'Trains')])[2]")
    private WebElement trainslink;
    
    @FindBy(xpath="//h2[text()='Explore More With ixigo']")
    private WebElement text;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
       public void clickTrainsLink() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(trainslink))
                .click();
    }
       public void exploreMore() {
    	   new WebDriverWait(driver, Duration.ofSeconds(10))
    	   .until(ExpectedConditions.elementToBeClickable(text))
    	   .click();
       }
}























































































//package com.pages;
//
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class HomePage {
//    WebDriver driver;
//    
//    @FindBy(xpath="(//p[contains(text(),'Trains')])[2]")
//    private WebElement trainslink;
//    
//    
//    
//    public HomePage (WebDriver driver) {
//    	this.driver=driver;
//    	PageFactory.initElements(driver, this);
//    }
//    
//    
//    public void clicktrainslink() {
//    	new WebDriverWait(driver, Duration.ofSeconds(10))
//    	.until(ExpectedConditions.elementToBeClickable(trainslink)).click();
//    }
//
//}