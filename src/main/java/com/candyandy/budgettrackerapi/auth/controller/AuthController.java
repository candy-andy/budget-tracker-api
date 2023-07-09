package com.candyandy.budgettrackerapi.auth.controller;

import com.candyandy.budgettrackerapi.auth.service.AuthService;
import com.candyandy.budgettrackerapi.user.dto.UserDetailsDto;
import com.candyandy.budgettrackerapi.auth.dto.UserLoginDto;
import jakarta.security.auth.message.AuthException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<UserDetailsDto> login(@RequestBody @Valid UserLoginDto userLoginDto) throws AuthException {
        UserDetailsDto userDetailsDto = authService.loginUser(userLoginDto);

        return ResponseEntity.ok(userDetailsDto);
    }
}
