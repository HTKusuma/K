package com.learnautomation.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.learnautomation.utility.ObjRepositoryData;
import in.amazon.uifunctions.GUIFunctions;
import junit.framework.Assert;

public class AmazonScenario2 extends BaseClass {
	public ObjRepositoryData ObjRepoProp;

	By Select_Your_Address = By.xpath(ObjRepositoryData.getValue("Select_Your_Address"));
	By Choose_Your_Location = By.xpath(ObjRepositoryData.getValue("Choose_Your_Location"));
	By Description_text = By.xpath(ObjRepositoryData.getValue("Description_text"));
	By SignIn_To_See_Your_Address_Button = By.xpath(ObjRepositoryData.getValue("SignIn_To_See_Your_Address_Button"));
	By Pin_code_Text_Box = By.xpath(ObjRepositoryData.getValue("Pin_code_Text_Box"));
	By Apply_Button = By.xpath(ObjRepositoryData.getValue("Apply_Button"));
	By Deliver_outside_India = By.xpath(ObjRepositoryData.getValue("Deliver_outside_India"));
	By Error_Message = By.xpath(ObjRepositoryData.getValue("Error_Message"));
	By Alert_icon = By.xpath(ObjRepositoryData.getValue("Alert_icon"));
	By Select = By.xpath(ObjRepositoryData.getValue("Select"));
	By ErrorText = By.xpath(ObjRepositoryData.getValue("ErrorText"));
	By Popup = By.xpath(ObjRepositoryData.getValue("Popup"));

	public AmazonScenario2(WebDriver driver) {
		this.driver = driver;
		ObjRepoProp = new ObjRepositoryData();

	}

	/* Click on "Select your Address" */

	public void click_On_Select_Your_Address_CTA() {
		GUIFunctions.click(driver, Select_Your_Address);
	}

	/* Verify the Popup content */

	public void verify_Popup_Content() throws Exception

	{
		/* header "Choose your Location */

		Assert.assertTrue(GUIFunctions.isElementPresent(driver, Choose_Your_Location));
		{
			System.out.println("Choose Your Location Header is displayed");
		}

		/* Description text */
		Assert.assertTrue(GUIFunctions.isElementPresent(driver, Description_text));
		{
			System.out.println(" Description Text is displayed");
		}

		/* Sign in to see your address Button */

		Assert.assertTrue(GUIFunctions.isElementPresent(driver, SignIn_To_See_Your_Address_Button));
		{
			System.out.println(" Sign in to see your address Button is displayed");
		}

		/* Pin code Text Box */
		Assert.assertTrue(GUIFunctions.isElementPresent(driver, Pin_code_Text_Box));
		{
			System.out.println(" Pin code Text Box is displayed");
		}

		/* Apply button */

		Assert.assertTrue(GUIFunctions.isElementPresent(driver, Apply_Button));
		{
			System.out.println(" Apply_Button is displayed");
		}

		/* Deliver outside India Dropdown and verify the values displayed. */

		Assert.assertTrue(GUIFunctions.isElementPresent(driver, Deliver_outside_India));
		{
			System.out.println(" Deliver_outside_India dropdown is displayed");
			GUIFunctions.click(driver, Deliver_outside_India);
			Thread.sleep(5000);
			Select s = new Select(driver.findElement(Select));
			Iterable<WebElement> country_options = s.getOptions();
			int i = 1;
			for (WebElement e : country_options) {
				System.out.println(i + ".  " + e.getText());
				i++;
			}
		}
	}

	/* Enter Invalid pin code and verify the error message */
	public void enter_PIN() throws Exception {
		GUIFunctions.enterTextinToTextBox(driver, Pin_code_Text_Box, "111111");
		GUIFunctions.click(driver, Apply_Button);
		Assert.assertTrue(GUIFunctions.isElementPresent(driver, Error_Message));
		System.out.println("Please enter a valid pincode error message is displayed");

		/* Alert icon */

		Assert.assertTrue(GUIFunctions.isElementPresent(driver, Alert_icon));
		{
			System.out.println(" Alert_icon is displayed");
		}

		/* Provide Valid pin code */

		GUIFunctions.enterTextinToTextBox(driver, Pin_code_Text_Box, "560073");
		GUIFunctions.click(driver, Apply_Button);

		/* Verifying popup is closed after entering valid Pincode */

		WebDriverWait w = new WebDriverWait(driver, 5);
		if (w.until(ExpectedConditions.invisibilityOfElementLocated(Popup))) {
	    System.out.println("Popup not exists");
		} else {
			System.out.println("Popup exists");
		}
	}
}


