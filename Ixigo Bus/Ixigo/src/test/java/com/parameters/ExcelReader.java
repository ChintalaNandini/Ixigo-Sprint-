package com.parameters;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ExcelReader {
 
    public static Object[][] getExcelData(String sheetName) {
        Object[][] data = null;
        FileInputStream fis = null;
        Workbook workbook = null;
        try {
            String excelPath = System.getProperty("user.dir") + "/src/test/resources/com/ExcelData/BusData.xlsx";
            File file = new File(excelPath);
            if (!file.exists()) {
                throw new RuntimeException("Excel file not found at: " + excelPath);
            }
 
            fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }
 
            int rows = sheet.getPhysicalNumberOfRows();
            if (rows <= 1) {
                return new Object[0][0]; // no data rows
            }
 
            int cols = sheet.getRow(0).getPhysicalNumberOfCells();
            data = new Object[rows - 1][cols];
 
            DataFormatter formatter = new DataFormatter(); // safely format any cell type to string
 
            for (int i = 1; i < rows; i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;
                for (int j = 0; j < cols; j++) {
                    Cell cell = row.getCell(j);
                    String value = formatter.formatCellValue(cell);
                    data[i - 1][j] = value;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read Excel data: " + e.getMessage(), e);
        } finally {
            try { if (workbook != null) workbook.close(); } catch (Exception ignored) {}
            try { if (fis != null) fis.close(); } catch (Exception ignored) {}
        }
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