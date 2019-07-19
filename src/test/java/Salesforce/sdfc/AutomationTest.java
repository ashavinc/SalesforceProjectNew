package Salesforce.sdfc;

import java.io.IOException;
import java.util.Set;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
	@Test (priority=1)
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
		
		System.out.println("TC3_CheckRememberme is completed");

	}

	@Test 
	public static void tc_06() throws InterruptedException {
	//to select myprofile
		
		WebElement mousehover=driver.findElement(By.id("userNavButton"));
		Actions act=new Actions(driver);
		act.moveToElement(mousehover).build().perform();
		
		clickObj(mousehover, "mousehover");

	WebElement profiledropdown=driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
	act.moveToElement(profiledropdown).build().perform();
	clickObj(profiledropdown,"profile");
	//profiledropdown.click();
	
	
	//edit contact
	WebElement editbutton=driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img"));
	clickObj(editbutton, "Editbutton");
	//editbutton.click();
	Thread.sleep(5000);
	
	//move to About tab
	driver.switchTo().frame("contactInfoContentId");
	WebElement abouttab=driver.findElement(By.xpath("//li[@id='aboutTab']"));
	clickObj(abouttab, "Abouttab");	
	//abouttab.click();
		Thread.sleep(5000);
    
	//edit lastname
	WebElement lastnameedit=driver.findElement(By.xpath("//input[@id='lastName']"));
	lastnameedit.clear();
	lastnameedit.sendKeys("gfdgdfg");
	Thread.sleep(5000);
	
	//save all button
	WebElement saveallbutton=driver.findElement(By.xpath("//input[@class='zen-btn zen-primaryBtn zen-pas']"));
	clickObj(saveallbutton, "SaveAll");
	//saveallbutton.click();
	Thread.sleep(5000);
	
	
	//post
	WebElement post=driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'Post')]"));
	clickObj(post, "post");
	//post.click();
	Thread.sleep(3000);
	
	WebElement frame=driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
	switchFrame(driver,frame);
	//driver.switchTo().frame(frame);
	
	String message="India wins";
	WebElement textbox=driver.findElement(By.xpath("/html[1]/body[1]"));
	textbox.sendKeys(message);
	driver.switchTo().defaultContent();
	Thread.sleep(5000);

	WebElement sharebutton=driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
	clickObj(sharebutton, "Sharebutton");
	//sharebutton.click();
	Thread.sleep(5000);
	
	WebElement file = driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'File')]"));
	clickObj(file, "file");
	//file.click();
	WebElement fileuploadbutton=driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']"));
	clickObj(fileuploadbutton,"fileupload");
	//fileuploadbutton.click();
	
	WebElement choosefile=driver.findElement(By.xpath("//input[@id='chatterFile']"));
	choosefile.sendKeys("C:\\Users\\Vincent Mari\\Documents\\file.txt");
	
	WebElement share=driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
	share.click();
	Thread.sleep(5000);
	
	WebElement photoupload=driver.findElement(By.xpath("//span[@id='displayBadge']"));
	photoupload.click();
	driver.switchTo().frame("uploadPhotoContentId");
	Thread.sleep(5000);

	
	WebElement choosepicfile=driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadInputFile']"));
	choosepicfile.sendKeys("C:\\Users\\Vincent Mari\\140.jpg");
    Thread.sleep(5000);
		
