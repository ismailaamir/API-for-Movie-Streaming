package com.aamir.api;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
 

public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {APIConfig.class, JPAConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/api/*"};
	}

}
