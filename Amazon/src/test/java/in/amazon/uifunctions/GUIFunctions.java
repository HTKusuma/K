package in.amazon.uifunctions;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class GUIFunctions {

	/**
	 * Method Name: isElementPresent Description: Method to verify the Element
	 */
	
	public static boolean isElementPresent(WebDriver driver,By by)
	{
		try{
			// Verify element is present
			driver.findElement(by);
			return true;
			
		}catch (NoSuchElementException e){
			System.out.println("No such element present--->\n" + e);
		}
		return false;
	}
	
	
	/* 
	 * is Displayed
	 * 
	 * 
	 */
	
	public static boolean isDisplayed(WebDriver driver,By by, String eleName)
	{
		try{
			// Verify element is present
			driver.findElement(by);
			System.out.println(eleName + " component is displayed");
			return true;
			
		}catch (NoSuchElementException e){
			System.out.println("No such element present--->\n" + e);
			Reporter.log("<p> No such element present");
		}
		return false;
		
	}
	
	
	/**
	 * Method Name: enterTextinToTextBox Description: Method used to enter text to textfield
	 * 
	 *  * @param by
	 *          :Element locator
	 * @param  driver
	 *              : WebDriver
	 *
	 */
	
    public static void enterTextinToTextBox(WebDriver driver, By by, String str){
    driver.findElement(by).clear();
    driver.findElement(by).sendKeys(str);
    }
    
    
    /**
     * This button selects the Radio Button iFrame
     * 
     * @param driver
     *             : WebDrive instance
     */
   
	
    public static void selectRadioButton(WebDriver driver,By by, String eleName)
	{
    	WebElement ele = driver.findElement(by);
		try{
			if(!ele.isSelected())
			{
				ele.click();
		    }
		System.out.println("Successfully selected the radio Button" + eleName + "'");
		
		}
       catch (NoSuchElementException e){
			System.out.println("Exception element not present--->\n" + eleName);
			Reporter.log("<p> No such element present");
		}
		
	}
    /**
     * Method Name: mouseHoverElement Description: This is used to scroll to an 
     * element which is not visible on the screen 
     * 
     * @param driver
     *             : WebDriver
     * @param  ele
     *             : WebElement locator
     *           
     */
    public static void mouseHoverElement(WebDriver driver,WebElement ele)
    {
    	try
    	{
    		Actions act = new Actions(driver);
    		act.moveToElement(ele).build().perform();
    		//act.click().perform();
    	}
    	catch (NoSuchElementException e)
    	{
    		System.out.println("Element to mouse hover  is not present"   +  e);
    		Reporter.log("Element to mouse hover  is not present"   +  e);
    	}
    }
	
    /**
     * Method Name: mouseHoverOnElementAndClick Description: This is used to scroll to an 
     * element which is not visible on the screen / or Not Clickable by
     * GUIFunctions.clickOnElement method and clicks on it
     * 
     * @param driver
     * @param  ele
     * @param  eleName
     * @throws Exception
     *             
     */
    public static void mouseHoverElementAndClick(WebDriver driver,WebElement ele, String eleName)
    {
    	try
    	{
    		Actions act = new Actions(driver);
    		act.moveToElement(ele).build().perform();
    		act.click().perform();
    		System.out.println("Successfully mouse hover and clicked on"  + eleName);
    		Reporter.log("Successfully mouse hover and clicked on"  + eleName);
    	
    	}
    	catch (NoSuchElementException e)
    	{
    		System.out.println("Element to mouse hover and click is not present"   +  e);
    		Reporter.log("Element to mouse hover and click is not present"   +  e);
    	}
    }
    
    
    /**
     * Method Name: selectDropDownValue_new   Description: This method selects 
     * dropdown value
     * 
     * @param  ele
     *             : DropDown webelement
     * @param dropDownValue
     *             : dropDown value to be selected
     * 
     */
    
    public static void selectDropDownValue(WebElement ele, String dropDownValue, String optType)
    {
    	try{
    		// Dropdown in which value to be selected
    		Select dropDown = new Select(ele);
    		
    		// Select dropdown value
    		if(optType.equalsIgnoreCase("text"))
    		{
    			dropDown.selectByVisibleText(dropDownValue.trim());
    		}
    		else if(optType.equalsIgnoreCase("value"))
    		{
    			dropDown.selectByValue(dropDownValue);
    		}
    		else if(optType.equalsIgnoreCase("index"))
    		{
    			int dropDownValueInt = Integer.parseInt(dropDownValue);
    			dropDown.selectByIndex(dropDownValueInt);
    		}
    	}
    		catch (NoSuchElementException e)
    		{
    			System.out.println("Element to select drop down is not present"   +  e);
        		Reporter.log("Element to select drop down is not present"   +  e);
    		}
    }
    
    /**
     * Method Name: pageScrollDown  Description: This method scrolls down till
     * required pixcel
     * 
     * @param driver
     *             : WebDriver
     *             
     * @throws Exception
     */
    
    public static void pageScrollDown(WebDriver driver,int reqYaxisPixelsScroll)
    {
    	JavascriptExecutor jse = (JavascriptExecutor) driver;
    	jse.executeScript("windows.scrollBy(0," + reqYaxisPixelsScroll + ")","");
    }
    
    /**
     * Method Name: CheckOrUnchekCheckBox  Description: This method check/Uncheck the checkbox
     * 
     * @param driver
     *             : WebDriver
     *             
     * @param  By
     *             : WebElement locator
     * @param  elename
     *             : Name of the element to be checked
     * @param  toCheck
     *             : True: To check the checkbox    false: To uncheck the checkbox
     */
    public static void checkOrUncheckCheckBox(WebDriver driver, By by, String eleName, Boolean toCheck)
    {
    	try
    	{
    		if(toCheck)
    		{
    			//check checkbox if not selected
    			
    			if(!driver.findElement(by).isSelected()){
    				driver.findElement(by).click();
    				System.out.println("Successfully checked the checkbox"   +  eleName);
            		Reporter.log("Successfully checked the checkbox"   +  eleName);	
    			}
    		}else if (!toCheck){
    			if(driver.findElement(by).isSelected()){
    				driver.findElement(by).click();
    				System.out.println("Successfully unchecked the checkbox"   +  eleName);
            		Reporter.log("Successfully unchecked the checkbox"   +  eleName);	
    		}
    	}
    	} catch (NoSuchElementException e)
    	{
    		System.out.println("Checkbox Element not present"   +  e);
    		Reporter.log("Checkbox Element not present"   +  e);	
    	}
    }
public static void click(WebDriver driver, By by)
{
        try{
            driver.findElement(by).click();
        System.out.println("Successfully clicked the button "); 
        }
        
         catch (NoSuchElementException e) 
        {
             System.out.println("Button to click is not present because of" + e);
    }
    
}

// To Scroll to bottom of the page
public static void pageScrollDownToBottom(WebDriver driver)
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
}

// To switch to nextTab
public static void switchToNextTab(WebDriver driver)
{
	ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(newTb.get(1));
}

//compare strings
public static void compareStrings(WebDriver driver, String str1, String str2){

    boolean bval = str1.equalsIgnoreCase(str2);
            if(bval==true){
        System.out.println("Strings are same");
            }
        else{
            System.out.println("Strings are not same");
            Reporter.log("<p>Strings are not same");
        }          
}

// get Text
public static String getText(WebDriver driver, By by){
    try
    {
    String str = driver.findElement(by).getText();
    System.out.println("Value/message is = "+ str);
    return str;
    }
    catch(NoSuchElementException e)
    {
        System.out.println("No Such Element Exception");
    }
    return null;
}
}
