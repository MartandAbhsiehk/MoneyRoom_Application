package com.monetroom.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReturnCollectorTourFund
{
	WebDriver driver;
	
	public ReturnCollectorTourFund(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getReturnCollectorTourFundLink()
	{
		return driver.findElement(By.xpath("//a[@title='Return Collector Tour Fund']"));
	}
	
	public void getlocationidDropdownlist()
	{
		WebElement element=driver.findElement(By.name("locationId"));
		
		Select st=new Select(element);
		st.selectByVisibleText("CASH ROOM");
	}
	
	public void getFundTypeDropDownList()
	{
		WebElement element =driver.findElement(By.name("fundId"));
		
		Select st=new Select(element);
		st.selectByVisibleText("Conductor Fund");
	}
	
	public void getEmployeeIdDropDownList()
	{
		WebElement element=driver.findElement(By.name("selectedEmpIdName"));
		
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
	
	 public void waitForReturnCollectorTourFundLinkToLoad()
		{
			WebDriverWait wait= new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Return Collector Tour Fund']"))));
		}
	
}
