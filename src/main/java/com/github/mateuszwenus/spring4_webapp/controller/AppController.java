package com.github.mateuszwenus.spring4_webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.mateuszwenus.spring4_webapp.service.FooService;
import com.github.mateuszwenus.spring_security_controller_auth.AuthorizeRequest;

@Controller
public class AppController {

  @Autowired
  private FooService fooService;

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

  @AuthorizeRequest("hasRole('ROLE_USER')")
  @RequestMapping("/user2")
  public String user2() {
    return "/user";
  }

  @AuthorizeRequest("hasRole('ROLE_MANAGER')")
  @RequestMapping("/manager2")
  public String manager2() {
    return "/manager";
  }

  @AuthorizeRequest("hasRole('ROLE_ADMIN')")
  @RequestMapping("/admin2")
  public String admin2() {
    return "/admin";
  }

  @RequestMapping("/callUserService")
  public String callUserService(ModelMap model) {
    model.put("result", fooService.doUserStuff());
    return "/serviceResult";
  }

  @RequestMapping("/callManagerService")
  public String callManagerService(ModelMap model) {
    model.put("result", fooService.doManagerStuff());
    return "/serviceResult";
  }

  @RequestMapping("/callAdminService")
  public String callAdminService(ModelMap model) {
    model.put("result", fooService.doAdminStuff());
    return "/serviceResult";
  }

  @ModelAttribute("authentication")
  public Authentication get() {
    return SecurityContextHolder.getContext().getAuthentication();
  }
}
