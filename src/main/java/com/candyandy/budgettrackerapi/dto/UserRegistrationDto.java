package com.candyandy.budgettrackerapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserRegistrationDto(
        @NotNull
        @Email
        String email,
        @NotNull
        String password) {
}
