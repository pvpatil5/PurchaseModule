package testNG.practise;

import org.testng.annotations.Test;

public class PriorityTest {
	@Test(invocationCount = 2)
	public void create()
	{
		System.out.println("Its Create Method");
	}
	@Test(dependsOnMethods="create")
	public void modify()
	{
		System.out.println("Its Modify Method");
	}
	@Test(enabled = false)
	public void delete()
	{
		System.out.println("Its Delete Method");
	}

}
