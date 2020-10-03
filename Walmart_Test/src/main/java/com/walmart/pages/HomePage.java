package com.walmart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walmart.base.Base;

public class HomePage extends Base{

	@FindBy(xpath="//span[contains(text(),'My account')]")
	WebElement myaccount;

	@FindBy(linkText="Join now")
	WebElement joinnowlink;
	Actions action = new Actions(driver);

	@FindBy(xpath="//span[@class='css-ya5i48 evkjyb01']")
	WebElement signin;

	@FindBy(xpath="//input[@placeholder='What are you looking for?']")
	WebElement searchbox;

	@FindBy(xpath="//button[@class='css-1pgwcoa e1xoeh2i2']")
	WebElement searchIcon;

	@FindBy(xpath="//span[contains(text(),'Outdoor living')]")
	WebElement outdoorliving;

	@FindBy(xpath="//span[contains(text(),'Furniture')]")
	WebElement furniture;

	//@FindBy(xpath="//li[@id='header-deals']//a[contains(text(),'Deals')]")
	@FindBy(linkText="Deals")
	WebElement dealslink;

	
	//@FindBy(xpath="//body//button[2]")
	//WebElement searchicon;

	@FindBy(xpath="//a[@id='nav-cart']//img[@id='shopping-cart-icon']")
	WebElement carticon;

/*//////////////////////////////////////////////////////////////////////////// */
	
	@FindBy(xpath="//a[@id='departments-button']")
	WebElement departmentlink;
	
	@FindBy(linkText="Baby")
	WebElement babylink;
	
	@FindBy(xpath="//a[contains(text(),'Toddler Beds')]")
	WebElement toddlerbedlink;
	
	@FindBy(xpath="//body/div/div/div[@id='browse-search-page']/div/div/div/div/div[7]/div[1]/div[1]/div[1]")
	WebElement relevantproductname;
	
	
	@FindBy(xpath="//div[@id='product-results']//div[1]//div[1]//a[1]//div[2]//div[1]//div[1]//p[1]")
WebElement firstproductname;	
	
	@FindBy(xpath="//div[@id='product-results']//div[1]//div[1]//a[1]//div[2]//div[2]//div[1]//div[1]//div[1]//div[1]//span[1]//span[1]")
	WebElement firstproductprice;
	
	//@FindBy(xpath="//div[@data-automation='product']")
	@FindBy(xpath="//p[@class='css-1c6n0sl eudvd6x0']")
	List<WebElement> numberofproductsonpage;
	
	@FindBy(xpath="//body//a[2]")
	WebElement secondpage;   
	
	@FindBy(xpath="//div[@data-automation='sort-by-dropdown-text']")
	WebElement sortby;
	
	
	@FindBy(xpath="//label[@class='css-1c6ntpr eu9xxh91' and contains(text(),'New Arrivals')]")
	WebElement filterbynewarrivals;
	
	@FindBy(xpath="//label[@class='css-1c6ntpr eu9xxh91' and contains(text(),'Customer Rating')]")
	WebElement filterbycustomerrating;
	
	@FindBy(xpath="//label[@class='css-1c6ntpr eu9xxh91' and contains(text(),'Category')]")
	WebElement filterbycategory;
	
	@FindBy(xpath="//label[@class='css-1c6ntpr eu9xxh91' and contains(text(),'Availability')]")
	WebElement filterbyavailability;
	
	@FindBy(xpath="//label[@class='css-1c6ntpr eu9xxh91' and contains(text(),'Price')]")
	WebElement filterbyprice;
	
	
	
	/*//////////////////////////////////////////////////////////////////////////// */	
	

	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}





	public void clickOnJoinNow()
	{
		action.moveToElement(myaccount).build().perform();
		joinnowlink.click();
	}

	public void clickOnSignIn()
	{
		signin.click();
	}


	public void navigateToOutdoorLiving()
	{
		js.executeScript("arguments[0].scrollIntoView();", outdoorliving);
		outdoorliving.click();
	}

	public void navigateToFurniture()
	{
		js.executeScript("arguments[0].scrollIntoView();",furniture);
		furniture.click();
	}
	public void searchProduct(String productname)
	{
		searchbox.sendKeys(productname);
		searchIcon.click();
		
		//return productname+"Page";
	}

	public DealsAndSalesPage clickOnDealsLink()
	{
		dealslink.click();
		return new DealsAndSalesPage();
	}

