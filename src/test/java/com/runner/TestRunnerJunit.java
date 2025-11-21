package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".\\src\\test\\resources\\com\\features\\Platform.feature",		
		glue = "com.stepDefinitionTestNG",
				//tags="@First",
				//tags="@Second",
			//tags="@Third",
				//tags="@Fourth",
		        // tags="@Fifth",
						//tags="@Six",
						//tags="@Seven",
	       plugin = {"pretty",
	    		   "html:Reports/cucumber-reports.html" , //report is generated in reports folder and the html file name will be cucumber-reports
	       "json:reports/json-report.json",
			"junit:reports/junit_report.xml"}
	       
		)
public class TestRunnerJunit {
	
	
 
}