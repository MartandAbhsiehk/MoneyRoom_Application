package com.moneyroom.test.regression;

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
import com.monetroom.utils.MainMenuButton;
import com.monetroom.utils.ReturnCollectorTourFund;
import com.moneyroom.object.ui.LoginPage;

public class ReturnCollectorTourFundVerification 
{
	WebDriver driver;
	LoginPage login;
	ReturnCollectorTourFund rFund;
	MainMenuButton mButton;
	
	@BeforeMethod
	public void preCondition() throws FindFailed
	{
		driver=CreateDriver.getDriverInterface();
		login=new LoginPage(driver);
		rFund=new ReturnCollectorTourFund(driver);
		mButton=new MainMenuButton(driver);
	}
	
	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}
	
	@Test
	public void ReturnCollectorTourFundTest() throws FindFailed
	{
		login.waitForLoginButtonToLoad();
		login.getUsernameTextbox().sendKeys("JONESD");
		login.getPasswordTextbox().sendKeys("Welcome1!");
		login.getLoginButton().click();
		
		rFund.getReturnCollectorTourFundLink().click();
		rFund.getlocationidDropdownlist();
		rFund.getFundTypeDropDownList();
		rFund.getEmployeeIdDropDownList();
		rFund.getCashHundredsTextbox().sendKeys("1");
		rFund.getContinueButton().click();
		rFund.getcommentsTextBox().sendKeys("Tour Fund Returned Sucessfully");
		rFund.getConfirmationFundButton().click();
		
		String sucessmsg="Fund Details saved successfully";
		String getsuccessmsg=driver.findElement(By.xpath("//TABLE[@id='Content']/TBODY/TR/TD[2]/TABLE/TBODY/TR[4]/TD/CENTER/FORM/CENTER/TABLE/TBODY/TR/TD/TABLE/TBODY/TR/TD/TABLE/TBODY/TR/TD[3]")).getText();
		Assert.assertEquals(sucessmsg, getsuccessmsg);
		
		
		String FundTotal=driver.findElement(By.xpath("//TABLE[@id='Content']/TBODY/TR/TD[2]/TABLE/TBODY/TR[4]/TD/CENTER/FORM/SPAN/TABLE/TBODY/TR/TD/TABLE/TBODY/TR/TD/TABLE/TBODY/TR[3]/TD[4]/SPAN ")).getText();
		String TotalCashEntered=driver.findElement(By.xpath("//TABLE[@id='Content']/TBODY/TR/TD[2]/TABLE/TBODY/TR[4]/TD/CENTER/FORM/SPAN/TABLE/TBODY/TR/TD/TABLE/TBODY/TR/TD/TABLE/TBODY/TR[3]/TD[7]/SPAN")).getText();
		Assert.assertEquals(FundTotal, TotalCashEntered);
		
		System.out.println("Total Fund : "+FundTotal);
		System.out.println("Total Cash Entered : "+TotalCashEntered);
		
		String IssuedFrom=driver.findElement(By.xpath("//TABLE[@id='Content']/TBODY/TR/TD[2]/TABLE/TBODY/TR[4]/TD/CENTER/FORM/SPAN/TABLE/TBODY/TR/TD/TABLE/TBODY/TR/TD/TABLE/TBODY/TR[1]/TD[4]/SPAN ")).getText();
		String IssuedTo=driver.findElement(By.xpath("//TABLE[@id='Content']/TBODY/TR/TD[2]/TABLE/TBODY/TR[4]/TD/CENTER/FORM/SPAN/TABLE/TBODY/TR/TD/TABLE/TBODY/TR/TD/TABLE/TBODY/TR[1]/TD[7]/SPAN")).getText();
		
		System.out.println("Issued From : "+IssuedFrom);
		System.out.println("Issued To : "+IssuedTo);
		
		System.out.println(getsuccessmsg);
		System.out.println("Returned $100 Tour Fund Sucessfully");
		login.getLogoutButton();
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
		s1.click();*/
		//rFund.getPrintReceiptButton().click();
		
	}
}
