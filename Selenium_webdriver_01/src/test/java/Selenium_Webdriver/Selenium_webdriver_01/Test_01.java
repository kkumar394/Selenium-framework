package Selenium_Webdriver.Selenium_webdriver_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test_01 extends Excel_Library
{
	WebDriver driver;
	@Test//(dataProvider = "excelData")
	public void Test_Google() throws Throwable {
		
		  ConfigReader cr =new ConfigReader();  
		
		  System.setProperty("webdriver.chrome.driver", cr.getChromePath()); 
		
		  driver = new ChromeDriver(); 
		  
		  driver.manage().window().maximize();

		  driver.get(cr.getURL());  //this code is added to get the URL
		  
		  Utils.captureScreenshot(driver, "Capture_googlepage");// to capture screenshot

		  Thread.sleep(2000);  // Let the user actually see something!     

		  WebElement searchBox = driver.findElement(By.name("b"));

		  searchBox.sendKeys("singapore");     

		  searchBox.submit();  
		  
		  //driver.findElement(By.id("email").sendKeys("krisshpa"));
		  //driver.findElement(By.id("pass").sendKeys("aA9871943907@"));)
		  
		  Utils.captureScreenshot(driver, "Result appeared");

		  Thread.sleep(2000);  // Let the user actually see something!     

		  driver.quit();  
		
	} 
	
	@DataProvider(name="excelData")
	public Object[][] passData (){
		
		Excel_Library el =new Excel_Library();
		
		int rows= el.getRowCount();
				
		Object[][] data = new Object[rows][2];	
		
		for(int i=0;i<rows;i++) {		
		
		data [i][0] = el.getData(0, i, 0);
		data [i][0] = el.getData(0, i, 1);
		}
		
		return data;
	}
		
	
}
