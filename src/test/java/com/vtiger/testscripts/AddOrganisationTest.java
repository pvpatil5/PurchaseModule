package com.vtiger.testscripts;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vtiger.genericLib.IPathConstant;
//import com.vtiger.genericLib.JSONFileUtility;
import com.vtiger.genericLib.PropertyFileUtility;
import com.vtiger.genericLib.WebDriverUtility;

public class AddOrganisationTest {
	
	@Test
	public void addOrganisationTest() throws Throwable
	{
		System.setProperty(IPathConstant.CHROME_KEY, IPathConstant.CHROME_VALUE);
		WebDriver driver=new ChromeDriver();
		WebDriverUtility wUtil = new WebDriverUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String URL=pUtil.propertyFileUtility("url");
//		String UN=pUtil.propertyFileUtility("username");
//		String PWD=pUtil.propertyFileUtility("password");
		driver.get(URL);
		wUtil.maximizeWindow(driver);
		
		
		
		
		
	}

}
