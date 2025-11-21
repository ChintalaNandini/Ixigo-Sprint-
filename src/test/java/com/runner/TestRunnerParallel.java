package com.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(
		dryRun=false,
		features = ".\\src\\test\\resources\\com\\features\\Platform.feature",		
		glue = "com.stepDefinitionTestNG", 
				plugin = {"pretty:Reports/pretty-reports.html", "html:Reports/cucumber-reports.html", //report is generated in reports folder and the html file namwe will be cucumber-reports
						"html:target/cucumber-report.html",
						"html:reports/HTMLReports.html",
						"json:reports/json-report.json",
						"junit:reports/junit_report.xml"}
		)
public class TestRunnerParallel extends AbstractTestNGCucumberTests {
	@DataProvider(parallel=true)  // parallel run
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
}