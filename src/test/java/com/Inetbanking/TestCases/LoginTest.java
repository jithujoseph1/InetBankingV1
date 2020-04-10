package com.Inetbanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Inetbanking.Utilities.ReadConfig;
import com.Inetbanking.pageObjects.LoginPage;

public class LoginTest extends BaseClass {
	
	@Test
	public void LoginTest_TC01() throws InterruptedException, IOException
	{
	
	LoginPage lp = new LoginPage(driver);
	lp.setUsername(ReadConfig.userName);
	lp.setPassWord(ReadConfig.password);
	lp.clickLogin();
	Thread.sleep(2000);
	logger.info("Logged in");
	System.out.println("Test Completed");
	
	try
	{	
	Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
	logger.info("TEST CASE PASSED");
	}
	catch(AssertionError ae)
	{
		
		logger.info("TEST CASE FAILED");
		captureScreen(driver,"LoginTest_TC01");
		Assert.assertTrue(false);
	}
	}
		
}
