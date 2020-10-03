package com.walmart.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.walmart.base.Base;
import com.walmart.pages.CreditCardsPage;
import com.walmart.pages.HomePage;
import com.walmart.pages.HomePageAfterLogin;
import com.walmart.pages.MyAccountPage;
import com.walmart.pages.SignInPage;

public class CreditCardsTest extends Base{
	
	HomePage homepage;
	SignInPage signinpage;
	HomePageAfterLogin homepageafterlogin;
	MyAccountPage myaccountpage;
	CreditCardsPage creditcardspage;
	
	public CreditCardsTest()
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
		creditcardspage= new CreditCardsPage();
		
		homepage.clickOnSignIn();
		
		signinpage.enterEmail(prop.getProperty("useremail"));
		signinpage.enterPassword(prop.getProperty("userpassword"));
		signinpage.clickOnSigninbutton();
		
		homepageafterlogin.clickOnMyAccountLink();
		myaccountpage.clickOnCreditCardsLink();
		
	}
	@Test
	public void  addCreditCard()
	{
		creditcardspage.clickOnAddNewCreditCard();
		creditcardspage.enterFirstName("nav");
		creditcardspage.enterLastName("kaur");
		creditcardspage.enterCreditCardNumber("4537337449281039");
		creditcardspage.enterExpiryMonth("08");
		creditcardspage.enterExpiryYear("21");
		creditcardspage.enterPhoneNumber("5146584875");
		creditcardspage.enterCreditAddress1("32 beachville Circle");
		
		creditcardspage.enterCreditAddress2("Aprt 12");
		//creditcardspage.enterCreditCity("Brampton");
		creditcardspage.enterCreditProvince("Ontario");
		//creditcardspage.enterPostalCode("L6X0V3");
		creditcardspage.clickOnSaveCreditCardButton();
	}
	
	@AfterMethod

	public void tearDown()
	{
		driver.close();
	}
	
	
	
	

}
