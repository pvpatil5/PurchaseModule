package com.practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LenskartTest {
	@Test
	public void lenskartTest() throws Throwable
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lenskart.com/");
        String lenskartlogo = driver.findElement(By.xpath("//img[@title='Lenskart']")).getAttribute("title");
        System.out.println(lenskartlogo);
		driver.findElement(By.xpath("//input[@class='search_input-bar autoSuggest']")).click();
		Thread.sleep(2000);
		List<WebElement> trendings = driver.findElements(By.xpath("//ul[@class='trending_list menu-link']//li"));
		
		for(WebElement trend: trendings)
		{
			System.out.println(trend.getText());
		}
	}

}
