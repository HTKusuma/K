/**
 * 
 */
package com.learnautomation.utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/**
 * @author Kusuma.HT
 *
 */
public class ExtentReport {
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/amazon.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		 logger = extent.createTest("Sample");
	}

	
	
	//@Test
	public void Login()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println("Title is " + driver.getTitle());
	

	}
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE);
		{
		 Helper.captureScreenshot(driver);
		 logger.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath("./Screenshots/" + ".png").build());
	}
		//extent.flush();
	}
}
