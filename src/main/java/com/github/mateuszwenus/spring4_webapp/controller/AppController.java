package com.github.mateuszwenus.spring4_webapp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.mateuszwenus.spring4_webapp.auth.AuthorizeRequest;

@Controller
public class AppController {

  @RequestMapping("/")
  public String index() {
    return "/index";
  }

  @AuthorizeRequest("hasRole('ROLE_USER')")
  @RequestMapping("/user")
  public String user() {
    return "/user";
  }

  @AuthorizeRequest("hasRole('ROLE_MANAGER')")
  @RequestMapping("/manager")
  public String manager() {
    return "/manager";
  }

  @AuthorizeRequest("hasRole('ROLE_ADMIN')")
  @RequestMapping("/admin")
  public String admin() {
    return "/admin";
  }

  @ModelAttribute("authentication")
  public Authentication get() {
    return SecurityContextHolder.getContext().getAuthentication();
  }
}
