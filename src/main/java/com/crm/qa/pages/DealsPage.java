package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase {

	
	
	@FindBy(xpath="//a[text()='Deals']")
	WebElement dealsLable;
	
	@FindBy(xpath="//a[text()='New Deal']")
	WebElement newDeals;
	
	@FindBy(xpath="//a[text()='Products']")
	WebElement products;
	
	@FindBy(xpath="//a[text()='Full Search Form']")
	WebElement fullSearchForm;
	
	
	
	
	public void TestBase(){
		PageFactory.initElements(driver, TestBase.class);
	}
	
	public boolean verifyDealsLabel(){
		return dealsLable.isDisplayed();
	}
	
	public boolean verifyNewDealsLabel(){
		return newDeals.isDisplayed();
	}
	
	public boolean verifyProducts(){
		return products.isDisplayed();
	}
	
	public boolean verifyFullSerachForm(){
		return fullSearchForm.isDisplayed();
	}
		
	public void clickProducts(){
		Actions actions = new Actions(driver);
		actions.moveToElement(products).click();
		
	}
}