//  Runtime.getRuntime().exec("C:\\Users\\Vincent Mari\\AutoIt\\ImageUpload.exe");		
//   Thread.sleep(5000);
//
    WebElement savephoto=driver.findElement(By.xpath("//input[@id='j_id0:j_id7:save']"));
    savephoto.click();
    Thread.sleep(3000);
	}

    @Test
    public static void tc_07() throws InterruptedException{
	
    WebElement mousehover2=driver.findElement(By.id("userNavButton"));
	Actions act2=new Actions(driver);
	act2.moveToElement(mousehover2).build().perform();
	mousehover2.click();
	Thread.sleep(5000);
	WebElement mysettings=driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
	act2.moveToElement(mysettings).build().perform();
	mysettings.click();
	Thread.sleep(5000);
	
	WebElement personal=driver.findElement(By.xpath("//div[@id='PersonalInfo']//a[@class='header setupFolder']"));
	personal.click();
	Thread.sleep(5000);
	
	WebElement loginhistory=driver.findElement(By.xpath("//span[@id='LoginHistory_font']"));
	loginhistory.click();
	Thread.sleep(5000);
	
	//WebElement downloadloginhistory=driver.findElement(By.linkText("Download login history for last six months, including logins from outside the website, such as API logins (Excel .csv file) »"));
	//downloadloginhistory.click();
	
	WebElement displaylayout=driver.findElement(By.xpath("//div[@id='DisplayAndLayout']//a[@class='header setupFolder']"));
	displaylayout.click();
	
	WebElement mytabs=driver.findElement(By.xpath("//a[@id='CustomizeTabs_font']"));
	mytabs.click();
	
	
	WebElement customApp=driver.findElement(By.xpath("//select[@id='p4']"));
	Select chatter=new Select(customApp);
	chatter.selectByValue("02u4P0000017iUY");
	Thread.sleep(5000);
	
	WebElement availableTabs=driver.findElement(By.xpath("//select[@id='duel_select_0']"));
	Select reportselect=new Select(availableTabs);
	reportselect.selectByValue("report");
	Thread.sleep(5000);
	
	
	WebElement addarrow=driver.findElement(By.xpath("//img[@class='rightArrowIcon']"));
	addarrow.click();
	Thread.sleep(5000);
		
	WebElement email=driver.findElement(By.xpath("//div[@id='EmailSetup']//a[@class='header setupFolder']"));
	email.click();
	
	
	WebElement emailsettings=driver.findElement(By.xpath("//div[@id='EmailSetup']//a[@class='header setupFolder']"));
	emailsettings.click();
	
//	WebElement calendersremainders=driver.findElement(By.xpath("//span[@id='CalendarAndReminders_font']"));
//	calendersremainders.click();
//	Thread.sleep(5000);
//	WebElement reminders=driver.findElement(By.xpath("//span[@id='Reminders_font']"));
//	reminders.click();
//		Thread.sleep(5000);
//	
//	WebElement reminderbutton=driver.findElement(By.xpath("//input[@id='testbtn']"));
//	reminderbutton.click();
	Thread.sleep(5000);
	}
    
    @Test
    public static void tc_08() {
//	
//	WebElement mousehover3=driver.findElement(By.id("userNavButton"));
//	Actions act3=new Actions(driver);
//	act3.moveToElement(mousehover2).build().perform();
//	mousehover3.click();
//	Thread.sleep(5000);
//	WebElement developerconsole=driver.findElement(By.xpath("//a[@class='debugLogLink menuButtonMenuLink']"));
//	act3.moveToElement(developerconsole).build().perform();
//	developerconsole.click();
//	Thread.sleep(5000);
    }

	
	@Test
 public static void tc_09() {    
//	WebElement mousehover4=driver.findElement(By.id("userNavButton"));
//	Actions act4=new Actions(driver);
//	act4.moveToElement(mousehover2).build().perform();
//	mousehover4.click();
	
//	Thread.sleep(5000);
//	WebElement logout=driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
//	act4.moveToElement(logout).build().perform();
//	logout.click();
//	Thread.sleep(5000);
	}

