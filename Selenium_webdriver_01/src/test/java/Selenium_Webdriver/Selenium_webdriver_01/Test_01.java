package Selenium_Webdriver.Selenium_webdriver_01;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import junit.framework.Assert;

public class Test_01 extends BaseClass
{	

@Test(dataProvider = "excelData")
public void Test_Google(String User, String pwd) throws Exception {
		
		
			test=extent.createTest("Test OpenMRS Application"); 
			PageObject pg= new PageObject(driver); 
			String Capture_googlepath =  Utils.captureScreenshot(driver, "Capture_googlepage");// to capture screenshot
			test.log(Status.PASS, "Screenshot taken for the Login Page");
			test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(Capture_googlepath).build());
			test.log(Status.PASS, "test started");
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);   

			pg.Uname(User);
			test.log(Status.PASS, "Username Entered");
			pg.Pwd(pwd);
		  	test.log(Status.PASS, "Password Entered");
		  	pg.Locationlist("Isolation Ward");
		  	test.log(Status.PASS,"Location Selected");
		  	pg.Login();
		  	test.log(Status.PASS,"Clicked on Login button");
		  
		  	Thread.sleep(5000);  // Let the user actually see something!
		  	String Result_Appeared = Utils.captureScreenshot(driver, "Result appeared");
		  	test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(Result_Appeared).build());
		  	test.log(Status.PASS, "Screenshot taken for the Home page");
		  	String Actual_Title = driver.getTitle();
		  	System.out.println(Actual_Title);
		  	String Expected_Title = "Home";
		  	
		  	if(Actual_Title.equals(Expected_Title)) 
		  	{
		  		test.log(Status.PASS, "Test Case Pass for the page");
		  	}
		  	else
		  	{
		  		test.log(Status.FAIL, "test Fail");
		  		String Test_fail;
		  		Test_fail = Utils.captureScreenshot(driver, "Wrong title");
				test.fail("Test fail as title wrong", MediaEntityBuilder.createScreenCaptureFromPath(Test_fail).build());
		  	}
		
		
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
