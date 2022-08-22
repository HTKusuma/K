package com.learnautomation.testcases;
import com.learnautomation.utility.ObjRepositoryData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.learnautomation.pages.AmazonScenario1;
import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.SignInPage;

import in.amazon.uifunctions.GUIFunctions;


public class VerifyAmazonScenario1Testcase extends BaseClass 
{
	//@Test
	public void scenario1() throws Exception
	{
	AmazonScenario1 sc1 = new AmazonScenario1(driver);
	sc1.scrollDownTillBackToCTA();
	sc1.clickOnBackToTopCTA();
	sc1.VerifyCountryFlag();
	sc1.searchforBooks();
	sc1.verifyFlashMessage();
	}
	
}


