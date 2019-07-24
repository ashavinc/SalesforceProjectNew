package Salesforce.sdfc;


	import java.io.IOException;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.junit.BeforeClass;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.*;
	import org.testng.annotations.Test;

	import com.relevantcodes.extentreports.*;

	public class phase1 extends reusableFunctions {
		
		static WebDriver driver;
		
		@AfterClass
		public static void logger()
		{
		reusableFunctions.report.endTest(logger);
			reusableFunctions.report.flush();
		}
		
		
		
		public static void initialize_driver() {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Vincent Mari\\drivers\\chromedriver_win32 (1)\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		}
		
		public static void launchUrl() {
			initialize_driver();
			driver.get("https://login.salesforce.com/");
			driver.manage().window().maximize();
			System.out.println("Salesforce application opened");
		}
		
		
		@Test (priority=1)
		public static void TC2_loginError() throws IOException, InterruptedException{
			CreateTestScriptReport("TC2_loginError");
			launchUrl();
			Thread.sleep(3000);
			WebElement username=driver.findElement(By.id("username"));
			enterText(username,"marydeenaasha80-wfks@force.com","UserName");
			Thread.sleep(3000);
			WebElement login=driver.findElement(By.id("Login"));
			clickObj(login, "Login");
			System.out.println("TC2_loginError is completed");
			driver.close();


		}
		@Test (priority=2)
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
			
			System.out.println("TC1_login is completed");
			driver.close();


		}

		@Test (priority=3)
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
			
			System.out.println("TC3_CheckRememberme is completed");
			driver.close();


		}


}
