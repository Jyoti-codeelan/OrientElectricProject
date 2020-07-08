package com.qa.orient.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)

public @interface JiraUtil {
	
	boolean logTicketId();

}
