package com.vtiger.testscripts;

import java.util.Set;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.vtiger.genericLib.ExcelUtility;
import com.vtiger.genericLib.JSONFileUtility;
//import com.vtiger.genericLib.JavaUtility;

public class AddContactOfOrganisationTest {
	@Test
	public  void addContactOfOrganisationTest() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		JSONFileUtility jUtil = new JSONFileUtility();
		String URL = jUtil.jsonFileUtility("url");
		String UN=jUtil.jsonFileUtility("username");
		String PWD=jUtil.jsonFileUtility("password");
		
		ExcelUtility eUtil = new ExcelUtility();
//		String orgname=eUtil.excelUtility("Sheet1", 1, 2)+JavaUtility.generateRandomNumber();
//		String industryType =eUtil.excelUtility("Sheet1", 3, 3);
		String lastname= eUtil.excelUtility("Sheet1", 5, 3);
		
		driver.get(URL);
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		WebElement salutation=driver.findElement(By.xpath("//select[@name='salutationtype']"));
		Select sel=new Select(salutation);
		sel.selectByValue("Mr.");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		Thread.sleep(4000);

		Set<String> allwh = driver.getWindowHandles();
	 System.out.println(allwh.size());
		String parentTitle=driver.getTitle();
		String pw=driver.getWindowHandle();
		for(String wh:allwh)
		{
			String title=driver.switchTo().window(wh).getTitle();
			if(!title.equals(parentTitle))
			{
				driver.switchTo().window(wh);
				Thread.sleep(2000);
				driver.findElement(By.id("1")).click();
				
				
			}

			driver.switchTo().window(pw);
					
		}

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		

	}

}
