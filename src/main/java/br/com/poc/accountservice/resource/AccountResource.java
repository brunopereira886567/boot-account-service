package br.com.poc.accountservice.resource;

import br.com.poc.accountservice.service.KeycloakService;
import br.com.poc.accountservice.service.dto.LoginRequest;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AccountResource {
    private final KeycloakService keycloakService;

    public AccountResource(KeycloakService keycloakService) {
        this.keycloakService = keycloakService;
    }

    @PostMapping("/login")
    public ResponseEntity<AccessTokenResponse> login(@RequestBody LoginRequest request){
        AccessTokenResponse accessTokenResponse = keycloakService.login(request);
        if (accessTokenResponse == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(accessTokenResponse);
        }
        return ResponseEntity.ok(accessTokenResponse);
    }

}
