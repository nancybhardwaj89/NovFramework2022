package com.democart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.democart.utils.ElementUtil;

public class ResultsPage {
	
	
	private WebDriver driver;
	
	private ElementUtil elementutil;
	
	
	private By searchHeader = By.cssSelector("div[id='content'] h1");
	
	private By productResults = By.cssSelector("div.caption a");
	
	
	public ResultsPage(WebDriver driver)
	{
		this.driver = driver;
		
		elementutil = new ElementUtil(driver);
		
		
		
	}
	
	public String getSearchPageHeader()
	
	{
		return elementutil.doGetText(searchHeader);
	}
	
	
	public int getSearchProductListCount()
	{
		
		return elementutil.getElements(productResults).size();
		
		
	}

	public ProductInfoPage selectProduct(String mainProductName)
	
	{
		List<WebElement> searchList = elementutil.getElements(productResults);
		
		for(WebElement e : searchList)
		{
			if(e.getText().equals(mainProductName))
			{
				e.click();
				break;
			}
		}
		
		return new ProductInfoPage(driver);
	}
	
	
	
	
}
