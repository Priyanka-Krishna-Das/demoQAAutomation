package com.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.baseClass.BaseClass;
import com.pageObjectModel.Forms;
import com.pageObjectModel.HomePage;

public class TC_002_Forms extends BaseClass{
	
	HomePage hp;
	Forms frm;
	
	@Test(priority=1,groups="sanity")
	public void goToElementSection()
	{
		hp=new HomePage(driver);
		hp.clkSectionForms();
	}

	@Test(priority=2,groups="sanity")
	public void goToFormSection()
	{
		frm=new Forms(driver);
		frm.clickClickPracticeFormSection();
		frm.displayTxtFormsSectionOpenConfirmation();
	}
	
	@Test(priority=3, dataProvider="data")
	public void fillFormAndSubmit() throws IOException, InterruptedException
	{
		frm=new Forms(driver);
		//frm.enterTxtFirstName(getFirstNameForms());
		frm.enterTxtFirstName("data");
		frm.enterTxtLastName(getLastNameForms());
		frm.enterTxtEmail(getGmailForms());
		frm.selectRadioBtnGender();
		frm.enterTxtMobile(getNumber());
		frm.selectDOB();
		//frm.enterTxtBoxSubject(getSubject());
		frm.chooseTxtBoxHobbies();
		frm.enterTxtBoxCurrAdd(getCurrAddForms());
		frm.selectStateAndCity();
		frm.clickBtnSubmit();
	}
}
