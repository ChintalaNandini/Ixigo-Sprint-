package com.setup;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.parameters.PropertyReader;
 
public class BaseSteps {
    public static WebDriver driver;
    public static Properties prop; // ✅ Global properties variable
 
    // Launch browser based on config
    public static void launchBrowser() {
        prop = PropertyReader.readProperty(); // ✅ Initialize properties
        String browser = prop.getProperty("browserName");
        String url = prop.getProperty("sourceUrl");
 
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\siddach\\OneDrive - Capgemini\\Desktop\\Selenium Grid\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\siddach\\OneDrive - Capgemini\\Desktop\\Selenium Grid\\msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid browser specified in config.properties");
            return;
        }
 
        driver.get(url);
        driver.manage().window().maximize();
        
        
        String newurl=prop.getProperty("targetUrl");
        driver.get(newurl);
        driver.manage().window().maximize();
    }
    
    
 
    // Sleep utility
    public static void sleep(int msec) {
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    
 
    
    
}