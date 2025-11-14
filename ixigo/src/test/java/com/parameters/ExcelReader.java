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


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.*;

public class ExcelReader {


    public static String readData(int sheetIndex, int rowNum) throws Exception {
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

        String pickup = cell.getStringCellValue();

        wb.close();
        fis.close();
        return pickup;
    }
}
