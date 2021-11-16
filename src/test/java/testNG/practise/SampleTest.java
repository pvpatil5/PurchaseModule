package testNG.practise;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SampleTest {
	
	@BeforeSuite
	public void connectToDB()
	{
		System.out.println("Connect to Database.");
	}

	@BeforeClass
	public void launchBrowser()
	{
		System.out.println("Launch The Browser");
	}
	
	
	@BeforeMethod
	public void login()
	{
		System.out.println("Login into Application");
	}
	
	@Test
	public void createOrganization()
	{
		System.out.println("Create the Organisation");
	}
	@Test
	public void modifyOrganisation()
	{
		System.out.println("Modify the Organisation");
	}
	@AfterMethod
	public void logout()
	{
		System.out.println("Logout from Application.");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("Close the Browser.");
	}
	@AfterSuite
	public void disconnectDB()
	{
		System.out.println("Disconnected from Database.");
	}

}
