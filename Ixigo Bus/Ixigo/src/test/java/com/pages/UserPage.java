package com.pages;


	import java.time.Duration;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import com.setup.BaseSteps;
	 
	public class UserPage extends BaseSteps {
	    private WebDriver driver;
	    private WebDriverWait wait;
	 
	    public UserPage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        PageFactory.initElements(driver, this);
	    }
	 
	 
	    //@FindBy(css = "button[data-testid=\"search-hotels\"] > div.flex.items-center.gap-5.font-medium")
	    //private WebElement searchButton;

}
