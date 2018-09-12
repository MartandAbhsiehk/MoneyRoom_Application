package com.moneyroom.object.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class IssueManagerSupervisorFund 
{
	WebDriver driver;
	
	public IssueManagerSupervisorFund(WebDriver driver)
	{
		this.driver=driver;
	}
    public WebElement getIssueManagerSupervisorLink()
    {
	return driver.findElement(By.xpath("//a[@title='Issue Manager/Supervisor Fund']"));
    }

    public void getLocationDropDownList()
    {
	WebElement element=driver.findElement(By.name("locationId"));
	Select st=new Select(element);
	st.selectByVisibleText("CASH ROOM");
    }
    
    public void getFundIdDropDownList()
    {
	WebElement element=driver.findElement(By.name("fundId"));
	Select st=new Select(element);
	st.selectByVisibleText("Supervisor Fund");
    }
    
    public WebElement getCashHundredsTextbox()
    {
	return driver.findElement(By.name("ctrlvcol%3Dcount%3Bctrl%3DdepositCashList%3Brow%3DHundreds%3Btype%3Dtxt"));
	}
    
     
    public WebElement getContinueButton()
    {
	return driver.findElement(By.name("btnContinue"));
	}
    
    public WebElement getCommentTextbox()
    {
	return driver.findElement(By.name("comments"));
	}
    
    public WebElement getCofirmFundsButton()
    {
	return driver.findElement(By.id("btnConfirmation"));
	}
    
    public WebElement getPrintReceiptButton()
    {
	return driver.findElement(By.id("btnPrint"));
	}
        
    public void waitForIssueManagerLinkToLoad()
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title=\"Issue Manager/Supervisor Fund\"]"))));
	}
    
  
}
