package com.lms.api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelReader {
	 public Map<String, String> readRequestBodyDetailsForUserModule() throws IOException {
	      
	       FileInputStream fis=new FileInputStream("C://Users//Ranji//Downloads//Punitha.xlsx");
		 /*String path="./src/test/resources/TestData/Punitha.xlsx";
		 File excelFile=new File(path);
		  FileInputStream fis=new FileInputStream();*/
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);

	        XSSFSheet dataSheet = workbook.getSheet("Sheet1");
	        if (dataSheet == null || dataSheet.getPhysicalNumberOfRows() < 2) {
	            throw new IllegalStateException("Invalid Excel sheet structure");
	        }

	        Map<String, String> requestDetails = new HashMap();

	        // Assuming the first row contains keys and the second row contains values
	        Row keyRow = dataSheet.getRow(0);
	        Row valueRow = dataSheet.getRow(1);

	        Iterator<Cell> keyCellIterator = keyRow.cellIterator();
	        Iterator<Cell> valueCellIterator = valueRow.cellIterator();

	        while (keyCellIterator.hasNext() && valueCellIterator.hasNext()) {
	            Cell keyCell = keyCellIterator.next();
	            Cell valueCell = valueCellIterator.next();

	            String key = getStringValueFromCell(keyCell);
	            String value = getStringValueFromCell(valueCell);

	            requestDetails.put(key, value);
	        }

	        return requestDetails;
	    }

	    private String getStringValueFromCell(Cell cell) {
	        if (cell == null) {
	            return ""; // Handle null cells if necessary
	        }

	        switch (cell.getCellType()) {
	            case STRING:
	                return cell.getStringCellValue();
	            case NUMERIC:
	                return String.valueOf(cell.getNumericCellValue());
	            case BOOLEAN:
	                return String.valueOf(cell.getBooleanCellValue());
	           
	            default:
	                return "";
	        }
	    }
	
}
	




