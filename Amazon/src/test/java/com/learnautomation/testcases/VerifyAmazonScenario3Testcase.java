package com.learnautomation.testcases;
import org.testng.annotations.Test;
import com.learnautomation.pages.AmazonScenario3;
import com.learnautomation.pages.BaseClass;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;


public class VerifyAmazonScenario3Testcase extends BaseClass {
	//@Test 
	public void Scenario3() throws Exception {
		logger = reports.createTest("Scenario 3");
		ExcelDataProvider excel = new ExcelDataProvider();
		AmazonScenario3 sc3 = new AmazonScenario3(driver);
		sc3.clickOnSearchTextField();
		for (int i = 1; i<=6; i++) {
			sc3.searchforDifferntCategory(excel.getStringData("Login", i, 0));
			Helper.captureScreenshot(driver);
			}
	}
}
