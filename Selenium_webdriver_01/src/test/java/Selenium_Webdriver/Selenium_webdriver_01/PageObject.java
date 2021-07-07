package Selenium_Webdriver.Selenium_webdriver_01;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public  class PageObject {
	
	  WebDriver driver ;
	
	public  PageObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id= "username")
	@CacheLookup
	WebElement Username;
	
	@FindBy(id= "password")
	@CacheLookup
	WebElement Password;
	
	@FindBy(id= "Inpatient Ward")
	@CacheLookup
	WebElement Location;
	
	@FindBy(id= "loginButton")
	@CacheLookup
	WebElement Login;
	
	@FindBy(xpath=".//ul[@id = 'sessionLocation']//li")
	//@CacheLookup
	List<WebElement>  Locationlist;
	
	
	public void Uname(String Uname)
	{
		Username.sendKeys(Uname);
	}
	

	public void Pwd(String Pass)
	{
		Password.sendKeys(Pass);
	}
	
	public void location()
	{
		Location.click();
	}
	
	
	public void Locationlist(String Loc)
	{	
		System.out.println(Locationlist);
		for (WebElement Location : Locationlist) {  
		     if (Location.getText().equalsIgnoreCase(Loc)){  
		    	 Location.click();  
		          break;  
		     }  
		}  
	}
	
	public void Login()
	{
		Login.click();
	}
	
}
