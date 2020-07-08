package com.qa.orient.TestPages;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.orient.basetest.BaseTest;
import com.qa.orient.pojo.Credentials;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class BusinessFinancePageTest extends BaseTest{
	
	
public static Logger log = Logger.getLogger(BusinessFinancePageTest.class.getName());
	
	
	@BeforeMethod
	public void BusinessFinancePageLogin(){
	log.info("Enter BF Credentials......");		
	credentials = new Credentials(prop.getProperty("username_BF"), prop.getProperty("password"));
	homePage = loginPage.getLogin(credentials);
	
	
	
	}
	
	@Test(priority=4)
	@Description("Approve quick idea on Business Finance page-----postive test case")
	@Severity(SeverityLevel.CRITICAL)
	public void getApproveIdeaOnBFPageTest(){
	homePage.goToBFPage();
	log.info("Idea Validate By BusinessFinance Page ..........");	
	bfPage.getIdeaValidateOnBFPage();
	}

}
