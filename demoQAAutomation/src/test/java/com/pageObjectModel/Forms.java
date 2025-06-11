package com.pageObjectModel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.baseClass.BaseClass;

public class Forms extends BaseClass{
	
	WebDriver driver;
	SoftAssert sa;
	
	//Const
	public Forms(WebDriver gdriver)
	{
		driver=gdriver;
		PageFactory.initElements(gdriver, this);
	}
	
	
	//Locators
	@FindBy(xpath="//span[text()='Practice Form']")
	private WebElement clickPracticeFormSection;
	
	@FindBy(xpath="//h1[text()='Practice Form']")
	private WebElement txtFormsSectionOpenConfirmation;
	
	@FindBy(xpath="//input[@id='firstName']")
	private WebElement txtBoxFirstName;
	
	@FindBy(xpath="//input[@id='lastName']")
	private WebElement txtBoxLastName;
	
	@FindBy(xpath="//input[@id='userEmail']")
	private WebElement txtBoxEmail;
	
	@FindBy(xpath="//input[@value='Female']")
	private WebElement radioBtnGender;
	
	@FindBy(xpath="//input[@id='userNumber']")
	private WebElement txtBoxNumber; 	
	
	@FindBy(xpath="//input[@id='dateOfBirthInput']")
	private WebElement txtBoxDOB;

	@FindBy(xpath="//select[@class='react-datepicker__year-select']")
	private WebElement selectYear;
	
	@FindBy(xpath="//select[@class='react-datepicker__month-select']")
	private WebElement selectMonth;
	
	@FindBy(xpath="//div[@aria-label='Choose Sunday, July 16th, 2000']")
	private WebElement selectDate;
	
	@FindBy(xpath="//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']")
	private WebElement txtBoxSubject;
	
	@FindBy(xpath="//input[@value='3']")
	private WebElement txtBoxHobbies;
	
	@FindBy(xpath="//input[@id='uploadPicture']")
	private WebElement clickBtnUploadImage;
	
	@FindBy(xpath="//textarea[@id='currentAddress']")
	private WebElement txtBoxCurrAdd;
	
	@FindBy(xpath="//div[@id='state']")
	private WebElement selectState;
	
	@FindBy(xpath="//div[@id='city']")
	private WebElement selectCity;
	
	@FindBy(xpath="//button[@id='submit']")
	private WebElement clickBtnSubmit;
	
	
	//methods
	public void clickClickPracticeFormSection()
	{
		//clickPracticeFormSection.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", clickPracticeFormSection);
	}
	
	public void displayTxtFormsSectionOpenConfirmation()
	{
		String dispTxtFormsSectionOpenConfirmation= txtFormsSectionOpenConfirmation.getText();
		System.out.println("Form section is open: "+dispTxtFormsSectionOpenConfirmation);
	}

	public void enterTxtFirstName(String firstName)
	{
		txtBoxFirstName.sendKeys(firstName);
	}
	
	public void enterTxtLastName(String lastName)
	{
		txtBoxLastName.sendKeys(lastName);
	}
	
	public void enterTxtEmail(String gmailForm)
	{
		txtBoxEmail.sendKeys(gmailForm);
	}
	
	public void selectRadioBtnGender()
	{
		try {
			Thread.sleep(7000);
		} 
		catch (InterruptedException e) 
		{
			
			e.printStackTrace();
		}
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", radioBtnGender);
	}
	
	public void enterTxtMobile(String number)
	{
		txtBoxNumber.sendKeys(number);
	}
	
	public void selectDOB() throws InterruptedException
	{
		
		txtBoxDOB.click();
		
		Select selYear = new Select(selectYear);
		selYear.selectByVisibleText("2000");
		
		Select selMonth = new Select(selectMonth);
		selMonth.selectByVisibleText("July");
		
		//selectDate.click();
		
		Thread.sleep(15000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", selectDate);
	}
	
	public void enterTxtBoxSubject(String subject)
	{
		txtBoxSubject.click();
		//txtBoxSubject.sendKeys(subject);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0]sendKeys(subject)", txtBoxSubject);
	}
	
	public void chooseTxtBoxHobbies()
	{
		//txtBoxHobbies.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", txtBoxHobbies);
	}
	
	public void clickBtnUploadImage(String image)
	{
		clickBtnUploadImage.sendKeys(image);
	}
	
	public void enterTxtBoxCurrAdd(String currAddForms)
	{
		txtBoxCurrAdd.sendKeys(currAddForms);
	}
	
	public void selectStateAndCity()
	{
		Select selState=new Select(selectState);
		selState.selectByVisibleText("NCR");
		
		Select selCity=new Select(selectCity);
		selCity.selectByVisibleText("Delhi");

	}
	
	public void clickBtnSubmit()
	{
		clickBtnSubmit.click();
	}
	
}

















