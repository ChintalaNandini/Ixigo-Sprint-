package com.runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(

   features = "src/test/resources/com/features/Search.feature",

   glue = {"com.StepDefinitionTestNG"},

   plugin = {

       "pretty",

       "html:target/cucumber-reports.html",

       "json:target/cucumber.json"

   },

   monochrome = true,

   dryRun = false

)


public class TestRunnerJunit {
	
	

}
