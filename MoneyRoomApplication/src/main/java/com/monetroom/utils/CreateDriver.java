package com.monetroom.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class CreateDriver
{
	
	public static WebDriver getDriverInterface() throws FindFailed
	{
		WebDriver driver=null;
		String browser = DataHandlers.getDataFromPropertyFile("./Config_Data/Configuration.properties","Browser");
		
		String url=DataHandlers.getDataFromPropertyFile("./Config_Data/Configuration.properties","url");
		
		if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver","./Browser_Servers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
		else
		{
			System.out.println("Application can only be run on IE");
			return driver;
		}
		//driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		Screen s=new Screen();
		Pattern ssl =new Pattern("C:\\Users\\52001317\\eclipse-workspace\\MoneyRoomApplication\\MoneyRoomApplication\\Sikuli_Images\\ssll.jpg");
		s.wait(ssl,3000);
		s.click();
		return driver;
	}
	
	
	
}
