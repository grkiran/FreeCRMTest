package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'User: Naveen K')]")
	WebElement userNameLable;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contacts;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newcontact;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasks;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public Boolean verifyUserName() {
		return userNameLable.isDisplayed();
	}

	public ContactsPage clickOnContactLink() {
		contacts.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLink() {
		tasks.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink(){
		Actions actions =new Actions(driver);
		actions.moveToElement(contacts).build().perform();
		newcontact.click();
		
	}

}





