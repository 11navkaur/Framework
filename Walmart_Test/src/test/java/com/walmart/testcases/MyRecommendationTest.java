package com.walmart.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.walmart.base.Base;
import com.walmart.pages.HomePage;
import com.walmart.pages.HomePageAfterLogin;
import com.walmart.pages.MyRecommendationPage;
import com.walmart.pages.SignInPage;

public class MyRecommendationTest extends Base{


	HomePage homepage;
	SignInPage signinpage;
	HomePageAfterLogin homepageafterlogin;
	MyRecommendationPage myrecommendationpage;
	public MyRecommendationTest()
	{
		super();
	}



	@BeforeTest()
	public void setUp() throws InterruptedException
	{
		initialization();
		homepage= new HomePage();
		signinpage = new SignInPage();
		homepageafterlogin = new HomePageAfterLogin();
		myrecommendationpage= new MyRecommendationPage();



		homepage.clickOnSignIn();
		//Thread.sleep(6000);
		signinpage.enterEmail("brucewayne@mailinator.com");
		signinpage.enterPassword("Batman@123");
		signinpage.clickOnSigninbutton();
	}

	@Test(priority=1)
	public void clickOnRecommendationLink() {
		homepageafterlogin.clickOnMyRecommendationlink();
		String actual=	myrecommendationpage.verifyHeader();

		String Expected="Recommendations for";

		Assert.assertEquals(actual, Expected);


	}






}
