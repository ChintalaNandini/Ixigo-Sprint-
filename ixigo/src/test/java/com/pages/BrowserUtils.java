package com.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class BrowserUtils {
	public static void switchToNewTab(WebDriver driver) {
        try {
            String currentHandle = driver.getWindowHandle();
            Set<String> allHandles = driver.getWindowHandles();

            for (String handle : allHandles) {
                if (!handle.equals(currentHandle)) {
                    driver.switchTo().window(handle);
                    System.out.println("Switched to new tab: " + driver.getTitle());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error while switching to new tab: " + e.getMessage());
        }
    }
	

}
