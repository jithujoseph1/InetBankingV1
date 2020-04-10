package com.Inetbanking.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Inetbanking.Utilities.ReadConfig;

public class BaseClass {
	
	public static WebDriver driver;
    public static Logger logger;
    public static ReadConfig rconf;
	
    @BeforeClass
	@Parameters("browser")
    public void setup(String br) throws IOException
    {
    logger = Logger.getLogger("ebanking");
    PropertyConfigurator.configure("Log4j.properties");
    rconf = new ReadConfig();
    if (br.equalsIgnoreCase("chrome"))
    {
	System.setProperty("webdriver.chrome.driver",ReadConfig.chromePath);    
	driver = new ChromeDriver();	
    }
    else if(br.equalsIgnoreCase("ie"))
    {
	System.setProperty("webdriver.ie.driver",ReadConfig.IEPath);    
	driver = new InternetExplorerDriver();	
    }
	
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get(ReadConfig.url);	
	logger.info("URL is opened");
    }
	
	@AfterClass
	public void teardown() throws IOException
	{
	driver.quit();	
	rconf.configEnd();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".jpeg");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
