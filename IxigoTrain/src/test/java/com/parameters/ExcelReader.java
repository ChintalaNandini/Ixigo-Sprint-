package com.parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

  
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

//System.out.println("Total sheets in Excel: " + wb.getNumberOfSheets());
//for (int i = 0; i < wb.getNumberOfSheets(); i++) {
//    System.out.println("Sheet " + i + ": " + wb.getSheetName(i));
//}