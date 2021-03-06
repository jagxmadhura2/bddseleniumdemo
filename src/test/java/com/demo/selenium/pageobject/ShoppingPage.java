package com.demo.selenium.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.selenium.utility.CommonUtils;
import com.demo.selenium.utility.LaunchBrowser;

import junit.framework.Assert;

public class ShoppingPage {
	WebDriver driver;
	CommonUtils bp;
	public Logger log;

	public ShoppingPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(LaunchBrowser.driver, this);
		log = Logger.getLogger(this.getClass());
		Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);

	}

	/*******************************
	 * protected WebElement
	 *******************************/
	@FindBy(xpath = "(//a[@title='Women'])")
	protected WebElement womenpage;
	
	
	@FindBy(xpath = "(//*[@id='ul_layered_category_0']/li[1])")
	protected WebElement filtercategories;
	
	
	public String filter1 = "//*[@id='ul_layered_id_attribute_group_";
	public String filter2 = "']/li[";
	public String filter3 = "]/label/a";

	
	@FindBy(xpath = "(//*[@id='our_price_display'])")
	protected WebElement productprice;
	
	@FindBy(xpath = "(//a[@title='Blouse'])")
	protected WebElement productselection;
	
	
	
	//*[@id="ul_layered_id_attribute_group_1"]/li[1]/label/a
	
	/*******************************
	 * String protected
	 *******************************/
	protected String role;


	
	public boolean navigateWomenPage() throws Exception {
		try {
			
			womenpage.click();
			Assert.assertEquals("Women - My Store", driver.getTitle());
			log.info(driver.getTitle() + "navigated to women section");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}



	public boolean userappliesFilters() throws Exception{
		try {
			
			//apply filter category
			Actions actions = new Actions(driver);
			actions.moveToElement(filtercategories).pause(1200).click().build().perform();

			
			//apply size and color using group attribute id
			for(int i=1;i<=3;i=i+2)
			{
				String filter = filter1+i+filter2+i+filter3;
				
				System.out.println(filter);
				
				WebElement clickfiltergroups = driver.findElement(By.xpath(filter));
				
				actions.moveToElement(clickfiltergroups).pause(500).click().pause(500).build().perform();
				
				System.out.println(i);
			}
			
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}



	public boolean selectproductitem() throws Exception{
		
		try {
			
			Thread.sleep(100);
			System.out.println("entered method");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");
			
			//js.executeScript("arguments[0].scrollIntoView(false);", productselection);
			
			//bp.explicitWait(productselection);
			Actions actions = new Actions(driver);
			actions.moveToElement(productselection).pause(500).click().pause(500).build().perform();
			
			//new window will open which is in iframe, so switch to iframe
			WebElement frame = driver.findElement(By.tagName("iframe"));
			driver.switchTo().frame(0);
			System.out.println("Found Iframe");
			
			log.info("validated price of the product" +productprice.getText());
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		
	}

}
