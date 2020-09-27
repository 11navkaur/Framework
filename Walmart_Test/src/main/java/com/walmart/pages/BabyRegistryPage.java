package com.walmart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walmart.base.Base;

public class BabyRegistryPage extends Base {

	@FindBy(xpath="//div[@class='html-cartridge managebuttons']//h3[contains(text(),'Create a registry')]")
	WebElement createbabyregistrylink;
	
public BabyRegistryPage() {
		
		PageFactory.initElements(driver, this);
		
	}

public String verifyTitle()
{
	String actualtitle=driver.getTitle();
	return actualtitle;
}
public void clickOnCreateBabyRegistry()
{
	createbabyregistrylink.click();
}
	
	
}
