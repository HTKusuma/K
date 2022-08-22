/**
 * 
 */
package com.learnautomation.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.learnautomation.utility.ObjRepositoryData;

import in.amazon.uifunctions.GUIFunctions;

/**
 * @author Kusuma.HT
 *
 */
public class Homepage {
	public ObjRepositoryData ObjRepoProp;
    WebDriver driver;
	 
	By LogoImg = By.xpath(ObjRepositoryData.getValue("LogoImg"));
	By SearchTextField = By.xpath(ObjRepositoryData.getValue("SearchTextField"));
	By CountryFlagDropdown = By.xpath(ObjRepositoryData.getValue("CountryFlagDropdown"));
	By CartImg = By.xpath(ObjRepositoryData.getValue("CartImg"));
	By ReturnsandOrdersCTA = By.xpath(ObjRepositoryData.getValue("ReturnsandOrdersCTA"));
	By PortuguesLanguageRadioButton = By.xpath(ObjRepositoryData.getValue("PortuguesLanguageRadioButton"));
			
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		ObjRepoProp = new ObjRepositoryData();
	}
	
	// Verify Amazon Logo
	
	public void VerifyAmazomLogoImg()
	{
		GUIFunctions.isElementPresent(driver, By.xpath(ObjRepositoryData.getValue("LogoImg")));
		String title = driver.getTitle();
		System.out.println("The text is " + title);
	}
	
	
	// Verify Search TextField
	
	public void VerifyAmazonSearchTextField()
	{
		GUIFunctions.isElementPresent(driver, By.xpath(ObjRepositoryData.getValue("SearchTextField")));
		System.out.println("Search Text field is present");
	}
	
	// Verify Language Selection Drop down
	
	public void VerifyAmazonCountryFlagDropdown()
	{
		GUIFunctions.isElementPresent(driver, By.xpath(ObjRepositoryData.getValue("CountryFlagDropdown")));
		System.out.println("Country Flag Dropdown is present");
		
	}
	
	// Verify ReturnsAndOrdersCTAs
	
	public void VerifyAmazonReturnsandOrdersCTA()
	{
		GUIFunctions.isElementPresent(driver, By.xpath(ObjRepositoryData.getValue("ReturnsandOrdersCTA")));
		System.out.println("ReturnsandOrdersCTA is present");
	}
	
	// Verify AddToCartIcon
	
	public void VerifyAmazonAddtoCartIcon()
	{
		GUIFunctions.isElementPresent(driver, By.xpath(ObjRepositoryData.getValue("CartImg")));
		System.out.println("CartImg is present");
	}
	
}
