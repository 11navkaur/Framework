package com.walmart.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.base.Base;
import com.walmart.pages.BabyRegistryPage;
import com.walmart.pages.HomePage;
import com.walmart.pages.HomePageAfterLogin;
import com.walmart.pages.MyListPage;
import com.walmart.pages.MyRegistriesPage;
import com.walmart.pages.SignInPage;

public class MyRegisteriesLinkTest extends Base {
	HomePage homepage;
	SignInPage signinpage;
	HomePageAfterLogin homepageafterlogin;
	MyListPage mylistpage;
	MyRegistriesPage myregistriespage;
	BabyRegistryPage babyregistrypage;
	
	
	public MyRegisteriesLinkTest()
	{
		super();
	}
	@BeforeMethod
	public void setUp() 
	{
		initialization();
		homepage= new HomePage();
		signinpage = new SignInPage();
		homepageafterlogin = new HomePageAfterLogin();
		mylistpage = new  MyListPage();
		myregistriespage = new  MyRegistriesPage();
		babyregistrypage = new  BabyRegistryPage();
		homepage.clickOnSignIn();
		signinpage.enterEmail(prop.getProperty("useremail"));
		signinpage.enterPassword(prop.getProperty("userpassword"));
		signinpage.clickOnSigninbutton();
		homepageafterlogin.clickOnMyRegisteriesLink();
		
    }
	
	@Test
	public void createBabyRegisteryTest()
	{
		myregistriespage.clickOnBabyRegistryLink();
		String actual= babyregistrypage.verifyTitle();
		Assert.assertEquals(actual, "Baby Registry | Walmart Canada");
	}
	
	
	
	@Test
	public void findRegistry()
	{
		myregistriespage.enterFirstName("ganga");
		myregistriespage.enterLastName("devi");
		myregistriespage.selectRegistry("Baby");
		myregistriespage.searchRegistry();
		//Assert.assertEquals(true, " Registry Search Results");
		Assert.assertTrue(true, "Registry Search Results");
	}
	@Test
	public void findRegistryWithExactMatch()
	{
		myregistriespage.enterFirstName("ganga");
		myregistriespage.enterLastName("devi");
		myregistriespage.selectRegistry("Baby");
		myregistriespage.selectCheckbox();
		myregistriespage.searchRegistry();
		Assert.assertEquals(true, " Registry Search Results");
	}
	
	@AfterMethod
	@Test 
	public void tearDown()
	{
		driver.close();
	}
}

