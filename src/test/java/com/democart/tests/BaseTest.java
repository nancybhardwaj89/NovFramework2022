package com.democart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.democart.factory.DriverFactory;
import com.democart.pages.AccountsPage;
import com.democart.pages.LoginPage;
import com.democart.pages.ProductInfoPage;
import com.democart.pages.RegistrationPage;
import com.democart.pages.ResultsPage;

public class BaseTest {
	
	WebDriver driver;
	
	
	
	DriverFactory df;
	
	Properties prop;
	
	LoginPage loginpage;
	
	AccountsPage accpage;
	
	ResultsPage resultspage;
	
	ProductInfoPage productinfopage;
	
	RegistrationPage regpage;
	
	SoftAssert softAssert;
	
	
	
	
	@BeforeTest
	public void setUp()
	{
		softAssert = new SoftAssert();
		
		df = new DriverFactory();
		
		
		
		prop = df.initProperties();
		
		
		driver = df.initDriver(prop);
		
		loginpage = new LoginPage(driver);
		
		
		
		
	}
	
	
	@AfterTest
	
	public void tearDown()
	
	{
		
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
