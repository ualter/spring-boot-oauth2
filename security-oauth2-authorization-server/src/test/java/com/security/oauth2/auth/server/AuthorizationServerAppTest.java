package com.security.oauth2.auth.server;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class AuthorizationServerAppTest {
	
	@Value("${oauth.token}")
    private String tokenUrl;
	
	@Value("${server.contextPath}")
	private String contextPath;
	
	@Value("${oauth.clientId:microshark}")
	private String clientIdResourceOwnerPassword;
	
	@Value("${oauth.clientSecret:3opm8b}")
	private String clientSecretResourceOwnerPassword;
	
	@Value("${oauth.clientId:yostark}")
	private String clientIdClientCredentials;
	
	@Value("${oauth.clientSecret:jep817}")
	private String clientSecretClientCredentials;
	
	@Test
	public void testTokenGenerationResourceOwnerPasswordCredentials() {
		ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
		List<String> scopes = new ArrayList<String>(2);
        scopes.add("read");
        resource.setAccessTokenUri(tokenUrl);
        resource.setClientId(clientIdResourceOwnerPassword);
        resource.setClientSecret(clientSecretResourceOwnerPassword);
        resource.setGrantType("password");
        resource.setScope(scopes);
        // On behalf of..
        resource.setUsername("john");
        resource.setPassword("123");
        
        //AccessTokenRequest atr = new DefaultAccessTokenRequest();
		//OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(resource, new DefaultOAuth2ClientContext(atr));
		OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(resource);
		
		OAuth2AccessToken oAuth2AccessToken = oAuth2RestTemplate.getAccessToken();
		assertNotNull("Access Token",oAuth2AccessToken.getValue());
		
		try {
			System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(oAuth2AccessToken));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTokenGenerationClientCredentials() {
		ClientCredentialsResourceDetails resource = new ClientCredentialsResourceDetails();
		List<String> scopes = new ArrayList<String>(2);
        scopes.add("read");
        scopes.add("write");
        resource.setAccessTokenUri(tokenUrl);
        resource.setClientId(clientIdClientCredentials);
        resource.setClientSecret(clientSecretClientCredentials);
        resource.setGrantType("client_credentials");
        resource.setScope(scopes);
        
        //AccessTokenRequest atr = new DefaultAccessTokenRequest();
		//OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(resource, new DefaultOAuth2ClientContext(atr));
		OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(resource);
		
		OAuth2AccessToken oAuth2AccessToken = oAuth2RestTemplate.getAccessToken();
		assertNotNull("Access Token",oAuth2AccessToken.getValue());
		
		try {
			System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(oAuth2AccessToken));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
