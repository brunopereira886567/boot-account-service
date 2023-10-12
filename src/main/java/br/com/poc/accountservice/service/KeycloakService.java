package br.com.poc.accountservice.service;

import br.com.poc.accountservice.service.dto.LoginRequest;
import org.keycloak.representations.AccessTokenResponse;

public interface KeycloakService {
     AccessTokenResponse loginWithKeycloak(LoginRequest request);
}
