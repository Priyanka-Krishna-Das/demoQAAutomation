package com.pageObjectModel;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.baseClass.BaseClass;
import com.utilities.PropertiesClass;

public class Elements extends BaseClass{
	
	//pending- table(update),dynamic prop, download, broken links
	
	WebDriver driver;
	SoftAssert sa;
	
	//Const
	public Elements(WebDriver gdriver)
	{
		driver=gdriver;
		PageFactory.initElements(gdriver, this);
	}
	
	
	//Locators
	@FindBy(xpath="//span[text()='Text Box']")
	private WebElement btnTxtBox;
	
	//Text box
	@FindBy(xpath="//h1[text()='Text Box']")
	private WebElement txtTxtBox;
	
	@FindBy(xpath="//input[@id='userName']")
	private WebElement txtBoxUsername;
	
	@FindBy(xpath="//input[@id='userEmail']")
	private WebElement txtBoxGmail;
	
	@FindBy(xpath="//textarea[@id='currentAddress']")
	private WebElement txtCurrAddress;
	
	@FindBy(xpath="//textarea[@id='permanentAddress']")
	private WebElement txtPerAddress;
	
	@FindBy(xpath="//button[@id='submit']")
	private WebElement btnSubmit;
	
	//CheckBox
	@FindBy(xpath="//span[text()='Check Box']")
	private WebElement clickCheckboxSection;
	
	@FindBy(xpath="//h1[text()='Check Box']")
	private WebElement txtCheckBoxSection;
	
	@FindBy(xpath="//span[@class='rct-checkbox']")
	private WebElement selcetCheckbox;
	
	@FindBy(xpath="//*[text()='You have selected :']")
	private WebElement txtAfterSelectingCheckBox;
	
	//radio button
	@FindBy(xpath="//span[text()='Radio Button']")
	private WebElement clickRadioButtonSection;
	
	@FindBy(xpath="//h1[text()='Radio Button']")
	private WebElement radioBtnSectionOpen;
	
	@FindBy(xpath="//input[@id='yesRadio']")
	private WebElement clickYesRadioBoxSection;
	
	@FindBy(xpath="//input[@id='noRadio']")
	private WebElement clickNoRadioBoxSection;
	
	@FindBy(xpath="//p[text()='You have selected ']")
	private WebElement txtAfterYesRadioSection;
	
	//Web table (add):
	@FindBy(xpath="//span[text()='Web Tables']")
	private WebElement clickWebTableSection;
	
	@FindBy(xpath="//h1[text()='Web Tables']")
	private WebElement txtWebTableSection;
	
	@FindBy(xpath="//button[@id='addNewRecordButton']")
	private WebElement btnAddWebTable;
	
	@FindBy(xpath="//input[@id='firstName']")
	private WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='lastName']")
	private WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='userEmail']")
	private WebElement txtUserEmail;
	
	@FindBy(xpath="//input[@placeholder='Age']")
	private WebElement txtUserAge;
	
	@FindBy(xpath="//input[@placeholder='Salary']")
	private WebElement txtUserSalary;
	
	@FindBy(xpath="//input[@id='department']")
	private WebElement txtUserDepartment;
	
	@FindBy(xpath="//button[@id='submit']")
	private WebElement btnSubmitForRowAddition;
	
	//Web table(Edit):
	@FindBy(xpath="//span[@id='edit-record-3']")
	private WebElement iconEdit;
	
	@FindBy(xpath="//input[@placeholder='Salary']")
	private WebElement txtUserSalaryEdit;
	
	@FindBy(xpath="//button[@id='submit']")
	private WebElement btnSubmitForRowEdition;
	
	//Buttons
	@FindBy(xpath="//span[text()='Buttons']")
	private WebElement clickBtnSection;
	
	@FindBy(xpath="//button[text()='Double Click Me']")
	private WebElement clickBtnDoubleClick;
	
	@FindBy(xpath="//button[@id='rightClickBtn']")
	private WebElement clickBtnRightClick;
	
	@FindBy(xpath="//button[text()='Click Me']")
	private WebElement clickBtnClickMe;
	
	//links
	@FindBy(xpath="//span[text()='Links']")
	private WebElement clickLinkSection;
	
	//@FindBy(linkText="'Home'")
	@FindBy(xpath="//a[@id='simpleLink']")
	private WebElement clickHomeLink;
	
	@FindBy(xpath="//*[text()='Elements']")
	private WebElement redirectionValidationHomepage;
	
	//Bronken links
	@FindBy(xpath="//span[text()='Broken Links - Images']")
	private WebElement clickBrokenLinkSection;
	
