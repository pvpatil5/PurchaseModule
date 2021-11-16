package com.practise;

//import java.util.Date;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SVGTagHandlingTest {
	@Test
	public void svgTagHandlingTest()
	{
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//div[.='Flights']")).click();
		driver.findElement(By.xpath("(//span[@class='radio__circle bs-border bc-neutral-500 bw-1 ba'])[2]")).click();
		driver.findElement(By.xpath("(//input[@placeholder='Any worldwide city or airport'])[1]")).sendKeys("Hyderabad");
		driver.findElement(By.xpath("//p[contains(text(),'(HYD)')]")).click();
		driver.findElement(By.xpath("(//input[@placeholder='Any worldwide city or airport'])[2]")).sendKeys("Mumbai");
		driver.findElement(By.xpath("//p[contains(text(),'(BOM)')]")).click();
		WebElement calender=driver.findElement(By.xpath("//div[@class='flex flex-middle p-relative homeCalender']"));
		Point loc=calender.getLocation();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy"+ loc);
//		calender.click();
//		driver.findElement(By.xpath("(//*[name()='svg' and @class='t-all ml-2'])[1]")).click();
		
//		Date date = new Date();
//		String d = date.toString();
//		String[] arr = d.split(" ");
//		String day = arr[0];
//		String month = arr[1];
//		String currentDate = arr[2];
//		String year = arr[5];
		
//		driver.findElement(By.xpath("//div[@aria-label='"+day+" "+month+" "+currentDate+" "+year+"']")).click();
		////div[@aria-label='"+day+" "+month+" "+currentDate+" "+year+"']
		driver.findElement(By.xpath("(//*[name()='svg' and @class='t-all ml-2'])[2]")).click();
		
		for(int i=0;i<=11;i++)
		{
			try {
				driver.findElement(By.xpath("//div[@aria-label='Sun Mar 13 2022']")).click();
				break;
				
			} catch (Exception e) {
				// TODO: handle exception
				driver.findElement(By.xpath("//*[name()='svg' and @data-testid='rightArrow']")).click();
			}
		}
		
		
		
	}

}
