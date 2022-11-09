package com.democart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.democart.utils.Constants;
import com.democart.utils.ElementUtil;

public class RegistrationPage {

	
	
	private WebDriver driver;
	
	private ElementUtil elementUtil;
	
	private By firstname = By.id("input-firstname");
	
	private By lastname= By.id("input-lastname");
	
	private By email = By.cssSelector("#input-email");
	
	private By phone = By.id("input-telephone");
	
	private By password = By.id("input-password");
	
	private By confirmPassword = By.id("input-confirm");
	
	private By subscribeYes = By.xpath("//label[normalize-space()='Yes']");
	
	private By subscribeNo = By.xpath("//label[normalize-space()='No']");
	
	private By agreeCheckbox = By.xpath("//input[@name='agree']");
	
	private By continueButton = By.xpath("//input[@value='Continue']");
	
	private By successMsg = By.cssSelector("div[id='content'] h1");
	
	private By logoutLink = By.linkText("Logout");
	
	private By registerLink = By.linkText("Register");
	
	
	

	
	
	public RegistrationPage(WebDriver driver)
	{
		this.driver = driver;
		
		elementUtil = new ElementUtil(driver);
		
	}
	
	
	
	
	public boolean accountRegistration(String firstName, String lastName, String email, String telephone,String password, String subscribe)
	{
		
		elementUtil.doSendKeys(firstname, firstName);
		
		elementUtil.doSendKeys(lastname, lastName);
		
		elementUtil.doSendKeys(this.email, email);
		
		elementUtil.doSendKeys(phone, telephone);
		
		elementUtil.doSendKeys(this.password, password);
		
		elementUtil.doSendKeys(confirmPassword, password);
		
		if(subscribe.equalsIgnoreCase("Yes"))
			
		{
			elementUtil.doClick(subscribeYes);
		}
		
		else
		{
			elementUtil.doClick(subscribeNo);
		}
		
		elementUtil.doClick(agreeCheckbox);
		
		elementUtil.doClick(continueButton);
		
		String mesg = elementUtil.waitForElementPresence(successMsg, Constants.DEFAULT_TIME_OUT).getText();
		
		if(mesg.contains(Constants.REGISTRATION_SUCCESS_MESSAGE))
		{
			
			elementUtil.doClick(logoutLink);
			
			elementUtil.doClick(registerLink);
			
			return true;
		}
		
		return false;
		
		
		
		
		
		
		
		
	}
}
