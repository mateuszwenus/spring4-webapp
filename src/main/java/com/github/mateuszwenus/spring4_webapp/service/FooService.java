package com.github.mateuszwenus.spring4_webapp.service;

import org.springframework.security.access.prepost.PreAuthorize;

public interface FooService {

  @PreAuthorize("hasRole('ROLE_USER')")
  String doUserStuff();

  @PreAuthorize("hasRole('ROLE_MANAGER')")
  String doManagerStuff();

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  String doAdminStuff();
}
