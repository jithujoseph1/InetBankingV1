package com.Inetbanking.TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Inetbanking.Utilities.ReadConfig;
import com.Inetbanking.pageObjects.AddNewCustomer;
import com.Inetbanking.pageObjects.LoginPage;

import jdk.internal.jline.internal.Log;

public class AddNewCustomerTest extends BaseClass {
	
	@Test
	public void AddNewCustomer_TC01() throws InterruptedException, IOException
	{
	
	LoginPage lp = new LoginPage(driver);	
	lp.setUsername(ReadConfig.userName);
	lp.setPassWord(ReadConfig.password);
	lp.clickLogin();
	Thread.sleep(2000);
	logger.info("Logged in");
	AddNewCustomer anc = new AddNewCustomer(driver);
	anc.clickAddNewCustomer();
	Thread.sleep(2000);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	anc.setCustomername("jjkkpp");
	anc.setGender("female");
	Thread.sleep(3000);
	anc.setDOB("10", "20", "1986");
	anc.setAddress("new St");
	anc.setCity("Lexington");
	anc.setState("MA");
	anc.setPin("024210");
	anc.setMobileNumber("9788828833");
	anc.setEmail(RandomStringUtils.randomAlphabetic(8)+"@gmail.com");
	anc.setPassword("kkk2222");
	logger.info("entered new customer details");
	Thread.sleep(2000);
	anc.clickSubmit();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	if(driver.getPageSource().contains("Customer Registered Successfully!!!"))
	{
		
		logger.info("New Customer Added");
		assertTrue(true);
	}
	
	else
	{
		logger.warn("Customer Add Failed");
		captureScreen(driver,"AddNewCustomer_TC01()");
		assertTrue(false);
	}
			
	}
		
}
