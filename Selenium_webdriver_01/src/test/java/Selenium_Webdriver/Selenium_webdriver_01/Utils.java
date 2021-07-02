package Selenium_Webdriver.Selenium_webdriver_01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;

public class Utils {

	
	public static void captureScreenshot(WebDriver driver, String screenshotName)throws Exception {
		
		try {
			TakesScreenshot ts =(TakesScreenshot) driver;
			File Source =ts.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(Source, new File("./Screenshots/"+ screenshotName+".png"));
			System.out.println("ScreenShot taken");
			
			
			}
		catch(Exception e) {
			System.out.println(e.getMessage());
			}
	}
	
	
}
