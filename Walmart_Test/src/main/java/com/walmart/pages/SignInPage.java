package com.walmart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.walmart.base.Base;

public class SignInPage extends Base {
	
	@FindBy(id="username")
	WebElement username;


	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Sign in')]")
	WebElement signinbutton;
	
	//HomePageAfterLogin homepageafterlogin;
	
	public SignInPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterEmail(String email)
	{
		username.clear();
		username.sendKeys(email);
	}
	
	public void enterPassword(String pass)
	{
		password.clear();
		password.sendKeys(pass);
	}
	
	
		public HomePageAfterLogin clickOnSigninbutton()
	{
		try{
			
			//wait.until(ExpectedConditions.elementToBeClickable(signinbutton));
			signinbutton.click();
	
		
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
		e.getLocalizedMessage();
	}
		return new  HomePageAfterLogin();
}
		
		public String verifyTitle()
		{
			return driver.getTitle();
		}
		
}

