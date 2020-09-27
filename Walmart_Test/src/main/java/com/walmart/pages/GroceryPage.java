package com.walmart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walmart.base.Base;

public class GroceryPage extends Base {
	
	
	@FindBy(xpath="//p[@class='css-1vmcotq eudvd6x0']")
	List<WebElement> productname;
	
	@FindBy(xpath="//div[@class='css-1yu3zn9 e1m8uw919']")
	List<WebElement> addicon;

	public GroceryPage()
	{
	PageFactory.initElements(driver, this);
	}
	
	
	public void groceryItemToCart()
	{
		
		for(int i=0; i<productname.size(); i++)
		{
			String name= productname.get(i).getText();
			if(name.contains("Cilantro"))
			{
				addicon.get(i).click();
				break;
			}
			
		}
		
	}
}
