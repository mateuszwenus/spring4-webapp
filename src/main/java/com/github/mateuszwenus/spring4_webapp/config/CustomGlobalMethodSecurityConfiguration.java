package com.github.mateuszwenus.spring4_webapp.config;


//@Configuration
//@EnableGlobalMethodSecurity
//public class CustomGlobalMethodSecurityConfiguration extends GlobalMethodSecurityConfiguration {
//
//  @Bean
//  @Override
//  @SuppressWarnings("rawtypes")
//  protected AccessDecisionManager accessDecisionManager() {
//    AbstractAccessDecisionManager accessDecisionManager = (AbstractAccessDecisionManager) super.accessDecisionManager();
//    List<AccessDecisionVoter> voters = new ArrayList<AccessDecisionVoter>(accessDecisionManager.getDecisionVoters());
//    WebExpressionVoter webExpressionVoter = new WebExpressionVoter();
//    webExpressionVoter.setExpressionHandler(filterInvocationSecurityExpressionHandler());
//    voters.add(webExpressionVoter);
//    return new AffirmativeBased(voters);
//  }
//
//  @Bean
//  public SecurityExpressionHandler<FilterInvocation> filterInvocationSecurityExpressionHandler() {
//    return new DefaultWebSecurityExpressionHandler();
//  }
// }
