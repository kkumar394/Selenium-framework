package Selenium_Webdriver.Selenium_webdriver_01;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test_01 //extends Excel_Library
{
	WebDriver driver;
	PageObject pg;
	@Test(dataProvider = "excelData")
	public void Test_Google(String User, String pwd) throws Throwable {
		  
		
		  ConfigReader cr =new ConfigReader();  
		
		  System.setProperty("webdriver.chrome.driver", cr.getChromePath()); 
		
		  driver = new ChromeDriver(); 
		  pg= new PageObject(driver);
		  
		  driver.manage().window().maximize();

		  driver.get(cr.getURL());  //this code is added to get the URL
		  
		  Utils.captureScreenshot(driver, "Capture_googlepage");// to capture screenshot

		  Thread.sleep(2000);  // Let the user actually see something!     

		  pg.Uname(User);
		  pg.Pwd(pwd);
		  pg.Login();
		  
		  Utils.captureScreenshot(driver, "Result appeared");

		  Thread.sleep(2000);  // Let the user actually see something!     

		  driver.quit();  
		
	} 
	
	@DataProvider(name="excelData")
	String[][] passData ()throws IOException
	{
		int rownum = xlUtils.getRowCount("Sheet1");
		int colCount = xlUtils.getColCount("Sheet1", rownum);
		
		String data[][] =new String[rownum][colCount];
		for(int i=1;i<=rownum;i++)
		{
			for (int j=0;j<colCount;j++)
			{
				data[i-1][j] =xlUtils.getCellData("Sheet1", i, j);
			}
		}
		return data;
	}
		
	
}
