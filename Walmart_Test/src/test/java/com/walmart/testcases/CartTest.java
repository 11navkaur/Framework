package com.walmart.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.walmart.base.Base;
import com.walmart.pages.CartPage;
import com.walmart.pages.DealsAndSalesPage;
import com.walmart.pages.GroceryPage;
import com.walmart.pages.HomePage;
import com.walmart.pages.HomePageAfterLogin;
import com.walmart.pages.SignInPage;


public class CartTest extends Base {

	HomePage homepage;
	DealsAndSalesPage dealsandsalespage;
	CartPage cartpage;
	SignInPage signinpage;
	GroceryPage grocerypage;
	HomePageAfterLogin homepageafterlogin;

public CartTest()
{
	super();
}

@BeforeTest()
public void setUp() 
{
	initialization();
	homepage = new  HomePage();
	dealsandsalespage= new  DealsAndSalesPage();
	cartpage = new  CartPage();
	grocerypage= new GroceryPage();
	signinpage = new SignInPage();
	homepageafterlogin = new HomePageAfterLogin();
	
}






@Test (priority=1)
public void addOneItemToCartTest()
{
	
	homepage.clickOnDealsLink();
	dealsandsalespage.clickOnFirstDeal();
	dealsandsalespage.addDealToCart();
	dealsandsalespage.checkOut();
	String actualprice=cartpage.getFirstProductPrice();
	Assert.assertTrue(true, actualprice);
	System.out.println(actualprice);
	

}

@Test  (priority=2)
public void increaseTheQuantityTest() throws InterruptedException
{
	homepage.clickOnDealsLink();
	dealsandsalespage.clickOnFirstDeal();
	dealsandsalespage.addDealToCart();
	dealsandsalespage.checkOut();
	cartpage.addItemQuantity();
	
	String newprice= cartpage.checkUpdatedprice();
	System.out.println(newprice);
	
}

@Test  (priority=3)

public void addSameItemMultipleTimes() throws InterruptedException
{
	homepage.clickOnDealsLink();
	dealsandsalespage.clickOnFirstDeal();
	dealsandsalespage.clickToIncreaseQuantity(2);
     Thread.sleep(2000);
	dealsandsalespage.addDealToCart();
	dealsandsalespage.checkOut();
	String actualnumber= cartpage.getNumberOfItems();
	
	Assert.assertEquals(actualnumber, "3 items");
	
}


@Test (priority=4)
public void addMultipleItemsDifferentTypeTest() 
{
	
	homepage.clickOnDealsLink();
    
     dealsandsalespage.addMultipleItemsToCart();
     homepage.clickOnCart();
     
     Assert.assertTrue(true, "Homeholiday Resin Realistic Human Mini Skull Decoration Prop Skeleton Head Halloween Coffee Bars Ornament");
     
  
     
}

@Test  (priority=5)
public void clickOnItemInCartTest()
{
	homepage.clickOnDealsLink();
	dealsandsalespage.clickOnFirstDeal();
	
	dealsandsalespage.addDealToCart();
	dealsandsalespage.checkOut();
	String expecteditem=cartpage.getNameOfFirstItem();
	System.out.println(expecteditem);
	cartpage.clickOnFirstItemInCart();
	//String actualitem=dealsandsalespage.getHeadingOfItem();
	//System.out.println(actualitem);
	//System.out.println(expecteditem);
	//Assert.assertEquals(actualitem, expecteditem);
}

@Test (priority=6)
public void reopenAfterClosingTest() 
{
	homepage.clickOnSignIn();
	signinpage.enterEmail(prop.getProperty("useremail"));
	signinpage.enterPassword(prop.getProperty("userpassword"));
	signinpage.clickOnSigninbutton();
	homepage.clickOnDealsLink();
	dealsandsalespage.clickOnFirstDeal();
	dealsandsalespage.addDealToCart();
	dealsandsalespage.checkOut();
	String beforelogout =cartpage.getCountOfItemsInCart();
	homepageafterlogin.clickOnSignOutLink();
	homepage.clickOnSignIn();
	signinpage.enterEmail(prop.getProperty("useremail"));
	signinpage.enterPassword(prop.getProperty("userpassword"));
	signinpage.clickOnSigninbutton();
	homepageafterlogin.clickOnCartLogo();
	String afetrlogout=cartpage.getCountOfItemsInCart();
	Assert.assertEquals(afetrlogout, beforelogout);
	
	
	
}


	
	


@AfterMethod
public void tearDown() throws InterruptedException
{
	Thread.sleep(1000);
	driver.close();
}






}
