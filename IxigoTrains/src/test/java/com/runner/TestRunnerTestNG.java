package com.runner;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		features = ".\\src\\test\\resources\\com\\features\\Login.feature",glue = "com.stepDefinitionTestNG",
		//tags="@2ndScenario",
	       plugin = {"pretty", "html:Reports/cucumber-reports.html",
	    		 
	    		   }
		)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests
{
	
}