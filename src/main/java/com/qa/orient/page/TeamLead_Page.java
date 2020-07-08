package com.qa.orient.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.orient.base.BasePage;
import com.qa.orient.utils.ElementUtils;

public class TeamLead_Page extends BasePage{
	
public ElementUtils elementUtils;
	
	private By profileIcon = By.xpath("//a[contains(@class,'dropdown-toggle')]");
	private By approvalsDrop = By.xpath("//a[contains(text(),'Approvals')]");
	private By approve = By.xpath("//button[contains(@name,'btnApproveContent')]");
	private By okBtm = By.xpath("//button[contains(@id,'btnApproveConfirm')]");
	
	
	
	public TeamLead_Page(WebDriver driver){
	this.driver = driver;
	elementUtils = new ElementUtils(this.driver);
	}

	
	public void getApprovalOnTeamLeadPage(){
		elementUtils.doClick(profileIcon);
		elementUtils.getMoveElement(approvalsDrop);
		
	}
}
