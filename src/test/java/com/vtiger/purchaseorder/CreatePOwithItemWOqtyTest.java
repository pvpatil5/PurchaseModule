package com.vtiger.purchaseorder;

import org.openqa.selenium.By;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vtiger.genericLib.BaseClass;
//import com.vtiger.genericLib.ExcelUtility;
//import com.vtiger.genericLib.IPathConstant;
import com.vtiger.genericLib.JavaUtility;
//import com.vtiger.genericLib.PropertyFileUtility;
//import com.vtiger.genericLib.WebDriverUtility;

public class CreatePOwithItemWOqtyTest extends BaseClass {
	@Test
	public void createPOwithItemWOqtyTest() throws Throwable
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
		WebElement rntb =driver.findElement(By.id("requisition_no"));
		rntb.sendKeys(eUtil.excelUtility("PO", 4, 1)+ JavaUtility.generateRandomNumber());

		Thread.sleep(1000);
		WebElement trntb=driver.findElement(By.id("tracking_no"));
		trntb.sendKeys(eUtil.excelUtility("PO", 5, 1)+JavaUtility.generateRandomNumber());

		Thread.sleep(1000);
		WebElement contactName=driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[2]"));
		contactName.click();

		wUtil.switchToWindow(driver, "Contacts");
		Thread.sleep(1000);
		driver.findElement(By.id("1")).click();
		wUtil.acceptAlert(driver);
		wUtil.switchToWindow(driver, "Purchase");

		Thread.sleep(1000);
		WebElement carrier=driver.findElement(By.xpath("//select[@name='carrier']"));
		wUtil.selectByValue(carrier, "BlueDart");

		Thread.sleep(1000);
		WebElement salesComm=driver.findElement(By.id("salescommission"));
		salesComm.sendKeys(eUtil.sendNumericCellValue("PO", 7, 1));

		Thread.sleep(1000);
		WebElement exciseDuty=driver.findElement(By.id("exciseduty"));
		exciseDuty.sendKeys(eUtil.sendNumericCellValue("PO", 8, 1));

		Thread.sleep(1000);
		WebElement status=driver.findElement(By.name("postatus"));
		wUtil.selectByValue(status, "Created");

		Thread.sleep(1000);
		WebElement billAdd=driver.findElement(By.xpath("//textarea[@name='bill_street']"));
		billAdd.sendKeys(eUtil.excelUtility("PO", 9, 1));

		Thread.sleep(1000);
		WebElement shipAdd=driver.findElement(By.xpath("//textarea[@name='ship_street']"));
		shipAdd.sendKeys(eUtil.excelUtility("PO", 10, 1));

		Thread.sleep(1000);
		WebElement billPOB=driver.findElement(By.id("bill_pobox"));
		billPOB.sendKeys(eUtil.sendNumericCellValue("PO", 11, 1));

		Thread.sleep(1000);
		WebElement shipPOB=driver.findElement(By.id("ship_pobox"));
		shipPOB.sendKeys(eUtil.sendNumericCellValue("PO", 12, 1));

		Thread.sleep(1000);
		WebElement billCity=driver.findElement(By.id("bill_city"));
		billCity.sendKeys(eUtil.excelUtility("PO", 13, 1));

		Thread.sleep(1000);
		WebElement shipCity=driver.findElement(By.id("ship_city"));
		shipCity.sendKeys(eUtil.excelUtility("PO", 14, 1));

		Thread.sleep(1000);
		WebElement billState=driver.findElement(By.id("bill_state"));
		billState.sendKeys(eUtil.excelUtility("PO", 15, 1));

		Thread.sleep(1000);
		WebElement shipState=driver.findElement(By.id("ship_state"));
		shipState.sendKeys(eUtil.excelUtility("PO", 16, 1));

		Thread.sleep(1000);
		WebElement billPOcode=driver.findElement(By.id("bill_code"));
		billPOcode.sendKeys(eUtil.sendNumericCellValue("PO", 17, 1));

		Thread.sleep(1000);
		WebElement shipPOcode=driver.findElement(By.id("ship_code"));
		shipPOcode.sendKeys(eUtil.sendNumericCellValue("PO", 18, 1));

		Thread.sleep(1000);
		WebElement billCountry=driver.findElement(By.id("bill_country"));
		billCountry.sendKeys(eUtil.excelUtility("PO", 19, 1));

		Thread.sleep(1000);
		WebElement shipCountry=driver.findElement(By.id("ship_country"));
		shipCountry.sendKeys(eUtil.excelUtility("PO", 20, 1));

		Thread.sleep(1000);
		WebElement description=driver.findElement(By.name("description"));
		description.sendKeys(eUtil.excelUtility("PO", 21, 1));

		Thread.sleep(1000);
		WebElement itemName=driver.findElement(By.id("searchIcon1"));
		itemName.click();

		wUtil.switchToWindow(driver, "Products");
		Thread.sleep(1000);
		WebElement item=driver.findElement(By.id("popup_product_12"));
		item.click();
		wUtil.switchToWindow(driver, "Purchase");

		Thread.sleep(1000);
		WebElement save=driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]"));
		save.click();
		
		wUtil.popupText(driver);
		wUtil.acceptAlert(driver);
	}

}
