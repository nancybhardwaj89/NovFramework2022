package com.democart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	
	public WebDriver driver;
	
	public static String highlight;
	
	
	private OptionsManager optionsmanager;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	
	
	/*
	 * This method is used to initialize the driver
	 */
	
    public WebDriver initDriver(Properties prop)
    {
    	
    	String browserName = prop.getProperty("browser");
    	highlight = prop.getProperty("highlight");
    	
    	System.out.println("Enter Bowser Name:" +browserName);
    	
    	optionsmanager = new OptionsManager(prop);
    	
    	
    	
    	if(browserName.equalsIgnoreCase("chrome"))
    	{
    		WebDriverManager.chromedriver().setup();
    		
    		//driver = new ChromeDriver(optionsmanager.getChromeoptions());
    		
    		tlDriver.set(new ChromeDriver(optionsmanager.getChromeoptions()));
    		
    		
    	}
    	
    	else if (browserName.equalsIgnoreCase("firefox"))
    	{
    		WebDriverManager.firefoxdriver().setup();
    		
    		//driver = new FirefoxDriver(optionsmanager.getFirefoxoptions());
    		
    		tlDriver.set(new FirefoxDriver(optionsmanager.getFirefoxoptions()));
    		
    		
    		
    	}
    	
    	else if (browserName.equalsIgnoreCase("safari"))
    	{
    		//driver = new SafariDriver();
    		
    		tlDriver.set(new SafariDriver());
    		
    	}
    	
    	else
    		
    	{
    		System.out.println("Plese enter correct browser name:" +browserName);
    	}
    	
    	
    	getDriver().manage().deleteAllCookies();
    	
    	getDriver().manage().window().maximize();
    	
    	getDriver().get(prop.getProperty("URL"));
    	
    	return getDriver();
    	
    }
    
    
    public WebDriver getDriver()
    
    {
    	
    	return tlDriver.get();
    }
    	
    	/**
    	 * This method is used to intializae the properties on the basis of given env
    	 * name
    	 * 
    	 * @return
    	 */

    	public Properties initProperties()

    	{
    		Properties prop = null;
    		
    		FileInputStream ip = null;
    		
    		
    		String env = System.getProperty("env"); //mvn clean install  -Denv=""
    		
    		try
    		{
    			
    		
    		
    	if(env==null)
    	{
    		System.out.println("Running on environment: QA env.....");
    		
				ip = new FileInputStream("./src/test/resoruces/config/config.properties");
			
    	}
    	
    	else
    	{
    		System.out.println("Running on Enviornment:" +env);
    		
    		switch(env)
    		{
    		case "Staging":
    			ip = new FileInputStream("./src/test/resoruces/config/staging.config.properties");
    			break;
    			
    		case "Dev":
    			ip = new FileInputStream("./src/test/resoruces/config/dev.config.properties");
    			break;
    			
    		default:
    			
    			System.out.println("No Environmane found");
    			
    			throw new Exception("NoENVFOUNDEXCEPTION");
    		
    		
    			
    		}
    		
    		
    	}
    		}
    		
    		catch (FileNotFoundException e)
    		{
    			e.printStackTrace();
    		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		
    		try 
    		{
    			
    			prop = new Properties();
    			prop.load(ip);

    		} 
    		
    		
    		
    		catch (IOException e) 
    		
    		{

    			e.printStackTrace();
    		}

    		return prop;

    	}
    	
    	
    	
    	
    	
    	
    	
    
}
