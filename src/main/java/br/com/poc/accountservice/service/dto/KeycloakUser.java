package br.com.poc.accountservice.service.dto;

public record KeycloakUser(
        String firstName,
        String lastName,
        String email,
        String username,
        String password,
        String role
) {}
