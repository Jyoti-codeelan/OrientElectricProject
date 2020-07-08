package com.qa.orient.page;

import org.openqa.selenium.WebDriver;

import com.qa.orient.base.JsonBase;
import com.qa.orient.utils.ElementUtils;

public class HomePage extends JsonBase{
	
	
	public ElementUtils elementUtils;
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		elementUtils = new ElementUtils(this.driver);
		
	}
	
	public Ideator_Page goToIdeatorPage(){
		return new Ideator_Page(driver);
	}

	public Level1_Page goToLevel1Page(){
		return new Level1_Page(driver);
	}
	
	public BusinessFinance_Page goToBFPage(){
		return new BusinessFinance_Page(driver);
	}
	
	public Level2_Page goToLevel2Page(){
		return new Level2_Page(driver);
	}
	
	public Level3_Page goToLevel3Page(){
		return new Level3_Page(driver);
	}
	
	public Level4_Page goToLevel4Page(){
		return new Level4_Page(driver);
	}
}
