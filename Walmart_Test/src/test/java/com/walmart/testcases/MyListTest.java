package com.walmart.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.walmart.base.Base;
import com.walmart.pages.HomePage;
import com.walmart.pages.HomePageAfterLogin;
import com.walmart.pages.MyListPage;
import com.walmart.pages.SignInPage;

public class MyListTest extends Base {
	HomePage homepage;
	SignInPage signinpage;
	HomePageAfterLogin homepageafterlogin;
	MyListPage mylistpage;
	
	
	public MyListTest()
	{
		super();
	}
	
	@BeforeTest()
	public void setUp() 
	{
		initialization();
		homepage= new HomePage();
		signinpage = new SignInPage();
		homepageafterlogin = new HomePageAfterLogin();
		mylistpage = new  MyListPage();
		
		homepage.clickOnSignIn();
		
		signinpage.enterEmail(prop.getProperty("useremail"));
		signinpage.enterPassword(prop.getProperty("userpassword"));
		signinpage.clickOnSigninbutton();
		homepageafterlogin.clickOnMyListLink();
	}
	
	/*@Test
	public void createShoppingList() throws InterruptedException
	{
		
		mylistpage.entershoppingListName("wayneburce");
		Thread.sleep(2000);
		mylistpage.clickOnCreateListButton();
		Thread.sleep(2000);
		Assert.assertEquals(true,driver.getPageSource().contains("wayneburce"));
		
	}*/
	
	@Test
	public void serachProductTest() throws InterruptedException
	{
		Assert.assertEquals(true,mylistpage.searchproductbox.isDisplayed());
		Thread.sleep(3000);
		mylistpage.searchproduct("table");
		Assert.assertEquals(true,driver.getPageSource().contains("table"));
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	

}
