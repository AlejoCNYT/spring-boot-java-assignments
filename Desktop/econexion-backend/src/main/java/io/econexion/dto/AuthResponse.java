package io.econexion.dto;

public record AuthResponse(
        String token,
        String name,
        String role
) {}
