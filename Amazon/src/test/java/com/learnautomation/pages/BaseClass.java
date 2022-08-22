package com.learnautomation.pages;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports reports;
	public ExtentTest logger;
	
	public static final String USERNAME = "chaitrapbabar1";
	public static final String AUTOMATE_KEY = "V5Tdw34zttfE4WGhtWie";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	
	@BeforeSuite
	public void setUpSuite() throws IOException 
	{
		
		Reporter.log("Setting up the reports and Test Started", true);
		
			excel = new ExcelDataProvider();
			config = new ConfigDataProvider();
			ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Amazon_" +Helper.getCurrentDateTime() +".html"));
			reports = new ExtentReports();
			reports.attachReporter(extent);
			Reporter.log("Setting Done----> Test can be Started", true);
		}
	
	@BeforeClass
	public void setup() throws MalformedURLException
	{
		Reporter.log("Trying to start Browser and Getting Application ready", true);
		driver=BrowserFactory.startApplication(driver, config.getBrowser(), config.getIntURL());
		
		
		//DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability("browserName", "Chrome");
		//capabilities.setCapability("browserVersion", "latest");
		//HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		//browserstackOptions.put("os", "Windows");
		//browserstackOptions.put("osVersion", "10");
		//browserstackOptions.put("resolution", "1024x768");
		//browserstackOptions.put("local", "false");
		//browserstackOptions.put("seleniumVersion", "3.14.0");
		//capabilities.setCapability("bstack:options", browserstackOptions);
	
		//driver = new RemoteWebDriver(new URL(URL), capabilities);
		//driver.get(config.getIntURL());
		Reporter.log("Browser and Application is up and running", true);
	}
	

	@AfterClass
	public void teardown()
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws Exception 
	{
		Reporter.log("Test is about to End", true);
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.skip("Test Skipped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		reports.flush();
		Reporter.log("Test Completed>>>> Reports Generated", true);
	}
	
	
}


