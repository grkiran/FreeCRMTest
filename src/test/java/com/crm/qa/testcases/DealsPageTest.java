package com.crm.qa.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends  TestBase{
	
	TestUtil testutil;
	DealsPage dealspage;
	
	public DealsPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setup(){
		initialization();
		 dealspage= new DealsPage();
	}
	
	@Test
	public void verifyDealsLabelTest(){
		testutil.switchToFrame();
		System.out.println(dealspage.verifyDealsLabel());
	}
	
	
	
	@AfterMethod
	public void teaddown(){
		driver.close();
	}
	

}
