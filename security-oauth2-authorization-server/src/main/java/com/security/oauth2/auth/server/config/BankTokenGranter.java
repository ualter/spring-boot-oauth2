package com.security.oauth2.auth.server.config;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.token.AbstractTokenGranter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@EqualsAndHashCode(callSuper = false)
public class BankTokenGranter /*extends AbstractTokenGranter*/ {

//    private final AuthenticationManager authenticationManager;
//
//    /**
//     * This parameter makes OAUTH login behave like session fixation. Enabled by default.
//     */
//    private boolean enableTokenFixation = false;
//
//    private final TokenStore tokenStore;
//
//    private static final String GRANT_TYPE = "bank";
//
//    public BankTokenGranter(AuthorizationServerTokenServices tokenServices, ClientDetailsService clientDetailsService, OAuth2RequestFactory requestFactory,
//            AuthenticationManager authenticationManager, TokenStore tokenStore) {
//        super(tokenServices, clientDetailsService, requestFactory, GRANT_TYPE);
//        this.authenticationManager = authenticationManager;
//        this.tokenStore = tokenStore;
//    }
//
//    @Override
//    protected OAuth2Authentication getOAuth2Authentication(ClientDetails client, TokenRequest tokenRequest) {
//        Map<String, String> parameters = new LinkedHashMap<>(tokenRequest.getRequestParameters());
//        String username = parameters.get("username");
//        String password = parameters.get("password");
//        String otp = parameters.get("otp");
//        String challenge = parameters.get("challenge");
//        String token = parameters.get("token");
//
//        log.debug("Authenticating username {} through OAUTH grant type bank", username);
//
//        Authentication auth = new BankAuthenticationToken(username, password, otp, challenge);
//        auth = authenticationManager.authenticate(auth);
//
//        if (auth.isAuthenticated()) {
//            if (enableTokenFixation) {
//                Collection<OAuth2AccessToken> accessTokens = tokenStore.findTokensByClientIdAndUserName(client.getClientId(), username);
//                accessTokens.forEach(tokenStore::removeAccessToken);
//
//                // Remove previous access and refresh token
//                OauthUtils.removeAccessToken(tokenStore, token);
//            }
//
//            OAuth2Request storedOAuth2Request = getRequestFactory().createOAuth2Request(client, tokenRequest);
//            return new OAuth2Authentication(storedOAuth2Request, auth);
//        } else {
//            throw new OmnichannelAuthenticationException(CommonErrorType.UNAUTHORIZED);
//        }
//    }

}
