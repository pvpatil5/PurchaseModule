package com.practise;

import java.util.Date;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import com.vtiger.genericLib.IPathConstant;

public class MakeMyTripTest {

	@Test(dataProvider="airports")
	public void MMTTest(String src, String dest) throws Throwable
	{
	
	System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
	Date date = new Date();
	String d = date.toString();
	String[] arr = d.split(" ");
	String day = arr[0];
	String month = arr[1];
	String currentDate = arr[2];
	String year = arr[5];
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.makemytrip.com/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser userLoggedOut']")).click();;
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
	driver.findElement(By.xpath("//input[@id='fromCity']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//div[contains(text(),'"+src+"')])")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[contains(text(),'"+dest+"')]")).click();
	
	//driver.findElement(By.xpath("//div[@aria-label='Wed Nov 10 2021']")).click();
	driver.findElement(By.xpath("//div[@aria-label='"+day+" "+month+" "+currentDate+" "+year+"']")).click();
	
	}
	
	@DataProvider
	public Object[][] airports()
	{
		Object arr[][]=new Object[4][2];
		
		arr[0][0]="BOM";
		arr[0][1]="HYD";
		
		arr[1][0]="PNQ";
		arr[1][1]="MAA";
		
		arr[2][0]="CCU";
		arr[2][1]="DEL";
		
		arr[3][0]="BLR";
		arr[3][1]="GOI";
		
		return arr;
		
	}
}