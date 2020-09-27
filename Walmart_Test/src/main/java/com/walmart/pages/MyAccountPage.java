package com.walmart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walmart.base.Base;

public class MyAccountPage extends Base {

	
	@FindBy(xpath="//h1[@class='tablet-hide']")
	WebElement title;
	
	@FindBy(linkText="Personal Settings")
	WebElement personalsettingslink;
	
	@FindBy(linkText="Addresses")
	WebElement addresseslink;
	
	@FindBy(linkText="Credit Cards")
	WebElement creditcardslink;
	
	
	
	@FindBy(linkText="Sign Out")
	WebElement signoutlink;
	
	public MyAccountPage()
	{
	PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle()
	{
	String MyAccountTitle=	title.getText();
	return MyAccountTitle;
	}
	
	public void clickOnPersonalSettingsLink()
	{
		personalsettingslink.click();
	}
	
	public void clickOnAddressesLink()
	{
		addresseslink.click();
	}
	
	public SignInPage clickOnSignOutLink()
	{
		signoutlink.click();
		return new SignInPage();
	}
	public void clickOnCreditCardsLink()
	{
		creditcardslink.click();
		
	}

}
