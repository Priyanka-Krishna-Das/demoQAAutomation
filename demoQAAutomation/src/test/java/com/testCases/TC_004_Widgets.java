package com.testCases;

import org.testng.annotations.Test;

import com.baseClass.BaseClass;
import com.pageObjectModel.HomePage;
import com.pageObjectModel.Widgets;

public class TC_004_Widgets extends BaseClass{
	
	HomePage hp;
	Widgets wi;
	
	@Test(priority=1,groups="sanity")
	public void goToAlertFrameAndWindowSection()
	{
		hp=new HomePage(driver);
		hp.clkSectionWidgets();
	}
	
	//@Test(priority=2)
	public void goToAccordian() throws InterruptedException
	{
		wi=new Widgets(driver);
		wi.clickScetionAccordian();
		wi.dispTxtAccordianSectionOpen();
		wi.clickSection2Heading();
		wi.clickSection3Heading();
	}
	
	//@Test(priority=3)
	public void goToAutoComplete() throws InterruptedException
	{
		wi=new Widgets(driver);
		wi.clickSectionAutoComplete();
		wi.enterTxtBoxMultipleColor("r");
	}
	
	//@Test(priority=3)
	public void goToSliderSection() throws InterruptedException
	{
		wi=new Widgets(driver);
		wi.clickSectionSlider();
		wi.setSlider();
	}

	//@Test(priority=4)
	public void goToProgressBarSection() throws InterruptedException
	{
		wi=new Widgets(driver);
		wi.clickSectionProgressBar();
	}
	
	//@Test(priority=5, invocationCount=2)
	public void startBtnProgressBarSection() throws InterruptedException
	{
		wi=new Widgets(driver);
		wi.clickBtnStart();
	}
	
	//@Test(priority=6)
	public void goToTabsSection() throws InterruptedException
	{
		wi=new Widgets(driver);
		wi.clickSectionTabs();
		wi.clickOriginTab();
		wi.clickUseTab();
	}
	
	//@Test(priority=7)
	public void goToToolTipSection() throws InterruptedException
	{
		wi=new Widgets(driver);
		wi.clickToolTipsSection();
		wi.displayBtnToolTipTxt();
	}
	
	//@Test(priority=8)
	public void goToMenuSection() throws InterruptedException
	{
		wi=new Widgets(driver);
		wi.clickMenueSection();
		wi.hoverBtnMenue2();
	}
	
	@Test(priority=9)
	public void goToSubMenuSection() throws InterruptedException
	{
		wi=new Widgets(driver);
		wi.clickSubMenuSection();
		wi.selectMultipleOption();
		wi.selectSingleOption();
		wi.selectOldStyleMenu();
		//wi.selectDropDownMultiple("b");
		wi.selectStandardMultiSelectOption();
	}
}

















