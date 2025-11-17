package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


	@CucumberOptions (
	features= ".\\src\\test\\resources\\com\\features\\Search.feature",
	glue = "com.StepDefinitionTestNG",
	
	//tags="@1st",
	//tags="@2nd",
	//tags="@3rd",
	//tags="@4th",
	//tags="@5th",
	//tags="@6th",
	
	plugin = {"pretty:Reports/pretty-reports.html", "html:Reports/cucumber-reports.html",
			"html:target/cucumber-report.html",
			"html:reports/HTMLReports.html",
			"json:reports/json-report.json",
			"junit:reports/junit_report.xml","pretty", "html:target/cucumber-reports.html"}
	)

	

public class TestRunnerTestNG extends AbstractTestNGCucumberTests 
 {
		

		
}
 

