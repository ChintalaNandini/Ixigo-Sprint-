package com.StepDefinitionTestNG;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.setup.BaseSteps;

import io.cucumber.java.*;

public class Hooks extends BaseSteps {

    public static ExtentSparkReporter spark;
    public static ExtentReports extReports;
    public static ExtentTest test;  //track the test cases,description

    @BeforeAll
    public static void beforeAll() {
        spark = new ExtentSparkReporter(".\\target\\ExtentReport.html");
        extReports = new ExtentReports();
        extReports.attachReporter(spark);
    }

    @AfterAll // All feature file ends,this will run
    public static void afterAll() {
        extReports.flush();  //flush() - acts as commit - if flush is not there then we cannt see the report
        
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        test = extReports.createTest(scenario.getName());
        launchBrowser(); // Fresh browser launch
    }
    @After                 //runs after every scenario
    public void afterScenario() {
        
        sleep(4000);
//        driver.quit();

	   if (driver != null) {
		   driver.quit();
	   }

    }}
//     }}   closeLoginPopupIfPresent(); // ✅ Handle Ixigo login popup automatically
//    }
//
//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//
//    // ✅ Reusable method to close Ixigo login popup
//    public void closeLoginPopupIfPresent() {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//            WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//div[contains(@class,'login-modal')]")));
//
//            System.out.println("Login popup detected. Closing it...");
//
//            // Click outside using Actions
//            Actions actions = new Actions(driver);
//            actions.moveByOffset(10, 10).click().perform();
//
//            // Wait until modal disappears
//            wait.until(ExpectedConditions.invisibilityOf(modal));
//            System.out.println("Login popup closed successfully.");
//        } catch (TimeoutException e) {
//            System.out.println("Login popup not present. Continuing...");
//        }
//    }
//}
//
//































//package com.StepDefinitionTestNG;
//
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
////import com.aventstack.extentreports.gherkin.model.Scenario;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.setup.BaseSteps;
//
//import io.cucumber.java.After;
//import io.cucumber.java.AfterAll;
//import io.cucumber.java.Before;
//import io.cucumber.java.BeforeAll;
//import io.cucumber.java.Scenario;
//
//
//public class Hooks extends BaseSteps {
//
//
//	public static ExtentSparkReporter spark;                     // classes of extent reports what should be color of report& gui
//	public static ExtentReports extReports;                      // what to track on report (tester name , date etc..,)
//	public static ExtentTest test;// It will track the test cases
//
//
//
//
//	@BeforeAll                                                   // it will run the code before feature file starts
//	public static void beforeAll()
//	{
//
//		spark = new ExtentSparkReporter(".\\target\\ExtentReport.html");   //for extent report
//		extReports = new ExtentReports();
//		extReports.attachReporter(spark);
//	}
//
//	@AfterAll                                                     // after feature file ends this will run
//	public static void afterAll()
//	{
//
//		extReports.flush();                                       // to generate extent report like commit method
//	}
//
//	@Before                                                        // before every scenario   
//	public void beforeScenario(Scenario scenario)
//	{
//
//		test = extReports.createTest(scenario.getName());           // on the test track the name of scenario
//		launchBrowser();                                            //Fresh browser will launch
//	}
//
//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//
//
//}
//
//