//--------------------------------------------------------------------------------------
	
	@Test
	public static void tc_10() {
	WebElement Mousehover=driver.findElement(By.id("Account_Tab"));
	Actions actn=new Actions(driver);
	actn.moveToElement(Mousehover).build().perform();
	
	WebElement Accountswitchto=driver.findElement(By.xpath("//li[@id='Account_Tab']"));
	actn.moveToElement(Accountswitchto).build().perform();
	Accountswitchto.click();
	WebElement newbutton=driver.findElement(By.xpath("//input[@name='new']"));
	newbutton.click();
	}
	
	@Test
	public static void tc_11() throws InterruptedException {
	WebElement accountname=driver.findElement(By.xpath("//input[@id='acc2']"));
	accountname.sendKeys("Ashley");
	Thread.sleep(3000);
	WebElement savebutton=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@name='save']"));
	savebutton.click();
	WebElement createnewview=driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
	createnewview.click();
	}
	
	@Test
	public static void tc_12() throws InterruptedException {
	
	WebElement viewname=driver.findElement(By.xpath("//input[@id='fname']"));
	viewname.sendKeys("Ash");
	WebElement viewUniquename=driver.findElement(By.xpath("//input[@id='devname']"));
	viewUniquename.sendKeys("Vinc");
	Thread.sleep(3000);
	WebElement save=driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']"));
	save.click();
	
	WebElement viewdropdown=driver.findElement(By.xpath("//select[@id='is:islv:inlineSchedulerListView:enhancedList_listSelect']"));
	selectusingtext(viewdropdown,"Ash", "Dropdown");
	
//	Select view = new Select(viewdropdown);
//	view.selectByVisibleText("Ash");
	
	Thread.sleep(3000);
	WebElement edit=driver.findElement(By.xpath("//a[contains(text(),'Edit')]"));
	edit.click();
	
	WebElement newviewname=driver.findElement(By.xpath("//input[@id='devname']"));
	newviewname.sendKeys("newAsh");
	
	WebElement fielddropdown=driver.findElement(By.xpath("//select[@id='fcol1']"));
	Select field=new Select(fielddropdown);
	field.selectByVisibleText("Account Name");
	
	WebElement operatordropdown=driver.findElement(By.xpath("//select[@id='fop1']"));
	Select operator=new Select(operatordropdown);
	operator.selectByVisibleText("equals");
	
	WebElement value=driver.findElement(By.xpath("//input[@id='fval1']"));
	value.sendKeys("a");
	
	WebElement availablefields=driver.findElement(By.xpath("//select[@id='colselector_select_0']//option[contains(text(),'Last Activity')]"));
	availablefields.click();
	
	WebElement addarrow1=driver.findElement(By.xpath("//img[@class='rightArrowIcon']"));
	addarrow1.click();
	
	WebElement savebtn=driver.findElement(By.cssSelector("body.hasMotif.accountTab.filterEdit.FilterEditPage.sfdcBody.brandQuaternaryBgr:nth-child(2) div.bodyDiv.brdPalette.brandPrimaryBrd:nth-child(2) table.outer td.oRight div.bPageBlock.brandSecondaryBrd.bEditBlock.secondaryPalette:nth-child(3) div.pbHeader:nth-child(11) table:nth-child(1) tbody:nth-child(1) tr:nth-child(1) td.pbButtonb > input.btn.primary:nth-child(1)"));
	savebtn.click();
	}
	//--------------------------------------------------------------------------------------------------------------------------
	@Test
	public static void tc_13() throws InterruptedException {
	
	WebElement MergeAccount=driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"));
	MergeAccount.click();
	
	WebElement findaccount=driver.findElement(By.xpath("//input[@id='srch']"));
	findaccount.sendKeys("ash");
	
	WebElement findaccountbtn=driver.findElement(By.xpath("//div[@class='pbWizardBody']//input[@name='srchbutton']"));
	findaccountbtn.click();
	
	boolean x = driver.findElement(By.xpath("//input[@id='cid0']")).isSelected();
	if(x==false)
	driver.findElement(By.xpath("//input[@id='cid0']")).click();
	
	boolean y=driver.findElement(By.xpath("//input[@id='cid1']")).isSelected();
	if(y==false)
	driver.findElement(By.xpath("//input[@id='cid1']")).click();
	
	
	WebElement nextbtn=driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@name='goNext']"));
	nextbtn.click();
	Thread.sleep(2000);
	
	WebElement mergeButton=driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@name='save']"));
	mergeButton.click();
	Thread.sleep(3000);

	driver.switchTo().alert().accept();
}

	//create account report
	@Test
	public static void tc_14() {
	WebElement Acclastactivity=driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]"));
	Acclastactivity.click();
	
	WebElement datefieldDropdown=driver.findElement(By.xpath("//input[@id='ext-gen20']"));
	Select date=new Select(datefieldDropdown);
	date.selectByVisibleText("Created Date");
	
	
	WebElement fromdate=driver.findElement(By.xpath("//img[@id='ext-gen152']"));
	fromdate.click();
	WebElement todaysdate=driver.findElement(By.xpath("//button[@id='ext-gen283']"));
	todaysdate.click();
	WebElement fdate=driver.findElement(By.xpath("//input[@id='ext-comp-1042']"));
	
	WebElement Todate=driver.findElement(By.xpath("//img[@id='ext-gen154']"));
	Todate.click();
	WebElement todaydate=driver.findElement(By.xpath("//button[@id='ext-gen301']"));
	todaydate.click();
	
	WebElement savereport=driver.findElement(By.xpath("//button[@id='ext-gen49']"));
	savereport.click();
	
	WebElement reportname=driver.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']"));
	reportname.sendKeys("reportSample");
	WebElement reportuniquename=driver.findElement(By.xpath("//input[@id='saveReportDlg_DeveloperName']"));
	reportuniquename.sendKeys("SampleReport");
	
	WebElement saveandRunReport=driver.findElement(By.xpath("//button[@id='ext-gen336']"));
	saveandRunReport.click();
	
	
}
	
	//-----------------------------------------------------------------------------------------------
	//-----Opportunities Tab-----------------------------------------------------------------

	@Test
	public static void tc_15() throws InterruptedException {
	WebElement hover=driver.findElement(By.id("Opportunity_Tab"));
	Actions actOppty=new Actions(driver);
	actOppty.moveToElement(hover).build().perform();
	
	WebElement Opportunityswitchto=driver.findElement(By.xpath("//li[@id='Opportunity_Tab']"));
	actOppty.moveToElement(Opportunityswitchto).build().perform();
	Opportunityswitchto.click();
	Thread.sleep(3000);
	}
	
	@Test
	public static void tc_16() throws InterruptedException {
	WebElement viewopportunites=driver.findElement(By.xpath("//select[@id='fcf']"));
	viewopportunites.click();
	Thread.sleep(3000);
	}
	
	@Test
	public static void tc_17() throws InterruptedException {
	WebElement pipeline=driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"));
	pipeline.click();
	Thread.sleep(3000);
	}
	
	@Test
	public static void tc_18() throws InterruptedException {
	WebElement stuckoppor=driver.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]"));
	stuckoppor.click();
	Thread.sleep(3000);  
	}
		
	//quarterly report
	@Test
	public static void tc_19() throws InterruptedException {
	WebElement currentfqdropdown=driver.findElement(By.xpath("//select[@id='quarter_q']"));
	currentfqdropdown.click();
	Select currentfq=new Select(currentfqdropdown);
	currentfq.selectByVisibleText("Current FQ");
	Thread.sleep(3000);

	WebElement alloppodropdown=driver.findElement(By.xpath("//select[@id='open']"));
	alloppodropdown.click();
	Select alloppor=new Select(alloppodropdown);
	alloppor.selectByVisibleText("Open Opportunities");
	Thread.sleep(3000);
	
	WebElement runreport=driver.findElement(By.xpath("//table[@class='opportunitySummary']//input[@name='go']"));
	runreport.click();

	Thread.sleep(3000);  
	}
	//------------------------------------------------------------------------------------
	
