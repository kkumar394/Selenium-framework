package Selenium_Webdriver.Selenium_webdriver_01;

import java.text.SimpleDateFormat;
import java.util.Date;

//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass  extends TestListenerAdapter
{

public WebDriver driver;
public ExtentHtmlReporter htmlReporter;
public ExtentReports extent;
public ExtentTest test;
public ConfigReader cr;

@BeforeSuite
public void extentReports()
{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";
		
		htmlReporter=new ExtentHtmlReporter (System.getProperty("user.dir")+ "/test-output/"+repName);//specify location of the report
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		
		extent=new ExtentReports();
		
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","kkumar");
		
		htmlReporter.config().setDocumentTitle("Selenium_WebDriver"); // Tile of report
		htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.STANDARD);
	
	
	
}

@BeforeClass
public void setUp()
{	
		cr = new ConfigReader();
		System.setProperty("webdriver.chrome.driver", cr.getChromePath()); 
	
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get(cr.getURL()); 
		  
}
	 


@AfterClass
public void tearDown()
{
		driver.quit();
}

@AfterSuite
public void ExtentReportEnd()
{
		extent.flush();
}

}
