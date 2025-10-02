package com.pageObjectModel;

import java.beans.Visibility;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.baseClass.BaseClass;

public class AlertFrameAndWindows extends BaseClass{
	//Nested frame
	
	WebDriver driver;
	SoftAssert sa;
	
	//Const
	public AlertFrameAndWindows(WebDriver gdriver)
	{
		driver=gdriver;
		PageFactory.initElements(gdriver, this);
	}
	
	
	//Locators
	//browserWindows
	@FindBy(xpath="//span[text()='Browser Windows']")
	private WebElement browserWindows;
	
	@FindBy(xpath="//button[text()='New Tab']")
	private WebElement btnNewTab;
	
	@FindBy(xpath="//h1[text()='This is a sample page']")
	private WebElement browserWindowsSwitchTxt;
	
	@FindBy(xpath="//button[text()='New Window']")
	private WebElement btnNewWindow;
	
	@FindBy(xpath="//h1[text()='This is a sample page']")
	private WebElement newTabSwitchTxt;
	
	@FindBy(xpath="//button[@id='messageWindowButton']")
	private WebElement btnNewWindowMessage;
	
	@FindBy(xpath="//body[text()='Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.']")
	private WebElement newWindowMessageSwitchTxt;
	
	//Alert
	
	@FindBy(xpath="//span[text()='Alerts']")
	private WebElement clickAlertSection;
	
	@FindBy(xpath="//button[@id='alertButton']")
	private WebElement clickBtnAlert;
	
	@FindBy(xpath="//button[@id='timerAlertButton']")
	private WebElement clickTimerAlertButton;
	
	@FindBy(xpath="//button[@id='confirmButton']")
	private WebElement clickConfirmButton;
	
	@FindBy(xpath="//button[@id='promtButton']")
	private WebElement clickPromtButton;
	
	//Frames
	@FindBy(xpath="//span[text()='Frames']")
	private WebElement clickFrameSection;
	
	@FindBy(xpath="//iframe[@id='frame1']")
	private WebElement swaitchFrame;
	
	@FindBy(xpath="//h1[@id='sampleHeading']")
	private WebElement txtFrameTitle;
	
	@FindBy(xpath="//h1[text()='Frames']")
	private WebElement txtFrameSectionTitle;
	
	//Nested frame
	
	//Model dialogs
	@FindBy(xpath="//span[text()='Modal Dialogs']")
	private WebElement modalDialogsSection;
	
	@FindBy(xpath="//button[@id='showSmallModal']")
	private WebElement btnShowSmallModal;
	
	@FindBy(xpath="//button[@id='closeSmallModal']")
	private WebElement btnCloseSmallModal;
	
	@FindBy(xpath="//button[@id='showLargeModal']")
	private WebElement btnShowLargeModal;
	
	@FindBy(xpath="//button[@id='closeLargeModal']")
	private WebElement btnCloseLargeModal;
	
	
	//Method
	//browserWindows
	public void clickBrowserWindows()
	{
		browserWindows.click();
	}
	
	public void clickBtnNewTab()
	{
		btnNewTab.click();
		
         Set<String> handels = driver.getWindowHandles(); //parId,childID,subChil.........
		
		Iterator options=handels.iterator();
		String parentId= (String) options.next();
		String childId= (String) options.next();
		
		driver.switchTo().window(childId);
		
		String dispNewTabSwitchTxt=newTabSwitchTxt.getText();
		System.out.println("New tab txt: "+dispNewTabSwitchTxt);
		
		driver.close();
		
		driver.switchTo().window(parentId);
		
	}
	
	public void clickBtnNewWindow()
	{
		btnNewWindow.click();
		
         Set<String> handels = driver.getWindowHandles(); //parId,childID,subChil.........
		
		Iterator options=handels.iterator();
		String parentId= (String) options.next();
		String childId= (String) options.next();
		
		driver.switchTo().window(childId);
		
		String dispNewTabSwitchTxt=newTabSwitchTxt.getText();
		System.out.println("New Window txt: "+dispNewTabSwitchTxt);
		
        driver.close();
		
		driver.switchTo().window(parentId);
	}
	
