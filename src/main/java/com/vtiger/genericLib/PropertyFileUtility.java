package com.vtiger.genericLib;

import java.io.FileInputStream;

//import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;
/**
 * This class is for get data from property file
 * @author Asus
 *
 */
public class PropertyFileUtility {
	@Test
	public String propertyFileUtility(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstant.PROPERTYFILEPATH);
		 Properties prop = new Properties();
		 prop.load(fis);
		 String value = prop.getProperty(key);
		 return value;
	}

}
