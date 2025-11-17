package com.runner;
 
import org.testng.annotations.DataProvider;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(
		dryRun=false,
		        features = "src/test/resources/com/Features/TopDeals.feature",   // ✅ Path to .feature files
		        glue = {"com.StepDefinitionTestNG"},                           // ✅ Package where step defs exist
//		        tags="@service",
		        plugin = {"pretty:Reports/PrettyReports.html",
		        		"html:Reports/cucumber-report.html",
		        		"html:Reports/HTMLReports.html",
		    			"json:Reports/json-report.json",
		    			"junit:Reports/junit_report.xml"})
 
public class TestRunnerParallel extends AbstractTestNGCucumberTests{
 
	@DataProvider(parallel=true)  // parallel run
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
}

 