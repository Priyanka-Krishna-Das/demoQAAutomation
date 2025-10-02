package com.baseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.utilities.PropertiesClass;

public class BaseClass extends PropertiesClass{
	
	public static WebDriver driver;
	
	@BeforeClass
	@Parameters("browser")
	public void setUp(String br) throws IOException
	{
		if(br.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get(getBaseUrl());
	}
	
	@FindBy(xpath="//input[@placeholder='Salary']")
	private static WebElement txtUserSalaryEdit;
	
	public static int slaryEdit()
	{
		String salary=txtUserSalaryEdit.getText();
		System.out.println("Before changing: "+salary);
		int total=Integer.parseInt(salary)+2;
		return total;
	}
	
	
	@DataProvider(name="data")
	public static void data() throws IOException
	{
		try 
		{
	        String filePath = "/demoQAAutomation/src/test/java/com/utilities/testDataForDemoQA.xlsx";
	        FileInputStream file = new FileInputStream(filePath);
	        
	        System.out.println("File opened successfully");
	        
	        XSSFWorkbook workbook=new XSSFWorkbook(file);
	        
	        XSSFSheet row10= workbook.getSheet("Sheet1");
	        XSSFCell valueReader = row10.getRow(1).getCell(0);
	        String row1= valueReader.getStringCellValue();
	        
	        
	        
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	
	

}
