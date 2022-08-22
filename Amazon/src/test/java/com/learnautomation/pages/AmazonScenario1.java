package com.learnautomation.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.learnautomation.utility.ObjRepositoryData;
import com.learnautomation.utility.TextRepositoryData;
import in.amazon.uifunctions.GUIFunctions;

public class AmazonScenario1 extends BaseClass {
	public ObjRepositoryData ObjRepoProp;
	public TextRepositoryData TextRepoProp;
	
	By BackToTop = By.xpath(ObjRepositoryData.getValue("BackToTop"));
	By Search = By.xpath(ObjRepositoryData.getValue("Search"));
	By Searchicon = By.xpath(ObjRepositoryData.getValue("Searchicon"));
	By PrimeReadingEligibilityCheckbox = By.xpath(ObjRepositoryData.getValue("PrimeReadingEligibilityCheckbox"));
	By CountryFlag = By.xpath(ObjRepositoryData.getValue("CountryFlag"));
	By CountryFlagDropdown = By.xpath(ObjRepositoryData.getValue("CountryFlagDropdown"));
	By Country = By.xpath(ObjRepositoryData.getValue("Country"));
	By GoToWebsiteCTA = By.xpath(ObjRepositoryData.getValue("GoToWebsiteCTA"));
	By SelectUS_CTA = By.xpath(ObjRepositoryData.getValue("SelectUS_CTA"));
	By BestSeller_Label = By.xpath(ObjRepositoryData.getValue("BestSeller_Label"));
	By Flash_Message = By.xpath(TextRepositoryData.getValue("Flash_Message"));
	By Flash_Message1 = By.xpath(TextRepositoryData.getValue("Flash_Message1"));
	
	public AmazonScenario1(WebDriver driver)
	{
		this.driver=driver;
		ObjRepoProp = new ObjRepositoryData();
		
	}
	    
	public void scrollDownTillBackToCTA()
		{
		
	       JavascriptExecutor js = (JavascriptExecutor) driver;
	 	   js.executeScript("window.scrollBy(4500, 4500)");
		
		}
		
		public void clickOnBackToTopCTA()
		{
			GUIFunctions.click(driver, BackToTop);
		}
		
		public  void VerifyCountryFlag() throws Exception
		{
			GUIFunctions.mouseHoverElement(driver, driver.findElement(CountryFlagDropdown));
			GUIFunctions.click(driver, CountryFlag);
			GUIFunctions.click(driver, Country);
			JavascriptExecutor js = (JavascriptExecutor) driver;
		 	  js.executeScript("document.querySelector('.a-popover-inner.a-lgtbox-vertical-scroll').scrollTo(0,300)");
		 	  
			GUIFunctions.click(driver,SelectUS_CTA );
			GUIFunctions.click(driver, GoToWebsiteCTA);
			GUIFunctions.switchToNextTab(driver);
		}
		
		public void searchforBooks() throws Exception
		{
			GUIFunctions.click(driver, Search);
			GUIFunctions.enterTextinToTextBox(driver, Search, "Prime Reading Eligible");
			GUIFunctions.click(driver, Searchicon);
			Thread.sleep(2000);
			GUIFunctions.checkOrUncheckCheckBox(driver, PrimeReadingEligibilityCheckbox, "PrimeReadingEligibilityCheckbox", true);
			GUIFunctions.mouseHoverElement(driver, driver.findElement(BestSeller_Label));
			
		}
		
		
		public void verifyFlashMessage()
        {
            String exp=ObjRepositoryData.getValue("Flash_Message1");
            String act = driver.findElement(By.xpath(ObjRepositoryData.getValue("Flash_Message"))).getText();
            //System.out.println(act);
            GUIFunctions.compareStrings(driver, act, exp);
        }
		

	} 

		
		

	
	


