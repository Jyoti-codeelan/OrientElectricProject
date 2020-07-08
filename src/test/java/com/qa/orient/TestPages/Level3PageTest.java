package com.qa.orient.TestPages;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.orient.basetest.BaseTest;
import com.qa.orient.pojo.Credentials;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class Level3PageTest extends BaseTest{
	
public static Logger log = Logger.getLogger(Level3PageTest.class.getName());  
	
	@BeforeMethod
	public void level3PageLogin(){
	log.info("Enter Level3 Credentials......");		
	credentials = new Credentials(prop.getProperty("username_3"), prop.getProperty("password"));
	homePage = loginPage.getLogin(credentials);
	//homePage.goToLevel3Page();
	
	
	}
	
	@Test(priority=6,enabled=true)
	@Description("Approve quick idea on Level3  page-----postive test case")
	@Severity(SeverityLevel.CRITICAL)
	public void getApproveLevel3PageTest(){
	homePage.goToLevel3Page();
	log.info("Idea Approve By Level3 Page ..........");	
	level3Page.getIdeaApproveOnLevel3Page();
	
	
	}
	
	@Test(enabled=false)
	public void getIdeaIntitiateProjectTest(){
	
	level3Page.getInitiateProject();
	}

}
