package com.walmart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.walmart.base.Base;

public class MyListPage extends Base {

	@FindBy(id="save-list-input")
	WebElement createlistinputbox;
	

	@FindBy(xpath="//button[@type='submit' and @id='save-list-button']")
	WebElement createlistbutton;
	
	@FindBy(name="embedded-search-form-input")
	 public WebElement searchproductbox;
	
	@FindBy(xpath="//button[contains(text(),'Search')]")
	WebElement searchproductbutton;
	
	@FindBy(xpath="//span[@class='list-title-txt'][contains(text(),'bruce')]")
	WebElement listname;
	
	public MyListPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void entershoppingListName(String listname)
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(createlistbutton));
		createlistinputbox.sendKeys(listname);
	}
	public void clickOnCreateListButton()
	{
		
		createlistbutton.click();
	}
	public String verifyListName()
	{
		String lname=listname.getText();
		return lname;
	}
	
	public void searchproduct(String product)
	{
		searchproductbox.sendKeys(product);
		searchproductbutton.click();
	}
}
