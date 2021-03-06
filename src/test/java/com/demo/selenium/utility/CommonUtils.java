package com.demo.selenium.utility;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.rauschig.jarchivelib.ArchiveFormat;
import org.rauschig.jarchivelib.Archiver;
import org.rauschig.jarchivelib.ArchiverFactory;
import org.rauschig.jarchivelib.CompressionType;

public class CommonUtils {
	public WebDriver driver = null;

	public CommonUtils() {

		this.driver = LaunchBrowser.driver;
	}

	public void waitTillElementIsVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, AutomationConstants.EXPLICIT);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	
	public boolean WaitForLoaderBarToComplete(WebElement element) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, AutomationConstants.EXPLICIT);	
		while(true) {
		    try {
		       if (element.getAttribute("style").contains("100%")) {
		    	   System.out.println("Loader bar completed");
		          return true;
		       }
		    } catch (Exception e) {
		    	System.out.println("Loader bar completed");
		       return true;
		    }
		   Thread.sleep(1000);
		  }
		
	}
	
	
	public boolean WaitForJiraProgressBar(WebElement element) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, AutomationConstants.EXPLICIT);	
		while(true) {
		    try {
		       if (element.isDisplayed()) {
		    	   System.out.println("Jira progress bar completed");
		          return true;
		       }
		    } catch (Exception e) {
		    	System.out.println("Jira progress bar completed");
		       return true;
		    }
		   Thread.sleep(1000);
		  }
		
	}
	
	
	public boolean WaitForTestStepSpinner(WebElement element) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, AutomationConstants.EXPLICIT);	
		while(true) {
		    try {
		       if (element.getAttribute("size").contains("100")) {
		    	   System.out.println("spinner bar completed");
		          return true;
		       }
		    } catch (Exception e) {
		    	System.out.println("spinner bar completed");
		       return true;
		    }
		   Thread.sleep(1000);
		  }
		
	}
		
	
	
	
	
	
	
	
	public boolean moveToElement(WebElement element) throws Exception {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).perform();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void moveToElementAndClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();

	}

	public boolean eraseText(WebElement ele) {

		Actions a1 = new Actions(driver);
		a1.moveToElement(ele).click().build().perform();
		String selectAll = Keys.chord(Keys.CONTROL, "a");
		a1.sendKeys(selectAll).sendKeys(Keys.DELETE).build().perform();
		return true;

	}

	public boolean waitForElement() throws InterruptedException {
		Thread.sleep(5000);
		return true;
	}

	
	public void ImplicitWait() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(AutomationConstants.IMPLICIT, TimeUnit.SECONDS);				

	}
	
	
	public void alertMsg() {
		Alert a1 = driver.switchTo().alert();
		a1.getText();

	}

	public void windowHandle() {
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		driver.close();
		driver.switchTo().window(tabs2.get(0));

	}

	public boolean explicitWait(WebElement ele) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, AutomationConstants.EXPLICIT);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		return true;
	}

	public boolean maxExplicitWait(WebElement ele) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, AutomationConstants.MAX_EXPLICIT);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		return true;
	}
	
	
	public boolean fluentWait(WebElement ele) throws InterruptedException {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(AutomationConstants.FLUENTWAIT, TimeUnit.SECONDS)
				.pollingEvery(AutomationConstants.POLLINGWAIT, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
				
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		return true;
		
	}
	
	

	public boolean switchToFrame(WebElement ele) throws Exception {
		try {
			driver.switchTo().frame(ele);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void switchWindowTab(int tabNo) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabNo));

	}

	public void dragAndDrop(WebElement source, int xoffset, int yoffset) {
		try {
			Actions act = new Actions(driver);

			act.dragAndDropBy(source, xoffset, yoffset).perform();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void pageLoad() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean status = js.executeScript("return document.readyState").toString().equals("complete");
		if (status == true) {
			System.out.println("Page Loaded Completely");
		} else {
			System.out.println("Page not loaded Completely");

		}

	}

	public String currentDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		Date date = new Date();

		String date1 = dateFormat.format(date);

		return date1;
	}

	public WebElement elementToBeClickable(String locator) throws InterruptedException {

		WebElement ele = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable((By.xpath(locator))));

		return ele;
	}

	public void setClipboardData(String string) {
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	public void uploadFile(String file_Location) {
		try {
      
			Thread.sleep(2000);
			String fileLocation = System.getProperty("user.dir");
			String uploadFileLocation = fileLocation + AutomationConstants.UPLOAD_FILE_LOCATION + file_Location;

			setClipboardData(uploadFileLocation);
			Robot robot = new Robot();
			
	        robot.delay(2000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.delay(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

	public static void stopWindowsService(String serviceName) {
		String[] command = { "cmd.exe", "/c", "net", "stop", serviceName };
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		try {
			Process process = new ProcessBuilder(command).start();
			inputStream = process.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream);
			bufferedReader = new BufferedReader(inputStreamReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception ex) {
			System.out.println("Exception : " + ex);
		} finally {
			try {
				inputStream.close();
				inputStreamReader.close();
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public static void startWindowsService(String serviceName) {

		String[] command = { "cmd.exe", "/c", "net", "start", serviceName };
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;

		try {
			Process process = new ProcessBuilder(command).start();
			inputStream = process.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream);
			bufferedReader = new BufferedReader(inputStreamReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}

		} catch (Exception ex) {
			System.out.println("Exception : " + ex);
		} finally {
			try {
				inputStream.close();
				inputStreamReader.close();
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public static void uncompress(File archiveFile, File destination) {
		archiveFile = archiveFile.getAbsoluteFile();
		destination = destination.getParentFile();
		if (archiveFile == null || !archiveFile.exists()) {
			return;
		}
		if (destination == null) {
			return;
		}
		if (!destination.exists()) {
			destination.mkdirs();
		}
		Archiver archiver = null;
		if (archiveFile.getName().endsWith(".tar.gz")) {
			archiver = ArchiverFactory.createArchiver(ArchiveFormat.TAR, CompressionType.GZIP);
		} else if (archiveFile.getName().endsWith(".zip")) {
			archiver = ArchiverFactory.createArchiver(ArchiveFormat.ZIP);
		} else if (archiveFile.getName().endsWith(".tar")) {
			archiver = ArchiverFactory.createArchiver(ArchiveFormat.TAR);
		}
		if (archiver != null) {
			try {
				archiver.extract(archiveFile, destination);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Compress source files
	 * 
	 * @param archiveNameWithExtension
	 *            {@link String}
	 * @param destination
	 *            {@link File}
	 * @param sources
	 *            {@link File}[]
	 * @return {@link File}
	 */
	public static File compress(String archiveNameWithExtension, File destination, File... sources) {
		if (isEmpty(archiveNameWithExtension)) {
			return null;
		}
		if (sources == null || sources.length == 0) {
			return null;
		}
		if (sources.length == 0) {
			return null;
		}
		if (destination == null) {
			return null;
		}
		if (!destination.exists()) {
			destination.mkdirs();
		}
		Archiver archiver = null;
		String _archiveNameWithExtension = archiveNameWithExtension.trim().toLowerCase();
		if (_archiveNameWithExtension.endsWith(".tar.gz")) {
			archiver = ArchiverFactory.createArchiver(ArchiveFormat.TAR, CompressionType.GZIP);
		} else if (_archiveNameWithExtension.endsWith(".zip")) {
			archiver = ArchiverFactory.createArchiver(ArchiveFormat.ZIP);
		} else if (_archiveNameWithExtension.endsWith(".tar")) {
			archiver = ArchiverFactory.createArchiver(ArchiveFormat.TAR);
		}

		if (archiver != null) {
			try {
				File archive = archiver.create(archiveNameWithExtension.trim(), destination, sources);
				return archive;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * Download file from {@link URL} to destination
	 * 
	 * @param url
	 *            {@link URL}
	 * @param destination
	 *            {@link File}
	 * @return {@link Boolean}
	 */
	public static boolean downloadFile(URL url, File destination) {
		destination = destination.getAbsoluteFile();
		if (url == null) {
			return false;
		}
		if (destination == null) {
			return false;
		}
		if (!destination.getParentFile().exists()) {
			destination.getParentFile().mkdirs();
		}
		try {
			org.apache.commons.io.FileUtils.copyURLToFile(url, destination, 5000, 5000);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Check if the given {@link String} is null or empty
	 * 
	 * @param str
	 *            {@link String}
	 * @return {@link Boolean}
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.trim().isEmpty();
	}

	
}
