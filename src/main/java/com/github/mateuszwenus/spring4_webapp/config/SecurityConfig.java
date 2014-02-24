package com.github.mateuszwenus.spring4_webapp.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.expression.WebExpressionVoter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().accessDecisionManager(accessDecisionManager())
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

  @SuppressWarnings("rawtypes")
  @Bean
  public AccessDecisionManager accessDecisionManager() {
    // TODO expression handler
    WebExpressionVoter webExpressionVoter = new WebExpressionVoter();
    return new AffirmativeBased(Arrays.<AccessDecisionVoter> asList(webExpressionVoter));
  }
}
