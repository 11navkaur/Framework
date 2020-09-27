package com.walmart.testcases;

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
		homepageafterlogin = new HomePageAfterLogin();
		myaccountpage = new MyAccountPage();
		addressespage =new AddressesPage();
		
		homepage.clickOnSignIn();
		signinpage.enterEmail(prop.getProperty("useremail"));
		signinpage.enterPassword(prop.getProperty("userpassword"));
		signinpage.clickOnSigninbutton();
		
		homepageafterlogin.clickOnMyAccountLink();
		myaccountpage.clickOnAddressesLink();
	}
	
	@Test
	public void addAddressTest()
	{
		addressespage.enterShippingFirstName("bruce");
		addressespage.enterShippingLastName("wayne");
		addressespage.enterShippingAddress1("52 gotham drive");
		addressespage.enterShippingAddress2("apartmanet 14");
		addressespage.enterShippingCity("newyork");
		addressespage.selectProvince("Ontario");
		addressespage.enterShippingPostalCode("L9O0N9");
		addressespage.enterShippingPhone("5256587465");
		addressespage.clickOnSaveButton();
	}
	
	
	
	@Test
	public void editAddressTest()
	{
		addressespage.editShippingAddress();
		addressespage.enterShippingFirstName("bruce1");
		addressespage.enterShippingLastName("wayne1");
		addressespage.enterShippingAddress1("521 gotham drive");
		addressespage.enterShippingAddress2("apartmanet 141");
		addressespage.enterShippingCity("newyork1");
		addressespage.selectProvince("Manitoba");
		addressespage.enterShippingPostalCode("L9O0N9");
		addressespage.enterShippingPhone("5258587465");
		addressespage.clickOnSaveButton();
	}
	
	@Test
	public void removeShippingAddressTest()
	{
		addressespage.removeShippingAddress();
	}

}
