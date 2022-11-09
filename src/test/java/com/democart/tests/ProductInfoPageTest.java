package com.democart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductInfoPageTest extends BaseTest


{
	
	

	@BeforeClass
	
	public void productInfoPageSetup()
	
	{
		accpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	
	public void productImagesTest()
	
	{
		resultspage = accpage.doSearch("iMac");
		
		productinfopage = resultspage.selectProduct("iMac");
		
		Assert.assertEquals(productinfopage.getProductImagesCount(), 3);
		
	}
	
	
	@Test
	
	public void productInfoTest()
	
	{
		resultspage  = accpage.doSearch("Macbook");
		
		productinfopage = resultspage.selectProduct("MacBook Pro");
		
		Map<String,String>  acutalProductInfoMap = productinfopage.getProductInfo();
		
		softAssert.assertEquals(acutalProductInfoMap.get("name"), "MacBook Pro" );
		
		softAssert.assertEquals(acutalProductInfoMap.get("Brand"), "Apple");
		
		softAssert.assertEquals(acutalProductInfoMap.get("Product Code"), "Product 18");
		
		softAssert.assertEquals(acutalProductInfoMap.get("Reward Points"), "800");
		
		softAssert.assertEquals(acutalProductInfoMap.get("Availability"), "In Stock");
		
		
		softAssert.assertEquals(acutalProductInfoMap.get("Product Price"), "$2,000.00");
		
		softAssert.assertAll();
		
		
		
	}
	
	
	
	
	
	
	
	

}
