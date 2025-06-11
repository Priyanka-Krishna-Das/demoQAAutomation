package com.testCases;

import org.testng.annotations.Test;

import com.baseClass.BaseClass;
import com.pageObjectModel.AlertFrameAndWindows;
import com.pageObjectModel.HomePage;

public class TC_003_AlertsFrameAndWindows extends BaseClass{

	HomePage hp;
	AlertFrameAndWindows aw;
	
	@Test(priority=1,groups="sanity")
	public void goToAlertFrameAndWindowSection()
	{
		hp=new HomePage(driver);
		hp.clkSectionAlertFrameAndWindow();
	}
	
	//@Test(priority=2)
	public void goToBrowesrWindow() throws InterruptedException
	{
		aw=new AlertFrameAndWindows(driver);
		aw.clickBrowserWindows();
		aw.clickBtnNewTab();
		aw.clickBtnNewWindow();
		aw.clickBtnNewWindowMessage();
	}
	
	//@Test(priority=3)
	public void goToAlert() throws InterruptedException
	{
		aw=new AlertFrameAndWindows(driver);
		aw.clickAlertSection();
		aw.clickBtnAlert();
	}
	
	//@Test(priority=4)
	public void goToFrame() throws InterruptedException
	{
		aw=new AlertFrameAndWindows(driver);
		aw.clickFrameSection();
		aw.displayTxtFrame();
		aw.dispFrameSectionTxt();
	}
	
	@Test(priority=5)
	public void goToDialogsModal() throws InterruptedException
	{
		aw=new AlertFrameAndWindows(driver);
		aw.clickModalDialogsSection();
		aw.clickBtnSmallModal();
		aw.clickBtnLargeModal();
	}
}
