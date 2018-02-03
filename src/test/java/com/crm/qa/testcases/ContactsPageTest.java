package com.crm.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

import jxl.read.biff.BiffException;

public class ContactsPageTest extends TestBase{

	LoginPage loginpage;
	TestUtil testutil;
	HomePage homepage;
	ContactsPage contactpage;
	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		homepage=loginpage.login(pro.getProperty("username"),pro.getProperty("password"));
		testutil.switchToFrame();
		contactpage=homepage.clickOnContactLink();
	}

	
	@Test(priority=1)
	public void verifyContactsLableTest(){
		Assert.assertTrue(contactpage.verifyContactLable(),"contact label is missing");
}
	
	@Test(priority=2)
	public void selectContactListNameTest(){
		contactpage.selectContactsByName("Alexender Alexender");
	}
	
	@Test(priority=3)
	public void selectMultipleContactListNameTest(){
		contactpage.selectContactsByName("Alexender Alexender");
		contactpage.selectContactsByName("ASelenium ASelenium");
	}

	@Test(priority=4)
	public void validateCreateContact(){
		homepage.clickOnNewContactLink();
		contactpage.createNewContact("Mr.", "rk", "g", "google");
	}
	
	@DataProvider
	public String[][] execldata() throws BiffException, IOException{
		String info[][]=testutil.getDataFromExcel();
		return info;
	}
	
	@Test(priority=5, dataProvider="execldata")
	public void validateCreateContactExcel(String title,String firstname,String lastname,String company){
		homepage.clickOnNewContactLink();
		contactpage.createNewContact(title,firstname,lastname,company);
	}
	
	
	@AfterMethod
	public void teardown(){
		driver.close();
	}
}
