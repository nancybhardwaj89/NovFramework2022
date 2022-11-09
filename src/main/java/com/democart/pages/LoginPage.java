package com.democart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.democart.utils.Constants;
import com.democart.utils.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	
	private ElementUtil elementUtil;
	
	
	//Private Locators
	
		private By emailID = By.id("input-email");
		
		private By password = By.id("input-password");
		
		private By loginBtn = By.xpath("//input[@value='Login']");
		
		private By forgotPwdLink = By.xpath("//div[@class='form-group']//a[normalize-space()='Forgotten Password']");
		
		private By header = By.xpath("//img[@title='naveenopencart']");
		
		private By RegisterLink = By.xpath("//a[@class='list-group-item'][normalize-space()='Register']");
	
	
	//constructor
		
		public LoginPage(WebDriver driver)
		
		{
			this.driver =driver;
			
			elementUtil = new ElementUtil(driver);
		}
	
		
		//page methods and no assertions here , only page actions/methods
		
		
	public String getLoginPageTitle()
	{
		
		return elementUtil.waitForTitleIs(Constants.LOGIN_PAGE_TITLE,5);
	}
	
	
	//public String getPageHeaderText()
	
	//{
		//return driver.findElement(header).getText();
	//}
	
	public boolean isForgotPwdLinkExits()
	
	{
		return elementUtil.doIsDisplayed(forgotPwdLink);
	}
	
	public AccountsPage doLogin(String un, String pwd)
	{
		System.out.println(un + ":" + pwd);
		elementUtil.doSendKeys(emailID, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);
		return new AccountsPage(driver);
		
	}
	
	public RegistrationPage navigateToRegisterPage()
	
	{
		elementUtil.doClick(RegisterLink);
		
		return new RegistrationPage(driver);
	}
	
	
	
	
	

}
