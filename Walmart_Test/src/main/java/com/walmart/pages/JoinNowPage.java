package com.walmart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.walmart.base.Base;

public class JoinNowPage extends Base {
@FindBy(id="firstName")
WebElement firstname;

@FindBy(id="lastName")
WebElement lastname;

@FindBy(id="phoneNumber")
WebElement phone;




@FindBy(id="email")
WebElement email;


@FindBy(id="password")
WebElement password;

@FindBy(xpath="//label[contains(text(),'By selecting \"Create account\", you are confirming')]")
WebElement termsandcondition;

@FindBy(id="marketingPreference")
WebElement marketingPreference;

@FindBy(xpath="//button[contains(text(),'Create account')]")
WebElement btn;

@FindBy(linkText="Sign in")
WebElement signinlink;


public JoinNowPage()
{
	PageFactory.initElements(driver, this);
}

public void enterfirstname(String userfirstname)
{
	firstname.clear();
	firstname.sendKeys(userfirstname);
}

public void enterlastname(String userlastname)
{
	lastname.clear();
	lastname.sendKeys(userlastname);
}
public void enterphone(String phone2)
{
	phone.clear();
	phone.sendKeys(phone2);
}
public void enteremail(String useremail)
{
	email.clear();
	email.sendKeys(useremail);
}

public void enterpassword(String userpassword)
{
	password.clear();
	password.sendKeys(userpassword);
}

public void clickOnTandC()
{
	js.executeScript("arguments[0].scrollIntoView();",termsandcondition);

	wait.until(ExpectedConditions.elementToBeClickable(termsandcondition));
	termsandcondition.click();
}

public void clickSubmit()
{
	btn.click();
}

public void clickOnSignIn()
{
	signinlink.click();
}
}
