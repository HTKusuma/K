/**
 * 
 */
package com.learnautomation.testcases;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.SignInPage;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;


/**
 * @author Kusuma.HT
 *
 */

//@Test(priority=1)
public class VerifyAmazonSignInTestcase extends BaseClass
{
    public void VerifyValidLogin() throws IOException
	{
		logger = reports.createTest("SignIn to Amazon");
		ExcelDataProvider excel = new ExcelDataProvider();
		SignInPage signin = PageFactory.initElements(driver, SignInPage.class);
		logger.info("Signing in to Amazon Application");
		signin.Homepage_SignInCTA();
		signin.typeUserName(excel.getStringData("Login", 0, 0));
		signin.clickOnContinueCTA();
		signin.typePassword(excel.getStringData("Login", 0, 1));
		signin.clickOnSignInSubmitCTA();
		Helper.captureScreenshot(driver);
		logger.pass("Login Done Successfully");
		


	}
}
