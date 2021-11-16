package ddt.practise;

//import java.io.FileNotFoundException;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

public class ReadTheDataFromJSONFileTest {
	@Test
	public void readTheDataFromJSONFileTest() throws Throwable
	{
		FileReader fr=new FileReader("./Data/commonData.json");
		
		JSONParser jp = new JSONParser();
		Object jobj = jp.parse(fr);
		
		@SuppressWarnings("rawtypes")
		HashMap obj= (HashMap)jobj;
		Object value= obj.get("url");
		System.out.println(value);
		
	}

}
