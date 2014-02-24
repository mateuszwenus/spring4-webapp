package com.github.mateuszwenus.spring4_webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import com.github.mateuszwenus.spring4_webapp.auth.AuthorizeRequestInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.github.mateuszwenus.spring4_webapp.controller")
public class WebConfig extends WebMvcConfigurerAdapter {

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(authorizeRequestInterceptor());
  }

  @Bean
  public AuthorizeRequestInterceptor authorizeRequestInterceptor() {
    return new AuthorizeRequestInterceptor();
  }

  @Bean
  public FreeMarkerConfigurer freeMarkerConfigurer() {
    FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
    configurer.setTemplateLoaderPath("/WEB-INF/view/");
    return configurer;
  }

  @Bean
  public FreeMarkerViewResolver freeMarkerViewResolver() {
    FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
    viewResolver.setCache(false);
    viewResolver.setPrefix("");
    viewResolver.setSuffix(".ftl");
    viewResolver.setExposeSpringMacroHelpers(true);
    viewResolver.setContentType("text/html;charset=UTF-8");
    viewResolver.setExposeRequestAttributes(true);
    return viewResolver;
  }
}
