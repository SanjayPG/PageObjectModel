package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement ContactsLink ;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement DealsLink ;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement TasksLink ;
	
	@FindBy(xpath="//td[contains(text(),'Sanjay Gorai')]")
	WebElement UserName;
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String verifyhomepage()
	{
		return driver.getTitle();
	}
	
	public ContactPage clickContactsLink()
	{
		ContactsLink.click();
		return new ContactPage();		
	}
	
	public DealsPage clickDealsLink()
	{
		DealsLink.click();
		return new DealsPage();		
	}
	
	public TaskPage clickTasksLink()
	{
		TasksLink.click();
		return new TaskPage();		
	}

	public boolean verifyCorrectUserName() {
		
		return UserName.isDisplayed();
        	
	}
	
	
	
	

}
