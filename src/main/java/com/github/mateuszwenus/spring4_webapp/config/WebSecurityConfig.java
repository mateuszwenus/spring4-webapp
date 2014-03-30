package com.github.mateuszwenus.spring4_webapp.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebExpressionVoter;

import com.github.mateuszwenus.spring_security_controller_auth.HandlerSecurityInterceptor;
import com.github.mateuszwenus.spring_security_controller_auth.WebExpressionVoterAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().accessDecisionManager(webAccessDecisionManager())
      .antMatchers("/user").hasRole("USER")
      .antMatchers("/manager").hasRole("MANAGER")
      .antMatchers("/admin").hasRole("ADMIN")
      .anyRequest().authenticated().and()
      .formLogin().and()
      .logout();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
      .withUser("user").password("user").roles("USER").and()
      .withUser("manager").password("manager").roles("MANAGER").and()
      .withUser("admin").password("admin").roles("ADMIN");
  }
  
  @Bean
  public HandlerSecurityInterceptor handlerSecurityInterceptor() {
    HandlerSecurityInterceptor interceptor = HandlerSecurityInterceptor.create();
    interceptor.setAccessDecisionManager(handlerAccessDecisionManager());
    interceptor.setAuthenticationManager(authenticationManagerBean());
    return interceptor;
  }

  @SuppressWarnings("rawtypes")
  @Bean
  public AccessDecisionManager handlerAccessDecisionManager() {
    return new AffirmativeBased(Arrays.<AccessDecisionVoter> asList(webExpressionVoterAdapter()));
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() {
    try {
      return super.authenticationManagerBean();
    } catch (Exception e) {
      throw new IllegalStateException(e);
    }
  }

  @Bean
  public WebExpressionVoterAdapter webExpressionVoterAdapter() {
    return new WebExpressionVoterAdapter(webExpressionVoter());
  }

  @SuppressWarnings("rawtypes")
  @Bean
  public AccessDecisionManager webAccessDecisionManager() {
    return new AffirmativeBased(Arrays.<AccessDecisionVoter> asList(webExpressionVoter()));
  }

  @Bean
  public WebExpressionVoter webExpressionVoter() {
    WebExpressionVoter webExpressionVoter = new WebExpressionVoter();
    DefaultWebSecurityExpressionHandler expressionHandler = new DefaultWebSecurityExpressionHandler();
    expressionHandler.setRoleHierarchy(roleHierarchy());
    webExpressionVoter.setExpressionHandler(expressionHandler);
    return webExpressionVoter;
  }

  @Bean
  public RoleHierarchy roleHierarchy() {
    RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
    roleHierarchy.setHierarchy("ROLE_ADMIN > ROLE_MANAGER ROLE_MANAGER > ROLE_USER");
    return roleHierarchy;
  }
}
