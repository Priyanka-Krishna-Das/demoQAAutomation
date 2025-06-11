package com.pageObjectModel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class Widgets {
	
	//Pendings- auto complete, datepicker, tool tip, submenue sendkeys selection

	//private static final boolean WebElement = false;
	WebDriver driver;
	SoftAssert sa;
	
	//Const
	public Widgets(WebDriver gdriver)
	{
		driver=gdriver;
		PageFactory.initElements(gdriver, this);
	}
	
	
	//Locators
	//Accordian
	@FindBy(xpath="//span[text()='Accordian']")
	private WebElement sectionAccordian;
	
	@FindBy(xpath="//h1[text()='Accordian']")
	private WebElement txtAccordianSectionOpen;
	
	@FindBy(xpath="//div[@id='section2Heading']")
	private WebElement section2Heading;
	
	@FindBy(xpath="//div[@id='section3Heading']")
	private WebElement section3Heading;
	
	//Auto Complete
	@FindBy(xpath="//span[text()='Auto Complete']")
	private WebElement sectionAutoComplete;
	
	@FindBy(xpath="//div[@id='autoCompleteMultipleContainer']")
	private WebElement txtBoxMultipleColor;
	
	@FindBy(xpath="//div[@class='css-12jo7m5 auto-complete__multi-value__label']")
	private List<WebElement> dropdownMultiplecolor;
	
	@FindBy(xpath="//div[@id='autoCompleteSingleContainer']")
	private WebElement txtBoxSingleColor;
	
	//Slider
	@FindBy(xpath="//span[text()='Slider']")
	private WebElement sectionSlider;
	
	@FindBy(xpath="//h1[text()='Slider']")
	private WebElement txtSliderSectionOpen;
	
	@FindBy(xpath="//div[@style='left: calc(25% + 5px);']")
	private WebElement inputSlider;
	
	//Progress bar
	@FindBy(xpath="//span[text()='Progress Bar']")
	private WebElement sectionProgressBar;
	
	@FindBy(xpath="//h1[text()='Progress Bar']")
	private WebElement txtProgressBarSectionOpen;
	
	@FindBy(xpath="//button[text()='Start' or text()='Stop']")
	private WebElement btnStartStop;
	
	//Tabs
	@FindBy(xpath="//span[text()='Tabs']")
	private WebElement sectionTabs;
	
	@FindBy(xpath="//h1[text()='Tabs']")
	private WebElement txtTabsSectionOpen;
	
	@FindBy(xpath="//a[text()='Origin']")
	private WebElement txtOriginTabsSectionOpen;
	
	@FindBy(xpath="//a[text()='Use']")
	private WebElement txtUseTabsSectionOpen;
	
	//Tabs
	@FindBy(xpath="//span[text()='Tool Tips']")
	private WebElement sectionToolTips;
	
	@FindBy(xpath="//h1[text()='Tool Tips']")
	private WebElement txtToolTipssSectionOpen;
	
	@FindBy(xpath="//button[@id='toolTipButton']")
	private WebElement btnToolTip;
	
	@FindBy(xpath="//input[@id='toolTipTextField']")
	private WebElement txtBoxToolTip;
	
	//Menu
	@FindBy(xpath="//span[text()='Menu']")
	private WebElement sectionMenue;
	
	@FindBy(xpath="//h1[text()='Menu']")
	private WebElement txtMenuessSectionOpen;
	
	@FindBy(xpath="//a[text()='Main Item 2']")
	private WebElement btnMenue2;
	
	@FindBy(xpath="//li/a[text()='SUB SUB LIST »']")
	private WebElement subMenueList;
	
	//Submenu
	@FindBy(xpath="//span[text()='Select Menu']")
	private WebElement sectionSubMenu;
	
	@FindBy(xpath="//h1[text()='Select Menu']")
	private WebElement txtMenuMenuSectionOpen;
	
	@FindBy(xpath="//div[text()='Select Option']")
	private WebElement selectOptionValue;
	
	@FindBy(xpath="//div[text()='Group 1, option 1']")
	private WebElement selectOptionValue1;
	
	@FindBy(xpath="//div[text()='Select Title']")
	private WebElement selectOptionSingleTitle;
	
	@FindBy(xpath="//div[text()='Dr.']")
	private WebElement selectOptionSingleTitleOption;
	
	@FindBy(xpath="//select[@id='oldSelectMenu']")
	private WebElement selectOldStyleMenu;
	
	@FindBy(xpath="//div[text()='Select...']")
	private List<WebElement> dropDownMultiple;
		
	@FindBy(xpath="//select[@id='cars']")
	private WebElement selectStandardMultiSelect;
	
	//Methods
	//Accordian
	public void clickScetionAccordian()
	{
		//sectionAccordian.click();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", sectionAccordian);
	}
	
	public void dispTxtAccordianSectionOpen()
	{
		String dispTxtAccordianSectionOpen=txtAccordianSectionOpen.getText();
		System.out.println("Accordin section opened: "+dispTxtAccordianSectionOpen);
		
		 sa=new SoftAssert();
			
		if (dispTxtAccordianSectionOpen.equals("Accordian")) 
		{
			sa.assertEquals(dispTxtAccordianSectionOpen,"Accordian");
			System.out.println("Accordin section opened: succ.....");
		}
		else{
			System.out.println("Accordin section opened: failed....");
		}
	}
	
	public void clickSection2Heading()
	{
		//section2Heading.click();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", section2Heading);
		
		String dispTxtSection2Heading=section2Heading.getText();
		System.out.println("Heading section 2: "+dispTxtSection2Heading);
	}
	
	public void clickSection3Heading()
	{
		//section3Heading.click();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", section3Heading);
		
		String dispTxtSection3Heading=section3Heading.getText();
		System.out.println("Heading section 3: "+dispTxtSection3Heading);
	}
	
	//Auto Complete
	public void clickSectionAutoComplete()
	{
		//sectionAutoComplete.click();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", sectionAutoComplete);
	}
	
	public void enterTxtBoxMultipleColor(String color)
	{
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("document.getElementById('elementID').setAttribute(r, txtBoxMultipleColor)");
		
		txtBoxMultipleColor.sendKeys(color);
		
		System.out.println("List of colors in the list: "+dropdownMultiplecolor.size());
		
		for(WebElement colors:dropdownMultiplecolor)
		{
			if(colors.getText().equalsIgnoreCase("red"))
			{
				colors.click();
				break;
			}
		}
	}
	
	//Slider
	public void clickSectionSlider()
	{
		//sectionAutoComplete.click();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", sectionSlider);
		
		String dispTxtSliderSectionOpen=txtSliderSectionOpen.getText();
		System.out.println("Slider section open: "+dispTxtSliderSectionOpen);
		
		 sa=new SoftAssert();
			
		if (dispTxtSliderSectionOpen.equals("Slider")) 
		{
			sa.assertEquals(dispTxtSliderSectionOpen,"Slider");
			System.out.println("Slider section open: succ.....");
		}
		else{
			System.out.println("Slider section open: failed....");
		}
		
	}
	
	public void setSlider()
	{
		Actions act=new Actions(driver);
		
		String dispTxtInputSliderBefore=inputSlider.getText();
		System.out.println("Before set: "+dispTxtInputSliderBefore);
		
		act.moveToElement(inputSlider, 89, 0);
		
		String dispTxtInputSliderAfter=inputSlider.getText();
		System.out.println("After set: "+dispTxtInputSliderAfter);
	}
	
	//Progress bar
	public void clickSectionProgressBar()
	{
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", sectionProgressBar);
		
		String dispTxtProgressBarSectionOpenn=txtProgressBarSectionOpen.getText();
		System.out.println("Progress bar section open txt: "+dispTxtProgressBarSectionOpenn);
		
		 sa=new SoftAssert();
			
		if (dispTxtProgressBarSectionOpenn.equals("Progress Bar")) 
		{
			sa.assertEquals(dispTxtProgressBarSectionOpenn,"Progress Bar");
			System.out.println("Progress bar section open: succ.....");
		}
		else{
			System.out.println("Progress bar section open: failed....");
		}
	}
	
	public void clickBtnStart()
	{
		btnStartStop.click();
	}
	
	//Tabs
	
	public void clickSectionTabs()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", sectionTabs);
		
		String dispTxTabsSectionOpen=txtTabsSectionOpen.getText();
		System.out.println("Tabs section open txt: "+dispTxTabsSectionOpen);
		
		 sa=new SoftAssert();
			
		if (dispTxTabsSectionOpen.equals("Tabs")) 
		{
			sa.assertEquals(dispTxTabsSectionOpen,"Tabs");
			System.out.println("Tabs section open txt: succ.....");
		}
		else{
			System.out.println("Tabs section open txt: failed....");
		}
	}
	
	public void clickOriginTab()
	{
		txtOriginTabsSectionOpen.click();
		
		String dispTxtOriginTabsSectionOpen=txtOriginTabsSectionOpen.getText();
		System.out.println("Origin Tabs section open txt: "+dispTxtOriginTabsSectionOpen);
		
		 sa=new SoftAssert();
			
		if (dispTxtOriginTabsSectionOpen.equals("Origin")) 
		{
			sa.assertEquals(dispTxtOriginTabsSectionOpen,"Origin");
			System.out.println("Origin Tabs section open txt: succ.....");
		}
		else{
			System.out.println("Origin Tabs section open txt: failed....");
		}
	}
	
	public void clickUseTab()
	{
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(6));
		w.until(ExpectedConditions.visibilityOf(txtUseTabsSectionOpen));
		
		txtUseTabsSectionOpen.click();
		
		String dispTxtUseTabsSectionOpen=txtUseTabsSectionOpen.getText();
		System.out.println("Use Tabs section open txt: "+dispTxtUseTabsSectionOpen);
		
		 sa=new SoftAssert();
			
		if (dispTxtUseTabsSectionOpen.equals("Use")) 
		{
			sa.assertEquals(dispTxtUseTabsSectionOpen,"Use");
			System.out.println("Use Tabs section open txt: succ.....");
		}
		else{
			System.out.println("Use Tabs section open txt: failed....");
		}
	}
	
	
	//ToolTips
	public void clickToolTipsSection()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", sectionToolTips);
		
		String dispTxtToolTipssSectionOpen=txtToolTipssSectionOpen.getText();
		System.out.println("ToolTips section open txt: "+dispTxtToolTipssSectionOpen);
		
		 sa=new SoftAssert();
			
		if (dispTxtToolTipssSectionOpen.equals("Tool Tips")) 
		{
			sa.assertEquals(dispTxtToolTipssSectionOpen,"Tool Tips");
			System.out.println("ToolTips section open txt: succ.....");
		}
		else{
			System.out.println("ToolTips section open txt: failed....");
		}
	}
	
	public void displayBtnToolTipTxt() throws InterruptedException
	{
		Thread.sleep(5000);
		Actions act=new Actions(driver);
		act.moveToElement(btnToolTip).build().perform();
		
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(4));
		w.until(ExpectedConditions.visibilityOf(btnToolTip));
		
		//String dispTxtbtnToolTip=btnToolTip.getAttribute("aria-describedby");
		String dispTxtbtnToolTip=btnToolTip.getAttribute("title");
		System.out.println("ToolTips Btn txt: "+dispTxtbtnToolTip);
	}
	
	//Menu
	public void clickMenueSection()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", sectionMenue);
		
		String dispTxtMenuessSectionOpen=txtMenuessSectionOpen.getText();
		System.out.println("Menu section open txt: "+dispTxtMenuessSectionOpen);
		
		 sa=new SoftAssert();
			
		if (dispTxtMenuessSectionOpen.equals("Menu")) 
		{
			sa.assertEquals(dispTxtMenuessSectionOpen,"Menu");
			System.out.println("Menu section open txt: succ.....");
		}
		else{
			System.out.println("Menu section open txt: failed....");
		}
	}
	
	public void hoverBtnMenue2()
	{
		Actions act=new Actions(driver);
		act.moveToElement(btnMenue2).build().perform();
		
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(4));
		w.until(ExpectedConditions.visibilityOf(subMenueList));
		
		String dispTxtMenuessSectionOpen=subMenueList.getText();
		System.out.println("Sub-Menu section open txt: "+dispTxtMenuessSectionOpen);

	}
	
	//Sub Menu
	public void clickSubMenuSection()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", sectionSubMenu);
		
		String dispTxtMenuMenuSectionOpen=txtMenuMenuSectionOpen.getText();
		System.out.println("Sub Menu section open txt: "+dispTxtMenuMenuSectionOpen);
		
		 sa=new SoftAssert();
			
		if (dispTxtMenuMenuSectionOpen.equals("Select Menu")) 
		{
			sa.assertEquals(dispTxtMenuMenuSectionOpen,"Select Menu");
			System.out.println("Sub Menu section open txt: succ.....");
		}
		else{
			System.out.println("Sub Menu section open txt: failed....");
		}
	}
	
	public void selectMultiOption()
	{
//		Select sel = new Select(selectOptionValue);
//		sel.selectByVisibleText("Group 1, option 1");
		selectOptionValue.click();
	}
	
	public void selectMultipleOption()
	{
//		Select sel = new Select(selectOptionValue);
//		sel.selectByVisibleText("Group 1, option 1");
		selectOptionValue.click();
		selectOptionValue1.click();
	}
	
	public void selectSingleOption() throws InterruptedException
	{
		selectOptionSingleTitle.click();
		Thread.sleep(5000);
		selectOptionSingleTitleOption.click();
	}
	
	public void selectOldStyleMenu()
	{
		Select sel = new Select(selectOldStyleMenu);
		sel.selectByVisibleText("Blue");
	}
	
	public void selectDropDownMultiple(String color2)
	{
		//Select sel = new Select(dropDownMultiple);
		//sel.selectByVisibleText("");
		
		//dropDownMultiple.sendKeys(color2);
		
		System.out.println("List of colors in the list: "+dropdownMultiplecolor.size());
		
		for(WebElement colors2:dropdownMultiplecolor)
		{
			if(colors2.getText().equalsIgnoreCase("black"))
			{
				colors2.click();
				break;
			}
		}
	}
	
	public void selectStandardMultiSelectOption()
	{
		Select sel = new Select(selectStandardMultiSelect);
		sel.selectByVisibleText("Audi");
	}
}













