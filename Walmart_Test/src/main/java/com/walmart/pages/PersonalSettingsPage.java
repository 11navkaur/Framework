package com.walmart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walmart.base.Base;

public class PersonalSettingsPage extends Base {
	
	@FindBy(xpath="//span[@id='set-edit-info']")
     WebElement editinfo;
	
	@FindBy(xpath="//input[@name='firstName']")
    WebElement firstname;
	
	@FindBy(xpath="//input[@name='lastName']")
    WebElement lastname;

	@FindBy(xpath="//input[@name='postalCode']")
    WebElement postalcode;
	
	@FindBy(xpath="//a[@id='unset-edit-info']")
    WebElement infocancelbutton;
	
	@FindBy(xpath="//button[@id='update-details-btn']")
    WebElement infosavebutton;
	
	@FindBy(xpath="//span[@id='set-edit-email']")
    WebElement editemail;

	@FindBy(xpath="//input[@name='email']")
    WebElement email;
	
	@FindBy(id="email-password")
    WebElement emailpassword;
	
	@FindBy(id="update-email-btn")
    WebElement emailsavebutton;
	
	@FindBy(id="unset-edit-email")
    WebElement canceleditemail;
	
	@FindBy(id="set-edit-password")
    WebElement editpassword;
	
	@FindBy(id="oldPassword")
    WebElement oldpassword;
	
	@FindBy(id="confirmPassword")
    WebElement confirmpassword;
	
	@FindBy(id="password")
    WebElement newpassword;
	
	@FindBy(id="update-passwd-btn")
    WebElement savepasswordbutt;
	
	@FindBy(id="unset-edit-password")
    WebElement canceleditpassword;
	
	@FindBy(id="set-edit-language")
    WebElement editlanguage;
	
	@FindBy(xpath="//label[2]//i[1]")
    WebElement englishlanguage;
	

	@FindBy(xpath="//label[3]//i[1]")
    WebElement frenchlanguage;
	
	@FindBy(id="update-language-btn")
    WebElement savelanguage;
	
	@FindBy(id="unset-edit-language")
    WebElement canceleditlanguage;
	
	
	@FindBy(linkText="Add your WIN and Discount Card Number to your account")
    WebElement areyouawallmartemployee;
	
	@FindBy(id="win")
    WebElement win;
	
	@FindBy(xpath="//input[contains(@name,'discountCard')]")
    WebElement discountcard;
	
	@FindBy(xpath="//input[contains(@name,'agree')]")
    WebElement agreecheckbox;
	
	@FindBy(id="update-associate-btn")
    WebElement saveassociatebutton;
	
	@FindBy(id="unset-edit-associate")
    WebElement cancelassociatebutton;
	
public PersonalSettingsPage() {
		
		PageFactory.initElements(driver, this);
		 
	}

public void editPersonalInformation(String newname,String newlastname,String newpostalcode)
{
	editinfo.click();
	firstname.sendKeys(newname);
	lastname.sendKeys(newlastname);
	postalcode.clear();
	postalcode.sendKeys(newpostalcode);
	infosavebutton.click();
	
}

public void cancelEditPersonalInformation(String newname,String newlastname,String newpostalcode)
{
	editinfo.click();
	firstname.sendKeys(newname);
	lastname.sendKeys(newlastname);
	postalcode.clear();
	postalcode.sendKeys(newpostalcode);
	infocancelbutton.click();
}
	
	public void editEmail(String useremail)
	{
		js.executeScript("arguments[0].scrollIntoView();", editemail);
		editemail.click();
		email.clear();
		email.sendKeys(useremail);
		emailpassword.sendKeys(prop.getProperty("userpassword"));
		emailsavebutton.click();
		
	}
	
	public void changePassword(String oldpass, String newpass, String confirmpass)
	{
		editpassword.click();
		oldpassword.sendKeys(oldpass);
		newpassword.sendKeys(newpass);
		confirmpassword.sendKeys(confirmpass);
		savepasswordbutt.click();
	}

   
	 public void editEnglishLanguage()
	 
	 {
		 editlanguage.click();
		 englishlanguage.click();
		 savelanguage.click();
	 }
	 
public void editFrenchLanguage()
	 
	 {
		 editlanguage.click();
		 frenchlanguage.click();
		 savelanguage.click();
	 }

public void addWinAndDiscount(String winnumber,String discountcode)
{
	areyouawallmartemployee.click();
	win.sendKeys(winnumber);
	discountcard.sendKeys(discountcode);
	agreecheckbox.click();
	saveassociatebutton.click();
	
}
}
