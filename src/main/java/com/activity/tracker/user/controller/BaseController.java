package com.activity.tracker.user.controller;

import com.activity.tracker.model.User;
import com.activity.tracker.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;

public abstract class BaseController {

    @Autowired
    UserService userService;


    protected String route(ModelMap model, String page) {
        model.addAttribute("USER", getLoggedInUser());
        return page;
    }

    protected User getLoggedInUser() {
        String username = SecurityContextHolder.getContext().getAuthentication() != null ? (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal() : null;
        User  loggedInUser = userService.getUserByUserName(username);
        return loggedInUser;
    }
}
