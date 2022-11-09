package com.democart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.democart.utils.Constants;
import com.github.dockerjava.api.model.ContainerNetworkSettings;

public class AccountsPageTest extends BaseTest {
	
	
	
	
	@BeforeClass
	
	public void accPageSetup()
	
	{
		accpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	
	public void accPageTitleTest()
	
	{
		String title = accpage.getAccPageTitle();
		
		System.out.println("Account Page title is:" +title);
		
		Assert.assertEquals(title, Constants.ACCOUNT_PAGE_TITLE);
		
		
		
	}
	
	
	@Test(priority=2)
	
	public void accSectionsList()
	
	{
		List<String> actAccSectionsList = accpage.getAccountsSectionList();
		
		System.out.println("Acutal Accounts section list is:" +actAccSectionsList);
		
		Assert.assertEquals(actAccSectionsList, Constants.EXPECTED_ACC_SEC_LIST);
		
		
		
	}
	
	@Test(priority=3)
	
	public void logoutLinkExistsTest()
	
	{
		Assert.assertTrue(accpage.isLogoutLinkExists());
	}
	
	
	
	@DataProvider
	
	public Object[][] getSearchData()
	
	{
		return new Object[][] {
			
			{"Macbook Pro"},
			{"Mackbook Air"},
			{"Apple"}
			};
		}
	
	
	
	
	@Test(priority=4, dataProvider="getSearchData")
	
	
	public void searchTest(String productName)
	{
		resultspage = accpage.doSearch(productName);
		
		String resultsHeader = resultspage.getSearchPageHeader();
		
		System.out.println("Result header is:" + resultsHeader );
		
		Assert.assertTrue(resultsHeader.contains(productName));
		
		
	}
	
	
	
	@DataProvider
	
	public Object[][] getProductSelectData()
	
	{
		
		return new Object[][] {
			
			{"Macbook", "MacBook Pro"},
			{"Macbook", "MacBook Air"},
			{"Apple", "Apple Cinema 30\""}
		};
	}
	
	@Test(priority=6, dataProvider = "getProductSelectData")
	
	public void selectProductTest(String productName, String mainProductName)
	
	{
		resultspage = accpage.doSearch(productName);
		
		productinfopage = resultspage.selectProduct(mainProductName);
		
		String header = productinfopage.getProductHeaderText();
		
		System.out.println("Prduct Header is:" +header);
		
		Assert.assertEquals(header, mainProductName);
		
		
		
	}
	
	
	

}
