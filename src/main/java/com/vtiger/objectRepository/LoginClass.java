package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginClass {
	
	public LoginClass(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name") private WebElement usernameTxtBox;
	@FindBy(name="user_password") private WebElement pwdTxtBox;
	@FindBy(id="submitButton") private WebElement loginBtn;
	
	public WebElement getUsernameTxtBox() {
		return usernameTxtBox;
	}
	public WebElement getPwdTxtox() {
		return pwdTxtBox;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void LoginToApp(String username, String pwd)
	{
		usernameTxtBox.sendKeys(username);
		pwdTxtBox.sendKeys(pwd);
		loginBtn.click();
	}
	
}