/*	public void searchproduct(String itemforsearch)
	{
		searchbox.sendKeys(itemforsearch);
		searchicon.click();
		//searchbox.sendKeys(Keys.ARROW_DOWN);
		//searchbox.sendKeys(Keys.ENTER);
		//action.keyDown(Keys.ENTER);
		//action.do
		//action.keyDown(Keys.CONTROL).click();
	
	}*/
	public void clickOnCart()
	{
		carticon.click();
	}
	public void navigateToBabyProducts()
	{
		action.moveToElement(departmentlink).build().perform();
		babylink.click();
	}
	
	public void navigateToDepartmentProduct() throws InterruptedException
	{
		action.moveToElement(departmentlink).build().perform();
		Thread.sleep(1000);
		action.moveToElement(babylink).build().perform();
		Thread.sleep(1000);
		toddlerbedlink.click();
	}
	public String verifySearchProductWithName()
	{
		return relevantproductname.getText();
	}
	
	public void verifyProductInformation()
	{
	System.out.println(firstproductname.getText());
	System.out.println(firstproductprice.getText());
	}
	
	public int getCountOfTotalproducts() throws InterruptedException
	{
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(7000);
		//System.out.println(numberofproductsonpage.size());
	   return numberofproductsonpage.size();
		
	}
	
	
	public String getItemsOnFirstPage()
	{
		for(int i = 0; i<numberofproductsonpage.size(); i++)
		{
			String firstpagelist= (numberofproductsonpage.get(i).getText());
			return firstpagelist;
		}
		return null;
		
	}
	public String getItemsOnSecondPage()
	{
		js.executeScript("arguments[0].scrollIntoView();",secondpage);
		secondpage.click();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		numberofproductsonpage.size();
		
		for(int i = 0; i<numberofproductsonpage.size(); i++)
		{
			String secondpagelist=numberofproductsonpage.get(i).getText();
			return secondpagelist;
		}
		return null;
	}
	
	public void sortBy(String sort)
	{
		sortby.click();
		driver.findElement(By.xpath("//span[contains(text(),'"+sort+"')]")).click();
	}
	public void filterByNewArrivals() 
	{
		js.executeScript("arguments[0].scrollIntoView();",filterbynewarrivals);
		filterbynewarrivals.click();
		WebElement filtercheckox=  driver.findElement(By.xpath("//span[@class='css-go8rfs eu1nysk1' and contains(text(),'New Arrivals')]"));
				filtercheckox.click();
				
				
				
	}
	public void filterByCategory( )
	{
		js.executeScript("arguments[0].scrollIntoView();",filterbycategory);
		filterbycategory.click();
	}
	
	public void filterByCustomerRating(int ratingrow)
	{
		js.executeScript("arguments[0].scrollIntoView();",filterbycustomerrating);
		filterbycustomerrating.click();
		driver.findElement(By.xpath("//div[@class='eggkv193 css-1aai4rr eo3fww40']/ul/li["+ratingrow+"]")).click();
		
	}
	
	public void filterByAvailabilty(String availableby)
	{
		js.executeScript("arguments[0].scrollIntoView();",filterbyavailability);
		filterbyavailability.click();
		driver.findElement(By.xpath("//span[contains(text(),'"+availableby+"')]")).click();
	}
	
	public void filterByPrice(String minprice,String maxprice) throws InterruptedException
	{
		
		js.executeScript("arguments[0].scrollIntoView();",filterbyprice);
		filterbyprice.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Min']")).sendKeys(minprice);
		driver.findElement(By.xpath("//input[@placeholder='Max']")).sendKeys(maxprice);
		driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		
	
	}
	}

