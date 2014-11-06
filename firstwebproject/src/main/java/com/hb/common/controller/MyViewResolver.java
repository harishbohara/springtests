package com.hb.common.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class MyViewResolver extends InternalResourceViewResolver {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	protected AbstractUrlBasedView buildView(String viewName) throws Exception {
		AbstractUrlBasedView toRet = super.buildView(viewName);
		logger.info("-----> My view resolver: viewname = " + viewName + " final=" + toRet.getUrl());
		return toRet;
	}
}
