package com.candyandy.budgettrackerapi.user.dto;

public class UserDetailsDto {

    private String email;

    public UserDetailsDto() {
    }

    public UserDetailsDto(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
