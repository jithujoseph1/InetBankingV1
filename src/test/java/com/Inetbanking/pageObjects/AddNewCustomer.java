package com.Inetbanking.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import jdk.internal.jline.internal.Log;


public class AddNewCustomer {
	
	private static WebDriver ldriver;
	
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[2]/a")
	private static WebElement newCustomerLink;
	
	@FindBy(name="name")
	private static WebElement customerName;
	
	@FindBy(name="rad1")
	private static List <WebElement> gender;
			
    @FindBy(name="dob")
	private static WebElement dob;
			
	@FindBy(name="addr")
	private static WebElement address;
			
	@FindBy(name="city")
	private static WebElement city;
	
	@FindBy(name="state")
	private static WebElement state;
	
	@FindBy(name="pinno")
	private static WebElement pin;	
	
	@FindBy(name="telephoneno")
	private static WebElement mobileNumber;
			
	@FindBy(name="emailid")
	private static WebElement eMail;
	
	@FindBy(name="password")
	private static WebElement passWord;	

	
	@FindBy(name="sub")
	private static WebElement submitButton;
	
	@FindBy(name="res")
	private static WebElement resetButton;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	private static WebElement logoutButton;
	
	
	public AddNewCustomer(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		
		/*
		 * userName = ldriver.findElement(By.name("uid")); passWord =
		 * ldriver.findElement(By.name("password")); loginButton =
		 * ldriver.findElement(By.name("btnLogin")); resetButton =
		 * ldriver.findElement(By.name("btnReset"));
		 */
		 
	}
	
	public void clickAddNewCustomer()
	{
		newCustomerLink.click();
	}
	
	public void setCustomername(String cname)
	{
		customerName.sendKeys(cname);
	}
	
	public void setGender(String gen)
	{
		
		if(gen.equalsIgnoreCase("male"))
			
		{
		   gender.get(0).click();	
		}
		else if(gen.equalsIgnoreCase("female"))
		{
			gender.get(1).click();
			
		}
		else
		{
			System.out.println("Gender not found");
			Assert.assertTrue(false);
		}
	}
	
	public void setDOB(String mm,String dd, String yyyy)
	{
		dob.sendKeys(mm);
		dob.sendKeys(dd);
		dob.sendKeys(yyyy);
	}
	
	public void setAddress(String add)
	{
		address.sendKeys(add);
	}
	
	public void setCity(String cityname)
	{
		city.sendKeys(cityname);
	}
	
	public void setState(String stat)
	{
		state.sendKeys(stat);
	}
	
	public void setPin(String pn)
	{
		pin.sendKeys(String.valueOf(pn));
	}
	
	public void setMobileNumber(String mob)
	{
		mobileNumber.sendKeys(mob);
	}
	
	public void setEmail(String em)
	{
		eMail.sendKeys(em);
	}
	
	public void setPassword(String pwd)
	{
		passWord.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		submitButton.click();
	}
	public void clickReset()
	{
		resetButton.click();
	}
	public void clickLogout()
	{
		logoutButton.click();
	}

}
