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

public class ContactTest extends TestBase {
	
	LoginPage login;
	HomePage homepage;
	ContactPage contactpage;
	TestUtil testutil;
	
	
	ContactTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialization();
		Thread.sleep(20000);
		login=new LoginPage();
		homepage=new HomePage();
		testutil=new TestUtil();
		login.login(prop.getProperty("username"),prop.getProperty("password"));
		testutil.switchToFrame();
		homepage.clickContactsLink();
	}
	
	
	@Test
	public void ClikOnContactCheckBox()
	{
		contactpage.clickOnCheckBoxofDatatable();
	}
	
	
	@AfterMethod
	public void tesrDown()
	{
		driver.quit();
	}
	
	
	
	

}
