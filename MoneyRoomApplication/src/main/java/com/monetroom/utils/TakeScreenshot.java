package com.monetroom.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot 
{
	WebDriver driver;
	
	public TakeScreenshot(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void CaptureScreenshot() throws IOException
	{
		
	 Date d = new Date();
     //System.out.println(d.toString());

     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");         // Your each screenshot will be taken as this format "Year-Month-Date-Hours-Minutes-Seconds"
     File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     FileUtils.copyFile(scrFile, new File("./PrintScreen_ScreenShots"+sdf.format(d)+".png"));
}
}