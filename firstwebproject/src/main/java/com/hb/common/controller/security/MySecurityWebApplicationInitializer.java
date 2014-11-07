package com.hb.common.controller.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class MySecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

    public MySecurityWebApplicationInitializer() {
        super(SecurityContext.class);
    }

}
