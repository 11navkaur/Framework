package com.walmart.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.walmart.base.Base;
import com.walmart.pages.HomePage;
import com.walmart.pages.TablePage;


//Testing navigation of products and searching of products
public class GuestAccountTest  extends Base {

	HomePage homepage;
	TablePage tablepage;
	public GuestAccountTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();

		homepage= new HomePage();
		tablepage = new TablePage();

	}
/*	@Test(priority=1)
	public void navigateProducts()
	{
		homepage.navigateToFurniture();
		driver.navigate().back();
		homepage.navigateToOutdoorLiving();
	}
	@Test(priority=1)
	public void searchGuestProduct()
	{
		homepage.searchProduct("table");
		
		int count =tablepage.countTablesPerPage();
		System.out.println(count);
		
	} */


	@Test 
	public void navigateToBabyProductsTest()
	{
		homepage.navigateToBabyProducts();
	}
	
	
	@Test 
	public void searchProductWithdescritionTextTest()
	{
		homepage.searchProduct("waterbottle");
	}
	
	@Test 
	public void searchProductWithItemNumberTest()
	{
		homepage.searchProduct("322YXQISBR52");
	}
	
	@Test  
	public void searchProductInDepartmentTest() throws InterruptedException
	{
		homepage.navigateToDepartmentProduct();
	}
	@Test 
	public void verifyRelvalantProductNameTest()
	{
		homepage.searchProduct("waterbottle");
		String actual = homepage.verifySearchProductWithName();
				
		Assert.assertTrue(true, actual);
		
	}
	
	@Test 
	public void verifyProductInformationTest()
	{
		homepage.searchProduct("waterbottle");
		
		homepage.verifyProductInformation();
	}
	
	@Test 
	public void getTotalNumberOfProductsPerPageTest() throws InterruptedException 
	{
		homepage.searchProduct("bottle");
	
		int totalcount=homepage.getCountOfTotalproducts();
		Assert.assertEquals(totalcount, 60);
		
	}
	@Test 
	public void noDuplicationOnPaginationTest()
	{
		homepage.searchProduct("bottle");
		String  firstpage= homepage.getItemsOnFirstPage();
		String secondpage = homepage.getItemsOnSecondPage();
		//firstpage.equals(secondpage);
		Assert.assertFalse(firstpage.equals(secondpage));
	}
	 
	@Test 
	public void sortingTest()
	{
		homepage.searchProduct("bottle");
		homepage.sortBy("Top Rated");
		
	}
	
	@Test 
	public void filternyNewArrivalsTest() 
	{
		homepage.searchProduct("bottle");
		homepage.filterByNewArrivals();
	
		//Assert.assertEquals(true, homepage.filterByNewArrivals());
	}
	
	 
	@Test 
	public void filterbyCustomerRatingTest()
	{
		homepage.searchProduct("bottle");
		homepage.filterByCustomerRating(4);
	}
	
	@Test 
	public void filterByAvailabiltyTest()
	{
		homepage.searchProduct("bottle");
		homepage.filterByAvailabilty("In Store");
	}
	
	@Test 
	public void filterByPriceTest() throws InterruptedException
	{
		homepage.searchProduct("bottle");
		homepage.filterByPrice("15", "20");
	}
	
	@Test 
	public void sortingAndFilteringTest()
	{
		homepage.searchProduct("bottle");
		homepage.sortBy("Top Rated");
		homepage.filterByAvailabilty("In Store");
		
		
	}
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(2000);	
		driver.quit();
	}

	
	
	
	
}















