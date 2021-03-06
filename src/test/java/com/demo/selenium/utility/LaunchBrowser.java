package com.demo.selenium.utility;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.io.Files;



public class LaunchBrowser implements AutomationConstants {
	public static WebDriver driver;
	public static WebDriver driver2;
	public static long timeout;
	

	public Logger log;

	public LaunchBrowser() {
		log = Logger.getLogger(this.getClass());
		Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
		BasicConfigurator.configure();
	}

	public boolean preCondition() throws Exception {
		try {
			
			//uncomment to use the local webdriver
			 	log.info("Initialising Framework");
			String browserType = Property_Lib.getPropertyValue(CONFIG_PATH
					+ CONFIG_FILE_TPE, "Browser");
			timeout = Long.parseLong((Property_Lib.getPropertyValue(CONFIG_PATH
					+ CONFIG_FILE_TPE, "IMPLICIT")));

			log.info("Browser:" + browserType);
			if (browserType.equalsIgnoreCase("chromeBrowser")) {
				File file = new File(DRIVER_PATH + CHROME_FILE);
				if (file.exists() && file.isFile()){
					log.info("file exists, and it is a file");
			    }else {
			    	log.info("Downloading the chrome driver.");
					boolean flag = CommonUtils.downloadFile(new URL("https://chromedriver.storage.googleapis.com/2.42/chromedriver_win32.zip"), new File(DRIVER_PATH+"chromedriver.zip"));
					log.info("Downloaded the chrome driver successfully : "+flag);
					CommonUtils.uncompress(new File(DRIVER_PATH+"chromedriver.zip"), new File(DRIVER_PATH+CHROME_FILE));
					log.info("Uncompressed the chrome driver successfully.");
			    }
				
				System.setProperty(CHROME_KEY, DRIVER_PATH + CHROME_FILE);
				ChromeOptions option = new ChromeOptions();
				option.addArguments("disable-infobars");
				driver = new ChromeDriver(option);
			} else if (browserType.equalsIgnoreCase("ieBrowser")) {
				System.setProperty(IE_KEY, DRIVER_PATH + IE_FILE);
				driver = new InternetExplorerDriver();

			} else {
				System.setProperty(GECKO_KEY, DRIVER_PATH + GECKO_FILE);
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
					
			
						
			//Implementing the browser selection using docker remote webdriver
			/*
			log.info("Initialising Framework");
			String browserType = Property_Lib.getPropertyValue(CONFIG_PATH
					+ CONFIG_FILE_TPE, "Browser");
			timeout = Long.parseLong((Property_Lib.getPropertyValue(CONFIG_PATH
					+ CONFIG_FILE_TPE, "IMPLICIT")));

			log.info("Browser:" + browserType);
			if (browserType.equalsIgnoreCase("chromeBrowser")) {
				
				DesiredCapabilities chromebrowser = DesiredCapabilities.chrome();
				
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromebrowser);
				driver.manage().window().maximize();
				log.info("TimeOut:" + timeout);

				driver.manage().timeouts()
						.implicitlyWait(timeout, TimeUnit.SECONDS);
				
				
			} else if (browserType.equalsIgnoreCase("firefox")) {
				
				DesiredCapabilities firefoxbrowser = DesiredCapabilities.firefox();
				
				driver = new RemoteWebDriver(new URL("http://localhost:6666/wd/hub"), firefoxbrowser);
				driver.manage().window().maximize();
				log.info("TimeOut:" + timeout);

				driver.manage().timeouts()
						.implicitlyWait(timeout, TimeUnit.SECONDS);

			}  else if (browserType.equalsIgnoreCase("safari")) {
				
				DesiredCapabilities safaribrowser = DesiredCapabilities.safari();
				
				driver = new RemoteWebDriver(new URL("http://localhost:7777/wd/hub"), safaribrowser);
				driver.manage().window().maximize();
				log.info("TimeOut:" + timeout);

				driver.manage().timeouts()
						.implicitlyWait(timeout, TimeUnit.SECONDS);

			} 
			
			else {
				DesiredCapabilities chromebrowser = DesiredCapabilities.chrome();
				
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromebrowser);
				driver.manage().window().maximize();
				log.info("TimeOut:" + timeout);

				driver.manage().timeouts()
						.implicitlyWait(timeout, TimeUnit.SECONDS);
			}*/
			
			//uncomment to use the local webdriver
		driver.manage().window().maximize();
			log.info("TimeOut:" + timeout);

			driver.manage().timeouts()
					.implicitlyWait(timeout, TimeUnit.SECONDS);

			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void getUrl(String url) {
		driver.get(url);

	}

	public void getScreenShot(String fileName) throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
		Date date = new Date();
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("./Screenshots/" + fileName
					+ "-" + dateFormat.format(date) + ".png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	

	public void close() {
		log.info("Finalising Frmework");
		driver.quit();
	}

	public void getUrl2(String url, WebDriver driver2)
			throws InterruptedException {

		CommonUtils bp = new CommonUtils();

		driver2.get(url);
		bp.waitForElement();
		log.info("Application Launced Sucessfully");

	}

}