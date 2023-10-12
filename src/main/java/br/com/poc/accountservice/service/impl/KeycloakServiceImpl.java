package br.com.poc.accountservice.service.impl;

import br.com.poc.accountservice.service.KeycloakService;
import br.com.poc.accountservice.service.dto.LoginRequest;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class KeycloakServiceImpl implements KeycloakService {

    @Value("oauth2.keycloak.server-url")
    public String serverUrl;
    @Value("oauth2.keycloak.realm")
    public String realm;
    @Value("oauth2.keycloak.client-id")
    public String clientId;
    @Value("oauth2.keycloak.client-secret")
    public String clientSecret;

    @Override
    public AccessTokenResponse loginWithKeycloak(LoginRequest request) {
        try (Keycloak loginKeycloak = buildKeycloak(request.username(), request.password())) {
            AccessTokenResponse accessTokenResponse = null;
            accessTokenResponse = loginKeycloak.tokenManager().getAccessToken();
            return accessTokenResponse;
        } catch (Exception e) {

        }
        return new AccessTokenResponse();
    }

    private Keycloak buildKeycloak(String username, String password) {
        return KeycloakBuilder.builder()
                .realm(realm)
                .serverUrl(serverUrl)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .username(username)
                .password(password)
                .build();
    }

}
