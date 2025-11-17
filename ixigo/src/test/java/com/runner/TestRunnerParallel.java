package com.runner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		dryRun=false,

		features = {"src/test/resources/Features/Login.feature"},	 glue = {"com.stepDefinitionTestNG"},

		plugin = {"pretty:reports/prettyReport.html","html:reports/HTMLReports.html",
				"json:reports/json-report.json",
				"junit:reports/junit_report.xml","pretty", "html:target/cucumber-reports.html"}
		)

public class TestRunnerParallel extends AbstractTestNGCucumberTests{
	@Override
	@DataProvider(parallel=true)  // parallel run

	public Object[][] scenarios()

	{

		return super.scenarios();

	}

}
