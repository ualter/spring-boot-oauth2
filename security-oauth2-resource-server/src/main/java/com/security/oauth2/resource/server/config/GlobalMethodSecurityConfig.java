package com.security.oauth2.resource.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;

//@Configuration
public class GlobalMethodSecurityConfig extends GlobalMethodSecurityConfiguration {

	@Override
	protected MethodSecurityExpressionHandler createExpressionHandler() {
		// With this: we activated the use of #oauth2 security expressions for methods (for instance) 
		return new OAuth2MethodSecurityExpressionHandler();
	}

}
