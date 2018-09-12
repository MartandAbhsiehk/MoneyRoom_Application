package com.moneyroom.object.ui;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{
	WebDriver 	driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getUsernameTextbox()
	{
		return driver.findElement(By.name("j_username"));
	}
	
	public WebElement getPasswordTextbox()
	{
		return driver.findElement(By.name("j_password"));
	}
	
	public WebElement getLoginButton()
	{
		return driver.findElement(By.id("btnLogin"));
	}
	
	public WebElement getLogoutButton()
	{
		return driver.findElement(By.xpath("//img[@alt='Logout']"));
	}
		
	public String getErrorMessagePopup()
	{
		Alert alert = driver.switchTo().alert();
		
		String Alerttext=alert .getText();
		alert.accept();
		return Alerttext;
	}
	
	public WebElement getErrorLink()
	{
		return driver.findElement(By.xpath("//a[@href='jsp/sso/Login.jsp']"));
	}
	
	public void waitForLoginButtonToLoad()
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("headerbody"))));
	}
}
