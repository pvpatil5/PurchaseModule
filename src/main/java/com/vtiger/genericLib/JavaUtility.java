package com.vtiger.genericLib;

import java.util.Random;


//import org.testng.annotations.Test;

/** 
 * 
 * @author Akshay Hedaoo
 *
 */
public class JavaUtility {
	
	public static int generateRandomNumber()
	{
		Random r=new Random();
		int number=r.nextInt(1000);
		return number;
	}
	

}
