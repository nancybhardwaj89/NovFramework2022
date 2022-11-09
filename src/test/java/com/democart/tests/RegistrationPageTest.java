
package com.democart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.democart.utils.Constants;
import com.democart.utils.ExcelUtil;



public class RegistrationPageTest extends BaseTest

{

	
	@BeforeClass
	
	public void regSetup()
	
	{
		regpage = loginpage.navigateToRegisterPage();
	}
	
	
	
	public String getRandomEmail()
	
	{
		Random random = new Random();
		
		String email =  "testautomation" + random.nextInt(5000) + "@gmail.com";
		
		return email;
	}
	
	
	
	
	
	
	@DataProvider
	
	public Object[][] getRegTestData()
	
	{
		return ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		
		
		
		//return new Object[][] {
			
			//{"Ghjffepika", "Sharma",  "1236598745", "Dg123456", "yes"},
			//{"Test", "DS",  "543543535", "er@343f", "no"},
			//{"Tesdisd", "DS", "543532535", "egd@343f", "no"}
			
		//};
	}
	
	
	
	
	@Test(dataProvider = "getRegTestData")
	
	public void registrationTest(String firstName, String lastName, String telephone,String password, String subscribe)
	
	{
		Assert.assertTrue(
				regpage.accountRegistration(firstName,lastName, getRandomEmail(), telephone,password,subscribe));
	}
	
	
}
