package com.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ICCTest {
	@Test
	public void icc()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com");	
		WebElement std = driver.findElement(By.xpath("//a[normalize-space()='Standings']"));
		System.out.println(std.getText());
	}

}
