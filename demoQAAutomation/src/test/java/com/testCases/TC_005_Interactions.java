package com.testCases;

import org.testng.annotations.Test;

import com.baseClass.BaseClass;
import com.pageObjectModel.HomePage;
import com.pageObjectModel.Interactions;

public class TC_005_Interactions extends BaseClass{
	
	HomePage hp;
	Interactions in;
	
	@Test(priority=1,groups="sanity")
	public void goToInteractions()
	{
		hp=new HomePage(driver);
		hp.clkSectionInteractions();
	}
	
	//@Test(priority=2,groups="sanity")
	public void goToSortable() throws InterruptedException
	{
		in=new Interactions(driver);
		in.clickScetionSortable();
		in.dispTxtSortableSectionOpen();
		in.sortGrid();
		in.sortList();
	}
	
	//@Test(priority=3)
	public void goToSelectable() throws InterruptedException
	{
		in=new Interactions(driver);
		in.clickScetionSelectable();
		in.dispTxtSelectableSectionOpen();
		in.clickTabGrid();
		in.checkSelectedGrid();
	}
	
	//@Test(priority=4)
	public void goToResize() throws InterruptedException
	{
		in=new Interactions(driver);
		in.clickScetionResizable();
		in.dispTxtResizeepen();
		in.clickResize();
	}
	
	@Test(priority=5)
	public void goToDropable() throws InterruptedException
	{
		in=new Interactions(driver);
		in.clickScetionDropable();
		in.dispTxtDropableopen();
		//in.sectionDragAndDrop();
		in.sectionDragAndDropNested();
	}

}
