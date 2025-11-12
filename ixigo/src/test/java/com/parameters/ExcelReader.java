package com.parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExcelReader {
	
	
	public static File f;
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static WebDriver driver;
	static String checkIn;
	static String checkOut;

	public static void readExcelFile(WebDriver driver) throws IOException {
		f = new File(System.getProperty("user.dir") + "//src//test//resources//ExcelData//Search_input.xlsx");

		fis = new FileInputStream(f);
		wb = new XSSFWorkbook(fis);

		// Get the sheet named "Record"
		sheet = wb.getSheet("Sheet1");

		
		
		// Read vertical data (username in A1, password in A2)
		checkIn = sheet.getRow(0).getCell(1).getStringCellValue(); //
		checkOut = sheet.getRow(0).getCell(2).getStringCellValue(); //


		WebElement checkin = driver.findElement(By.xpath("//div[@data-placeholder='Check-in']"));
		WebElement checkout = driver.findElement(By.xpath("//div[@data-placeholder='Check-out']"));
		
	}
	
	
}
