package com.runner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
   features = ".\\src\\test\\resources\\com\\features\\Hotelspage.feature",
   glue = {"com.stepDefinitionTestNG"},
		   plugin = {"pretty", "html:target/cucumber-report.html",
	        		"pretty","html:reports/HTMLReports.html",
	    			"json:reports/json-report.json",
	    			"junit:reports/junit_report.xml"},
   monochrome = true,
   dryRun = false
)
public class TestRunnerJunit {

}