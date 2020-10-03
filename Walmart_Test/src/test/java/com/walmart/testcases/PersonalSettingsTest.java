package com.walmart.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.walmart.base.Base;

import com.walmart.pages.HomePage;
import com.walmart.pages.HomePageAfterLogin;
import com.walmart.pages.MyAccountPage;
import com.walmart.pages.MyListPage;
import com.walmart.pages.PersonalSettingsPage;
import com.walmart.pages.SignInPage;

public class PersonalSettingsTest extends Base {


	HomePage homepage;
	SignInPage signinpage;
	HomePageAfterLogin homepageafterlogin;
	MyListPage mylistpage;
	MyAccountPage myaccountpage;
	PersonalSettingsPage personalsettingspage;

	public PersonalSettingsTest() {
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
		personalsettingspage = new  PersonalSettingsPage();

		homepage.clickOnSignIn();
		signinpage.enterEmail(prop.getProperty("useremail"));
		signinpage.enterPassword(prop.getProperty("userpassword"));
		signinpage.clickOnSigninbutton();

		homepageafterlogin.clickOnMyAccountLink();
		myaccountpage.clickOnPersonalSettingsLink();
	}

	@Test
	public void editPersonalInformationTest()
	{
		personalsettingspage.editPersonalInformation("brucenew", "waynenew", "L6L0V0");
	}

	@Test(enabled=false)
	public void cancelEditpersonalInformationTest()
	{
		personalsettingspage.cancelEditPersonalInformation("brucenew", "waynefirst", "L9O0B3");
	}

	@Test (enabled=false)
	public void editEmailTest()
	{
		personalsettingspage.editEmail("brucewayne2@mailinator.com");

		Assert.assertTrue(false, "brucewayne2@mailinator.com");
	}

	@Test (enabled=false)
	public void changePasswordTest()
	{
		personalsettingspage.changePassword("Batman@123", "Batman@1234", "Batman@1234");
	}
 
	@Test (enabled=false)
	public void changeLanguageToEnglishTest()
	{
		personalsettingspage.editEnglishLanguage();
	}


	@Test (enabled=false)
	public void changeLaguageToFrenchTest()
	{
		personalsettingspage.editFrenchLanguage();
	}

	@Test (enabled=false)
	public void winAndDiscountcodeTest()
	{
		personalsettingspage.addWinAndDiscount("axn", "2017wal");
	}

	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.close();
	}


}
