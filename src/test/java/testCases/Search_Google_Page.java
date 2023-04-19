package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v108.log.Log;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.FacebookPage;
import pageObject.SearchGoogle;

public class Search_Google_Page {
	
	WebDriver driver;
	@BeforeTest
	public void beforeTest()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
	}
	
	@Test(priority = 0)
	public void enterText()
	{
		SearchGoogle search = new SearchGoogle(driver);
		try {
			search.getText("Facebook");
			
			Thread.sleep(5000);
		} 
		catch (InterruptedException exp)
		{
			System.out.println(exp.getMessage());
			
		}
		
		
	}
	@Test(priority = 1)
	public void accessFacebook()
	{
		SearchGoogle search1 = new SearchGoogle(driver);
		try
		{
		search1.clickOnFacebookLink();
		Thread.sleep(5000);
		}
		catch(Exception exp)
		{
			System.out.println(exp.getMessage());
		}
	}
	
	@Test(priority = 2)
	public void loginfacebookPage()
	{
		FacebookPage page = new FacebookPage(driver);
		try {
		page.enterUserName_Pwd("salusingh929@gmail.com", "1@salusingh");
		Thread.sleep(5000);
		page.clickOnLoginBtn();
		System.out.println("Login");
	
		Thread.sleep(10000);
		}
		catch(Exception exp)
		{
			System.out.println(exp.getMessage());
		}
	}
	@AfterTest
	public void afterTest()
	{
		//driver.quit();
	}

}
