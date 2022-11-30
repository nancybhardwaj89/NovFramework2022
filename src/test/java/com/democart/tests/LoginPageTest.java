
package com.democart.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.democart.pages.AccountsPage;
import com.democart.utils.Constants;
import com.democart.utils.Errors;

public class LoginPageTest extends BaseTest {
	
	
	@Test(priority=1)
	
	public void loginPageTitleTest()
	
	{
		
		String title = loginpage.getLoginPageTitle();
		System.out.println("Login Page Title is:" +title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, Errors.TITLE_ERROR_MSG);
		
		
		
	}
	
	//@Test(priority=2)
	
	//public void loginPageHeaderTest()
	//{
		//String header = loginpage.getPageHeaderText();
		//System.out.println("Login page header text is:" +header);
	   //Assert.assertEquals(header, Constants.LOGIN_PAGE_HEADER, Errors.HEADER_ERROR_MSG);
		
	//}
	
	
	@Test(priority=3)
	 public void forgotPwdLinkTest()
	 
	 {
		Assert.assertTrue(loginpage.isForgotPwdLinkExits(), Errors.Forgot_PASSWORD_ERROR_MSG);
	 }
	
	
	@Test(priority=5)
	
	 public void loginTest()
	 
	 {
		AccountsPage accpage = loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertTrue(accpage.isLogoutLinkExists());
		
	 }
	

}
