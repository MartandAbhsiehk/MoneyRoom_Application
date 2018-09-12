package com.moneyroom.test.regression;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.monetroom.utils.CreateDriver;
import com.monetroom.utils.PrintButton;
import com.monetroom.utils.PrintReceiptButton;
import com.monetroom.utils.TakeScreenshot;
import com.moneyroom.object.ui.IssueManagerSupervisorFund;
import com.moneyroom.object.ui.LoginPage;

public class IssueManagerSupervisorFundVerification 
{
	WebDriver driver;
	LoginPage login;
	IssueManagerSupervisorFund fund;
	PrintButton print;
	PrintReceiptButton printR;
	//TakeScreenshot sshot;
	
	@BeforeMethod
	public void preCondition() throws FindFailed
	{
		driver=CreateDriver.getDriverInterface();
		login=new LoginPage(driver);
		fund=new IssueManagerSupervisorFund(driver);
		//sshot= new TakeScreenshot(driver);
	}
	
	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}
	
	@Test(enabled=true,priority=1)
	public void IssueManagerSupervisorFundTest() throws IOException, FindFailed, InterruptedException
	{
		login.waitForLoginButtonToLoad();
		login.getUsernameTextbox().sendKeys("STEVEM");
		login.getPasswordTextbox().sendKeys("Welcome123!");
		login.getLoginButton().click();
		
		fund.waitForIssueManagerLinkToLoad();
		fund.getIssueManagerSupervisorLink().click();
		fund.getLocationDropDownList();
		fund.getFundIdDropDownList();
		fund.getCashHundredsTextbox().sendKeys("1");
		
		Thread.sleep(2000);
		String cashEntered="$100.00";
		fund.getContinueButton().click();
		String Totalcash=driver.findElement(By.xpath("//TABLE[@id='Content']/TBODY/TR/TD[2]/TABLE/TBODY/TR[4]/TD/CENTER/FORM/SPAN/TABLE/TBODY/TR/TD/TABLE/TBODY/TR/TD/TABLE/TBODY/TR[3]/TD[4]/SPAN ")).getText();
		String TotalCashEntered=driver.findElement(By.xpath("//TABLE[@id='Content']/TBODY/TR/TD[2]/TABLE/TBODY/TR[4]/TD/CENTER/FORM/SPAN/TABLE/TBODY/TR/TD/TABLE/TBODY/TR/TD/TABLE/TBODY/TR[3]/TD[7]/SPAN")).getText();
		
		Assert.assertEquals(cashEntered, TotalCashEntered);
		
		System.out.println("Totalcash"+Totalcash);
		System.out.println("TotalCashEntered"+TotalCashEntered);
		
		fund.getCommentTextbox().sendKeys("Manager/Supervisor Tour Fund is Issued" );
		fund.getCofirmFundsButton().click();
		
		String sucessmsg="Fund Details saved successfully";
		String getsuccessmsg=driver.findElement(By.xpath("//TABLE[@id='Content']/TBODY/TR/TD[2]/TABLE/TBODY/TR[4]/TD/CENTER/FORM/CENTER/TABLE/TBODY/TR/TD/TABLE/TBODY/TR/TD/TABLE/TBODY/TR/TD[3]")).getText();
		Assert.assertEquals(sucessmsg, getsuccessmsg);
		/*Screen s=new Screen();
		Pattern ssl =new Pattern("C:\\Users\\52001317\\eclipse-workspace\\MoneyRoomApplication\\MoneyRoomApplication\\Sikuli_Images\\PrintReceiptButton.JPG");
		s.wait(ssl,3000);
		s.click();
		//Thread.sleep(2000);
		//fund.getPrintReceiptButton().click();
		//Thread.sleep(2000);
		Screen s1=new Screen();
		Pattern ssl1 =new Pattern("C:\\Users\\52001317\\eclipse-workspace\\MoneyRoomApplication\\MoneyRoomApplication\\Sikuli_Images\\PrintButtonImg.JPG");
		s1.wait(ssl1,3000);
		s1.click();
		
		//print.getPrintButton();
		 Thread.sleep(2000);
		//login.getLogoutButton().click();*/
	     login.getLogoutButton().click();
	
		//sshot.CaptureScreenshot();
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
		String Totalcash2=driver.findElement(By.xpath("//TABLE[@id='Content']/TBODY/TR/TD[2]/TABLE/TBODY/TR[4]/TD/CENTER/FORM/SPAN/TABLE/TBODY/TR/TD/TABLE/TBODY/TR/TD/TABLE/TBODY/TR[3]/TD[4]/SPAN ")).getText();
		
		System.out.println("UpdatedTotalcash"+Totalcash2);
		
		
	}
	
	
	 
}
	

