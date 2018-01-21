package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.session.FirefoxFilter;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
		
	public TestBase()
	{
		try{
		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\HP\\workspace2\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(fis);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();	
		}
	}
	
	public static void initialization()
	{
		String browser=prop.getProperty("browser");
		if(browser.trim().toUpperCase().equals("CHROME"))
		{
			System.setProperty("webdriver.chrome.driver","E:\\Slenium\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.trim().toUpperCase().equals("MOZILLA"))
		{
			System.setProperty("webDriver.gecko.driver","E:\\Slenium\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		
		 e_driver=new EventFiringWebDriver(driver);
		 eventListener=new WebEventListener();
		 e_driver.register(eventListener);
		 driver=e_driver;
		
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
		
	}
	

	
	
	
	
	
	
	
}


