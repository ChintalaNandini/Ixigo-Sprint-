package com.parameters;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.*;

public class ExcelReader {

	public static Properties prop;

    public static String readData(int sheetIndex, int rowNum) throws Exception {
        //String excelPath = "C:\\Users\\siddach\\trainingss\\ixigo\\src\\test\\resources\\ExcelData\\Inputs.xlsx";
        
        prop = PropertyReader.readProperty(); 
        String excelPath = prop.getProperty("excelpath");
        FileInputStream fis = new FileInputStream(excelPath);
        Workbook wb = WorkbookFactory.create(fis);

        Sheet sheet = wb.getSheetAt(sheetIndex);

        
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            wb.close();
            fis.close();
            throw new Exception("Row " + rowNum + " not found in sheet " + sheetIndex);
        }

        Cell cell = row.getCell(0);
        if (cell == null) {
            wb.close();
            fis.close();
            throw new Exception("Cell not found at row " + rowNum);
        }

        String pickup = cell.getStringCellValue();

        wb.close();
        fis.close();
        return pickup;
    }
    
    public static String readData1(int sheetIndex, int rowNum) throws Exception {
        String excelPath = "C:\\Users\\siddach\\trainingss\\ixigo\\src\\test\\resources\\ExcelData\\Inputs.xlsx";
        FileInputStream fis = new FileInputStream(excelPath);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheetAt(sheetIndex);
        Row row = sheet.getRow(rowNum);

        if (row == null) {
            wb.close();
            fis.close();
            throw new Exception("Row " + rowNum + " not found in sheet " + sheetIndex);
        }

        Cell cell = row.getCell(0);
        if (cell == null) {
            wb.close();
            fis.close();
            throw new Exception("Cell not found at row " + rowNum);
        }

        String pickup;
        switch (cell.getCellType()) {
            case STRING:
                pickup = cell.getStringCellValue();
                break;
            case NUMERIC:
                // Convert numeric to long and then to string to preserve leading zeros
                pickup = String.valueOf(BigDecimal.valueOf(cell.getNumericCellValue()).toPlainString());
                break;
            default:
                wb.close();
                fis.close();
                throw new Exception("Unsupported cell type at row " + rowNum);
        }

        wb.close();
        fis.close();
        return pickup;
    }
}
