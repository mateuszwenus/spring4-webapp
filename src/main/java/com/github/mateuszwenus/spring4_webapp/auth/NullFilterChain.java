package com.github.mateuszwenus.spring4_webapp.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class NullFilterChain implements FilterChain {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
    throw new UnsupportedOperationException("doFilter()");
  }
}
