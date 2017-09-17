package com.util;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils 
{
	public static FileInputStream fin;
	public static FileOutputStream fout;
	public static Workbook wb;
	public static Sheet ws;
	public static Row row;
	public static Cell cell;
	
	public static int getRowCount(String xlfile, int xlsheet) throws IOException
	{
		fin = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fin);
		ws = wb.getSheetAt(xlsheet);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fin.close();
		return rowcount;
	}
	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException
	{
		fin = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fin);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		int colcount = row.getLastCellNum();
		wb.close();
		fin.close();
		return colcount;
	}
	public static String getCellData(String xlfile, int xlsheet, int rownum, int colnum) throws IOException
	{
		fin = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fin);
		ws = wb.getSheetAt(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		String data = cell.getStringCellValue();
		return data;
	}
	public static void setCellData(String xlfile, int xlsheet, int rownum, int colnum, String data) throws IOException
	{
		fin = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fin);
		ws = wb.getSheetAt(xlsheet);
		row = ws.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fout = new FileOutputStream(xlfile);
		wb.write(fout);
		wb.close();
		fin.close();
		fout.close();
	}
	@SuppressWarnings("deprecation")
	public static void setGreenColor(String xlfile, int xlsheet, int rownum, int colnum) throws IOException
	{
		fin = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fin);
		ws = wb.getSheetAt(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		CellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fout = new FileOutputStream(xlfile);
		wb.write(fout);
		wb.close();
		fin.close();
		fout.close();
	}
	
	@SuppressWarnings("deprecation")
	public static void setRedColor(String xlfile, int xlsheet, int rownum, int colnum) throws IOException
	{
		fin = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fin);
		ws = wb.getSheetAt(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		CellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fout = new FileOutputStream(xlfile);
		wb.write(fout);
		wb.close();
		fin.close();
		fout.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
