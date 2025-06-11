package com.testCases;


import java.io.IOException;

import org.testng.annotations.Test;

import com.baseClass.BaseClass;
import com.pageObjectModel.Elements;
import com.pageObjectModel.HomePage;

public class TC_001_Elements extends BaseClass{
	
	HomePage hp;
	Elements el;

	@Test(priority=1,groups="sanity")
	public void goToElementSection()
	{
		
		hp=new HomePage(driver);
		hp.clkSectionElements();
	
	}
	
	//@Test(priority=2,groups="sanity")
	public void textBoxSection() throws InterruptedException
	{
		el=new Elements(driver);
		try 
		{
			el.clkBtnTxtBox();
			System.out.println("text box click");
			el.enterTxtUsername(getFullName());
			System.out.println("username");
			el.enterTxtGmail(getGmail());
			el.enterTxtCurrAdress(getCurrAdd());
			el.enterTxtPerAdress(getPerAdd());
			el.clickSubmit();
		} 
		catch (IOException e) 
		{

			e.printStackTrace();
		}
	}
	
	//@Test(priority=3)
	public void checkBoxSection()
	{
		el=new Elements(driver);
		el.clickCheckboxSection();
		el.clickSelcetCheckBox();
	}
	
	
	//@Test(priority=4)
	public void checkRadioBtnSection() throws InterruptedException
	{
		el=new Elements(driver);
		el.clickRadioBtnSection();
		el.clickRadioBtn();
	}
	
	//@Test(priority=5)
	public void checkWebTableSectionAddRow() throws InterruptedException
	{
		el=new Elements(driver);
		el.clickBtnWebTableSection();
		el.clickBtnAdd();
		try 
		{
			el.enterTxtFirstName(getFirstName());
			el.enterTxtLastName(getLastName());
			el.enterTxtUserEmail(getUserEmail());
			el.enterUserAge(getUserAge());
			el.enterUserSalary(getUserSalary());
			el.enterUserDepartment(getUserDepartment());
			el.clickBtnSubmitForRowAddition();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//@Test(priority=6)
	public void checkEditOnWebTable()
	{
		el=new Elements(driver);
		el.clickBtnWebTableSection();
		el.clickEditIconCustInfo();
		
		el.clickEditCustSalary(slaryEdit());
	}
	
	//@Test(priority=7)
	public void checkButtionSection() throws InterruptedException
	{
		el=new Elements(driver);
		el.clickBtnSection();
		el.clickBtnDoubleClick();
		el.clickBtnRightClick();
		el.clickBtnClickMe();
	}
	
	//@Test(priority=8)
	public void checkLinkSection() throws InterruptedException
	{
		el=new Elements(driver);
		el.clickBtnLinkSection();
		el.clickLinkHome();
		el.checkRedirectionHomePage();
		el.backToParentWind();
	}
	
	@Test(priority=9)
	public void checkBrokenLinkSection() throws InterruptedException
	{
		el=new Elements(driver);
		el.clickBrokenLinkSection();
		el.clickBrokenLink();
	}
	
	//@Test(priority=10)
	public void checkUploadAndDownloadSection() throws InterruptedException
	{
		el=new Elements(driver);
		el.clickUploadAndDownloadSection();
		el.clickBtnUpload();
		//el.clickBtnDownload();
	}
	
	//@Test(priority=11)
	public void checkDynamicPropertiesSection() throws InterruptedException
	{
		el=new Elements(driver);
	}
	
}
