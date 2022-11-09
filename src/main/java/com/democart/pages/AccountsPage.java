package com.democart.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.democart.utils.Constants;
import com.democart.utils.ElementUtil;

public class AccountsPage {
	
	
	
	private WebDriver driver;
	
	private ElementUtil elementutil;
	
	private By accSections = By.cssSelector("div#content h2");
	
	private By logoutLink = By.linkText("Logout");
	
	private By searchField = By.name("search");
	
	private By serchButton = By.xpath("//button[@class='btn btn-default btn-lg']");
	
	
	//Constructor
	
	public AccountsPage(WebDriver driver)
	{
		this.driver = driver;
		
		elementutil = new ElementUtil(driver);
		
		
		
	}
	
	
	public String getAccPageTitle()
	
	{
		return elementutil.waitForTitleContains(Constants.ACCOUNT_PAGE_TITLE, 10);
	}
	
	
	
	public String getAccPageURL()
	
	{
		return elementutil.waitForUrlContains(Constants.ACCOUNT_PAGE_URL_FRACTION, 10);
		
		
		
		
	}
	
	
	
	public List<String> getAccountsSectionList()
	
	{
		
		List<String> accSecValuesList =new ArrayList<String>();
		
		List<WebElement> accSecList = elementutil.getElements(accSections);
		
		for(WebElement e: accSecList)
		{
			accSecValuesList.add(e.getText());
		}
		
		//Collections.sort(accSecValuesList);
		return accSecValuesList;
		
		
	}
	
	public boolean isLogoutLinkExists()
	
	{
		return elementutil.doIsDisplayed(logoutLink);
		
	}
	
	public ResultsPage doSearch(String productName)
	{
		System.out.println("Searching the product:" +productName);
		
		elementutil.doSendKeys(searchField, productName);
		
		elementutil.doClick(serchButton);
		
		return new ResultsPage(driver);
	}
	
	
	
	
	
	
	
	

}
