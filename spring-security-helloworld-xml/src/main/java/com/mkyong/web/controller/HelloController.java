package com.mkyong.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hb.model.UserService;

@Controller
public class HelloController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
    public ModelAndView welcomePage(HttpServletResponse response) {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is welcome page!");
        model.setViewName("hello");
        /*
        FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory("402617649887268", "0acbe5fb8d3a7b725d4079c78118773c");
        OAuth2Operations oauthOperations = connectionFactory.getOAuthOperations();
        OAuth2Parameters params = new OAuth2Parameters();
        params.setRedirectUri("http://localhost:8080/spring-security-helloworld-xml/fb");
        String authorizeUrl = oauthOperations.buildAuthorizeUrl(GrantType.IMPLICIT_GRANT, params);
        try {
            response.sendRedirect(authorizeUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        return model;

    }

    @RequestMapping(value = { "/fb" }, method = RequestMethod.GET)
    public ModelAndView welcomePageFB(@RequestParam(required = false) String code, @RequestParam(required = false) String accessToken, HttpServletResponse response, HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        String str = request.getParameter("#accessToken");

        FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory("402617649887268", "0acbe5fb8d3a7b725d4079c78118773c");
        AccessGrant accessGrant = new AccessGrant(accessToken);
        Connection<Facebook> connection = connectionFactory.createConnection(accessGrant);

        model.addObject("title", "Spring Security Hello World: FB");
        model.addObject("message", "This is welcome page!: FB + test" + str);
        model.setViewName("hello");

        return model;

    }

    @RequestMapping(value = { "/fba" }, method = RequestMethod.GET)
    public ModelAndView welcomePageFBa(@RequestParam(required = false) String code, HttpServletResponse response, HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        String str = request.getParameter("code");

        FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory("402617649887268", "0acbe5fb8d3a7b725d4079c78118773c");
        AccessGrant accessGrant = new AccessGrant(code);
        Connection<Facebook> fb = connectionFactory.createConnection(accessGrant);
        fb.getDisplayName();

        model.addObject("title", "Spring Security Hello World: FB");
        model.addObject("message", "This is welcome page!: FB + " + fb.getDisplayName());
        model.setViewName("hello");

        return model;

    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is protected page!");
        model.setViewName("admin");

        return model;

    }
}