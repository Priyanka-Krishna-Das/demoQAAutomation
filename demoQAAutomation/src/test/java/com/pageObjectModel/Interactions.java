package com.pageObjectModel;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.baseClass.BaseClass;

public class Interactions extends BaseClass{
	
	//pending- scroll, select, resize
	WebDriver driver;
	SoftAssert sa;
	
	//Const
	public Interactions(WebDriver gdriver)
	{
		driver=gdriver;
		PageFactory.initElements(gdriver, this);
	}
	
	
	//Locators
	//Sortable
	@FindBy(xpath="//span[text()='Sortable']")
	private WebElement sectionSortable;
	
	@FindBy(xpath="//h1[text()='Sortable']")
	private WebElement txtSortableOpen;
	
	@FindBy(xpath="//a[@id='demo-tab-grid']")
	private WebElement btnTabGrid;
	
	@FindBy(xpath="//div[text()='One']")
	private WebElement gridOne;
	
	@FindBy(xpath="//a[@id='demo-tab-list']")
	private WebElement btnTabList;
	
	@FindBy(xpath="//div[text()='One']")
	private WebElement listOne;
	
	//Selectable
	@FindBy(xpath="//span[text()='Selectable']")
	private WebElement sectionSelectable;
		
	@FindBy(xpath="//h1[text()='Selectable']")
	private WebElement txtSelectableSectionOpen;
	
	@FindBy(xpath="//a[@id='demo-tab-grid']")
	private WebElement btnTabGridSelect;
	
	@FindBy(xpath="//li[text()='One']")
	private WebElement gridOneSelect;
	
	@FindBy(xpath="//li[text()='Three']")
	private WebElement gridThreeUnSelected;
	
	//Resizing 
	@FindBy(xpath="//span[text()='Resizable']")
	private WebElement sectionResizable;
	
	@FindBy(xpath="//h1[text()='Resizable']")
	private WebElement txtResizableSectionOpen;
	
	@FindBy(xpath="//div[@id='resizableBoxWithRestriction']")
	private WebElement btnResize;
	
	//Dropable
	@FindBy(xpath="//span[text()='Droppable']")
	private WebElement sectionDropable;
	
	@FindBy(xpath="//h1[text()='Droppable']")
	private WebElement txtDropableSectionOpen;
	
	@FindBy(xpath="//a[@id='droppableExample-tab-accept']")
	private WebElement tabAccept;
	
	@FindBy(xpath="//div[@id='acceptable']")
	private WebElement dragAccept;
	
	@FindBy(xpath="//div[@id='droppable']//p[text()='Drop here']")
	private WebElement dropHereSection;
	
	@FindBy(xpath="//div[@id='Prevent Propogation']")
	private WebElement tabPreventPropogation;
	
	@FindBy(xpath="//div[text()='Drag Me']")
	private WebElement dragMe;
	
	@FindBy(xpath="//div[@id='notGreedyDropBox']")
	private WebElement dropHereBox;
		
	
	//Methods
	//Sortable
	public void clickScetionSortable()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", sectionSortable);
	}
	
	public void dispTxtSortableSectionOpen()
	{
		String dispTxtSortableSectionOpen=txtSortableOpen.getText();
		System.out.println("Sortable section opened: "+dispTxtSortableSectionOpen);
		
		 sa=new SoftAssert();
			
		if (dispTxtSortableSectionOpen.equals("Sortable")) 
		{
			sa.assertEquals(dispTxtSortableSectionOpen,"Sortable");
			System.out.println("Sortable section opened: succ.....");
		}
		else{
			System.out.println("Sortable section opened: failed....");
			System.out.println("Testing");
			System.out.println("vipin gadha ban gya hai jab se usko ek ladki mili hai");
		}
	}
	
	public void sortGrid() throws InterruptedException
	{
		Thread.sleep(5000);
		btnTabGrid.click();
		Actions act=new Actions(driver);
		act.moveToElement(gridOne, 20, 0);
		Thread.sleep(5000);
	}
	
	public void sortList()
	{
		btnTabList.click();
		Actions act=new Actions(driver);
		act.moveToElement(listOne, 0, 20);
	}

	//Selectable
	public void clickScetionSelectable()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", sectionSelectable);
	}
	
	public void dispTxtSelectableSectionOpen() throws InterruptedException
	{
		
		Thread.sleep(5000);
		String dispTxtSelectableSectionOpen=txtSelectableSectionOpen.getText();
		System.out.println("Selectable section opened: "+dispTxtSelectableSectionOpen);
		
		 sa=new SoftAssert();
			
		if (dispTxtSelectableSectionOpen.equals("Selectable")) 
		{
			sa.assertEquals(dispTxtSelectableSectionOpen,"Selectable");
			System.out.println("Selectable section opened: succ.....");
		}
		else{
			System.out.println("Selectable section opened: failed....");
		}
	}
	
	public void clickTabGrid() throws InterruptedException
	{
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", btnTabGridSelect);
	}
	
	public void checkSelectedGrid() throws InterruptedException
	{
		Thread.sleep(5000);
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(6));
		w.until(ExpectedConditions.visibilityOf(gridOneSelect));
		
		//gridOneSelect.click();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", gridOneSelect);
		
		boolean oneGridSelected=gridOneSelect.isSelected();
		System.out.println("Grid One selected: "+oneGridSelected);
		
		Thread.sleep(3000);
		
		boolean threeGridUnSelected=gridThreeUnSelected.isSelected();
		System.out.println("Grid Three selected: "+threeGridUnSelected);
		
	}
	
	//Resize
	public void clickScetionResizable()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", sectionResizable);
	}
	
	public void dispTxtResizeepen()
	{
		String dispTxtResizableSectionOpen=txtResizableSectionOpen.getText();
		System.out.println("Resize section opened: "+dispTxtResizableSectionOpen);
		
		 sa=new SoftAssert();
			
		if (dispTxtResizableSectionOpen.equals("Resizable")) 
		{
			sa.assertEquals(dispTxtResizableSectionOpen,"Resizable");
			System.out.println("Resize section opened: succ.....");
		}
		else{
			System.out.println("Resize section opened: failed....");
		}
	}
	
	public void clickResize() throws InterruptedException
	{
		Thread.sleep(3000);
		Actions act=new Actions(driver);
		act.dragAndDropBy(btnResize, 80, 100).build().perform();
	}
	
	//Droppable
	public void clickScetionDropable()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", sectionDropable);
	}
	
	public void dispTxtDropableopen()
	{
		String dispTxtDropableSectionOpen=txtDropableSectionOpen.getText();
		System.out.println("Resize section opened: "+dispTxtDropableSectionOpen);
		
		 sa=new SoftAssert();
			
		if (dispTxtDropableSectionOpen.equals("Droppable")) 
		{
			sa.assertEquals(dispTxtDropableSectionOpen,"Droppable");
			System.out.println("Dropable section opened: succ.....");
		}
		else{
			System.out.println("Dropable section opened: failed....");
		}
	}
	
	public void sectionDragAndDrop() throws InterruptedException
	{
		tabAccept.click();
		
		Thread.sleep(3000);
		Actions act=new Actions(driver);
		act.clickAndHold(dragAccept).moveToElement(dropHereSection).build().perform();
		
	}
	
	public void sectionDragAndDropNested() throws InterruptedException
	{
		tabPreventPropogation.click();
		
		Thread.sleep(3000);
		Actions act=new Actions(driver);
		act.clickAndHold(dragMe).moveToElement(dropHereBox).release().build().perform();
		//act.dragAndDrop(dragMe, dropHereBox).release().build().perform();
	}
}

















