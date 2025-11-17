package com.runner;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		features = ".\\src\\test\\resources\\com\\features\\Login.feature",glue = "com.stepDefinitionTestNG",
		tags="@1stScenario",
	       plugin = {"pretty", "html:Reports/cucumber-reports.html",
	    		   "json:reports/json-report.json",
	    		   "junit:reports/junit_report.xml"}
	    		
		)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests
{
	
}


//package com.Runner;
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
// 
//@CucumberOptions( features = ".\\src\\test\\resources\\com\\Features\\TopDeals.feature", 
//		glue = "com.StepDefinitionTestNG",
// 
//		plugin = {"pretty", "html:Reports/cucumber-reports.html",		//format is same for all runner class(junit, TestNG, Parallel) 
//		"json:reports/json-report.json",
//		"junit:reports/junit_report.xml"}
//		//tags = "@FirstScenario or @SecondScenario or @ThirdScenario or @FourthScenario or @FifthScenario"
//)	
// 
//public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
// 
//}