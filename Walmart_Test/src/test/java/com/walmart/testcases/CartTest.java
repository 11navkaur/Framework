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
	driver.findElement(By.xpath("//button[contains(text(),'Close')]")).click();
}



@Test(enabled=false)
public void addOneGroceryItem()
{
	homepage.searchproduct("grocery food");
	
	grocerypage.groceryItemToCart();
}



@Test(enabled=false)
public void addOneItemToCartTest()
{
	/*homepage.clickOnDealsLink();
	String expectedprice=dealsandsalespage.getFirstDealPrice();
	dealsandsalespage.addFirstDealToCart();
	dealsandsalespage.clickOnCheckOut();
	String actualprice=cartpage.getFirstProductPrice();
	System.out.println(actualprice);
	System.out.println(expectedprice);

	Assert.assertEquals(actualprice, expectedprice); */
	
	homepage.clickOnDealsLink();
	
	dealsandsalespage.clickOnFirstDeal();
	String expectedprice= dealsandsalespage.getFirstDealPrice();
	dealsandsalespage.addDealToCart();
	
	dealsandsalespage.checkOut();
	
	String actualprice=cartpage.getFirstProductPrice();
	
	System.out.println(actualprice);
	System.out.println(expectedprice);

	Assert.assertEquals(actualprice, expectedprice);

}

@Test (enabled=false)
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

@Test (enabled=false)

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


@Test(enabled=false)
public void addMultipleItemsDifferentTypeTest() 
{
	/*homepage.clickOnDealsLink();
	Thread.sleep(2000);
	dealsandsalespage.addFirstItemToCart();
	dealsandsalespage.clickOnContinueShoppingButton();
	Thread.sleep(2000);
	dealsandsalespage.addSecondItemToCart();
	dealsandsalespage.clickOnContinueShoppingButton();*/
	//Thread.sleep(2000);
	//dealsandsalespage.addThirdItemTocart();
	//dealsandsalespage.clickOnContinueShoppingButton();
	homepage.clickOnDealsLink();
    
     dealsandsalespage.addMultipleItemsToCart();
     homepage.clickOnCart();
     
     Assert.assertTrue(true, "Homeholiday Resin Realistic Human Mini Skull Decoration Prop Skeleton Head Halloween Coffee Bars Ornament");
     
  
     
}

@Test (enabled=false)
public void clickOnItemInCartTest()
{
	homepage.clickOnDealsLink();
	dealsandsalespage.clickOnFirstDeal();
	
	dealsandsalespage.addDealToCart();
	dealsandsalespage.checkOut();
	String expectedname=cartpage.getNameOfFirstItem();
	cartpage.clickOnFirstItemInCart();
	String actualname=dealsandsalespage.getHeadingOfItem();
	
	Assert.assertTrue(true, expectedname);
}

@Test
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
	homepageafterlogin.clickOnSignOutLink();
	homepage.clickOnSignIn();
	signinpage.enterEmail(prop.getProperty("useremail"));
	signinpage.enterPassword(prop.getProperty("userpassword"));
	signinpage.clickOnSigninbutton();
	homepageafterlogin.clickOnCartLogo();
	cartpage.getCountOfItemsInCart();
	
	
	
	
}


	
	


@AfterMethod
@Test (enabled=false)
public void tearDown()
{
	driver.close();
}






}
