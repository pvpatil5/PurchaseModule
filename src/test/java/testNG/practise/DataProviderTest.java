package testNG.practise;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@DataProvider
	public Object[][] bankdb1()
	{
		Object[][] obj= new Object[3][2];

		obj[0][0]= "Honey";
		obj[0][1]= 12345;

		obj[1][0]= "Bunny";
		obj[1][1]= 67890;

		obj[2][0]= "Sunny";
		obj[2][1]= 13579;

		return obj;
	}

	@Test(dataProvider = "bankdb1")
	public void details(String username, int amount)
	{
		Reporter.log("Name of User: "+ username+ " And Amount in Bank: "+amount, true);
	}
}
