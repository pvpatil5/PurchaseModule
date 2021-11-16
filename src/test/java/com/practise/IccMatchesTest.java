package com.practise;
import java.util.Collections;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IccMatchesTest {
	@Test
	public void iccMatchesTest()
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/test");	
		List<WebElement> teams = driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
		List<WebElement> matches = driver.findElements(By.xpath("//table//tbody//tr//td[3]"));
		HashMap<String, Integer> teamCard=new HashMap<String, Integer>();
		for(int i=0;i<teams.size();i++)
		{
			String teamName=teams.get(i).getText();
			String matchesplayed=matches.get(i).getText();
			int numberOfMatches = Integer.parseInt(matchesplayed);

			teamCard.put(teamName, numberOfMatches);
		}
		System.out.println("==unsorted===");
		for(Map.Entry<String, Integer> m : teamCard.entrySet())
		{  
			System.out.println(m.getKey()+" "+m.getValue());    
		}

		//convert HashMap into List   
		List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(teamCard.entrySet()); 

		//sorting the list elements  
		Collections.sort(list, new Comparator<Entry<String, Integer>>()   
		{  
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2)   
			{  
				@SuppressWarnings("unused")
				boolean order;
				if (order=true)   
				{  
					//compare two object and return an integer  
					return o1.getValue().compareTo(o2.getValue());
				}   
				else   
				{  
					return o2.getValue().compareTo(o1.getValue());  
				}  
			}  
		}); 

		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Entry<String, Integer> entrylist : list)   
		{  
			sortedMap.put(entrylist.getKey(), entrylist.getValue());  
		}  

		System.out.println("===sorted===");
		for(Map.Entry<String, Integer> n : sortedMap.entrySet())
		{
			System.out.println(n.getKey()+" "+n.getValue());    
		}  
		System.out.println("===Higest Matches Played===");
		int maxValueInMap=(Collections.max(sortedMap.values()));  // This will return max value in the HashMap
		for (Entry<String, Integer> entry : sortedMap.entrySet()) 
		{  // Iterate through HashMap
			if (entry.getValue()==maxValueInMap)
			{
				System.out.println(entry.getValue()+" "+entry.getKey());     // Print the key with max value
			}

		}
	}
}
