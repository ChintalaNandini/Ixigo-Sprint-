package com.parameters;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class PropertyReader {
	public static Properties readProperty() {
		Properties prop = null;
		 //Properties prop = new Properties();
		String fileName = ".\\src\\test\\resources\\PropertiesFile\\profile.properties";
	       // String fileName = System.getProperty("user.dir") + "/src/test/resources/PropertiesFile/profile.properties";
		try
		{
			FileInputStream fis  = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);				
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File name or file path is not correct");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return prop;
		
	}

}