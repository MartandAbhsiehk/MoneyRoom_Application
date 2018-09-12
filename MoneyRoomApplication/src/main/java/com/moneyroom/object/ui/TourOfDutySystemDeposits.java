package com.moneyroom.object.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TourOfDutySystemDeposits 
{
	WebDriver driver;
	
	public TourOfDutySystemDeposits(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getTourofDutySystemDepositsLink()
	{
		return driver.findElement(By.xpath("//a[@title='Tour of Duty System Deposits']"));
	}
	
	public void getSourceTypeDropDownlist()
	{
		WebElement element= driver.findElement(By.name("sourceType"));
		
		Select st=new Select(element);
		st.selectByVisibleText("HSD");
	}
	
	public void getEmployIdandName()
	{
		WebElement element=driver.findElement(By.name("employeeId"));
		
		Select st=new Select(element);
		
		st.selectByValue("12");
	}
	
	public WebElement getSearchTODButton()
	{
		return driver.findElement(By.name("btnSearchTOD"));
	}
	
	public WebElement getContinueButton()
	{
		return driver.findElement(By.name("btnContinue"));
	}
	
	
}
