package com.stepDefinitionTestNG;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.setup.BaseSteps;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
public class Hooks extends BaseSteps{
	public static ExtentSparkReporter spark;
    public static ExtentReports extReports;
    public static ExtentTest test;
    @BeforeAll
    public static void beforeAll() {
        spark = new ExtentSparkReporter(".\\target\\ExtentReport.html");      //for extent report
        extReports = new ExtentReports();
        extReports.attachReporter(spark);
    }
    @AfterAll
    public static void afterAll() {
        extReports.flush();                              //to generate extent report like commit method
    }
    @Before                                               //before every scenario
    public void beforeScenario(Scenario scenario) {

       test = extReports.createTest(scenario.getName());
       launchBrowser();
    }
    @After
    public void afterScenario() {
        sleep(4000);
        driver.quit();
        if (driver != null) {
			driver.quit(); 
		}
		extReports.flush();
    }
}