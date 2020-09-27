package com.walmart.util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static void main(String[] args) {
		getRowCount();
	}
	public static void getRowCount() 
	{
		XSSFWorkbook workbook;
		try {
		String projectpath=	System.getProperty("user.dir");
			workbook = new XSSFWorkbook(projectpath+"\\src\\main\\java\\com\\walmart\\testdata\\walmart.xlsx");
			XSSFSheet sheet = workbook.getSheet("email"); 
			int rowCount= sheet.getPhysicalNumberOfRows();
			System.out.println(rowCount);
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	
}
