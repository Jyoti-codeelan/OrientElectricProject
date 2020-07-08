package com.qa.orient.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.orient.base.BasePage;
import com.qa.orient.pojo.Credentials;
import com.qa.orient.utils.ElementUtils;

public class LoginPage extends BasePage{

	public static Logger log= Logger.getLogger(LoginPage.class.getName());
	WebDriver driver;
	ElementUtils elementUtils;
	
	
	By Employee_Number = By.id("Username");
	By Password = By.id("Password");
	By Login = By.id("btnLogin");

	
	
	public LoginPage(WebDriver driver){
	log.info("Driver intilize..........");	
	this.driver=driver;
	elementUtils = new ElementUtils(this.driver);
		
	}
	
	
	
	public  HomePage getLogin(Credentials credentials) {

		log.info("Enter Credentials..........");
		System.out.println("credentials are : " + credentials.getEmailID()  + " " + credentials.getPassword());
		elementUtils.doSendKeys(Employee_Number, credentials.getEmailID());
		elementUtils.doSendKeys(Password, credentials.getPassword());
		log.info("Click on Loin Button.......");
		elementUtils.doClick(Login);
		
		return new HomePage(driver);
		
    }



	
}
