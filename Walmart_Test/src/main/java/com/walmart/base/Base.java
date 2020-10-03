package com.walmart.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.walmart.util.Utility;
import com.walmart.util.WebEventListner;

public class Base {

	static public WebDriver driver;   // scope all over the project
	static public  Properties prop;
	static public FileInputStream ip;
	static public Actions action;
	static public	JavascriptExecutor js;
	static public WebDriverWait wait;
	static EventFiringWebDriver e_driver;
	static WebEventListner eventlistner;
	public Base() 
	{
		try{
			prop = new Properties();
		
		ip= new FileInputStream("C:\\Users\\Nav\\eclipse-workspace\\Walmart_Test\\src\\main\\java\\com\\walmart\\config\\config.properties");
	    prop.load(ip);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	
	public void initialization()
	{
		String browser= prop.getProperty("browser");  //reading  values from config file
		
		if(browser.equals("firefox"))
				{
			System.setProperty("webdriver.gecko.driver","E:\\geckodriver.exe");
			driver= new FirefoxDriver();
				}
		else if(browser.equals("chrome"))
		{
		
			System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		
		e_driver=new EventFiringWebDriver(driver);
		 eventlistner = new WebEventListner();
		 e_driver.register(eventlistner);
		
		 driver=e_driver;
		 
		 
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Utility.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utility.Implicit_Wait, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	
		
		js = (JavascriptExecutor)driver;
		 action = new Actions(driver);
		  wait = new WebDriverWait(driver,5000);
		  
		 driver.findElement(By.xpath("//button[contains(text(),'Close')]")).click();
	
		
	}
	
	
	
}
