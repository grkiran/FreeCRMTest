package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties pro;
	
	
	public TestBase(){
		try {
			pro =new Properties();
			FileInputStream ip =new FileInputStream("C:/Users/GRK/testhome/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");
			pro.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public void initialization() {
	//	String browser = pro.getProperty("browser"); 
		//switch (browser) {
	//	case "ff":
	//	case "firefox":
	//		System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
	//		driver = new FirefoxDriver();
	//		break;

	//	case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
		//	break;

	//	case "ie":
		//	System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
			//driver = new InternetExplorerDriver();
			//break;

		//default:
			//System.out.println("Please select browsers : ff or chrome or ie");
			//break;
	//	}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		String url = pro.getProperty("url");
		driver.get(url);
		
		
		
	}
	
}
