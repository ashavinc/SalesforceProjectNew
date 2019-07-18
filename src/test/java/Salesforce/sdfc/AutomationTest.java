package Salesforce.sdfc;

import java.io.IOException;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.*;

public class AutomationTest extends reusableFunctions {
	
	static WebDriver driver;
	
//	public static void main(String[] args) throws IOException, InterruptedException {
//		launchUrl();
//		login();
//		TC1_login();
//		TC2_loginError();
//		TC3_CheckRememberme();
//		
//	}
	
	@AfterClass
	public static void logger()
	{
		reusableFunctions.report.endTest(logger);
		reusableFunctions.report.flush();
	}
	
	public static void initialize_driver() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Vincent Mari\\drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@Test 
	public static void launchUrl() {
		initialize_driver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		System.out.println("Salesforce application opened");
	}
	@Test 
	public static void login() throws InterruptedException {
		
		CreateTestScriptReport("login");
		launchUrl();
		Thread.sleep(3000);
		WebElement username=driver.findElement(By.id("username"));
		enterText(username,"marydeenaasha80-wfks@force.com","UserName");
		Thread.sleep(3000);
		WebElement password=driver.findElement(By.id("password"));
		enterText(password,"salesforce1","Password");
		Thread.sleep(3000);
		WebElement login=driver.findElement(By.id("Login"));
		clickObj(login, "Login");
		driver.close();
	}
	@Test 
	public static void TC2_loginError() throws IOException, InterruptedException{
		CreateTestScriptReport("TC2_loginError");
		launchUrl();
		Thread.sleep(3000);
		WebElement username=driver.findElement(By.id("username"));
		enterText(username,"marydeenaasha80-wfks@force.com","UserName");
		Thread.sleep(3000);
		WebElement login=driver.findElement(By.id("Login"));
		clickObj(login, "Login");
		driver.close();
		System.out.println("TC2_loginError is completed");

	}
	@Test 
	public static void TC1_login() throws IOException, InterruptedException{
		CreateTestScriptReport("TC1_login");
		launchUrl();
		WebElement username=driver.findElement(By.id("username"));
		enterText(username,"marydeenaasha80-wfks@force.com","UserName");
		WebElement password=driver.findElement(By.id("password"));
		password.clear();
		enterText(password,"salesforce1","Password");
		WebElement login=driver.findElement(By.id("Login"));
		clickObj(login, "Login");
		
		driver.close();
		System.out.println("TC1_login is completed");

	}

	@Test
	public static void TC3_CheckRememberme() throws IOException, InterruptedException{
		CreateTestScriptReport("TC3_CheckRememberme");
		launchUrl();
		Thread.sleep(3000);
		WebElement rememberme=driver.findElement(By.xpath("//input[@id='rememberUn']"));
		SelectCheckbox(rememberme, "RememberMe");
		WebElement username=driver.findElement(By.id("username"));
		enterText(username,"marydeenaasha80-wfks@force.com","UserName");
		WebElement password=driver.findElement(By.id("password"));
		password.clear();
		enterText(password,"salesforce1","Password");
		Thread.sleep(3000);
		WebElement login=driver.findElement(By.id("Login"));
		clickObj(login, "Login");
		Thread.sleep(3000);
		
		driver.close();
		System.out.println("TC3_CheckRememberme is completed");

	}

	
	
		
	}
	
