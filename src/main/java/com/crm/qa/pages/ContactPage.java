package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	public boolean verifyContactLink()
	{
		return ContactsLink.isDisplayed();
	}
	
	
	public void clickOnCheckBoxofDatatable()
	{
		driver.switchTo().frame("leftpanel");
		driver.findElement(By.xpath("//table[@class='datacard']//a[contains(text(),'sanjaygorai')]/../preceding-sibling::td/input")).click();
	}
	

}
