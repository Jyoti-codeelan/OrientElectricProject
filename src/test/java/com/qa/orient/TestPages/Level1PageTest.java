package com.qa.orient.TestPages;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.orient.basetest.BaseTest;
import com.qa.orient.pojo.Credentials;
import com.qa.orient.utils.JiraUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class Level1PageTest extends BaseTest{
	
	public static Logger log = Logger.getLogger(Level1PageTest.class.getName());
	
	
	@BeforeMethod
	public void level1Login(){
	log.info("Enter Level1 Credentials......");		
	credentials = new Credentials(prop.getProperty("username_1"), prop.getProperty("password"));
	homePage = loginPage.getLogin(credentials);
	
	
	
	}
	@JiraUtil(logTicketId=true)
	@Test(priority=2)
	@Description("Approve quick idea on level1 page-----postive test case")
	@Severity(SeverityLevel.CRITICAL)
	public void getApproveIdeaOnLevel1Page(){
		homePage.goToLevel1Page();
		log.info("Idea Approve By Level1 ..........");	
		level1Page.getApproveIdeaOnLevel1Page();
	}

}
