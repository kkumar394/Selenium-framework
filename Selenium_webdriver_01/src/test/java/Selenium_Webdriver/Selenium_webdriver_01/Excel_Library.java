package Selenium_Webdriver.Selenium_webdriver_01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;






public class Excel_Library {
	
	//FileInputStream fis;
	 public XSSFWorkbook wb;
	 public XSSFSheet sheet1;
	
	ConfigReader cr =new ConfigReader();
	public Excel_Library ()  {
	
	try {
		File src =new File(cr.getExcelPath());
		FileInputStream fis = new FileInputStream (src);
		 wb = new XSSFWorkbook(fis);
		 //System.out.println(sheet1);
		 //wb.close();
		}

	 catch (Exception e) {
		System.out.println(e.getMessage());
	 	}
	
	
	}
	

	public String getData (int sheetNumber, int row, int column) {
		sheet1 =wb.getSheetAt(sheetNumber);
		String data= sheet1.getRow(row).getCell(column).getStringCellValue();
		
		return data;
	} 
	
	public int getRowCount () {
		int rowcount =sheet1.getLastRowNum();
		
		return rowcount;
	} 
	
	
}
