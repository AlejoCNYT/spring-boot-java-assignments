package io.econexion.dto;

import io.econexion.domain.Role;
import jakarta.validation.constraints.*;

public record SignupRequest(
        @NotBlank String name,
        @Email String email,
        @Size(min = 8) String password,
        Role role
) {}
