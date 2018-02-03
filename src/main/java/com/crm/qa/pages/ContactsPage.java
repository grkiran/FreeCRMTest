package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	
	@FindBy(xpath="//td[@class='datacardtitle' and contains(text(),'Contacts')]")
	WebElement contactsLable;

	@FindBy(xpath="//legend[@class='fieldset' and contains(text(),'Contact Information')]")
	WebElement contactinformation;
	
	@FindBy(name="title")
	WebElement title;
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveButton;
	
	
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactLable(){
		 return contactsLable.isDisplayed();
	}
	
	
	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public boolean verifyNewContactInformationLabel(){
		return contactinformation.isDisplayed();
	}
	
	public void createNewContact(String title_name,String first_name, String last_name,String company_name){
		Select select = new Select(title);
				select.selectByVisibleText(title_name);
				firstname.sendKeys(first_name);
				lastname.sendKeys(last_name);
				company.sendKeys(company_name);
				saveButton.click();
	}
	 
	
}

