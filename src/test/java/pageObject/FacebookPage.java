package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookPage {
	
	WebDriver driver;
	public FacebookPage(WebDriver driver)
	{
		this.driver=driver;
	}
	By userName = By.xpath("//input[@id='email']");
	By userPass = By.xpath("//input[@id='pass']");
	By loginBtn = By.xpath("//button[contains(text(),'Log in')]");
	
	public void enterUserName_Pwd(String user, String pwd)
	{
		driver.findElement(userName).clear();
		driver.findElement(userName).sendKeys(user);
		driver.findElement(userPass).clear();
		driver.findElement(userPass).sendKeys(pwd);
		 
	}
	
	public void clickOnLoginBtn()
	{
		driver.findElement(loginBtn).click();
	}

	
}
