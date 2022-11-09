package com.democart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.democart.utils.ElementUtil;

public class ProductInfoPage {
	
	private WebDriver driver;
	
	private ElementUtil elementutil;
	
	private By productHeader = By.cssSelector("div[class='col-sm-4'] h1");
	
	
	private By productImages = By.cssSelector("ul.thumbnails img");
	
	private By productMetaData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	
	private By productPriceData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
	
	private By productQuanity = By.id("input-quantity");
	
	private By addToCartButton =  By.id("button-cart");
	
	private Map<String, String>  productInfoMap;
	
	
	
	
	public ProductInfoPage(WebDriver driver)
	
	
	{
		this.driver = driver;
		
		elementutil = new ElementUtil(driver);
	}
	
	
	public String getProductHeaderText()
	
	{
		return elementutil.doGetText(productHeader);
	}
	
	
	
	public int getProductImagesCount()
	
	{
		return elementutil.getElements(productImages).size();
		
		
	}
	
	
	public Map<String, String> getProductInfo()
	
	{
		
		productInfoMap = new HashMap<String, String>();
		
		productInfoMap.put("name", getProductHeaderText());
		
		List<WebElement> metaDataList = elementutil.getElements(productMetaData);
		
		System.out.println("Total Product Meta Data List is:" +metaDataList.size());
		
		//Brand: Apple
		//Product Code: Product 18
		//Reward Points: 800
		//Availability: In Stock
		
		for (WebElement e: metaDataList)
		
		{
			String meta[] = e.getText().split(":");
			String metaKey = meta[0].trim();
			String metaValue = meta[1].trim();
			productInfoMap.put(metaKey, metaValue);
			
			
			
		}
		
		//Price Data
		
		List<WebElement> priceList = elementutil.getElements(productPriceData);
		
		System.out.println("Total product price list:" +priceList.size());
		
		String price = priceList.get(0).getText().trim();
		
		String exTaxPrice = priceList.get(1).getText().trim();
		
		productInfoMap.put("Product Price", price);
		
		
		productInfoMap.put("Ex Tax Price", exTaxPrice);
		
		return productInfoMap;
	}
	
	

}
