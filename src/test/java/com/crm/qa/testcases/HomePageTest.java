package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	DealsPage dealspage;
	ContactsPage contactspage;
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		 testutil = new TestUtil();
		loginpage = new LoginPage();	
		homepage=loginpage.login(pro.getProperty("username"),pro.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle =homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"CRMPRO","homepage title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		testutil.switchToFrame();
		Assert.assertTrue(homepage.verifyUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		testutil.switchToFrame();
		contactspage=homepage.clickOnContactLink();
	}
	
	
	@Test(priority=4)
	public void verifyDealsLinkTest(){
		testutil.switchToFrame();
		dealspage=homepage.clickOnDealsLink();
		
	}
	
	@AfterMethod
	public void teardown(){
		driver.close();
	}

}
