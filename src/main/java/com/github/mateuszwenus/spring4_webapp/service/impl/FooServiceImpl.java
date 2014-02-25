package com.github.mateuszwenus.spring4_webapp.service.impl;

import org.springframework.stereotype.Service;

import com.github.mateuszwenus.spring4_webapp.service.FooService;

@Service
public class FooServiceImpl implements FooService {

  @Override
  public String doUserStuff() {
    return "did user stuff";
  }

  @Override
  public String doManagerStuff() {
    return "did manager stuff";
  }

  @Override
  public String doAdminStuff() {
    return "did admin stuff";
  }
}
