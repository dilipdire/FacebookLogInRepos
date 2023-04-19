package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenBrowser {
	
	WebDriver driver;
	
	public void getBrowser(BrowserTypes browser)
	{
		switch(browser)
		{
		case CHROME:
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		
		case FIREFOX:
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}
		default :
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		}
		
	}
	
	public static void main(String[] args) {
		
		new OpenBrowser().getBrowser(BrowserTypes.FIREFOX);
		
		
	}
	
	

}
