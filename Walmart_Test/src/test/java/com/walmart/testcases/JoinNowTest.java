package com.walmart.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.walmart.base.Base;
import com.walmart.pages.HomePage;
import com.walmart.pages.JoinNowPage;
import com.walmart.pages.MyAccountPage;
import com.walmart.util.Utility;

public class JoinNowTest extends Base{
	HomePage homepage;
	JoinNowPage joinnow;
	MyAccountPage myaccount;
	String sheetName = "email";
	public JoinNowTest()
	{
		super();
	}

	
	
	@BeforeTest()
	public void setUp()
	{
		initialization();
		homepage= new HomePage();
		joinnow= new JoinNowPage();
		homepage.clickOnJoinNow();
		myaccount= new MyAccountPage();
	}
	
	@Test(enabled=false)
	public void createAccountwithValidCedentials()
	{
		joinnow.enterfirstname("tom");
		joinnow.enterlastname("hanks");
		joinnow.enteremail("tomhanks1243@mailinator.com");
		joinnow.enterpassword("Home123");
		joinnow.clickOnTandC();
		joinnow.clickSubmit();
	}
	
	@DataProvider ()
	public Object[][] getData()
	{
		Object[][] data= Utility.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getData")
	//public void validEmail(String fname, String lname, String uemail, String upassword)
	public void email(String fname,String lname, String uemail,String upass) throws InterruptedException
	{
		joinnow.enterfirstname(fname);
		joinnow.enterlastname(lname);
	    //joinnow.enterphone(phone);
	 	joinnow.enteremail(uemail);
		joinnow.enterpassword(upass);
		joinnow.clickOnTandC();
		joinnow.clickSubmit();
	
		String actualtitle=myaccount.verifyTitle();
		
		Assert.assertEquals(actualtitle, "My Account");
		Thread.sleep(2000);
	}
	
	
	@AfterTest()
	public void tearDown()
	{
		driver.quit();
	} 
	
} 
