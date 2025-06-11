package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesClass {
	
	
	public static Properties readProperties() throws IOException
	{
	Properties prop = new Properties();
	
	FileInputStream file = new FileInputStream("D:\\Automation_Practice\\demoQAAutomation\\config.properties");
	
	prop.load(file);
	return prop;
	}
	
	public static String getBaseUrl() throws IOException
	{
		return readProperties().getProperty("baseUrl");
	}

	public static String getFullName() throws IOException
	{
		return readProperties().getProperty("fullName");
	}
	
	public static String getGmail() throws IOException
	{
		return readProperties().getProperty("gmail");
	}
	
	public static String getCurrAdd() throws IOException
	{
		return readProperties().getProperty("currAdd");
	}
	
	public static String getPerAdd() throws IOException
	{
		return readProperties().getProperty("perAdd");
	}
	
	public static String getFirstName() throws IOException
	{
		return readProperties().getProperty("firstName");
	}
	
	public static String getLastName() throws IOException
	{
		return readProperties().getProperty("lastName");
	}
	
	//Table
	public static String getUserEmail() throws IOException
	{
		return readProperties().getProperty("userEmail");
	}
	
	public static String getUserAge() throws IOException
	{
		return readProperties().getProperty("userAge");
	}
	
	public static String getUserSalary() throws IOException
	{
		return readProperties().getProperty("userSalary");
	}
	
	public static String getUserDepartment() throws IOException
	{
		return readProperties().getProperty("userDepartment");
	}
	
	//forms section
	public static String getFirstNameForms() throws IOException
	{
		return readProperties().getProperty("firstName");
	}
	
	public static String getLastNameForms() throws IOException
	{
		return readProperties().getProperty("lastName");
	}
	
	public static String getGmailForms() throws IOException
	{
		return readProperties().getProperty("gmailForms");
	}
	
	public static String getNumber() throws IOException
	{
		return readProperties().getProperty("number");
	}
	
	public static String getSubject() throws IOException
	{
		return readProperties().getProperty("subject");
	}
	
	public static String getImage() throws IOException
	{
		return readProperties().getProperty("image");
	}
	
	public static String getCurrAddForms() throws IOException
	{
		return readProperties().getProperty("currAddForms");
	}
}
