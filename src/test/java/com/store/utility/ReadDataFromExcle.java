package com.store.utility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcle {

	public static FileInputStream inputstream;
	public static XSSFWorkbook workbook;
	public static XSSFSheet exclesheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static String getCellValue(String filename,String sheetname,int rowno,int cellno) {
		
		try {
			inputstream=new FileInputStream(filename);
			workbook= new XSSFWorkbook(inputstream);
			exclesheet = workbook.getSheet(sheetname);
			cell=workbook.getSheet(sheetname).getRow(rowno).getCell(cellno);
			
			workbook.close();
			return cell.getStringCellValue();
		}
		catch(Exception e) {
			return "Failed";
		}
	}
	
	public static int getRowCount(String filename, String sheetname) {
		
		try {
			inputstream = new FileInputStream(filename);
			workbook=new XSSFWorkbook(inputstream);
			exclesheet = workbook.getSheet(sheetname);
			
			int ttlrows = exclesheet.getLastRowNum()+1;
			
			workbook.close();
			return ttlrows;
		}
		catch (Exception e) {
			return 0;
		}
		
	}
	
public static int getColumnCount(String filename, String sheetname) {
		
		try {
			inputstream = new FileInputStream(filename);
			workbook=new XSSFWorkbook(inputstream);
			exclesheet = workbook.getSheet(sheetname);
			
			int ttlcolumn = exclesheet.getLastRowNum()+1;
			
			workbook.close();
			return ttlcolumn;
		}
		catch (Exception e) {
			return 0;
		}
		
	}
	
}
