package Selenium_Webdriver.Selenium_webdriver_01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class xlUtils {
	 
		public static File src;
	 	public static FileInputStream fis;
		public static FileOutputStream fos;
		public static XSSFWorkbook wb;
		public static XSSFSheet ws;
		public static XSSFRow row;
		public static XSSFCell cell;
	
		public static ConfigReader cr =new ConfigReader();
	
	public static int getRowCount (String Xlsheet) throws IOException
	{
			File src =new File(cr.getExcelPath());
			fis = new FileInputStream (src);
			wb = new XSSFWorkbook(fis);
			ws =wb.getSheet(Xlsheet);
			int rowCount =ws.getLastRowNum();
			wb.close();
			fis.close();
			return rowCount;
		
	}
	
	public static int getColCount (String Xlsheet, int rownum) throws IOException
	{
			src =new File(cr.getExcelPath());
			fis = new FileInputStream (src);
			wb = new XSSFWorkbook(fis);
			ws =wb.getSheet(Xlsheet);
			row = ws.getRow(rownum);
			int cellCount = row.getLastCellNum();
			wb.close();
			fis.close();
			return cellCount;
		
	}
	

	public static String getCellData (String Xlsheet, int row, int column) throws IOException 
	{	
		src =new File(cr.getExcelPath());
		fis = new FileInputStream (src);
		ws =wb.getSheet(Xlsheet);
		String data= ws.getRow(row).getCell(column).getStringCellValue();
		wb.close();
		fis.close();
		return data;
	} 
	
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fos=new FileOutputStream(xlfile);
		wb.write(fos);		
		wb.close();
		fis.close();
		fos.close();
	}
	
	
	
}
