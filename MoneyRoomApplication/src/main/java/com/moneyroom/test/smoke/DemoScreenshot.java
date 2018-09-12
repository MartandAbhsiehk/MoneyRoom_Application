package com.moneyroom.test.smoke;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.sikuli.script.FindFailed;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.monetroom.utils.CreateDriver;
import com.monetroom.utils.TakeScreenshot;
import com.moneyroom.object.ui.IssueManagerSupervisorFund;
import com.moneyroom.object.ui.LoginPage;

public class DemoScreenshot 
{
	WebDriver driver;
	LoginPage login;
	IssueManagerSupervisorFund fund;
	TakeScreenshot sshot;
	
	
	@BeforeMethod
	public void preCondition() throws FindFailed
	{
		driver=CreateDriver.getDriverInterface();
		login=new LoginPage(driver);
		fund=new IssueManagerSupervisorFund(driver);
		sshot= new TakeScreenshot(driver);
	}
	
	@Test
	public void test() throws IOException
	{
		
		
	/*System.setProperty("webdriver.ie.driver","/MoneyRoomApplication/Browser_Servers/IEDriverServer.exe");
	WebDriver driver= new InternetExplorerDriver();
	driver.get("https://10.36.88.133:9445/OpsMRWeb/jsp/sso/Login.jsp");*/
		login.waitForLoginButtonToLoad();
		login.getUsernameTextbox().sendKeys("STEVEM");
		login.getPasswordTextbox().sendKeys("Welcome123!");
		login.getLoginButton().click();
		
		fund.waitForIssueManagerLinkToLoad();
		fund.getIssueManagerSupervisorLink().click();
		fund.getLocationDropDownList();
		fund.getFundIdDropDownList();
		fund.getCashHundredsTextbox().sendKeys("1");
		fund.getContinueButton().click();
		fund.getCommentTextbox().sendKeys("Manager/Supervisor Tour Fund is Issued" );
		fund.getCofirmFundsButton().click();
		fund.getPrintReceiptButton().click();
		
		driver.switchTo().alert();
		
	
	 Date d = new Date();
     System.out.println(d.toString());

     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");         // Your each screenshot will be taken as this format "Year-Month-Date-Hours-Minutes-Seconds"
    
     TakesScreenshot ts = (TakesScreenshot)driver;
     File scrFile = ts.getScreenshotAs(OutputType.FILE);
     FileUtils.copyFile(scrFile, new File("./MoneyRoomApplication/PrintScreen_ScreenShots/hi.png"));//"+sdf.format(d)+".png"));

     driver.quit();
	}}
