package com.learnautomation.pages;
import com.learnautomation.utility.ObjRepositoryData;
import in.amazon.uifunctions.GUIFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.learnautomation.pages.BaseClass;

/**
 * @author Kusuma.HT
 * 
 * This locator will store all the methods of SignIn Page
 *
 */
public class SignInPage extends BaseClass
{
	public ObjRepositoryData ObjRepoProp;
	
	By HomepageSignIn = By.xpath(ObjRepositoryData.getValue("HomepageSignInCTA"));
	By Username = By.xpath(ObjRepositoryData.getValue("Username"));
    By ContinueCTA = By.xpath(ObjRepositoryData.getValue("ContinueCTA"));
    By Password = By.xpath(ObjRepositoryData.getValue("Password"));
    By SignInSubmitCTA = By.xpath(ObjRepositoryData.getValue("SignInSubmitCTA"));
	
	public SignInPage(WebDriver driver)
	{
		this.driver=driver;
		ObjRepoProp = new ObjRepositoryData();
	
	}
	
	// Click On Sign In CTA in Home Page
	
	public void Homepage_SignInCTA()
	{
		GUIFunctions.click(driver, HomepageSignIn);
	}
	
	// Enter Email Id by reading MailId from Excel
	
    public void typeUserName(String uid)
    {
	GUIFunctions.enterTextinToTextBox(driver, Username ,uid);
    }

	// Click On Continue CTA in UserName Page

	public void clickOnContinueCTA()
	{
		GUIFunctions.click(driver, ContinueCTA);
	}
	
	// Enter Email Id by reading Password from Excel
	
   public void typePassword(String pid)
	{
		GUIFunctions.enterTextinToTextBox(driver, Password, pid);
	}
	
	// Click On SignIn CTA in Password Page  
	
    public void clickOnSignInSubmitCTA()
	{
		GUIFunctions.click(driver, SignInSubmitCTA);
	}

}

	
