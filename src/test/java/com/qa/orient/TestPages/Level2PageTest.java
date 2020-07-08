package com.qa.orient.TestPages;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.orient.basetest.BaseTest;
import com.qa.orient.pojo.Credentials;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class Level2PageTest extends BaseTest{
	
	public static Logger log = Logger.getLogger(Level2PageTest.class.getName());  
	
	@BeforeMethod
	public void level2PageLogin(){
	log.info("Enter BF Credentials......");		
	credentials = new Credentials(prop.getProperty("username_2"), prop.getProperty("password"));
	homePage = loginPage.getLogin(credentials);
	
	
	
	}
	
	@Test(priority=5)
	@Description("Approve quick idea on Level2  page-----postive test case")
	@Severity(SeverityLevel.CRITICAL)
	public void getApproveLevel2PageTest(){
	homePage.goToLevel2Page();
	log.info("Idea Approve By Level2 Page ..........");	
	level2Page.getIdeaValidateOnLevel2Page();
	
	}

}
