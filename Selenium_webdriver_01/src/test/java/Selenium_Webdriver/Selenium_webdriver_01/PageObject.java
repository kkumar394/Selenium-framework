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
	
	@FindBy(name= "q")
	WebElement search;
	
	@FindBy(name= "btnK")
	WebElement SearchButton;
	
	public void search()
	{
		search.sendKeys("Selenium Webdriver java");
		search.sendKeys(Keys.ENTER);
	}
	

	public void searchbutton()
	{
		SearchButton.click();
	}
	
	
	

	
}
