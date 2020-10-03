package com.walmart.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.walmart.base.Base;

public class DealsAndSalesPage extends Base{


	//@FindBy(xpath="//div[4]//div[2]//section[1]//div[2]//div[2]//div[1]//article[1]//div[1]//button[1]")
	@FindBy(xpath="//body/div/div/div/div/div/div[4]/div[2]/section[1]/div[2]/div[2]/div[1]/article[1]/a[1]/div[3]")
	WebElement clickonfirstdeal;

	@FindBy(xpath="//div[4]//div[2]//section[1]//div[2]//div[2]//div[1]//article[2]//div[1]//button[1]//span[2]")
	WebElement addoneitemtocart;
	
	@FindBy(xpath="//div[4]//div[2]//section[1]//div[2]//div[2]//div[1]//article[3]//div[1]//button[1]//span[2]")
	WebElement addseconditemtocart;
	
	@FindBy(xpath="//div[5]//div[2]//section[1]//div[2]//div[2]//div[1]//article[2]//div[1]//button[1]//span[2]")
	WebElement addthirditemtocart;
	
	@FindBy(xpath="//body/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/h1[1]")
	WebElement headingofitemincart;
	
	
	
	//@FindBy(xpath="//div[4]//div[2]//section[1]//div[2]//div[2]//div[1]//article[1]//a[1]//div[3]//span[2]//div[1]//div[1]")
	//@FindBy(css="div.js-content:nth-child(2) div.css-10wd6bz.evlleax1 div.css-186cfsd.evlleax2 div.css-0.eewy8oa0:nth-child(3) div.css-12rl50h.eewy8oa2:nth-child(3) div.css-18f77yw.eewy8oa4 div.css-1rfwmbp.eewy8oa5 div.css-w3hdpp.e1cd9jig0 div.css-j7qwjs.e1yn5b3f0 div.css-5ki3bg.e1yn5b3f5 div.css-18u0794.e1906lj50 div.css-j7qwjs.e1906lj51 div.css-k008qs.e1ufqjyx0 span.css-s3vnpn.esdkp3p2 > span.css-2vqe5n.esdkp3p0")
	@FindBy(xpath="//body/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/span[1]/span[1]")
	WebElement firstdealprice;

	@FindBy(xpath="//body/div/div/div/div/div/div[4]/div[2]/section[1]/div[2]/div[2]/div[1]/article[1]/a[1]/div[3]/div[1]")
	
	WebElement firstdealname;
	
	//@FindBy(xpath="//a[contains(text(),'Check out')]")
   //WebElement checkout;
	
	//@FindBy(xpath="//a[contains(text(),'Continue shopping')]")
	  // WebElement continueshopping;
	
	@FindBy(xpath="//button[contains(text(),'Add to cart')]")
	WebElement dealsandsalespageaddtocart;
	
	@FindBy(xpath="//button[contains(text(),'Checkout')]")
	WebElement dealsandsalespagecheckout;
	
	@FindBy(xpath="//a[contains(text(),'Continue shopping')]")
	WebElement dealspagecontinueshopping;
	
	@FindBy(xpath="//button[contains(text(),'+')]")
	WebElement increasequantity;
	
	@FindBy(xpath="//h2[@class='thumb-header']")
	//@FindBy(xpath="//div[@class='product-details-container']")
	List<WebElement> dealpageitemname;
	
	@FindBy(xpath="//button[@class='button add-to-cart-btn available']")
	List<WebElement> dealpageaddtocartbutton;
	
	
	public DealsAndSalesPage()
	{
		PageFactory.initElements(driver, this);
	}

	public void clickOnFirstDeal()
	{
		js.executeScript("arguments[0].scrollIntoView();",clickonfirstdeal);
		clickonfirstdeal.click();
	}
	
	

	public String getFirstDealPrice()
	{
		return firstdealprice.getText();
	}

	public String getFirstDealName()
	{
		return firstdealname.getText();
	}
	
	
	/*public void clickOnCheckOut()
	{
		checkout.click();
	}
	
	public void clickOnContinueShopping()
	{
		continueshopping.click();
	} */
	public void addDealToCart()
	{
		js.executeScript("arguments[0].scrollIntoView();",dealsandsalespageaddtocart);
		dealsandsalespageaddtocart.click();
	}
	
	public void checkOut()
	{
		dealsandsalespagecheckout.click();
	}
	
	public void clickToIncreaseQuantity(int numberofitems)
	{
		
		//increasequantity.click();
		for(int i =0;i<numberofitems;i++)
		{
			js.executeScript("arguments[0].scrollIntoView();",increasequantity);
			wait.until(ExpectedConditions.visibilityOf(increasequantity));
			increasequantity.click();
		}
	}
	
	public void addMultipleItemsToCart()
	{
		String[] itemsneeded= {"Gyrocopters PRO 6.0 Off-Road Hoverboard - UL 2272 Certified with Bluetooth, LED wheels, APP, No Fall Technology, Front and Back lights (Black)","IMGadgets- Dual Wireless Charger for Smart Watch and Other Qi-Enabled Smart Devices"};
		
		for(int i=0; i<dealpageitemname.size(); i++)
		{
			String name= dealpageitemname.get(i).getText();
			//System.out.println(name);
			List itemsneedelist= Arrays.asList(itemsneeded);
			
			if(itemsneedelist.contains(name))
			{
				
				dealpageaddtocartbutton.get(i).click();
				dealspagecontinueshopping.click();
			driver.navigate().refresh();
				//Thread.sleep(1000);
			
			}
			
		}
	}
	
	public void addFirstItemToCart()
	{
		//js.executeScript("window.scrollBy(0,250)");
		addoneitemtocart.click();
	}
		
	public void addSecondItemToCart()
	{
		//js.executeScript("arguments[0].scrollIntoView();",addseconditemtocart);
		//js.executeScript("window.scrollBy(0,250)");
		addseconditemtocart.click();
	}
	public void addThirdItemTocart()
	{js.executeScript("window.scrollBy(0,250)");
		//js.executeScript("arguments[0].scrollIntoView();",addthirditemtocart);
		addthirditemtocart.click();
	}
	
	public void clickOnContinueShoppingButton()
	{
		dealspagecontinueshopping.click();
	}
	
	public String getHeadingOfItem()
	{
		return headingofitemincart.getText();
	}
}
