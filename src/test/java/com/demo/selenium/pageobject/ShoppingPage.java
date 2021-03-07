package com.demo.selenium.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	
	@FindBy(xpath = "(//a[@title='White'])")
	protected WebElement colorselection;	

	@FindBy(xpath = "(//p[@id='add_to_cart']//span[.='Add to cart'])")
	protected WebElement addtocartbutton;
	
	@FindBy(xpath = "(//*[@id='layer_cart_product_title'])")
	protected WebElement validateproducttitle;

	@FindBy(xpath = "(//html//div[@id='layer_cart']//h2)")
	protected WebElement validateproductheading;
	
	@FindBy(xpath = "(//html//div[@id='layer_cart']//span[@class='ajax_block_cart_total'])")
	protected WebElement validatecarttotal;
	
	@FindBy(xpath = "(//html//div[@id='layer_cart']//a[@title='Proceed to checkout'])")
	protected WebElement proceedtocheckoutconfirmation;

	@FindBy(xpath = "(//p[@class='cart_navigation clearfix']/a[1])")
	protected WebElement proceedtocheckoutsummarypage;
	
	@FindBy(xpath = "(//p[@class='cart_navigation clearfix']/button)")
	protected WebElement proceedtocheckoutaddresspage;
	
	@FindBy(xpath = "(//p[@class='cart_navigation clearfix']/button)")
	protected WebElement proceedtocheckoutshippingpage;
	
	@FindBy(xpath = "(//*[@id='cgv'])")
	protected WebElement agreeterms;
	
	
	
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



	public boolean slectcolorandsize() throws Exception{
		

		try {
		
			
			Select sizeselction = new Select(driver.findElement(By.name("group_1")));
			sizeselction.selectByVisibleText("M");
			
			log.info("selected the Medium size");
			
			Thread.sleep(500);
	
			Actions actions = new Actions(driver);
			actions.moveToElement(colorselection).pause(500).click().pause(500).build().perform();
		
			log.info("selected the white color");
			
			//to click on add to cart
			actions.moveToElement(colorselection).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
			
			
			log.info("Added product to cart successfully");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}



/*	public boolean validatecartitem() throws Exception{

			try {
				
				driver.switchTo().parentFrame();
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
		Object jse=	js.executeScript("arguments[0].text;", proceedtocheckoutconfirmation);
				
			log.info(jse);
				
				
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}*/



	public boolean proceedtocheckout() throws Exception{
		// TODO Auto-generated method stub
	
		try {
			driver.switchTo().parentFrame();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", proceedtocheckoutconfirmation);
			log.info("user navigated to shopping cart summary page");
			
		
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		throw e;
	}
	}



	public boolean  navigatetoshippingdetails() throws Exception{
		

		try {
			driver.navigate().refresh();
			Thread.sleep(2000);
			//driver.switchTo().parentFrame();
			//scroll down and click on proceed to checkout
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");
		
			Actions actions = new Actions(driver);
			actions.moveToElement(proceedtocheckoutsummarypage).pause(500).click().pause(500).build().perform();
		
			//again click on proceed to checkout in address page
			actions.moveToElement(proceedtocheckoutaddresspage).pause(500).click().pause(500).build().perform();
			
		
			//check agree terms is enabled or not and proceed to checkout
			
			actions.moveToElement(agreeterms).pause(500).click().pause(500).build().perform();
			
			if(agreeterms.isEnabled())
			{
				log.info("agreed terms and conditions check");
			}
			
			else
			{
				actions.moveToElement(agreeterms).pause(500).click().pause(500).build().perform();
			}
			
			actions.moveToElement(proceedtocheckoutshippingpage).pause(500).click().pause(500).build().perform();
			
			log.info("user clicked on procced to checkout in shipping page and navigated to payment page");
			
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		throw e;
	}
		
	}


		
}

	
