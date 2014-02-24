package org.springframework.security.web.access.expression;

import org.springframework.expression.Expression;

public class PublicWebExpressionConfigAttribute extends WebExpressionConfigAttribute {

  private static final long serialVersionUID = 1L;

  public PublicWebExpressionConfigAttribute(Expression authorizeExpression) {
    super(authorizeExpression);
  }
}
