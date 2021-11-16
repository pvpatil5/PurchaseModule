package com.practise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableInVtigerTest {
	@Test
	public void webTableInVtigerTest()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		List<WebElement> listOrg = driver.findElements(By.xpath("//table[@class='lvt small']//tr//td[3]"));
		List<WebElement> checkBox = driver.findElements(By.xpath("//table[@class='lvt small']//tr//td[1]/input"));
		for(int i=1;i<listOrg.size();i++)
		{
			
			System.out.println(listOrg.get(i).getText());

		}
//		for(int i=2;i<checkBox.size();i++)
//		{
//			checkBox.get(i).click();
//
//		}
//		driver.findElement(By.xpath("//table[@class='lvt small']//tr[last()]//td[1]")).click();
	
//		driver.findElement(By.id("selectCurrentPageRec")).click();
		
		for(int i=1;i<listOrg.size();i++)
		{
			String orgName = listOrg.get(i).getText();
			if(orgName.equalsIgnoreCase("Test Yantra 5 Software Solutions"))
			{
			checkBox.get(i).click();
			driver.findElement(By.xpath("(//input[@value='Delete'])[2]")).click();
			driver.switchTo().alert().accept();
			}
		}
		
	}

}
