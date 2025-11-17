package com.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
    features = ".\\src\\test\\resources\\com\\features\\Hotelspage.feature", // folder containing both feature files
    glue = "com.stepDefinitionTestNG",                 // package for step definitions
    	plugin = {
    			"pretty", "html:target/cucumber-report.html",
                "html:reports/HTMLReports.html",
                "json:reports/json-report.json",
                "junit:reports/junit_report.xml"
    			},
    monochrome = true
    )
public class TestRunner extends AbstractTestNGCucumberTests{
	
}
