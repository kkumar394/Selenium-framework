package Selenium_Webdriver.Selenium_webdriver_01;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	Properties pro;
	public ConfigReader()
	{
		
		try
		{	
		File src = new File  ("./Configuration/Config.property");
		FileInputStream fis = new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	public String getChromePath()
	{
		String path = pro.getProperty("ChromeDriver");
		return path;
	}
	
	public String getURL()
	{
		String path = pro.getProperty("URL");
		return path;
	}
	
	public String getExcelPath()
	{
		String path = pro.getProperty("ExcelPath");
		return path;
	}
	
	
	
	}

