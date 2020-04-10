package com.Inetbanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	FileInputStream fis;
	public static String userName;
	public static String password;
	public static String url;
	public static String chromePath;
	public static String IEPath;	
	
	public ReadConfig() throws IOException
	{
		
		try
		{
		fis = new FileInputStream(new File("./Configuration\\Config.properties"));
		pro = new Properties();
		pro.load(fis);
		userName = pro.getProperty("userName");
		password = pro.getProperty("passWord");
		url = pro.getProperty("URL");
		chromePath = pro.getProperty("chromePath");
		IEPath = pro.getProperty("iePath");
	   }
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	
	public void configEnd() throws IOException
	{
	 	fis.close();
	}	
	
}
