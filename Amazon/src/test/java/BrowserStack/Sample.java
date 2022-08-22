package BrowserStack;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sample {

public WebDriver driver = null;
	
	public static final String USERNAME = "chaitrapbabar1";
	public static final String AUTOMATE_KEY = "V5Tdw34zttfE4WGhtWie";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";


@BeforeClass
public void setup() throws MalformedURLException
{
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("browserName", "Chrome");
	capabilities.setCapability("browserVersion", "latest");
	HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
	browserstackOptions.put("os", "Windows");
	browserstackOptions.put("osVersion", "10");
	browserstackOptions.put("resolution", "1024x768");
	browserstackOptions.put("local", "false");
	browserstackOptions.put("seleniumVersion", "3.14.0");
	capabilities.setCapability("bstack:options", browserstackOptions);
	
	driver = new RemoteWebDriver(new URL(URL), capabilities);
	
}

//@Test
public void VerifyLogin()
{
driver.get("https://www.google.com");
}

@AfterClass
public void tearDown()
{
driver.quit();
}
	}
	
