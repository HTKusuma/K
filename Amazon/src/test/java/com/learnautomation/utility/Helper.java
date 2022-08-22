package com.learnautomation.utility;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	// screenshots, alerts, frames, windows , sync issues, javaScript executor
	
	public static String captureScreenshot(WebDriver driver)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath = System.getProperty("user.dir")+"./Screenshots/" + getCurrentDateTime()+ ".png";
		
		try {
			FileHandler.copy(src, new File(screenshotpath));
			System.out.println("Capture Screenshot");
		} catch (Exception e) 
		{
			System.out.println("Unable to capture Screenshot>>" + e.getMessage());
		}
		return screenshotpath;
	}
		
		public static String getCurrentDateTime()
		{
			DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
			Date currentDate = new Date();
			return customFormat.format(currentDate);
		}
	}
	


