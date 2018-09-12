package com.monetroom.utils;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class PrintReceiptButton
{
	public void getPrintReceiptButton() throws FindFailed
	{
		Screen s1=new Screen();
		Pattern ssl1 =new Pattern("C:\\Users\\52001317\\eclipse-workspace\\MoneyRoomApplication\\MoneyRoomApplication\\Sikuli_Images\\PrintButtonImg.JPG");
		s1.wait(ssl1,3000);
		s1.click();
	}
}
