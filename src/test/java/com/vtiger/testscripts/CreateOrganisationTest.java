package com.vtiger.testscripts;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;

//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vtiger.genericLib.BaseClass;
import com.vtiger.genericLib.ExcelUtility;
import com.vtiger.genericLib.JavaUtility;

//import com.vtiger.genericLib.PropertyFileUtility;




public class CreateOrganisationTest extends BaseClass {
	@Test
	public void createOrganisation()  throws Throwable {

		ExcelUtility eUtil = new ExcelUtility();
		String orgname=eUtil.excelUtility("Sheet1", 1, 2)+JavaUtility.generateRandomNumber();


		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//a[text()=\"Organizations\"])[1]")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();

		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		String orgInfo = driver.findElement(By.className("dvHeaderText")).getText();
		Assert.assertTrue(orgInfo.contains(orgname));
		Reporter.log("Organisation created");
		Reporter.log("Verification Done", true);
		

	}

}
