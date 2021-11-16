package testNG.practise;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericLib.BaseClass;

@Listeners(com.vtiger.genericLib.ListenerImp.class)
public class ScreenshotAfterMethodFailTest extends BaseClass {
	
	@Test
	public void screenshotAfterMethodFailTest()
	{
		System.out.println(10/0);
	}

	@Test
	public void error()
	{
		System.out.println(11/0);
	}
}
