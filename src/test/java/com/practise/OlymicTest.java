package com.practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OlymicTest {
	@Test
	public void olymicMedals()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://olympics.com/");
		WebElement featuredAtheletes=driver.findElement(By.xpath("//h2[text()='Featured']"));
		Point loc=featuredAtheletes.getLocation();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy"+ loc);

		List<WebElement> allAtheletes = driver.findElements(By.xpath("//a[@class='featured-athlete__name d-flex text-body']"));

		for(WebElement one:allAtheletes)
		{
			String name = one.getText();
			WebElement athelete = driver.findElement(By.xpath("//span[text()='"+name+"']"));
			WebElement medals = driver.findElement(By.xpath("//span[text()='"+name+"']/ancestor::li//div[@class='featured-athlete__medals text-body-sm']"));
			System.out.println(athelete.getText());
			System.out.println("==Medals==");
			System.out.println(medals.getText());
			try {
				WebElement goldcount = driver.findElement(By.xpath("//span[text()='"+name+"']/ancestor::li//div[@class='featured-athlete__medals text-body-sm']//span[contains(@class,'gold')]"));
				System.out.println("Athelete Name: "+ name+ " No.of Gold: "+ goldcount.getText());
//				break;
			} catch (Exception e) {
				System.out.println("No Gold available for This Athelete");
			}
			
//			System.out.println("Athelete Name: "+ name+ " No.of Gold: "+ goldcount.getText());
		}
	}

}

