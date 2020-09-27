package com.walmart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.walmart.base.Base;

public class MyRegistriesPage extends Base{

	
	@FindBy(xpath="//h3[contains(text(),'Baby')]")
	WebElement babyregistrylink;
	
	@FindBy(xpath="//h3[contains(text(),'Wedding')]")
	WebElement weddingregistrylink;
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement firstnameinputbox;
	
	@FindBy(xpath="//input[@name='lastname']")
     WebElement lastnameinputbox;	
	
	@FindBy(id="registry-type")
	WebElement selectRegistrytype;
	

	
	@FindBy(xpath="//input[@name='exactMatch']")
	WebElement checkbox;
	
	@FindBy(xpath="//button[contains(text(),'Find a Registry')]")
	WebElement findbutton;
	
	public MyRegistriesPage() {
		
		PageFactory.initElements(driver, this);
		 
	}
	
	
	public BabyRegistryPage clickOnBabyRegistryLink()
	{
		babyregistrylink.click();
		return new BabyRegistryPage();
	}
	
	public void clickOnWeddingRegistryLink()
	{
		weddingregistrylink.click();
	}
	
	public void enterFirstName(String registrantfirstname)
	{
		firstnameinputbox.sendKeys(registrantfirstname);
	}
	
	public void enterLastName(String registrantlastname)
	{
		lastnameinputbox.sendKeys(registrantlastname);
	}
	public void selectRegistry(String registrytype)
	
	{
		 Select s= new Select(selectRegistrytype);
		s.selectByVisibleText(registrytype);
	}
	
	public void selectCheckbox()
	{
		checkbox.click();
	}
	
	public void searchRegistry()
	{
		findbutton.click();
	}
}
