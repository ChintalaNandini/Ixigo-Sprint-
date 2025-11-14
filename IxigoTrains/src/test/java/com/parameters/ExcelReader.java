package com.parameters;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelReader {
	public static String[] getRowData(int sheetNo, int rowNum) throws IOException {
	    String filePath = "src/test/resources/ExcelData/Book4.xlsx";
	    FileInputStream file = new FileInputStream(filePath);
	    Workbook workbook = new XSSFWorkbook(file);
	    Sheet sheet = workbook.getSheetAt(sheetNo);
	    DataFormatter formatter = new DataFormatter();
	    // Get header row to determine column count
	    Row headerRow = sheet.getRow(0);
	    int colCount = headerRow.getLastCellNum();
	    // Read target row
	    Row row = sheet.getRow(rowNum);
	    String[] rowData = new String[colCount];
	    for (int j = 0; j < colCount; j++) {
	        Cell cell = (row != null) ? row.getCell(j) : null;
	        rowData[j] = (cell != null) ? formatter.formatCellValue(cell) : "";
	    }
	    workbook.close();
	    file.close();
	    return rowData;
	}
	
	public static String getDataByRowCol(String filePath, int sheetIndex, int rowIndex, int colIndex) {
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             XSSFWorkbook wb = new XSSFWorkbook(fis)) {
            XSSFSheet sheet = wb.getSheetAt(sheetIndex);
            Row row = sheet.getRow(rowIndex);
            if (row == null) return null;
            Cell cell = row.getCell(colIndex);
            if (cell == null) return null;
            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
//  for Source
    public static String getSource(String filePath, int sheetIndex, int rowIndex, int sourceCol) {
        return getDataByRowCol(filePath, sheetIndex, rowIndex, sourceCol);
    }
 
    //  for Destination
    public static String getDestination(String filePath, int sheetIndex, int rowIndex, int destinationCol) {
        return getDataByRowCol(filePath, sheetIndex, rowIndex, destinationCol);
    }
}


























































//package com.parameters;
// 
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//public class ExcelReader {
//	File f;
//	FileInputStream fis ;
//	XSSFWorkbook wb;
//	XSSFSheet sh ;
////path of file -- parameterized constructor
//	public ExcelReader(String filepath) // input of the excel file
//	{		
//		 try {
//			 f= new File(filepath);
//			fis = new FileInputStream(f);
//			wb= new XSSFWorkbook(fis);
//		} catch (IOException e)
//		 {			
//			e.printStackTrace();
//		}
//	}
//	//data from cell
//	public String getCellData(int sheetno , int row , int col)  //actual data read from excel
//	{
//		sh = wb.getSheetAt(sheetno);
//		 DataFormatter formatter = new DataFormatter();
//		 String value=formatter.formatCellValue(sh.getRow(row).getCell(col));
//		//String value=sh.getRow(row).getCell(col).getStringCellValue();
//		 return value;
//	}
// 
//	//count of rows
//	public int getRowcount(int sheetno)
//	{
//		sh = wb.getSheetAt(sheetno);
//		int rows=sh.getLastRowNum();
//		return rows;
//	}
//	//count of columns
//	public int getColcount(int sheetno)
//	{
//		sh = wb.getSheetAt(sheetno);
//		int cols=sh.getRow(0).getLastCellNum();
//		return cols;
//	}
//}


























































//package com.parameters;
// 
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//public class ExcelReader {
//	File f;
//	FileInputStream fis ;
//	XSSFWorkbook wb;
//	XSSFSheet sh ;
////path of file -- parameterized constructor
//	public ExcelReader(String filepath) // input of the excel file
//	{		
//		 try {
//			 f= new File(filepath);
//			fis = new FileInputStream(f);
//			wb= new XSSFWorkbook(fis);
//		} catch (IOException e)
//		 {			
//			e.printStackTrace();
//		}
//	}
//	//data from cell
//	public String getCellData(int sheetno , int row , int col)  //actual data read from excel
//	{
//		sh = wb.getSheetAt(sheetno);
//		 DataFormatter formatter = new DataFormatter();
//		 String value=formatter.formatCellValue(sh.getRow(row).getCell(col));
//		//String value=sh.getRow(row).getCell(col).getStringCellValue();
//		 return value;
//	}
// 
//	//count of rows
//	public int getRowcount(int sheetno)
//	{
//		sh = wb.getSheetAt(sheetno);
//		int rows=sh.getLastRowNum();
//		return rows;
//	}
//	//count of columns
//	public int getColcount(int sheetno)
//	{
//		sh = wb.getSheetAt(sheetno);
//		int cols=sh.getRow(0).getLastCellNum();
//		return cols;
//	}
//}