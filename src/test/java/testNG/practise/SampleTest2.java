package testNG.practise;

import org.testng.annotations.Test;

public class SampleTest2 {
	
	@Test(retryAnalyzer = com.vtiger.genericLib.RetryAnalyser.class )
	public void retryTest()
	{
		System.out.println(10/0);
	}

}
