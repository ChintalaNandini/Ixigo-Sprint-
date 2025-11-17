package com.runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(

   features = "src/test/resources/com/features/Search.feature",

   glue = {"com.StepDefinitionTestNG"},

   plugin = {"pretty:Reports/pretty-reports.html", "html:Reports/cucumber-reports.html",
			"json:reports/json-report.json",
			"junit:reports/junit_report.xml"}
)


public class TestRunnerJunit { 
			

}


 
 