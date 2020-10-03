package com.walmart.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.walmart.base.Base;
import com.walmart.pages.AddressesPage;
import com.walmart.pages.HomePage;
import com.walmart.pages.HomePageAfterLogin;
import com.walmart.pages.MyAccountPage;
import com.walmart.pages.SignInPage;

public class AddressesTest  extends Base {
	
	HomePage homepage;
	SignInPage signinpage;
	HomePageAfterLogin homepageafterlogin;
	MyAccountPage myaccountpage;
	AddressesPage addressespage;
	
	public AddressesTest()
	{
		super();
	}
	
	@BeforeTest
	public void setUp() 
	{
		initialization();
		homepage= new HomePage();
		signinpage = new SignInPage();
		
		
		homepage.clickOnSignIn();
		signinpage.enterEmail(prop.getProperty("useremail"));
		signinpage.enterPassword(prop.getProperty("userpassword"));
		signinpage.clickOnSigninbutton();
		
		homepageafterlogin = new HomePageAfterLogin();
		myaccountpage = new MyAccountPage();
		addressespage =new AddressesPage();
		
		homepageafterlogin.clickOnMyAccountLink();
		myaccountpage.clickOnAddressesLink();
		
	}
	
	@Test(enabled=false)
	public void addAddressTest() throws InterruptedException
	{
		addressespage.enterShippingFirstName("bruce");
		addressespage.enterShippingLastName("wayne");
		addressespage.enterShippingAddress1("32 Beachville cir");
		Thread.sleep(1000);
		addressespage.enterShippingAddress2("apartmanet 14");
		addressespage.enterShippingCity("newyork");
		addressespage.selectProvince("Ontario");
		addressespage.enterShippingPostalCode("L6X 0V3");
		addressespage.enterShippingPhone("5256587465");
		addressespage.clickOnSaveButton();
		addressespage.clickOnSaveButton();
		
	}
	
	
	
	@Test (enabled=false)
	public void editAddressTest() throws InterruptedException
	{
		
		Thread.sleep(1000);
		addressespage.editShippingAddress();
		addressespage.enterShippingFirstName("bruce1");
		addressespage.enterShippingLastName("wayne1");
		addressespage.enterShippingAddress1("521 gotham drive");
		Thread.sleep(1000);
		addressespage.enterShippingAddress2("apartmanet 141");
		addressespage.enterShippingCity("newyork1");
		addressespage.selectProvince("Manitoba");
		addressespage.enterShippingPostalCode("L9O0N9");
		addressespage.enterShippingPhone("5258587465");
		addressespage.clickOnSaveButton();
		addressespage.clickOnSaveButton();
	}
	
	@Test 
	public void removeShippingAddressTest()
	{
		addressespage.removeShippingAddress();
	}
	@AfterMethod 
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(2000);	
		driver.quit();
	}
}
