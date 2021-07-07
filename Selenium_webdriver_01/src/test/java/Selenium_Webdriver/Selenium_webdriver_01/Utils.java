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

	
	public static String captureScreenshot(WebDriver driver, String screenshotName)throws Exception {
			TakesScreenshot ts =(TakesScreenshot) driver;
			File Source =ts.getScreenshotAs(OutputType.FILE);
			String path=(System.getProperty("user.dir")+"/Screenshots/"+screenshotName+".png");
			
			File destination = new File(path);
		try {
			
			FileHandler.copy(Source, destination);
			System.out.println("ScreenShot taken");
			
			}
		catch(Exception e) {
			System.out.println(e.getMessage());
			}
		System.out.println(path);
		return path;
	}
	
	
}
