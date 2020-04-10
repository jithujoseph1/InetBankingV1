package com.Inetbanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	private static WebDriver ldriver;
	
	@FindBy(name="uid")
	private static WebElement userName;
	
	@FindBy(name="password")
	private static WebElement passWord;
	
	@FindBy(name="btnLogin")
	private static WebElement loginButton;
	
	@FindBy(name="btnReset")
	private static WebElement resetButton;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	private static WebElement logoutButton;
	
	
	public LoginPage(WebDriver rdriver)
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
	
	public void setUsername(String uname)
	{
		userName.sendKeys(uname);
	}
	
	public void setPassWord(String pwd)
	{
		passWord.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		loginButton.click();
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
