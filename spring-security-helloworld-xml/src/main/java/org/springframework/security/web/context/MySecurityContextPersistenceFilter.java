package org.springframework.security.web.context;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MySecurityContextPersistenceFilter
		extends
		org.springframework.security.web.context.SecurityContextPersistenceFilter {

	public MySecurityContextPersistenceFilter() {
		super();
	}

	public MySecurityContextPersistenceFilter(SecurityContextRepository repo) {
		super(repo);
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		super.doFilter(req, res, chain);
	}
}
