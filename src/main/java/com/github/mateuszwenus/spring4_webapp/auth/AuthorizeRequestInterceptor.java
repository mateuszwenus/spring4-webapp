package com.github.mateuszwenus.spring4_webapp.auth;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.Expression;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.PublicWebExpressionConfigAttribute;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthorizeRequestInterceptor extends HandlerInterceptorAdapter {

  @Autowired
  private AccessDecisionManager accessDecisionManager;

  @Autowired
  private SecurityExpressionHandler<FilterInvocation> securityExprHandler;

  @Override
  public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) {
    if (handler instanceof HandlerMethod) {
      HandlerMethod handlerMethod = (HandlerMethod) handler;
      AuthorizeRequest ann = handlerMethod.getMethodAnnotation(AuthorizeRequest.class);
      if (ann != null) {
        checkAccess(req, resp, ann);
      }
    }
    return true;
  }

  private void checkAccess(HttpServletRequest req, HttpServletResponse resp, AuthorizeRequest ann) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    FilterInvocation fi = new FilterInvocation(req, resp, new NullFilterChain());
    Expression expr = securityExprHandler.getExpressionParser().parseExpression(ann.value());
    ConfigAttribute configAttribute = new PublicWebExpressionConfigAttribute(expr);
    List<ConfigAttribute> configAttributes = Arrays.asList(configAttribute);
    accessDecisionManager.decide(authentication, fi, configAttributes);
  }
}
