package com.demo.selenium.testrunner;

import org.junit.AfterClass;
import java.io.*;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/Batch1_Features" },
//tags={"@Create"},
tags = { "@Login, @Shopping" },
glue = { "com.demo.selenium.stepdefinitions" }, plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/extent/ExtentReport.html",
		"html:target/cucumber-html-report", "junit:target/cucumber_batch1.xml",
		"pretty:target/cucumber-pretty.txt", "rerun:target/rerun.txt",
		"usage:target/cucumber-usage.json", "json:target/cucumber25.json" }, monochrome = false)
public class testrunner extends AbstractTestNGCucumberTests {

	
	@AfterClass
	public static void setup()
	{
	Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
	Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
	Reporter.setSystemInfo("User Name", "Jagadeesh");
	Reporter.setSystemInfo("Application Name", "Demo sUI Automation");
	Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
	Reporter.setSystemInfo("Environment", "Production");
	Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	}
	
	
	
}
