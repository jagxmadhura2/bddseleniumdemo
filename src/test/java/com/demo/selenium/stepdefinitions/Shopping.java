package com.demo.selenium.stepdefinitions;

import com.demo.selenium.pageobject.LoginPage;
import com.demo.selenium.pageobject.ShoppingPage;
import com.demo.selenium.utility.CommonUtils;
import com.demo.selenium.utility.LaunchBrowser;
import com.demo.selenium.pageobject.ShoppingPage;
import com.demo.selenium.utility.Property_Lib;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Shopping extends LaunchBrowser{

	
	LaunchBrowser lb;
	LoginPage lp;
	CommonUtils bp;
	ShoppingPage sp;

	String fileName = "Shopping";
	
	
	@Given("^User navigates to women category$")
    public void user_navigates_to_women_category() throws Exception  {  
		
		try {
			sp = new ShoppingPage(driver);
			sp.navigateWomenPage();
		}

		catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();

			driver.close();
			throw e;
		}
		
		
    }

    @When("^User applies filters$")
    public void user_applies_filters() throws Throwable {
       

		try {
			sp = new ShoppingPage(driver);
			sp.userappliesFilters();
		}

		catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();

			driver.close();
			throw e;
		}
		
    	
    }

    @And("^User add selected items to cart$")
    public void user_add_selected_items_to_cart()throws Throwable  {
        
    	try {
			sp = new ShoppingPage(driver);
			sp.selectproductitem();
		}

		catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();

			driver.close();
			throw e;
		}
    	
    }
    
    @Then("^User enters shipping details$")
    public void user_enters_shipping_details()  {
       
    }

    

    @And("^Proceed to checkout$")
    public void proceed_to_checkout() throws Throwable {
        
    }

    @And("^User add incorrect payment details$")
    public void user_add_incorrect_payment_details() {
        ;
    }

	
	
	
	
	
}
