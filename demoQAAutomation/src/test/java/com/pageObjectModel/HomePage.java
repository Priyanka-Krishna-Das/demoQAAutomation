package com.pageObjectModel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	//Const
	public HomePage(WebDriver gdriver)
	{
		driver=gdriver;
		PageFactory.initElements(gdriver, this);
	}
	
	//Locators
	@FindBy(xpath="//h5[text()='Elements']")
	private WebElement sectionElements;
	
	@FindBy(xpath="//h5[text()='Forms']")
	private WebElement sectionForms;
	
	@FindBy(xpath="//h5[text()='Alerts, Frame & Windows']")
	private WebElement sectionAlertFrameAndWindows;
	
	@FindBy(xpath="//h5[text()='Widgets']")
	private WebElement sectionWidgets;
	
	@FindBy(xpath="//h5[text()='Interactions']")
	private WebElement sectionInteractions;
	
	
	//Methods
	public void clkSectionElements()
	{
		try {
			Thread.sleep(10000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", sectionElements);
	}

	public void clkSectionForms()
	{
		try {
			Thread.sleep(10000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", sectionForms);
	}
	
	public void clkSectionAlertFrameAndWindow()
	{
		try {
			Thread.sleep(10000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", sectionAlertFrameAndWindows);
	}
	
	public void clkSectionWidgets()
	{
		try {
			Thread.sleep(10000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", sectionWidgets);
	}
	
	public void clkSectionInteractions()
	{
		try {
			Thread.sleep(10000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", sectionInteractions);
	}
	
	
}

















