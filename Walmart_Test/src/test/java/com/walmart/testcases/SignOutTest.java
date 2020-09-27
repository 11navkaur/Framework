package com.walmart.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.walmart.base.Base;
import com.walmart.pages.AddressesPage;
import com.walmart.pages.HomePage;
import com.walmart.pages.HomePageAfterLogin;
import com.walmart.pages.MyAccountPage;
import com.walmart.pages.SignInPage;

public class SignOutTest extends Base{

	
	
	HomePage homepage;
	SignInPage signinpage;
	HomePageAfterLogin homepageafterlogin;
	MyAccountPage myaccountpage;
	
	
	public SignOutTest()
	{
		super();
	}
	
	@BeforeTest
	public void setUp() 
	{
		initialization();
		homepage= new HomePage();
		signinpage = new SignInPage();
		homepageafterlogin = new HomePageAfterLogin();
		//myaccountpage = new MyAccountPage();
		
		
		homepage.clickOnSignIn();
		signinpage.enterEmail(prop.getProperty("useremail"));
		signinpage.enterPassword(prop.getProperty("userpassword"));
		signinpage.clickOnSigninbutton();
		
	}
	
	@Test
	public void signOutTest()
	{
		String title=	signinpage.verifyTitle();
		homepageafterlogin.clickOnSignOutLink();
	
		
		Assert.assertEquals(title, "Walmart Canada");
	}
}
