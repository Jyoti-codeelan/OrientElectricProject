package com.qa.orient.listeners;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.orient.utils.JiraUtil;

public class TestJiraListener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	JiraUtil jiraUtil = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraUtil.class)	;
	boolean isTicketReady = jiraUtil.logTicketId();	
	if(isTicketReady ==true){
		//rise jira ticket
		System.out.println("is Ticket Ready for JIRA ::" +isTicketReady);
		JiraService jiraSer = new JiraService("https://dasjyoti.atlassian.net/", "jyotid@codeelan.com" ,
				"CVt7fLf6Qa6B17rPgMUf59E4", "OR");
		
		String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName()+"got failed due to some assertion or exception";
		String issueDescription = result.getThrowable().getMessage()+ "\n";
		issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
		jiraSer.createJiraTicket("Bug", issueSummary, issueDescription, "Jyoti");
	}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		
	}

}
