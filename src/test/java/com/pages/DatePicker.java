package com.pages;


	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

	public class DatePicker {

	    WebDriver driver;

	    public DatePicker(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void selectDate(String dateType) {
	        // Step 1: Calculate target date
	        LocalDate targetDate = dateType.equalsIgnoreCase("Today") ?
	                               LocalDate.now() :
	                               LocalDate.now().plusDays(1);

	        // Step 2: Format date for calendar matching
	        DateTimeFormatter dayFormat = DateTimeFormatter.ofPattern("d");
	        DateTimeFormatter monthFormat = DateTimeFormatter.ofPattern("MMMM");
	        DateTimeFormatter yearFormat = DateTimeFormatter.ofPattern("yyyy");

	        String day = targetDate.format(dayFormat);
	        String month = targetDate.format(monthFormat);
	        String year = targetDate.format(yearFormat);

	        // Step 3: Open calendar
	        driver.findElement(By.xpath("//input[@placeholder='Travel Date']")).click();

	        // Step 4: Navigate to correct month/year if needed
	        while (true) {
	            String displayedMonthYear = driver.findElement(By.cssSelector(".rdp-month")).getText();
	            if (displayedMonthYear.contains(month) && displayedMonthYear.contains(year)) {
	                break;
	            }
	            driver.findElement(By.cssSelector(".rdp-nav-button[aria-label='Next month']")).click();
	        }

	        // Step 5: Select the day
	        driver.findElement(By.xpath("//div[@class='rdp-day' and text()='" + day + "']")).click();
	    }
	}


