package com.qa.orient.TestPages;

import org.apache.log4j.Logger;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.orient.basetest.BaseTest;
import com.qa.orient.pojo.Credentials;
import com.qa.orient.utils.JiraUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;


@Epic("----Orient Electric Level1 Module------")
@Feature("UserStory-001:: Define the level1 feature for OEP")

public class IdeatorPageTest extends BaseTest{
	
	public static Logger log = Logger.getLogger(IdeatorPageTest.class.getName());
	
	
	
	@BeforeMethod
	public void ideatorLogin(){
	
	log.info("Enter Ideator Credentials......");	
	credentials = new Credentials(prop.getProperty("username_ideator"), prop.getProperty("password"));
	homePage = loginPage.getLogin(credentials);
	
	
	}
	
	
	@Test(priority=1,enabled=true)
	@Description("Add a Quick idea on Ideator Page")
	public void getCreateIdeaTest(){

	log.info("Create an idea on ideator page");
	ideatorPage = homePage.goToIdeatorPage();
	ideatorPage.getCreateNewIdea();
	
	}

	@JiraUtil(logTicketId=true)
	@Test(priority=3,enabled=true)
	@Description("Convert quick idea into Main idea on Ideator Page")
	public void getConvertMainIdeaTest(){
	ideatorPage.getConvertToMainIdeaOnIdeatorPage();
		
		
	}
}
