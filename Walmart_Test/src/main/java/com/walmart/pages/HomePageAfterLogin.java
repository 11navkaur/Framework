package com.walmart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walmart.base.Base;

public class HomePageAfterLogin extends Base{

	
	@FindBy(xpath="//span[contains(text(),'My account')]")
	WebElement myaccount;
	
	
	
	@FindBy(linkText="My recommendations")
	WebElement recommendationlink;
	
	@FindBy(xpath="//a[contains(text(),'My lists')]")
   WebElement mylistlink;
	
	
	@FindBy(xpath="//a[contains(text(),'My registries')]")
	WebElement myregisterieslink;
	
	//@FindBy(xpath="//div[contains(@class,'flyout-menu-content')]//a[@id='header-my-account']")
	//@FindBy(linkText="My Account")
	@FindBy(xpath="//span[contains(text(),'My account')]")
	WebElement myaccountlink;
	
	@FindBy(xpath="//li[@id='header-deals']//a[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath="//body/div/div/div/div/div/div/div/div/div/div/div/div[5]/a[1]//*[local-name()='svg']")
    WebElement cartlogo;	
	
	//@FindBy(xpath="//p[@class='remembered-not-user']//a[@id='header-sign-out']")
	@FindBy(linkText="Sign out")
	WebElement signoutlink;
	
	public HomePageAfterLogin()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMyRecommendationlink()
	{
		
		action.moveToElement(myaccount).build().perform();
		recommendationlink.click();
		
	}
	
	public void clickOnMyListLink()
	{
		
		action.moveToElement(myaccount).build().perform();
		mylistlink.click();
		
	}
	
	public void clickOnMyRegisteriesLink()
	{
		action.moveToElement(myaccount).build().perform();
		myregisterieslink.click();
		
	}
	
	public void clickOnMyAccountLink()
	{
		//action.moveToElement(myaccount).build().perform();
		//System.out.println(myaccountlink.getText());
		myaccountlink.click();
		
	}

	public SignInPage clickOnSignOutLink()
	{
		action.moveToElement(myaccount).build().perform();
		signoutlink.click();
		 return new SignInPage();
	}
	
	public DealsAndSalesPage clickOnDealsLink()
	{
		dealslink.click();
		return new DealsAndSalesPage();
	}
	
	public void clickOnCartLogo()
	{
		cartlogo.click();
	}
}
