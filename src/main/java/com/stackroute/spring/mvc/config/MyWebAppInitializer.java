package com.stackroute.spring.mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


//web.xml

//url mapping
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	
	//beans.xml
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {AppConfig.class };
    }

    
    //looks for the configuration file which is the replacement for
    // dispatcher-servlet.xml
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    //replacement of url mappings 
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}