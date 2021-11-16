package com.vtiger.purchaseorder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vtiger.genericLib.BaseClass;

public class CreatePOwithMandatoryTest extends BaseClass {
	@Test
	public void createPOwithMandatoryTest() throws Throwable
	{
		wUtil.waitForPageLoad(driver);
		WebElement more = driver.findElement(By.xpath("//a[text()='More']"));
		wUtil.mouseHover(driver, more);
		driver.findElement(By.xpath("//a[@name='Purchase Order']")).click();

		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		WebElement subtb=driver.findElement(By.xpath("//input[@name='subject']"));
		subtb.sendKeys(eUtil.excelUtility("PO", 2, 1));

		WebElement addVendor=driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]"));
		addVendor.click();

		wUtil.switchToWindow(driver, "Vendor");
		driver.findElement(By.id("1")).click();
		wUtil.switchToWindow(driver, "Purchase");

		Thread.sleep(1000);
		WebElement status=driver.findElement(By.name("postatus"));
		wUtil.selectByValue(status, "Created");

		Thread.sleep(1000);
		WebElement billAdd=driver.findElement(By.xpath("//textarea[@name='bill_street']"));
		billAdd.sendKeys(eUtil.excelUtility("PO", 9, 1));

		Thread.sleep(1000);
		WebElement shipAdd=driver.findElement(By.xpath("//textarea[@name='ship_street']"));
		shipAdd.sendKeys(eUtil.excelUtility("PO", 10, 1));

		WebElement description=driver.findElement(By.name("description"));
		wUtil.scrollToWebElement(driver, description);
		
		Thread.sleep(1000);
		WebElement itemName=driver.findElement(By.id("searchIcon1"));
		itemName.click();

		wUtil.switchToWindow(driver, "Products");
		Thread.sleep(1000);
		WebElement item=driver.findElement(By.id("popup_product_12"));
		item.click();
		wUtil.switchToWindow(driver, "Purchase");
		
		Thread.sleep(1000);
		WebElement qty=driver.findElement(By.id("qty1"));
		qty.sendKeys(eUtil.sendNumericCellValue("PO", 23, 1));
		
		Thread.sleep(1000);
		WebElement listPrice=driver.findElement(By.id("listPrice1"));
		listPrice.sendKeys(eUtil.sendNumericCellValue("PO", 24, 1));
		

		Thread.sleep(1000);
		WebElement save=driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]"));
		save.click();

//		wUtil.acceptAlert(driver);
	}

}
