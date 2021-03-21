package com.mhsoft;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SessionListener implements HttpSessionListener {

	private static final Logger logger = LoggerFactory.getLogger(SessionListener.class);

	
    @Override
    public void sessionCreated(HttpSessionEvent se) {
    	logger.info("[MHSS0001]Created session");

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    	logger.info("[MHSS0002]Destroyed session");
    	
    }

}
