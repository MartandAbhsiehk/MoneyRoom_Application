package com.moneyroom.test.smoke;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.monetroom.utils.CreateDriver;
import com.moneyroom.object.ui.LoginPage;

public class SimpleUnitTest 
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
	
	@Test
	public void testApp()
	{
		login.waitForLoginButtonToLoad();
		
		String actualtitle=driver.getTitle();
		String expectedTitle="Money Room Application";
		Assert.assertEquals(actualtitle, expectedTitle);
		
	}
	
	

}
