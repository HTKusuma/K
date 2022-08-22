package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import com.learnautomation.utility.ObjRepositoryData;
import com.learnautomation.utility.TextRepositoryData;

import in.amazon.uifunctions.GUIFunctions;

public class AmazonScenario3 extends BaseClass {
	public ObjRepositoryData ObjRepoProp;
	public TextRepositoryData TextRepoProp;

	By Search = By.xpath(ObjRepositoryData.getValue("Search"));
	By Searchicon = By.xpath(ObjRepositoryData.getValue("Searchicon"));
	By Headings = By.xpath(ObjRepositoryData.getValue("Headings"));
	By PageVerify = By.xpath(TextRepositoryData.getValue("PageVerify"));

	public AmazonScenario3(WebDriver driver) {
		this.driver = driver;
		ObjRepoProp = new ObjRepositoryData();

	}

	public void clickOnSearchTextField() {
		GUIFunctions.click(driver, Search);
		Reporter.log("Successfully clicked on Search TextField");

	}

	public void searchforDifferntCategory(String Searchtext) throws Exception {
		GUIFunctions.enterTextinToTextBox(driver, Search, Searchtext);
		GUIFunctions.click(driver, Searchicon);
		String Expectedurl = driver.getCurrentUrl();
		{
			System.out.println(" The Expected page  " + Expectedurl + "  is displayed");
		}
		
		String title = driver.getTitle();
		if (title.equals("Amazon.in : Books")) {
			System.out.println("This is Books Search Result Page");
		} else if (title.equals("Amazon.in : Watches")) {
			System.out.println("This is Watches Search Result Page");
		} else if (title.equals("Amazon.in : Shoes")) {
			System.out.println("This is Shoes Search Result Page");
		} else if (title.equals("Amazon.in : Toys")) {
			System.out.println("This is Toys Search Result Page");
		} else if (title.equals("Amazon.in : Plants")) {
			System.out.println("This is Plants Search Result Page");
		} else {
			System.out.println("Search Result Page not found");
		}
	}
}
