package org.springframework.security.web.context;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
public class MyRequestHeaderAuthenticationFilter extends RequestHeaderAuthenticationFilter {

    public MyService service;

    public MyRequestHeaderAuthenticationFilter() {
        System.out.println("afadsf : " + service);
    }

    @Override
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        return "harish";
    }

    public MyService getService() {
        return service;
    }

    public void setService(MyService service) {
        this.service = service;
    }

}
