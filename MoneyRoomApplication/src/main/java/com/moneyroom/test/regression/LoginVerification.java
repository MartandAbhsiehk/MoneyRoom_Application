package com.moneyroom.test.regression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.monetroom.utils.CreateDriver;
import com.moneyroom.object.ui.LoginPage;

public class LoginVerification 
{
	WebDriver driver;
	LoginPage login;
	
	@BeforeMethod
	public void preConditions() throws FindFailed
	{
		driver=CreateDriver.getDriverInterface();
		login= new LoginPage(driver);
		
	}
	
	@AfterMethod
	public void postConditions()
	{
		driver.close();
	}
	
	@Test(priority=1)
	public void InvalidLoginTest()
	{
       login.waitForLoginButtonToLoad();
		
		
		login.getLoginButton().click();
		login.getErrorMessagePopup();
	}
	
	@Test(priority=2) 
	public void InvalidUsernamePasswordLogin()
	{
		login.getUsernameTextbox().sendKeys("STEVEn");
		login.getPasswordTextbox().sendKeys("Welcome123123123!");
		login.getLoginButton().click();
		login.getErrorLink().click();
		
	}
	
	@Test(priority=3)//(dataProvider="Excelsheetdata")
	public void Login_Logout_Verification()//(String username,String password)
	{
		login.waitForLoginButtonToLoad();
		
		String actualtitle=driver.getTitle();
		String expectedTitle="Money Room Application";
		Assert.assertEquals(actualtitle, expectedTitle);
		
		login.getUsernameTextbox().sendKeys("STEVEM");
		login.getPasswordTextbox().sendKeys("Welcome123!");
		login.getLoginButton().click();
		login.getLogoutButton().click();
		
		/*String UsernameStatus=login.getUsernameTextbox().getAttribute("value");
		String PasswordStatus=login.getPasswordTextbox().getAttribute("value");
		String empty="";
		if(UsernameStatus.equals(empty)&&PasswordStatus.equals(empty))
		{
			String errormsg=login.getErrorMessage();
			System.out.println(errormsg);
		}
		else
		{
			login.getUsernameTextbox().send
		}*/
	}
	
	/*@DataProvider(name="Excelsheetdata")
	public Object[][] passData()
	{
		
	}*/
	
}
