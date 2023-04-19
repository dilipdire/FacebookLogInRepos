package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchGoogle {
	
	public static WebDriver driver;
	
	public SearchGoogle(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By sesrchText = By.xpath("//input[@name='q']");
	By clickOnSearchBtn = By.xpath("((//input[@name='btnK'])[2])");
	By facebookLink = By.xpath("//h3[contains(text(),'Facebook - log in or sign up')]");
	
	public void getText(String enterValue)
	{
		driver.findElement(sesrchText).sendKeys(enterValue);
		driver.findElement(clickOnSearchBtn).click();
	}
	
	public void clickOnFacebookLink()
	{
		driver.findElement(facebookLink).click();
	}
	
	

}
