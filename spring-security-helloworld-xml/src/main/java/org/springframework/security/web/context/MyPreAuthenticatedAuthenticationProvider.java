package org.springframework.security.web.context;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component("preauthAuthProvider")
public class MyPreAuthenticatedAuthenticationProvider implements AuthenticationProvider {

   

    public MyPreAuthenticatedAuthenticationProvider() {
        System.out.println("MyPreAuthenticatedAuthenticationProvider");
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("------> HB this is my MyPreAuthenticatedAuthenticationProvider: enter: " + authentication.getPrincipal());
        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
