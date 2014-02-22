package com.github.mateuszwenus.spring4_webapp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

  @RequestMapping("/")
  public String index() {
    return "/index";
  }

  @RequestMapping("/user")
  public String user() {
    return "/user";
  }

  @RequestMapping("/manager")
  public String manager() {
    return "/manager";
  }

  @RequestMapping("/admin")
  public String admin() {
    return "/admin";
  }

  @ModelAttribute("authentication")
  public Authentication get() {
    return SecurityContextHolder.getContext().getAuthentication();
  }
}
