package com.appium.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelReader {

	private XSSFWorkbook wb = null;
	private XSSFSheet sheet = null;
	private String filePath;
	
	public ExcelReader(String filePath) {
		this.filePath=filePath;
	}
	
	public void ReadExcel(String sheetName,String column) throws IOException {
		
		FileInputStream fis = new FileInputStream(new File(this.filePath));
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		int count = sheet.getLastRowNum();
		for(int i =1;i<count;i++)
		{
			int cellcount = sheet.getRow(i).getLastCellNum();
			for(int j =0;j<cellcount;j++)
			{
				if(sheet.getRow(0).getCell(j).getStringCellValue().equals("TestCase"))
				{
					System.out.println(sheet.getRow(i).getCell(j).getNumericCellValue());
				}
				else
				{
					System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
				}
			}
			
		}
	}
}
