package com.walmart.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.walmart.base.Base;

public class CreditCardsPage  extends Base {

	
	@FindBy(xpath="//button[@id='add-new-cc-modal-trigger']")
	WebElement addnewcreditcard;
	
	@FindBy(id="credit-card-first-name")
	WebElement cardfirstname;
	
	
	
	@FindBy(id="credit-card-last-name")
	WebElement cardlastname;
	
	@FindBy(id="credit-card-card-no")
	WebElement creditcardnumber;
	
	@FindBy(id="credit-card-expiry-month")
	WebElement expirymonth;
	
	@FindBy(id="credit-card-expiry-year")
	WebElement expiryyear;
	
	
	@FindBy(id="credit-card-security-code")
	WebElement securitycode;
	
	@FindBy(id="credit-card-phone")
	WebElement creditphonenumber;
	
	@FindBy(id="credit-card-address1")
	WebElement creditcardaddress1;
	
	@FindBy(id="credit-card-address2")
	WebElement creditcardaddress2;
	
	@FindBy(id="credit-card-city")
	WebElement creditcardcity;
	
	
	@FindBy(xpath="//select[@class='a-input--width100']")
	WebElement creditcardprovince;
	
	
	
	@FindBy(id="credit-card-postal-code")
	WebElement creditcardpostalcode;
	
	@FindBy(id="add-cc-modal-btn")
	WebElement savecreditcardbutton;
	
	
	public  CreditCardsPage()
	
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAddNewCreditCard()
	{
		addnewcreditcard.click();
	}
	
	public void enterFirstName(String fname)
	{
		cardfirstname.clear();
		cardfirstname.sendKeys(fname);
	}
	
	public void enterLastName(String lname)
	{
		cardlastname.clear();
		cardlastname.sendKeys(lname);
	}
	
	public void enterCreditCardNumber(CharSequence credit)
	{
		creditcardnumber.sendKeys(credit);
	}
	
	public void enterExpiryMonth(CharSequence month)
	{
		expirymonth.sendKeys(month);
	}
	
	public void enterExpiryYear(CharSequence year)
	{
		expiryyear.sendKeys(year);
	}
	
	public void enterSecurityCode(CharSequence code)
	{
		securitycode.sendKeys(code);
	}
	
	public void enterPhoneNumber(CharSequence phone)
	{
		creditphonenumber.sendKeys(phone);
	}
	
	public void enterCreditAddress1(String add1)
	{
		creditcardaddress1.sendKeys(add1);
       action.sendKeys(Keys.ENTER);
		
	}
	
	public void enterCreditAddress2(String add2)
	{
		creditcardaddress2.sendKeys(add2);
	}
	
	public void enterCreditCity(String city)
	{
		creditcardcity.sendKeys(city);
	}

	public void enterCreditProvince(String province)
	{
		Select creditprovince = new Select (creditcardprovince);
		creditprovince.selectByVisibleText(province);
	}
	
	public void enterPostalCode(String postal)
	{
		creditcardpostalcode.sendKeys(postal);
	}

	
	public void clickOnSaveCreditCardButton()
	{
		savecreditcardbutton.click();
	}
}
