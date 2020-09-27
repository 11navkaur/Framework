package com.walmart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walmart.base.Base;

public class MyRecommendationPage extends Base {

	
	@FindBy(xpath="//h1[contains(text(),'Recommendations for')]")
	WebElement title;
	
	public  MyRecommendationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHeader()
	{
		String actual=title.getText();
		return actual;
	
	}
}

