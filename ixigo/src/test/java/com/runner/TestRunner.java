package com.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
    features = ".\\src\\test\\resources\\com\\features\\Hotelspage.feature", // folder containing both feature files
    glue = "com.stepDefinitionTestNG",                 // package for step definitions
    plugin = {"pretty", "html:target/cucumber-report.html"},tags="@fs"
    )
public class TestRunner extends AbstractTestNGCucumberTests{
	
}
