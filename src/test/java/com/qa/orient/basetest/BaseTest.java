package com.qa.orient.basetest;

import java.util.Properties;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.qa.orient.base.BasePage;
import com.qa.orient.base.JsonBase;
import com.qa.orient.page.BusinessFinance_Page;
import com.qa.orient.page.HomePage;
import com.qa.orient.page.Ideator_Page;
import com.qa.orient.page.Level1_Page;
import com.qa.orient.page.Level2_Page;
import com.qa.orient.page.Level3_Page;
import com.qa.orient.page.Level4_Page;
import com.qa.orient.page.LoginPage;
import com.qa.orient.pojo.Credentials;
import com.qa.orient.utils.ElementUtils;
import com.qa.orient.utils.TimeUtil;

public class BaseTest {

	
	public BasePage basePage;
	
	public Properties prop;
	public WebDriver driver;
	public LoginPage loginPage;
	public ElementUtils elementutils;
	public HomePage homePage;
	public Credentials credentials;
	public Ideator_Page ideatorPage;
	public Level1_Page level1Page;
	public BusinessFinance_Page bfPage;
	public Level2_Page level2Page;
	public Level3_Page level3Page;
	public Level4_Page level4Page;
	
	
	@BeforeMethod
	//@Parameters(value= {"browser"})
	//public void setUp(String browserName){
	  public void setUp(){
		basePage = new BasePage();
		prop = basePage.initializes_Properties();
		driver = basePage.initialize_driver(prop);
		elementutils = new ElementUtils(driver);
		loginPage = new LoginPage(driver);
		ideatorPage = new Ideator_Page(driver);
		level1Page = new Level1_Page(driver);
		bfPage = new BusinessFinance_Page(driver);
		level2Page = new Level2_Page(driver);
		level3Page = new Level3_Page(driver);
		level4Page = new Level4_Page(driver);

		//credentials = new Credentials(prop.getProperty("username_1"), prop.getProperty("password_1"));
		
		
	}
	
	
	@AfterMethod
	public  void quit() {
	TimeUtil.mediumWait();
		
	 if(driver!=null) {
		driver.quit();
			}

	
	}
	
	
}
