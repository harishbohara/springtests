package com.hb.facebook;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

//@Configuration
//@EnableWebMvcSecurity
//@ComponentScan("com.hb.facebook")
public class SecurityConfig  {

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("login.jsp").permitAll();
    }
}
