package com.selenium4.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	
	public static int getRowCount(String xFile, String xSheet) throws IOException {
		fis=new FileInputStream(xFile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(xSheet);
		int rowCount  = ws.getLastRowNum();
		wb.close();
		fis.close();
		return rowCount;
	}
	
	public static int getCellCount(String xFile, String xSheet,int rowNum) throws IOException {
		fis=new FileInputStream(xFile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(xSheet);
		row = ws.getRow(rowNum);
		int cellCount  = row.getLastCellNum();
		wb.close();
		fis.close();
		return cellCount;
		
	}
	
	public static String getCellDate(String xFile, String xSheet, int rowNum, int colNum) throws IOException {
		fis=new FileInputStream(xFile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(xSheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(colNum);
		
		String data;
		
		try {
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);
		}
		catch (Exception e) {
			data = "";
		}
		wb.close();
		fis.close();
		return data;
	}
	
	public static void setCellData(String xFile, String xSheet, int rowNum, int colNum,String data) throws IOException {
		fis=new FileInputStream(xFile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(xSheet);
		row = ws.getRow(rowNum);
		cell = row.createCell(colNum);
		cell.setCellValue(data);
		fos = new FileOutputStream(xFile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}
	
	public static void fillGreenColour(String xFile, String xSheet, int rownum, int colnum) throws IOException {
		fis = new FileInputStream(xFile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(xSheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		
		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		
		fos = new FileOutputStream(xFile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}
	
	public static void fillRedColour(String xFile, String xSheet, int rownum, int colnum) throws IOException {
		fis = new FileInputStream(xFile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(xSheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		
		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		
		fos = new FileOutputStream(xFile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}
}
