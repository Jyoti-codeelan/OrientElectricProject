package com.qa.orient.utils;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class SendingEmailUtil {

	
	
	public void getMail(){
	// Create the attachment
	  EmailAttachment attachment = new EmailAttachment();
	  attachment.setPath("D:\\All_Selenium_Projects\\OrientElectricProject\\screenshots");
	  attachment.setDisposition(EmailAttachment.ATTACHMENT);
	  attachment.setDescription("OEL Screenshot");
	  attachment.setName("OEL");

	  // Create the email message
	  MultiPartEmail email = new MultiPartEmail();
	  email.setHostName("smtp.googlemail.com");
	  try {
		email.addTo("jyotid@codeelan.com", "jyoti");
		email.setFrom("me@apache.org", "Me");
		email.setSubject("Report Status");
		  email.setMsg("After execution");

		  // add the attachment
		  email.attach(attachment);
		  
		// send the email
		  email.send();
		  
	} catch (EmailException e1) {
		
		e1.printStackTrace();
	}
	  
	  

	  
	}
}
