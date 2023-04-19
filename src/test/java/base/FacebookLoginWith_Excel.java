package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookLoginWith_Excel {
	
	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet ;
	XSSFCell cell;
	
	
	
	@BeforeMethod
	public void login_with_Excel()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(option);
		driver.get("http://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
	}
	
	@Test
	public void readData() throws IOException
	{
		File file= new File("D:\\project\\mis\\Readdata\\facebook.xlsx");
		FileInputStream fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);
		for(int i=1;i<sheet.getLastRowNum();i++)
		{
			cell = sheet.getRow(i).getCell(0);
			cell.setCellType(cell.getCellType());
	        driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys(cell.getStringCellValue());

	        cell = sheet.getRow(i).getCell(1);
			cell.setCellType(cell.getCellType());
	        driver.findElement(By.xpath("//input[contains(@type,'pass')]")).sendKeys(cell.getStringCellValue());
		    driver.findElement(By.xpath("//button[@type='submit']")).click();

		}
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		
	}

}
