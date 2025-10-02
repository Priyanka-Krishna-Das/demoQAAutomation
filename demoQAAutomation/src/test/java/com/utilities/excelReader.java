package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xslf.usermodel.XSLFCommentAuthors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class excelReader {
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
