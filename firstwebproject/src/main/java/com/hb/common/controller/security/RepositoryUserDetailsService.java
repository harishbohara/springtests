package com.hb.common.controller.security;

import java.util.Vector;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUser;

public class RepositoryUserDetailsService implements UserDetailsService {

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("USER");
        Vector<GrantedAuthority> authorities = new Vector<GrantedAuthority>();
        authorities.add(authority);
        return new SocialUser("harish", "bohara", authorities);
    }

}
