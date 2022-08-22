/**
 * 
 */
package com.learnautomation.testcases;

import org.testng.annotations.Test;
import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.Homepage;

/**
 * @author Kusuma.HT
 *
 * Verifying the elements AmazonLogo, SearchTextfield, CountryFlagDropdown, ReturnandOrderCTA , CartIcon
 */
@Test
public class VerifyAmazonHomePageTestcase extends BaseClass
{
	
	public void VerifyElementsOfHomePage()
	{
		logger = reports.createTest("Verify Components of Home Page");
		Homepage home = new Homepage(driver);
		logger.info("Started Verifying Components of Homepage--> Amazon Application");
		home.VerifyAmazomLogoImg();
		home.VerifyAmazonSearchTextField();
		home.VerifyAmazonCountryFlagDropdown();
		home.VerifyAmazonReturnsandOrdersCTA();
		home.VerifyAmazonAddtoCartIcon();
		logger.pass("Successfully completed verifying components of Homepage");
		
	}

}
