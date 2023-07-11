package com.candyandy.budgettrackerapi.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserRegistrationDto(
        @NotNull
        @Email
        String email,

        @NotNull
        String password) {
}
