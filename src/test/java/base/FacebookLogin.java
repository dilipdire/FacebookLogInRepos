package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.channel.ServerChannelRecvByteBufAllocator;

public class FacebookLogin {
	public static WebDriver driver;
	@Test(dataProvider="test")
	public void loginTest(String email, String pwd) throws InterruptedException
	 {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys(email);
        driver.findElement(By.xpath("//input[contains(@type,'pass')]")).sendKeys(pwd);
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    
	}
	
	@DataProvider(name="test")
	public Object[][] getData()
	{
		Object[][] data = new Object[2][2];
		data[0][0] ="salusingh929@gmail.com"; 
		data[0][1] ="1@salusingh"; 
		data[1][0]= "anit@gmail.com";
		data[1][1]= "1111";
		
		return data;
	}

}