//----------Leads Tab-----------------------------------------------------------------
	@Test
	public static void tc_20() throws InterruptedException
	{
	Actions leadact=new Actions(driver);
	leadact.build().perform();
	
	WebElement leadstab=driver.findElement(By.xpath("//li[@id='Lead_Tab']"));
	leadact.moveToElement(leadstab).build().perform();
	leadstab.click();
	Thread.sleep(3000);
	}
	
	@Test
	public static void tc_21() throws InterruptedException
	{

	WebElement LeadDropdown=driver.findElement(By.xpath("//select[@id='fcf']"));
	LeadDropdown.click();
	Select ld=new Select(LeadDropdown);
	ld.selectByVisibleText("Today's Leads");
	Thread.sleep(3000);
	}
	
	@Test
	public static void tc_22()
	{
		WebElement LeadDropdown=driver.findElement(By.xpath("//select[@id='fcf']"));
		LeadDropdown.click();
		Select ld=new Select(LeadDropdown);
		ld.selectByVisibleText("Today's Leads");
		WebElement Gobutton=driver.findElement(By.xpath("//span[@class='fBody']//input[@name='go']"));
		Gobutton.click();
	}
	
	@Test
	public static void tc_23() throws InterruptedException {
		
	WebElement leadsNew=driver.findElement(By.xpath("//input[@name='new']"));
	leadsNew.click();
	}
	
	@Test
	public static void tc_24() throws InterruptedException {

	WebElement leadslastname=driver.findElement(By.xpath("//input[@id='name_lastlea2']"));
	leadslastname.sendKeys("ABCD");
	
	WebElement leadscompanyname=driver.findElement(By.xpath("//input[@id='lea3']"));
	leadscompanyname.sendKeys("ABCD");
	Thread.sleep(3000);
	
	WebElement leadsSave=driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[1]"));
	leadsSave.click();
	Thread.sleep(3000);
	}
