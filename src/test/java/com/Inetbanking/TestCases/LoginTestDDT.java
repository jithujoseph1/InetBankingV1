package com.Inetbanking.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Inetbanking.Utilities.ReadConfig;
import com.Inetbanking.Utilities.XLUtils;
import com.Inetbanking.pageObjects.LoginPage;

public class LoginTestDDT extends BaseClass {
	
	@Test(dataProvider="LoginParams")
	public void LoginTest_TC02(String uname, String pwd) throws InterruptedException, IOException
	{
	
	LoginPage lp = new LoginPage(driver);
	lp.setUsername(uname);
	lp.setPassWord(pwd);
	Thread.sleep(3000);
	lp.clickLogin();
	Thread.sleep(2000);
	
	if(isAlertPresent())
	{
		//captureScreen(driver,"LoginTest_TC02");
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();	
		logger.warn("Login unsuccessful");
		Assert.assertTrue(false);
		
	}
	
	else
	{
	 lp.clickLogout();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.switchTo().alert().accept();
	 driver.switchTo().defaultContent();	 
	 logger.info("Login Successful");
	 Assert.assertTrue(true);
	}
		
	
	}
	

	
	@DataProvider(name="LoginParams")
	String[][] getData() throws IOException
	{
	    String xlfile = "./src\\test\\java\\com\\Inetbanking\\testdata\\LoginData.xlsx";
		int rowcount = XLUtils.getRowCount(xlfile, "Sheet1");
		int colcount = XLUtils.getCellCount(xlfile, "Sheet1", 1);
		String loginData[][] = new String[rowcount][colcount];
		for (int i=1; i<=rowcount;i++)
		  {
			for (int j=0;j<colcount;j++)
		  	{
			
			 loginData[i-1][j] = XLUtils.getCellData(xlfile, "Sheet1", i, j);
			}
		  }
		return loginData;
	}
	
	
		
}