//	@FindBy(xpath="//a[text()='Click Here for Broken Link']")
//	private Set<WebElement> clickBtnBrokenLink;
	
	@FindBy(tagName="a")
	private Set<WebElement> clickBtnBrokenLink;
	
	//upload and download
	@FindBy(xpath="//span[text()='Upload and Download']")
	private WebElement clickUploadAndDownloadSection;
	
	@FindBy(xpath="//input[@id='uploadFile']")
	private WebElement clickBtnUpload;
	
	@FindBy(xpath="//p[@id='uploadedFilePath']")
	private WebElement txtUploadConfirm;
	
	@FindBy(xpath="//a[@id='downloadButton']")
	private WebElement clickBtnDownload;
	
	//Dynamic prop
	@FindBy(xpath="//span[text()='Dynamic Properties']")
	private WebElement clickDynamicPropSection;
	
	@FindBy(xpath="//h1[text()='Dynamic Properties']")
	private WebElement txtDynamicPropSectionOpen;
	
	//@FindBy(xpath="//h1[text()='Dynamic Properties']")
	//private WebElement txtDynamicPropSectionOpen;
	
	
	//Methods
	public void clkBtnTxtBox()
	{
		//btnTxtBox.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", btnTxtBox);
		
		String displaytxtTxtBox=txtTxtBox.getText();
		System.out.println("Text box txt: "+displaytxtTxtBox);
		
		if (displaytxtTxtBox.equals("Text Box")) 
		{
			sa.assertEquals(displaytxtTxtBox, "Text Box");
			System.out.println("Text Box section open.....");
		}
		else{
		    System.out.println("Text Box section close.....");
		}
	}

	//Text box
	public void enterTxtUsername(String username) throws InterruptedException
	{
		Thread.sleep(3000);
		txtBoxUsername.click();
		txtBoxUsername.sendKeys(username);
		
	}
	
	public void enterTxtGmail(String gmail)
	{
		txtBoxGmail.sendKeys(gmail);
	}
	
	public void enterTxtCurrAdress(String currAdd)
	{
		txtCurrAddress.sendKeys(currAdd);
	}
	
	public void enterTxtPerAdress(String perAdd)
	{
		txtPerAddress.sendKeys(perAdd);
	}
	
	public void clickSubmit()
	{
		btnSubmit.click();
	}
	
	
	//CheckBox
	public void clickCheckboxSection()
	{
		clickCheckboxSection.click();
		
		String dispTxtCheckBoxSection=txtCheckBoxSection.getText();
		System.out.println("Checkbox section is open: "+dispTxtCheckBoxSection);
	}
	
	public void clickSelcetCheckBox()
	{
		selcetCheckbox.click();
		
		String dispTxtAfterSelectingCheckBox=txtAfterSelectingCheckBox.getText();
		System.out.println("CheckBoxClick: "+dispTxtAfterSelectingCheckBox);
		
		sa=new SoftAssert();
		
		if (dispTxtAfterSelectingCheckBox.equals("You have selected :")) 
		{
			sa.assertEquals(dispTxtAfterSelectingCheckBox,"You have selected :");
			System.out.println("Checkbox selected.....");
		}
		else{
		    System.out.println("Checkbox not selected.....");
		}
	}
	
	//Radio btn section
	public void clickRadioBtnSection()
	{
		clickRadioButtonSection.click();
		String dispTxtRadioBtnSectionOpen=radioBtnSectionOpen.getText();
		System.out.println("Radio Btn section open: "+dispTxtRadioBtnSectionOpen);
		
		sa=new SoftAssert();
		
		if (dispTxtRadioBtnSectionOpen.equals("Radio Button")) 
		{
			sa.assertEquals(dispTxtRadioBtnSectionOpen,"Radio Button");
			System.out.println("Radio btn section open.....");
		}
		else{
		    System.out.println("Radio btn section not open....");
		}
	} 	
	
	public void clickRadioBtn() throws InterruptedException
	{
		Thread.sleep(5000);
		//clickYesRadioBoxSection.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", clickYesRadioBoxSection);
		
		System.out.println("Yes Radio btn: "+clickYesRadioBoxSection.isSelected());
		
		System.out.println("No Radio btn: "+clickNoRadioBoxSection.isSelected());
		
		String dispTxtAfterYesRadioSection=txtAfterYesRadioSection.getText();
		System.out.println("Radio btn txt: "+dispTxtAfterYesRadioSection);
	}
	
	//Web table(add):
	public void clickBtnWebTableSection()
	{
		clickWebTableSection.click();
		String dispTxtWebTableSection=txtWebTableSection.getText();
		System.out.println("Web table Btn section open: "+dispTxtWebTableSection);
		
		sa=new SoftAssert();
		
		if (dispTxtWebTableSection.equals("Web Tables")) 
		{
			sa.assertEquals(dispTxtWebTableSection,"Web Tables");
			System.out.println("Web table section open.....");
		}
		else{
		    System.out.println("Web table section not open....");
		}
	} 	
	
	public void clickBtnAdd()
	{
		btnAddWebTable.click();
	}
	
	public void enterTxtFirstName(String firstName)
	{
		txtFirstName.sendKeys(firstName);
	}
	
	public void enterTxtLastName(String lastName)
	{
		txtLastName.sendKeys(lastName);
	}
	
	public void enterTxtUserEmail(String userEmail)
	{
		txtUserEmail.sendKeys(userEmail);
	}
	
	public void enterUserAge(String userAge)
	{
		txtUserAge.sendKeys(userAge);
	}
	
	public void enterUserSalary(String userSalary)
	{
		txtUserSalary.sendKeys(userSalary);
	}
	
	public void enterUserDepartment(String userDepartment)
	{
		txtUserDepartment.sendKeys(userDepartment);
	}
	
	public void clickBtnSubmitForRowAddition()
	{
		btnSubmitForRowAddition.click();
	}
	
	//Web table(edit):
	
	public void clickEditIconCustInfo()
	{
		iconEdit.click();
	}
	
	//int div=2;
	
	
	public void clickEditCustSalary(int i)
	{
		
		txtUserSalaryEdit.sendKeys();
	}
	
	
	public void clickBtnSubmitForRowEdition()
	{
		btnSubmitForRowEdition.click();
	}
	
	//Button
	public void clickBtnSection() throws InterruptedException
	{
		Thread.sleep(6000);
		//clickBtnSection.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", clickBtnSection);
	}
	
	public void clickBtnDoubleClick() throws InterruptedException
	{
		Thread.sleep(15000);
		Actions actions=new Actions(driver);
		actions.doubleClick(clickBtnDoubleClick).build().perform();
		System.out.println("Double click");
	}
	
	public void clickBtnRightClick()
	{
		Actions actions=new Actions(driver);
		actions.contextClick(clickBtnRightClick).build().perform();
		System.out.println("Right click");
	}
	
	public void clickBtnClickMe()
	{
		Actions actions=new Actions(driver);
		actions.click(clickBtnClickMe).build().perform();
		System.out.println("Click Me: ");
	}
	
	//link
	public void clickBtnLinkSection()
	{
		//clickLinkSection.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", clickLinkSection);
	}
	
	public void clickLinkHome()
	{
		clickHomeLink.click();
		
		//take control to new window- newwindow is new version features driver.switchTo().newWindow(WindowType.WINDOW);
		//every window has id and that called as window handel
		
		Set<String> handels = driver.getWindowHandles(); //parId,childID,subChil.........
		
		Iterator options=handels.iterator();
		String parentId= (String) options.next();
		String childId= (String) options.next();
		
		driver.switchTo().window(childId);
	}
	
	public void checkRedirectionHomePage()
	{
		String txtRedirectionValidationHomepage=redirectionValidationHomepage.getText();
		System.out.println("Redirection home page: "+txtRedirectionValidationHomepage);
		
		sa=new SoftAssert();
		
		if (txtRedirectionValidationHomepage.equals("Elements")) 
		{
			sa.assertEquals(txtRedirectionValidationHomepage,"Elements");
			System.out.println("Redirection succ.....");
		}
		else{
		    System.out.println("Redirection failed....");
		}
	}
	
	public void backToParentWind()
	{
		Set<String> handels = driver.getWindowHandles(); //parId,childID,subChil.........
		
		Iterator options=handels.iterator();
		String parentId= (String) options.next();
		String childId= (String) options.next();
		
		driver.switchTo().window(parentId);
		
		String dispTxtClickLinkSection=clickLinkSection.getText();
		System.out.println("Return back to links section: "+dispTxtClickLinkSection);
		
		sa=new SoftAssert();
		
		if (dispTxtClickLinkSection.equals("Links")) 
		{
			sa.assertEquals(dispTxtClickLinkSection,"Links");
			System.out.println("Return back to links section.....");
		}
		else
		{
		    System.out.println("Failed....");
		}
	}
	
	
	//broken link
	public void clickBrokenLinkSection() throws InterruptedException
	{
		Thread.sleep(5000);
		//clickBrokenLinkSection.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", clickBrokenLinkSection);
	}
	
	
	public void clickBrokenLink()
	{
		//clickBtnBrokenLink.click();
		
		// Iterating each link and checking the response status
		for (WebElement link : clickBtnBrokenLink) 
		{
			String url = link.getAttribute("href");
			verifyLink(url);
			}

			driver.quit();
			}

			public static void verifyLink(String url) {
			try 
			{
			URL link = new URL(url);
			HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
			httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
			httpURLConnection.connect();


			if (httpURLConnection.getResponseCode() == 200) 
			{
			System.out.println(url + " - " + httpURLConnection.getResponseMessage());
			} 
			else 
			{
			System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
			}
			} 
			catch (Exception e) 
			{
			System.out.println(url + " - " + "is a broken link");
			}
	}
		
		
	//upload and download
	public void clickUploadAndDownloadSection()
	{
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].click()", clickUploadAndDownloadSection);
	}
	
	public void clickBtnDownload()
	{
		clickBtnDownload.click();
			
	}
	
	public void clickBtnUpload()
	{
		clickBtnUpload.sendKeys("C:\\Users\\DELL\\Downloads\\SSR NATRAJ PG.pdf");
		String dispTxtUploadConfirm=clickBtnUpload.getText();
		System.out.println("File upload text: "+dispTxtUploadConfirm);
		
		sa=new SoftAssert();
		
		if (dispTxtUploadConfirm.equals("C:\\fakepath\\SSR NATRAJ PG.pdf")) 
		{
			sa.assertEquals(dispTxtUploadConfirm,"C:\\fakepath\\SSR NATRAJ PG.pdf");
			System.out.println("File upload succ.....");
		}
		else{
		    System.out.println("File upload Failed....");
		}
	}
}












