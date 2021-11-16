package com.vtiger.testscripts;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.vtiger.genericLib.ExcelUtility;
import com.vtiger.genericLib.JSONFileUtility;
import com.vtiger.genericLib.JavaUtility;
import com.vtiger.genericLib.WebDriverUtility;


public class AddIndustryInOrganisationTest {
	@Test
	public  void addIndustryInOrganisationTest() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		JSONFileUtility jUtil = new JSONFileUtility();
		String URL = jUtil.jsonFileUtility("url");
		String UN=jUtil.jsonFileUtility("username");
		String PWD=jUtil.jsonFileUtility("password");
		
		ExcelUtility eUtil = new ExcelUtility();
		String orgname=eUtil.excelUtility("Sheet1", 1, 2)+JavaUtility.generateRandomNumber();
		String industryType =eUtil.excelUtility("Sheet1", 3, 3);
				
		
		driver.get(URL);
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//a[text()=\"Organizations\"])[1]")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(orgname);
		WebElement industry= driver.findElement(By.xpath("//select[@name='industry']"));
		Select sel=new Select(industry);
		sel.selectByValue(industryType);
		WebDriverUtility wUtil = new WebDriverUtility();
		wUtil.selectByValue(industry, industryType);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
//		Thread.sleep(4000);
//		Actions ac=new Actions(driver);
//		WebElement icon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		ac.moveToElement(icon).perform();
//		Thread.sleep(2000);
//		WebElement out=driver.findElement(By.xpath("//a[text()='Sign Out']"));
//		out.click();

	}

}
