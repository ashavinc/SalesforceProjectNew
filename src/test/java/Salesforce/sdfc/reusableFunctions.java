package Salesforce.sdfc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class reusableFunctions {
	static WebDriver driver;
	static ExtentTest logger;
	static ExtentReports report=new ExtentReports("C:\\Users\\Vincent Mari\\ExtentReports\\sample.html");
//	{
//		report=new ExtentReports("C:\\Users\\Vincent Mari\\ExtentReports\\sample.html");
//		String path="C:\\Users\\Vincent Mari\\ExtentReports\\sample.html";
//		report=new ExtentReports(path);
//	}
//	
	public static ExtentTest CreateTestScriptReport(String TestScriptName)
	{
		logger=report.startTest(TestScriptName);
		return logger;
	}
	
	
	/* Name of the method: enterText
	 * Brief Description: Enter Text
	 * Arguments: obj--WebObject, text--text to be entered, objname--name of the object
	 * Created by: Automation team
	 * Created Date: 7/14/2019
	 * Last modified: 7/14/2019
	 */
	public static void enterText(WebElement obj, String text, String objname)
	{
		if (obj.isEnabled()) {
			obj.sendKeys(text);
			System.out.println("Pass: "+ text + " entered is "+ objname+" field");
			logger.log(LogStatus.PASS, text + " entered is "+ objname+" field");

		}
		else
		{
			System.out.println("Fail:"+ objname + " field  not enabled, please check application");
			logger.log(LogStatus.FAIL, objname+" filed not enabled, please check the application");

		}
	}
	
	/* Name of the method: clickObj
	 * Brief Description: Click the object
	 * Arguments: obj--WebObject, objname--name of the object
	 * Created by: Automation team
	 * Created Date: 7/14/2019
	 * Last modified: 7/14/2019
	 */
	
	public static void clickObj(WebElement obj, String objname)
	{
		if(obj.isEnabled()) {
			obj.click();
			System.out.println("Pass: "+ objname +" is clicked");
			logger.log(LogStatus.PASS, objname+" is clicked");

		}
		else
		{
			System.out.println("Fail: "+ objname+ "field not enabled, please check the application");
			logger.log(LogStatus.FAIL, objname+" field not enabled, please check the application");

		}
	}
	/* Name of the method: SelectCheckbox
	 * Brief Description: Select the checkbox
	 * Arguments: obj--WebObject, objname--name of the object
	 * Created by: Automation team
	 * Created Date: 7/14/2019
	 * Last modified: 7/16/2019
	 */
	
	public static void SelectCheckbox(WebElement obj, String objname)
	{
		if(obj.isDisplayed()) {
			if(obj.isSelected()) {
				System.out.println("Pass: "+objname+" is already selected");
			}
			else
			{
			obj.click();
			System.out.println("Pass: "+ objname +" is selected");
			logger.log(LogStatus.PASS, objname+" is selected");
			}
		}
		else
		{
			System.out.println("Fail: "+ objname+ "is not present, please check the application");
			logger.log(LogStatus.FAIL, objname+" is not displayed, please check the application");
		}
	}

	public static void selectusingtext(WebElement obj,String text,String objname)
	{
		if(obj.isDisplayed()) {
			if(obj.isSelected()) {
				System.out.println("Pass: "+objname+" is already selected");
			}
			else
			{
				Select view = new Select(obj);
				view.selectByVisibleText("text");
				System.out.println("Pass: "+ objname +" is selected");
			logger.log(LogStatus.PASS, objname+" is selected");
			}
		}
		else
		{
			System.out.println("Fail: "+ objname+ "is not present, please check the application");
			logger.log(LogStatus.FAIL, objname+" is not displayed, please check the application");
		}
		
	}
public static void Selectdropdown(WebElement obj, String objname)
{
	if(obj.isDisplayed()) {
		if(obj.isSelected()) {
			System.out.println("Pass: "+objname+" is already selected");
		}
		else
		{
		obj.click();
		System.out.println("Pass: "+ objname +" is selected");
		logger.log(LogStatus.PASS, objname+" is selected");
		}
	}
	else
	{
		System.out.println("Fail: "+ objname+ "is not present, please check the application");
		logger.log(LogStatus.FAIL, objname+" is not displayed, please check the application");
	}
}

public static void switchFrame(WebDriver driver, WebElement obj)
{
	if(obj.isDisplayed()) {
		driver.switchTo().frame(obj);
		System.out.println("Pass: We can switch to"+ obj +" frame");
		logger.log(LogStatus.PASS, "Switch to frame");
	}
	else
	{
		System.out.println("Fail: We cannot switch to "+ obj + " frame ");
		logger.log(LogStatus.FAIL, "Cannot switch to frame");

	}
}
public static void switchFrameId(WebDriver driver, WebElement obj) {
	driver.switchTo().frame(obj);
	System.out.println("Pass: We can switch to"+ obj +" frame");
	logger.log(LogStatus.PASS, "Switch to frame");
}

public static void switchdefaultFrame(WebDriver driver) {
	driver.switchTo().defaultContent();
	System.out.println("Pass: We can switch "+driver+" back to frame");
	logger.log(LogStatus.PASS, "Switch back to the frame");
}


}