//---------------------------------------------------------------------------------------------------------
	@Test
	public static void tc_25() throws InterruptedException {
	
	Actions ContactAct=new Actions(driver);
	ContactAct.build().perform();
	
	WebElement ContactsTab=driver.findElement(By.xpath("//li[@id='Contact_Tab']"));
	ContactAct.moveToElement(ContactsTab).build().perform();
	ContactsTab.click();
	Thread.sleep(3000);
	}
	@Test
	public static void tc_26() {

	WebElement createnewview=driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
	createnewview.click();
	
	WebElement viewname=driver.findElement(By.xpath("//input[@id='fname']"));
	viewname.sendKeys("rsrsr");
	
	WebElement viewuniquename=driver.findElement(By.xpath("//input[@id='devname']"));
	viewuniquename.sendKeys("trtr");
	WebElement savenewview=driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']"));
	savenewview.click();
	}
	
	@Test
	public static void tc_27() throws InterruptedException {
	
	WebElement recentlyvieweddropdown=driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
	Select sl=new Select(recentlyvieweddropdown);
	recentlyvieweddropdown.click();
	sl.selectByVisibleText("Recently Created");
	Thread.sleep(3000);
	}
	
	@Test
	public static void tc_28() throws InterruptedException {
	
	//TC28
	WebElement dropdown=driver.findElement(By.xpath("//select[@id='fcf']"));
	Select s2=new Select(dropdown);
	dropdown.click();
	s2.selectByVisibleText("My Contacts");
	Thread.sleep(3000);
	}
	
	//TC29
	@Test
	public static void tc_29() throws InterruptedException {

	WebElement contactlink=driver.findElement(By.xpath("//a[contains(text(),'Amos (Sample), Jon')]"));
	contactlink.click();
	Thread.sleep(3000);
	}
	
	//TC30
	@Test
	public static void tc_30() throws InterruptedException {

	WebElement createnewview=driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
	createnewview.click();
	WebElement viewuniquename=driver.findElement(By.xpath("//input[@id='devname']"));
	viewuniquename.sendKeys("uuuu");
	WebElement savenewview=driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']"));
	savenewview.click();
	Thread.sleep(3000);
	}
	
	//TC31
	@Test
	public static void tc_31() throws InterruptedException {

	WebElement createnewview=driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
	createnewview.click();
	
	WebElement viewname=driver.findElement(By.xpath("//input[@id='fname']"));
	viewname.sendKeys("rsrsr");
	
	WebElement viewuniquename=driver.findElement(By.xpath("//input[@id='devname']"));
	viewuniquename.sendKeys("uuuu");
	WebElement cancelnewview=driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='cancel']"));
	cancelnewview.click();
	Thread.sleep(3000);
	}
	
	//TC32
	@Test
	public static void tc_32() throws InterruptedException {

	WebElement newcontact=driver.findElement(By.xpath("//input[@name='new']"));
	newcontact.click();
	WebElement lastnamenew=driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
	lastnamenew.sendKeys("Indian");
	WebElement acctname=driver.findElement(By.xpath("//input[@id='con4']"));
	acctname.sendKeys("Global Media");
	WebElement savenew=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@name='save_new']"));
	savenew.click();
	Thread.sleep(3000);
	}
	
	
	//----------------------------------------------------------------------------------
	
	//TC33
	@Test
	public static void tc_33() throws InterruptedException {

	WebElement namelink=driver.findElement(By.xpath("//h1[@class='currentStatusUserName']//a[contains(text(),'Merlyn Abcd')]"));
	namelink.click();
	Thread.sleep(3000);
	}
	//TC34
	@Test
	public static void tc_34() throws InterruptedException {

	WebElement moderatorbutton=driver.findElement(By.xpath("//a[@id='moderatorMutton']"));
	moderatorbutton.click();
	WebElement editprofile=driver.findElement(By.xpath("//a[contains(text(),'Edit Profile')]"));
	editprofile.click();
	driver.switchTo().frame("aboutMeContentId");
	WebElement lname=driver.findElement(By.xpath("//input[@id='lastName']"));
	lname.clear();
	lname.sendKeys("Abcd");
	WebElement saveall=driver.findElement(By.xpath("//input[@class='zen-btn zen-primaryBtn zen-pas']"));
	saveall.click();

	Thread.sleep(3000);
	}
	
	//TC35
	@Test
	public static void tc_35() throws InterruptedException {

	Actions actalltabs=new Actions(driver);
	actalltabs.build().perform();
	
	WebElement alltabs=driver.findElement(By.xpath("//li[@id='AllTab_Tab']"));
	actalltabs.moveToElement(alltabs).build().perform();
	alltabs.click();
	Thread.sleep(3000);
	
	WebElement customise=driver.findElement(By.xpath("//input[@name='customize']"));
	customise.click();
	
	WebElement reportstab=driver.findElement(By.xpath("//option[contains(text(),'Reports')]"));
	reportstab.click();
	Thread.sleep(3000);

	WebElement leftarrow=driver.findElement(By.xpath("//img[@class='leftArrowIcon']"));
	leftarrow.click();
	
	WebElement svebtn=driver.findElement(By.xpath("//input[@name='save']"));
	svebtn.click();
	Thread.sleep(3000);
	
	WebElement usermenu=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
	Actions actlogout=new Actions(driver);
	actlogout.moveToElement(usermenu).build().perform();
	usermenu.click();
	Thread.sleep(3000);
	
	WebElement lgout=driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
	actlogout.moveToElement(lgout).build().perform();
	lgout.click();
	Thread.sleep(3000);
	}
	
	//-----------------------------------------------------------------------------------------------------------------
	
	//TC36
	@Test
	public static void tc_36() throws InterruptedException {

	WebElement clock=driver.findElement(By.cssSelector("body.hasMotif.homeTab.homepage.ext-webkit.ext-chrome.sfdcBody.brandQuaternaryBgr:nth-child(2) div.bodyDiv.brdPalette.brandPrimaryBrd:nth-child(2) table.outer td.oRight div.bPageTitle:nth-child(2) div.ptBody.secondaryPalette div.greeting:nth-child(2) div.content span.pageDescription > a:nth-child(1)"));
	clock.click();
	Thread.sleep(3000);
	
	WebElement eightpm=driver.findElement(By.xpath("//a[contains(text(),'8:00 PM')]"));
	eightpm.click();
	Thread.sleep(3000);
	
	WebElement subjectcombo=driver.findElement(By.xpath("//img[@class='comboboxIcon']"));
	subjectcombo.click();
	Thread.sleep(5000);
	
	String parentWindow = driver.getWindowHandle();
	Set<String> handles =  driver.getWindowHandles();
	   for(String windowHandle  : handles)
	       {
	       if(!windowHandle.equals(parentWindow))
	          {
	          driver.switchTo().window(windowHandle);
	          
	        // <!--Perform your operation here for new window-->
	         Actions atn = new Actions(driver);
	        WebElement others=driver.findElement(By.xpath("//a[contains(text(),'Other')]"));
	        atn.contextClick(others).perform();
	        others.click();
	        Thread.sleep(3000);
	        // driver.close(); //closing child window
	         driver.switchTo().window(parentWindow); //cntrl to parent window
		        Thread.sleep(3000);

	          }
	       }	
	// Switch back to original browser (first window)
	
	 //driver.switchTo().defaultContent();
	WebElement endtime=driver.findElement(By.xpath("//input[@id='EndDateTime_time']"));
	endtime.click();

driver.findElement(By.xpath("//div[@id='timePickerItem_42']")).click();

	//Select sel=new Select(endtime);
	//sel.selectByVisibleText("9:00 PM");
	Thread.sleep(3000);

	
	WebElement saveb=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@name='save']"));
	saveb.click();
	Thread.sleep(3000);
	}
	
	//--------------------------------------------------------------------------------------------------
	
	//TC37
	@Test
	public static void tc_37() throws InterruptedException {

	WebElement clk=driver.findElement(By.cssSelector("body.hasMotif.homeTab.homepage.ext-webkit.ext-chrome.sfdcBody.brandQuaternaryBgr:nth-child(2) div.bodyDiv.brdPalette.brandPrimaryBrd:nth-child(2) table.outer td.oRight div.bPageTitle:nth-child(2) div.ptBody.secondaryPalette div.greeting:nth-child(2) div.content span.pageDescription > a:nth-child(1)"));
	clk.click();
	Thread.sleep(3000);
	
	WebElement fourpm=driver.findElement(By.xpath("//a[contains(text(),'4:00 PM')]"));
	fourpm.click();
	Thread.sleep(3000);

	WebElement sbjectcombo=driver.findElement(By.xpath("//img[@class='comboboxIcon']"));
	sbjectcombo.click();
	Thread.sleep(5000);
	String parentwindow = driver.getWindowHandle();
	Set<String> handle =  driver.getWindowHandles();
	   for(String windowHandle  : handle)
	       {
	       if(!windowHandle.equals(parentwindow))
	          {
	          driver.switchTo().window(windowHandle);
	          
	        // <!--Perform your operation here for new window-->
	         Actions actt = new Actions(driver);
	        WebElement others=driver.findElement(By.xpath("//a[contains(text(),'Other')]"));
	        actt.contextClick(others).perform();
	        others.click();
	        Thread.sleep(3000);
	        // driver.close(); //closing child window
	         driver.switchTo().window(parentwindow); //cntrl to parent window
		        Thread.sleep(3000);

	          }
	       }	
	// Switch back to original browser (first window)
	
	WebElement endtme=driver.findElement(By.xpath("//input[@id='EndDateTime_time']"));
	endtme.click();
	driver.findElement(By.xpath("//div[@id='timePickerItem_38']")).click();
	Thread.sleep(3000);

	WebElement recurrence=driver.findElement(By.xpath("//input[@id='IsRecurrence']"));
	recurrence.click();
	Thread.sleep(3000);
	
	WebElement weekly=driver.findElement(By.xpath("//input[@id='rectypeftw']"));
	weekly.click();
	Thread.sleep(3000);
	
	WebElement recurrenceenddate=driver.findElement(By.xpath("//input[@id='RecurrenceEndDateOnly']"));
	recurrenceenddate.click();
	Thread.sleep(3000);
	
	WebElement selectdate=driver.findElement(By.xpath("//a[@class='calToday']"));
	selectdate.click();
	Thread.sleep(3000);
	
	WebElement setreminder=driver.findElement(By.xpath("//select[@id='reminder_lt']"));
	setreminder.click();
	Thread.sleep(3000);

	WebElement twoweeks=driver.findElement(By.xpath("//select[@id='reminder_lt']//option[contains(text(),'2 weeks')]"));
	twoweeks.click();
	Thread.sleep(3000);

	WebElement svbutton=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@name='save']"));
	svbutton.click();
	Thread.sleep(3000);
	}
	//-------------------------------------------------------------------------------------------------------
	
	//TC38
	@Test
	public static void tc_38() {

	WebElement setuplink=driver.findElement(By.xpath("//a[@id='setupLink']"));
	setuplink.click();
	WebElement getstartedbutton=driver.findElement(By.xpath("//a[contains(text(),'Get Started')]"));
	getstartedbutton.click();
	
	}


	
		
	}
	
