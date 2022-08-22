package com.learnautomation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.learnautomation.pages.AmazonScenario1;
import com.learnautomation.pages.AmazonScenario2;
import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.SignInPage;

public class VerifyAmazonScenario2Testcase extends BaseClass{
	
	//@Test(priority = 1)
	public void Scenario2() throws Exception
	{
	AmazonScenario2 sc1 = new AmazonScenario2(driver);
	sc1.click_On_Select_Your_Address_CTA();
	sc1.verify_Popup_Content();
	sc1.enter_PIN();
	}
}
