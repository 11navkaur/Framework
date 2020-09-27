package com.walmart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walmart.base.Base;


public class TablePage extends Base{

@FindBy(xpath="//a[contains(text(),'Previous')]")
WebElement previouspage;
	
	//@FindAll({@FindBy(xpath="css-1c6n0sl eudvd6x0")})
	//@FindBy(className="css-x7wixz epettpn0")
	

	
	// List <WebElements> tableCount;


	public TablePage()
	{
		PageFactory.initElements(driver, this);
	}

	public int countTablesPerPage()
	{
		js.executeScript("arguments[0].scrollIntoView();", previouspage);
		List<WebElement> tablecount=driver.findElements(By.xpath("//div[@class='css-1i8qcff ek6u9510']/div"));
	
		System.out.println(tablecount.size());
	//	int str= tableCount.size();
		//System.out.println(str);
		//turn str;
		return 0;
	}
	
	
	
	
	
	
	
	
}


