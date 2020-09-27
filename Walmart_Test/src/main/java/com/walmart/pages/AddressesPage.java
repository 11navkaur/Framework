package com.walmart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.walmart.base.Base;

public class AddressesPage extends Base {

	@FindBy(id="shipping-first-name")
	WebElement shippingfirstname;
	
	@FindBy(id="shipping-last-name")
	WebElement shippinglastname;
	
	@FindBy(id="shipping-address1")
	WebElement shippingaddress1;
	
	@FindBy(id="shipping-address2")
	WebElement shippingaddress2;
	
	@FindBy(id="shipping-city")
	WebElement shippingcity;

	
	@FindBy(id="provinces")
	WebElement province;
	Select shippingprovince = new Select(province);
	
	@FindBy(id="shipping-postal-code")
	WebElement shippingpostalcode;
	
	@FindBy(id="shipping-phone")
	WebElement shippingphone;
	
	@FindBy(id="save-address-btn")
	WebElement shippingsavebutton;
	
	@FindBy(id="edit-address-btn")
	WebElement editshipping ;
	
	@FindBy(id="remove-address-btn")
	WebElement removeshipping ;
	
	
	public AddressesPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterShippingFirstName(String fname)
	{
		shippingfirstname.clear();
		shippingfirstname.sendKeys(fname);
	}
	
	
	public void enterShippingLastName(String lname)
	{
		shippinglastname.clear();
		shippinglastname.sendKeys(lname);
	}
	
	public void enterShippingAddress1(String address1)
	{
		shippingaddress1.clear();
		shippingaddress1.sendKeys(address1);
	}
	
	public void enterShippingAddress2(String address2)
	{
		shippingaddress2.clear();
		shippingaddress2.sendKeys(address2);
	}
	
	public void enterShippingCity(String city)
	{
		shippingcity.clear();
		shippingcity.sendKeys(city);
	}
	
	public void selectProvince(String province)
	{
		shippingprovince.deselectAll();
		shippingprovince.selectByVisibleText(province);
	}
	
	public void enterShippingPostalCode(String pcode)
	{
		shippingpostalcode.clear();
		shippingpostalcode.sendKeys(pcode);
	}
	
	public void enterShippingPhone(String phone)
	{
		shippingphone.clear();
		shippingphone.sendKeys(phone);
	}
	
	public void clickOnSaveButton()
	{
		shippingsavebutton.click();
	}
	
	
	public void editShippingAddress()
	{
		editshipping.click();
	}
	
	public void removeShippingAddress()
	{
		removeshipping.click();
	}
}
