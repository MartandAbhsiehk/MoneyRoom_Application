package com.moneyroom.test.regression;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
import com.monetroom.utils.PrintButton;
import com.monetroom.utils.TakeScreenshot;
import com.moneyroom.object.ui.IssueCollectorTourFund;
import com.moneyroom.object.ui.LoginPage;

public class IssueCollectorTourFundVerification
{
	WebDriver driver;
	LoginPage login;
	IssueCollectorTourFund Ifund;
	PrintButton print;
	MainMenuButton mbutton;
	
	//TakeScreenshot tks;
	@BeforeMethod
	public void preConditions() throws FindFailed
	{
	 driver=CreateDriver.getDriverInterface();	
	 login=new LoginPage(driver);
	 Ifund=new IssueCollectorTourFund(driver);
	 //tks=new TakeScreenshot(driver);
	}
	
	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}
	
	@Test(enabled=true)
	public void IssueCollectorTourFundTest() throws FindFailed, InterruptedException, SQLException
	{
		login.waitForLoginButtonToLoad();
		login.getUsernameTextbox().sendKeys("JONESD");
		login.getPasswordTextbox().sendKeys("Welcome1!");
		login.getLoginButton().click();
		
		Ifund.waitForIssueCollectorTourFundLinkToLoad();
		Ifund.getIssueCollectorTourFundLink().click();
		Ifund.getlocationIddropDownlsit();
		Thread.sleep(3000);
		Ifund.getfundIdDropdowmlist();
		Ifund.getdisplayEmpIdNameDropdownlist();
		Ifund.getCashHundredsTextbox().sendKeys("1");;
		Ifund.getContinueButton().click();
		Ifund.getcommentsTextBox().sendKeys("Issued Tour Fund to Collector");
		Ifund.getConfirmationFundButton().click();
		
		String sucessmsg="Fund Details saved successfully";
		String getsuccessmsg=driver.findElement(By.xpath("//TABLE[@id='Content']/TBODY/TR/TD[2]/TABLE/TBODY/TR[4]/TD/CENTER/FORM/CENTER/TABLE/TBODY/TR/TD/TABLE/TBODY/TR/TD/TABLE/TBODY/TR/TD[3]")).getText();
		Assert.assertEquals(sucessmsg, getsuccessmsg);
		
		String FundTotal=driver.findElement(By.xpath("//TABLE[@id='Content']/TBODY/TR/TD[2]/TABLE/TBODY/TR[4]/TD/CENTER/FORM/SPAN/TABLE/TBODY/TR/TD/TABLE/TBODY/TR/TD/TABLE/TBODY/TR[3]/TD[4]/SPAN ")).getText();
		String TotalCashEntered=driver.findElement(By.xpath("//TABLE[@id='Content']/TBODY/TR/TD[2]/TABLE/TBODY/TR[4]/TD/CENTER/FORM/SPAN/TABLE/TBODY/TR/TD/TABLE/TBODY/TR/TD/TABLE/TBODY/TR[3]/TD[7]/SPAN")).getText();
		
		
		System.out.println("Total Fund : "+FundTotal);
		System.out.println("Total Cash Entered : "+TotalCashEntered);
		
		String IssuedFrom=driver.findElement(By.xpath("//TABLE[@id='Content']/TBODY/TR/TD[2]/TABLE/TBODY/TR[4]/TD/CENTER/FORM/SPAN/TABLE/TBODY/TR/TD/TABLE/TBODY/TR/TD/TABLE/TBODY/TR[1]/TD[4]/SPAN ")).getText();
		String IssuedTo=driver.findElement(By.xpath("//TABLE[@id='Content']/TBODY/TR/TD[2]/TABLE/TBODY/TR[4]/TD/CENTER/FORM/SPAN/TABLE/TBODY/TR/TD/TABLE/TBODY/TR/TD/TABLE/TBODY/TR[1]/TD[7]/SPAN")).getText();
		
		System.out.println("Issued From : "+IssuedFrom);
		System.out.println("Issued To : "+IssuedTo);
		System.out.println(getsuccessmsg);
		
		login.getLogoutButton();
		//print receipt
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
		//Ifund.getPrintReceiptButton().click();
		//print.getPrintButton();
		Thread.sleep(3000);
		//mbutton.getmainMenuButton().click();*/
		Ifund.connect();
	}
	/*@Test
	public void DatabaseConnectivity() throws SQLException
	{
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.36.194.152:1521/OPQA","SUNILS","SUNILS#123");

		Statement stm=con.createStatement();

		//execute the Query
		// String s="select FUND_AMOUNT from opms.o_r_fund_management order by update_ts desc";
		String s="select MAX(fund_amount) from opms.o_r_fund_managemenT where fund_amount=100 and comments='Issued Tour Fund to Collector'";
		ResultSet rs= stm.executeQuery(s);

		while(rs.next())
		{
		// String fundadded=rs.getString("FUND_AMOUNT");
		String fundadded=rs.getString("MAX(fund_amount)");
		System.out.println(fundadded);
		}
	}*/
		
		//login.getLogoutButton().click();
		
	
}
