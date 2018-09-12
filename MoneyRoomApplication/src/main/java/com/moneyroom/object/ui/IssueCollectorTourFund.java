package com.moneyroom.object.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class IssueCollectorTourFund 
{
	WebDriver driver;
	
	public IssueCollectorTourFund(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getIssueCollectorTourFundLink()
	{
		return driver.findElement(By.xpath("//a[@title= 'Issue Collector Tour Fund']"));
	}
	
	public void getlocationIddropDownlsit()
	{
		WebElement element= driver.findElement(By.name("locationId"));
		
		Select st=new Select(element);
		st.selectByVisibleText("CASH ROOM");
		
	}
	
	public void getfundIdDropdowmlist()
	{
		WebElement element=driver.findElement(By.name("fundId"));
		
		Select st=new Select(element);
		st.selectByVisibleText("Conductor Fund");
		
	}
	
	public void getdisplayEmpIdNameDropdownlist()
	{
		WebElement element=driver.findElement(By.name("displayEmpIdName"));
		
		Select st=new Select(element);
		st.selectByIndex(7);
	}
	
	public WebElement getCashHundredsTextbox()
	{
		return driver.findElement(By.name("ctrlvcol%3Dcount%3Bctrl%3DdepositCashList%3Brow%3DHundreds%3Btype%3Dtxt"));
	}
	
	public WebElement getContinueButton()
	{
		return driver.findElement(By.name("btnContinue"));
	}
	
	public WebElement getcommentsTextBox()
	{
		return driver.findElement(By.name("comments"));
	}
	
	public WebElement getConfirmationFundButton()
	{
		return driver.findElement(By.name("btnConfirmation"));
	}
	
	public WebElement getPrintReceiptButton()
	{
		return driver.findElement(By.name("btnPrint"));
	}
	
	 public void waitForIssueCollectorTourFundLinkToLoad()
		{
			WebDriverWait wait= new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title= 'Issue Collector Tour Fund']"))));
		}
	
	public void getPrintButton() throws FindFailed
    {
    	Screen s=new Screen();
		Pattern ssl =new Pattern("C:\\Users\\52001317\\eclipse-workspace\\MoneyRoomApplication\\MoneyRoomApplication\\Sikuli_Images\\printbutton.jpg");
		s.wait(ssl,3000);
		s.click();
    }
	
	 public void connect() throws SQLException
	  {
		 //step1-create connection:
         //host name   port SID    username  password
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
System.out.println("Issued $"+" "+fundadded+" "+"Tour Fund to Collector");
}
		  
	  }
}
