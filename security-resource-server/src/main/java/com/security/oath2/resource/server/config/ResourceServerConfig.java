package com.security.oath2.resource.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	

    @Value("${security.oauth2.resource.token-info-uri}")
    private String checkTokenUri;

    @Value("${security.oauth2.client.client-id}")
    private String clientId;

    @Value("${security.oauth2.client.client-secret}")
    private String clientSecret;
    

	@Override
	public void configure(HttpSecurity http) throws Exception {
		//@formatter:off
		http.
			antMatcher("/**")
				.authorizeRequests()
			.anyRequest()
				.authenticated();
		//@formatter:on
	}
	
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenServices(remoteTokenServices()).resourceId("ee").stateless(true);
    }
	
	@Bean
    public RemoteTokenServices remoteTokenServices() {
        final RemoteTokenServices tokenServices = new RemoteTokenServices();
        tokenServices.setCheckTokenEndpointUrl(checkTokenUri);
        tokenServices.setClientId(clientId);
        tokenServices.setClientSecret(clientSecret);
        return tokenServices;
    }

}
