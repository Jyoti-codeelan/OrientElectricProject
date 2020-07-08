package com.qa.orient.listeners;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.Issue.FluentCreate;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class JiraService {
	
	public JiraClient jira;
	public String project;
	
	
	public JiraService(String jiraUrl, String userName, String password, String project){
		
		BasicCredentials creds = new BasicCredentials(userName,password);
		jira = new JiraClient(jiraUrl,creds);
		this.project = project;
	}

	public void createJiraTicket(String issueType, String summary, String description, String reportName){
	
		try {
			FluentCreate fluentCreate = jira.createIssue(project, issueType);
			fluentCreate.field(Field.SUMMARY, summary);
			fluentCreate.field(Field.DESCRIPTION, description);
			Issue newIssue = fluentCreate.execute();
			System.out.println("new issue created in jira with ID::" +newIssue);
			
			
		} catch (JiraException e) {
		
			e.printStackTrace();
		}
	}
}
