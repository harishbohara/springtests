package com.hb.facebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;

@Configuration
// @EnableWebMvcSecurity
// @ComponentScan("com.hb.facebook")
public class SecurityConfig {

    @Autowired
    public ConnectionFactoryLocator connectionFactoryLocator;

    @Autowired
    public UsersConnectionRepository usersConnectionRepository;

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("login.jsp").permitAll();
    }

    @Bean
    public ProviderSignInController providerSignInController() {
        return new ProviderSignInController(connectionFactoryLocator, usersConnectionRepository, new SignInAdapter() {
            
            @Override
            public String signIn(String userId, Connection<?> connection, NativeWebRequest request) {
                String name = connection.getDisplayName();
                return "THis is me";
            }
        });
    }
}
