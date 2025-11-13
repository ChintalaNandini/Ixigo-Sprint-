package com.parameters;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ExcelReader {
 
	public Object[][] getExcelData(String sheetName) throws IOException {
	    String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\BusData.xlsx";
	    FileInputStream fis = new FileInputStream(excelPath);
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheet(sheetName);

	    int totalRows = sheet.getPhysicalNumberOfRows();
	    int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();

	    Object[][] data = new Object[totalRows - 1][totalCols];

	    for (int i = 1; i < totalRows; i++) {
	        XSSFRow row = sheet.getRow(i);
	        for (int j = 0; j < totalCols; j++) {
	            XSSFCell cell = row.getCell(j);
	            if (cell == null) {
	                data[i - 1][j] = "";
	            } else {
	                cell.setCellType(CellType.STRING);
	                data[i - 1][j] = cell.getStringCellValue();
	            }
	        }
	    }

	    workbook.close();
	    fis.close();
	    return data;
	}

}




//"src/test/resources/ExcelData/BusData.xlsx"
















































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