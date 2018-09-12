package com.monetroom.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainMenuButton 
{
	WebDriver driver;
	public MainMenuButton(WebDriver driver)
	{
		this.driver=driver;
	}
	public WebElement getmainMenuButton()
	{
		return driver.findElement(By.xpath("//img[@alt='Main Menu']"));
	}
}
