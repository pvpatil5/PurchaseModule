package com.vtiger.genericLib;

import java.io.FileInputStream;

//import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.testng.annotations.Test;

public class ExcelUtility {

	public String excelUtility(String sheetname, int rowno, int cellno) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstant.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Cell cell=wb.getSheet(sheetname).getRow(rowno).getCell(cellno);
		return cell.getStringCellValue();
		
	}
	public String sendNumericCellValue(String sheetname, int rowno, int cellno) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstant.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Cell cell=wb.getSheet(sheetname).getRow(rowno).getCell(cellno);
		int value=(int) cell.getNumericCellValue();
		return String.valueOf(value);
		
	}

}
