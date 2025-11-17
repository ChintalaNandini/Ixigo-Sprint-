//package com.pages;
//
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//	 
//public class OffersPage {
//    WebDriver driver;
//
//    @FindBy(linkText = "Track Ticket")
//    WebElement trackTicketLink;
//
//    public OffersPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
//
//    public void clickOnTrackTicket() {
//        trackTicketLink.click();
//    }
//}
//
//
//
////========================================
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////	    // Locators
////	    By offersLink = By.xpath("//a[contains(text(),'Offers')]");
////	    By bannerOffer = By.xpath("//*[contains(text(),'50% OFF') or contains(text(),'Get Rs')]");
////	 
////	    public OffersPage(WebDriver driver) {
////	        this.driver = driver;
////	    }
////	 
////	    // Validate Home Page
////	    public void validateHomePage() {
////	        String title = driver.getTitle();
////	        Assert.assertTrue(title.toLowerCase().contains("ixigo"), " Home page not loaded");
////	        System.out.println(" Ixigo Home Page validated successfully");
////	    }
////	 
////	    // Click on Offers Link
////	    public void clickOffers() {
////	        driver.findElement(offersLink).click();
////	        System.out.println(" Navigating to Offers page...");
////	    }
////	    
////	    
////	 
////	    // Validate Offers Page
////	    public void validateOffersPage() {
////	        String url = driver.getCurrentUrl();
////	        Assert.assertTrue(url.contains("offers"), " Offers page not opened");
////	        System.out.println("✅ Offers page opened successfully");
////	 
////	        // Validate banner or offer text
////	        boolean isBannerVisible = driver.findElement(bannerOffer).isDisplayed();
////	        Assert.assertTrue(isBannerVisible, " Offers banner not visible");
////	        System.out.println("✅ Offer banner validated successfully");
////	    }
////	    //
////	    
////	 // Locator for Track Ticket link
////	    By trackTicketLink = By.linkText("Track Ticket");
////	     
////	    // Locators for Track Ticket Page validation
////	    By trackTicketTitle = By.xpath("//h1[contains(text(),'Enter Ticket Details')]");
////	    By bookingIdField = By.xpath("//input[contains(@placeholder,'Booking ID')]");
////	    By mobileNumberField = By.xpath("//input[contains(@placeholder,'Mobile Number')]");
////	    By trackDetailsButton = By.xpath("//button[contains(text(),'Track Details')]");
////	    By faqSection = By.xpath("//h2[contains(text(),'Frequently Asked Questions')]");
////	     
////	    // Click on Track Ticket link
////	    public void clickOnTrackTicket() {
////	        driver.findElement(trackTicketLink).click();
////	        System.out.println(" Clicked on Track Ticket option");
////	    }
////	     
////	    // Validate Track Ticket page
////	    public void validateTrackTicketPage() {
////	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////	        wait.until(ExpectedConditions.visibilityOfElementLocated(trackTicketTitle));
////	     
////	        String titleText = driver.findElement(trackTicketTitle).getText();
////	        Assert.assertEquals(titleText, "Enter Ticket Details", " Title mismatch!");
////	     
////	        Assert.assertTrue(driver.findElement(bookingIdField).isDisplayed(), "Booking ID field not visible");
////	        Assert.assertTrue(driver.findElement(mobileNumberField).isDisplayed(), "Mobile number field not visible");
////	        Assert.assertTrue(driver.findElement(trackDetailsButton).isDisplayed(), "Track Details button not visible");
////	        Assert.assertTrue(driver.findElement(faqSection).isDisplayed(), "FAQ section not visible");
////	     
////	        System.out.println(" Track Ticket page validated successfully");
////	    }
////	    
////	}
////	 
////
////
