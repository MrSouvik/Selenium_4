package com.selenium4.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Documents\\Testdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int lastRow = sheet.getLastRowNum();
		int noOfRow  = lastRow+1;
		int noOfCell = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("No of Row = "+noOfRow);
		System.out.println("No of Cell = "+noOfCell);
		for(int i=0; i<noOfRow; i++) {
			for(int j=0; j<noOfCell; j++) {
				String value = sheet.getRow(i).getCell(j).toString();
				System.out.print(value+" ");
			}
			System.out.println();
			
		//read status
			FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Documents\\Testdata.xlsx");
			if(i==0) {
				sheet.getRow(i).createCell(5).setCellValue("Read Status");
			}
			else {
				sheet.getRow(i).createCell(5).setCellValue(true);
			}
			
			workbook.write(fos);
		}
		workbook.close();
		fis.close();
	}
}
