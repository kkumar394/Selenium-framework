package Selenium_Webdriver.Selenium_webdriver_01;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public  class PageObject {
	
	  WebDriver driver ;
	
	public  PageObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name= "email")
	WebElement Username;
	
	@FindBy(name= "pass")
	WebElement Password;
	
	@FindBy(name= "login")
	WebElement Login;
	
	public void Uname(String Uname)
	{
		Username.sendKeys(Uname);
	}
	

	public void Pwd(String Pass)
	{
		Password.sendKeys(Pass);
	}
	
	public void Login()
	{
		Login.click();
	}
	
}