	public void clickBtnNewWindowMessage() throws InterruptedException
	{
		
		//btnNewWindowMessage.click();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", btnNewWindowMessage);
		
        Set<String> handels = driver.getWindowHandles(); //parId,childID,subChil.........
		
		Iterator options=handels.iterator();
		String parentId= (String) options.next();
		String childId= (String) options.next();
		
		driver.switchTo().window(childId);
		
		Thread.sleep(5000);
		
		//String dispNewWindowMessageSwitchTxt=newWindowMessageSwitchTxt.getText();
		//System.out.println("New Window Message: "+dispNewWindowMessageSwitchTxt);
		
        driver.close();
		
		driver.switchTo().window(parentId);
	}


	//Alert
	public void clickAlertSection()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", clickAlertSection);
	}
	
	public void clickBtnAlert() throws InterruptedException
	{
		clickBtnAlert.click();
		Alert alert = driver.switchTo().alert();
		String btnAlertTxt=alert.getText();
		System.out.println("Btn alert txt: "+btnAlertTxt);
		alert.accept();
		
		//clickTimerAlertButton.click();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", clickTimerAlertButton);
		
		
		Thread.sleep(7000);
		
//		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(6));
//		w.until(ExpectedConditions.visibilityOfElementLocated(clickTimerAlertButton));
		
		String timeAlertTxt=alert.getText();
		System.out.println("Time alert txt: "+timeAlertTxt);
		alert.accept();
		
		
		//clickConfirmButton.click();
		
		js.executeScript("arguments[0].click()", clickConfirmButton);
		
		String confirmAlertTxt=alert.getText();
		System.out.println("Confirm alert txt: "+confirmAlertTxt);
		alert.dismiss();
		
		//clickPromtButton.click();
		
		js.executeScript("arguments[0].click()", clickPromtButton);
		alert.sendKeys("priyanka");
		String promoAlertTxt=alert.getText();
		System.out.println("Promo alert txt: "+promoAlertTxt);
		alert.accept();
		
	}
	
	//Frame
	
	public void clickFrameSection()
	{
		//clickFrameSection.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", clickFrameSection);
	}
	
	public void displayTxtFrame() throws InterruptedException
	{
		Thread.sleep(5000);
		//driver.switchTo().frame((WebElement) By.xpath("//iframe[@id='frame1']"));
		driver.switchTo().frame(swaitchFrame);
		
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(6));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@id='sampleHeading']")));
		
		String dispFrameTxt=txtFrameTitle.getText();
		System.out.println("switch to frame: "+dispFrameTxt);
		
		 sa=new SoftAssert();
			
			if (dispFrameTxt.equals("This is a sample page")) 
			{
				sa.assertEquals(dispFrameTxt,"This is a sample page");
				System.out.println("frame succ.....");
			}
			else{
			    System.out.println("frame failed....");
			}
		
		driver.switchTo().defaultContent();
	}
	
	public void dispFrameSectionTxt()
	{
		String dispTxtFrameSectionTitle=txtFrameSectionTitle.getText();
		System.out.println("Frame section title: "+dispTxtFrameSectionTitle);
		
        sa=new SoftAssert();
		
		if (dispTxtFrameSectionTitle.equals("Frames")) 
		{
			sa.assertEquals(dispTxtFrameSectionTitle,"Frames");
			System.out.println("Default frame succ.....");
		}
		else{
		    System.out.println("Default frame failed....");
		}
	}
	
	public void clickModalDialogsSection()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", modalDialogsSection);
	}
	
	public void clickBtnSmallModal()
	{
		btnShowSmallModal.click();
		
		String dispTxtBtnCloseSmallModal=btnCloseSmallModal.getText();
		System.out.println("Small Model window text: "+dispTxtBtnCloseSmallModal);
		
		btnCloseSmallModal.click();
	}
	
	public void clickBtnLargeModal()
	{
		btnShowLargeModal.click();
		
		String dispTxtBtnCloseLargeModal=btnCloseLargeModal.getText();
		System.out.println("Large Model window text: "+dispTxtBtnCloseLargeModal);
		
		btnCloseLargeModal.click();
	}
	
	
	
}











