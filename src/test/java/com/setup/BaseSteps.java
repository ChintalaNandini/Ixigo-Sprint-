package com.setup;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

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
            System.setProperty("webdriver.chrome.driver", "C:\\training\\SeleniumGrid\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\training\\SeleniumGrid\\msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid browser specified in config.properties");
            return;
        }

        driver.get(url);
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

    // Switch to window by index
    public static void switchToWindow(int index) {
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowsList = new ArrayList<>(windowHandles);

        if (index < windowsList.size()) {
            driver.switchTo().window(windowsList.get(index));
        } else {
            System.out.println("Invalid window index: " + index);
        }
    }

    // Switch to window by title
    public static void switchToWindowByTitle(String title) {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(title)) {
                break;
            }
        }
    }

    // Close all windows except main
    public static void closeExtraWindows() {
        String mainWindow = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
    }

    // Switch URL to targetUrl from properties
    public static void switchURL() {
        String newUrl = prop.getProperty("targetUrl"); // ✅ Reads targetUrl
        if (newUrl != null && !newUrl.isEmpty()) {
            driver.navigate().to(newUrl);
        } else {
            System.out.println("targetUrl not found in config.properties");
        }
    }

    // Navigation helpers
    public static void navigateBack() {
        driver.navigate().back();
    }

    public static void navigateForward() {
        driver.navigate().forward();
    }

    public static void refreshPage() {
        driver.navigate().refresh();
    }
}
