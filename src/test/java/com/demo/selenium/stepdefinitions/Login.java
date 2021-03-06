package com.demo.selenium.stepdefinitions;

import org.junit.runner.RunWith;

import com.demo.selenium.pageobject.LoginPage;
import com.demo.selenium.utility.CommonUtils;
import com.demo.selenium.utility.LaunchBrowser;
import com.demo.selenium.utility.Property_Lib;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class Login extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	CommonUtils bp;

	String fileName = "Login";

	@Given("^User Selects the Browser, Launches it and Maximises it$")
	public void user_Selects_the_Browser_Launches_it_and_Maximises_it() throws Throwable {
		try {

			lb = new LaunchBrowser();
			lb.preCondition();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			throw e;
		}

	}

	@When("^User Navigates to the URL provided$")
	public void user_Navigates_to_the_URL_provided() throws Throwable {
		try {
			lb = new LaunchBrowser();
			String url = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE, "BaseUrl");
			lb.getUrl(url);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			throw e;
		}
	}
	
	@Then("^Validate home page$")
	public void validate_home_page() throws Throwable {
		try {
			
		    String expectedTitle="My Store";
		    String actualTitle=driver.getTitle();
		    if(actualTitle.equals(expectedTitle)){
		       log.info("user is in home page");
		    }
		    
		    else {
		    	
		    }
			
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			throw e;
		}
	}	
	
	
	
	@Given("^User sign in using username and password$")
	public void user_sgin_in_using_username_and_password() throws Throwable {
		try {
			lp = new LoginPage(driver);
			String Uname = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE, "UserName");
			String Pass = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE, "Password");
			lp.signin(Uname,Pass);
			lp.verifyLoginTitle();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			throw e;
		}

	}
	
	
}