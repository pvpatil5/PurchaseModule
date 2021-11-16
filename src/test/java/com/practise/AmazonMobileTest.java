package com.practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonMobileTest {
	
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles under 15000");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("//span[text()='See more']")).click();
		driver.findElement(By.xpath("//span[text()='MI']/ancestor::li[@id='p_89/MI']/descendant::i[@class='a-icon a-icon-checkbox']")).click();
		
		List<WebElement> mobilelist = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> mobileprice = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	
		for(int i=0;i<mobilelist.size();i++)
		{
			if(i==0)
			{
				System.out.println("Name of 1st Mobile: "+ mobilelist.get(i).getText());
				System.out.println("Price of 1st Mobile: "+ mobileprice.get(i).getText());
			}
		}
	}

}
