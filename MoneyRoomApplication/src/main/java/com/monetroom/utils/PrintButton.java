package com.monetroom.utils;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class PrintButton 
{
	
	public void getPrintButton() throws FindFailed
    {
    	Screen s=new Screen();
		Pattern ssl =new Pattern("C:\\Users\\52001317\\eclipse-workspace\\MoneyRoomApplication\\MoneyRoomApplication\\Sikuli_Images\\PrintButtonImg.JPG");
		s.wait(ssl,3000);
		s.click();
    }
}
