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


	@Test(enabled=false)
	public void navigateToBabyProductsTest()
	{
		homepage.navigateToBabyProducts();
	}
	
	
	@Test(enabled=false)
	public void searchProductWithdescritionTextTest()
	{
		homepage.searchProduct("waterbottle");
	}
	
	@Test(enabled=false)
	public void searchProductWithItemNumberTest()
	{
		homepage.searchProduct("322YXQISBR52");
	}
	
	@Test (enabled=false)
	public void searchProductInDepartmentTest() throws InterruptedException
	{
		homepage.navigateToDepartmentProduct();
	}
	@Test(enabled=false)
	public void verifyRelvalantProductNameTest()
	{
		homepage.searchProduct("waterbottle");
		String actual = homepage.verifySearchProductWithName();
		String expected="Showing 46 results for waterbottle";
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(enabled=false)
	public void verifyProductInformationTest()
	{
		homepage.searchProduct("waterbottle");
		
		homepage.verifyProductInformation();
	}
	
	@Test (enabled=false)
	public void getTotalNumberOfProductsPerPageTest() throws InterruptedException 
	{
		homepage.searchProduct("bottle");
	
		int totalcount=homepage.getCountOfTotalproducts();
		Assert.assertEquals(totalcount, 60);
		
	}
	@Test(enabled=false)
	public void noDuplicationOnPaginationTest()
	{
		homepage.searchProduct("bottle");
		String  firstpage= homepage.getItemsOnFirstPage();
		String secondpage = homepage.getItemsOnSecondPage();
		//firstpage.equals(secondpage);
		Assert.assertFalse(firstpage.equals(secondpage));
	}
	 
	@Test (enabled=false)
	public void sortingTest()
	{
		homepage.searchProduct("bottle");
		homepage.sortBy("Top Rated");
		
	}
	
	@Test (enabled=false)
	public void filternyNewArrivalsTest() throws InterruptedException 
	{
		homepage.searchProduct("bottle");
		homepage.filterByNewArrivals();
	
		Assert.assertEquals(true, homepage.filterByNewArrivals());
	}
	
	
	@Test (enabled=false)
	public void filterbyCustomerRatingTest()
	{
		homepage.searchProduct("bottle");
		homepage.filterByCustomerRating(4);
	}
	
	@Test  (enabled=false)
	public void filterByAvailabiltyTest()
	{
		homepage.searchProduct("bottle");
		homepage.filterByAvailabilty("In Store");
	}
	
	@Test(enabled=false)
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
	@AfterMethod(enabled=false)
	public void tearDown()
	{
		driver.quit();
	}

	
	
	
	
}















