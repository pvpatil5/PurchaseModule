package com.vtiger.genericLib;

//import java.io.FileNotFoundException;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
//import org.testng.annotations.Test;
/**
 * This class is use to read data from Json file
 * @author Asus
 *
 */
public class JSONFileUtility {

	
	public String jsonFileUtility(String key) throws Throwable
	{
		FileReader fr=new FileReader(IPathConstant.JSONFILEPATH);
		
		JSONParser jp = new JSONParser();
		Object jobj = jp.parse(fr);
		@SuppressWarnings("rawtypes")
		HashMap obj= (HashMap)jobj;
		
		String value= (String) obj.get(key);
		return value;
		
	}
}
