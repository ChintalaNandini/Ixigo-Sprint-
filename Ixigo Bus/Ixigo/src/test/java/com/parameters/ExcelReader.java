package com.parameters;


import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    public static String getCellData(String sheetName, int rowNum, int colNum) throws Exception {
        FileInputStream fis = new FileInputStream("src/test/resources/ExcelData/Book2.xlsx");
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);
        workbook.close();
        return cell.toString();
    }
}


	
























































//import java.io.FileInputStream;
//import java.io.IOException;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
// 
//
//
//
//public class ExcelReader {
//	public static String getCellData(String sheetname,int rowNum, int colNum) throws IOException {
//		FileInputStream file = new FileInputStream("src/test/resources/ExcelData/Book2.xlsx");
//		Workbook workbook = new XSSFWorkbook(file);
//		Sheet sheet = workbook.getSheet(sheetname);
//		Row row = sheet.getRow(rowNum);
//		Cell cell = row.getCell(colNum);
//
//		String value;
//		switch(cell.getCellType()) {
//		case STRING:
//			value = cell.getStringCellValue();
//			break;
//		case NUMERIC:
//			value = String.valueOf((long) cell.getNumericCellValue());
//			break;
//		case BOOLEAN:
//			value = String.valueOf(cell.getBooleanCellValue());
//			break;
//			default:
//				value ="";
//		}
//		workbook.close();
//		file.close();
//		return value;
//
//
//	}
//}