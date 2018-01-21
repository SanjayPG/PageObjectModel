package com.crm.qa.tetcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

import junit.framework.Assert;

public class HomePageTest extends TestBase{
	LoginPage login;
	HomePage homepage;
	TestUtil testutil;
	ContactPage contactpage;
		
	public HomePageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		testutil=new TestUtil();
		contactpage = new ContactPage();
		login=new LoginPage();
		homepage=login.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test
	public void verifyHomePageTitle()
	{
		 String homepageTitle=homepage.verifyhomepage();
		 Assert.assertEquals(homepageTitle, "CRMPRO","home Page Title Not Mached");		 
	}
	
	@Test
	public void veifyUserNameTest()
	{
		testutil.switchToFrame();
		boolean flag=homepage.verifyCorrectUserName();	
		Assert.assertTrue(flag);
	}
	
	@Test
	public void verifyContactLinkTest()
	{
		testutil.switchToFrame();
		contactpage=homepage.clickContactsLink();
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	

}
