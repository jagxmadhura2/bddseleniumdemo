package com.demo.selenium.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.selenium.utility.CommonUtils;
import com.demo.selenium.utility.LaunchBrowser;

import junit.framework.Assert;

public class LoginPage {
	WebDriver driver;
	CommonUtils bp;
	public Logger log;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(LaunchBrowser.driver, this);
		log = Logger.getLogger(this.getClass());
		Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);

	}

	/*******************************
	 * protected WebElement
	 *******************************/
	@FindBy(xpath = "(//input[@id='email'])")
	protected WebElement username;

	@FindBy(xpath = "(//input[@id='passwd'])")
	protected WebElement password;

	@FindBy(xpath = "(//button[@id='SubmitLogin'])")
	protected WebElement loginButton;

	@FindBy(xpath = "((//*[@class='css-164r41r'])[5])")
	public WebElement user_option;

	@FindBy(xpath = "(//*[text()='Log out'])")
	public WebElement logout;
	
	@FindBy(xpath = "(//a[@title='Log in to your customer account'])")
	public WebElement signin;

	/*******************************
	 * String protected
	 *******************************/
	protected String role;

	/*
	 * **************************************************** Method Name :
	 * enterUname(String userName) Purpose : To enter Username Author : OPAL1 Date
	 * Created : 29/07/17 Date Modified :29/11/20 Reviewed By : Jagadeesh
	 * ******************************************************
	 */
	public boolean enterUname(String userName) throws Exception {
		try {
			bp = new CommonUtils();
			bp.explicitWait(username);
			username.sendKeys(userName);
			bp.ImplicitWait();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	/*
	 * **************************************************** Method Name
	 * :enterPass(String passWord) Purpose : To enter Password Author : OPAL1 Date
	 * Created : 27/07/17 Date Modified :29/11/20 Reviewed By : Jagadeesh
	 * ******************************************************
	 */
	public boolean enterPass(String passWord) throws Exception {
		try {
			bp = new CommonUtils();
			bp.explicitWait(password);
			password.sendKeys(passWord);
			bp.ImplicitWait();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	/*
	 * **************************************************** Method Name
	 * :clickOnLogin() Purpose : To click On Login Author : OPAL1 Date Created :
	 * 27/07/17 Date Modified :29/11/20 Reviewed By : Jagadeesh
	 * ******************************************************
	 */
	public boolean clickOnLogin() throws Exception {
		try {
			bp = new CommonUtils();
			bp.explicitWait(loginButton);
			loginButton.click();
			bp.waitForElement();
			log.info("Successfully landed to user home page");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/*
	 * **************************************************** Method Name
	 * :enterUnameAndPassword(String name,String passWord) Purpose : To enter
	 * Username And Password Author : OPAL1 Date Created : 27/07/17 Date Modified :29/11/20
	 * Reviewed By : Jagadeesh ******************************************************
	 */
	public boolean signin(String name, String passWord) throws Exception {
		try {
			bp = new CommonUtils();
			signin.click();
			bp.explicitWait(username);
			username.sendKeys(name);
			
			bp.explicitWait(password);
			password.sendKeys(passWord);
			bp.explicitWait(loginButton);
			loginButton.click();
			bp.waitForElement();
			log.info("Successfully landed to home Page");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	/*
	 * **************************************************** Method Name :
	 * verifyLoginTitle() Purpose : To verify Login Title Author : OPAL1 Date
	 * Created : 27/07/17 Date Modified :29/11/20 Reviewed By : Jagadeesh
	 * ******************************************************
	 */
	public boolean verifyLoginTitle() throws Exception {
		try {
			String titleLogin = driver.getTitle();
			log.info(titleLogin);
			Assert.assertEquals("My account - My Store", titleLogin);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
