package com.walmart.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walmart.base.Base;

public class CartPage extends Base {

	@FindBy(xpath="//span[@class='css-2vqe5n esdkp3p0']")
	WebElement firstproductprice;
	
	@FindBy(xpath="//button[contains(text(),'+')]")
	WebElement addquanitity;
	
	@FindBy(xpath="//button[contains(text(),'-')]")
	WebElement removequantity;
	
	@FindBy(xpath="//body/div/div/div/div/div/div/div/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/span[1]/span[1]")
	WebElement updatedprice;
	
	@FindBy(xpath="//body/div/div/div/div/div/div/div[1]/span[1]")
	WebElement numberofitems;
	
	
	@FindBy(xpath="//div[@class='css-6dnhn e3alz352']")
	List<WebElement> itemstoberemoved;
	
	
	@FindBy(xpath="//span[contains(text(),'X Remove')]")
	List<WebElement> removeitem;
	
	@FindBy(xpath="//body//div//div//div//div//div//div//div//div//div//div[1]//div[1]//div[2]//a[1]")
	WebElement firstitemlink;
	
@FindBy(xpath="//body//div//div//div//div//div//div//div//div//div//div[1]//div[1]//div[2]//a[1]")
WebElement firstitemname;

@FindBy(xpath="//body/div/div/div/div/div/div/div[1]/span[1]")
WebElement numberofitemsincart;
	
	public CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getFirstProductPrice()
	{
		return firstproductprice.getText();
	}
	
	public void addItemQuantity() throws InterruptedException
	{
		addquanitity.click();
		Thread.sleep(2000);
	}
	
	public String checkUpdatedprice()
	{
		return updatedprice.getText();
	}
	
	public String getNumberOfItems()
	{
		return numberofitems.getText();
	}
	
	public void removeItemFromCart()
	{
		for(int i=0; i<itemstoberemoved.size();i++)
		{
			String name=itemstoberemoved.get(i).getText();
			
			if(name.contains("abc"))
			{
				removeitem.get(i).click();
			}
		}
	}
	
	public void clickOnFirstItemInCart()
	{
		firstitemlink.click();
	}
	
	public String getNameOfFirstItem()
	{
		return firstitemname.getText();
	}
public String getCountOfItemsInCart()
{
	String totalItems=  numberofitemsincart.getText();
	System.out.println(totalItems);
	return totalItems;
	
}
}
