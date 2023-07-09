package com.candyandy.budgettrackerapi.user.controller;

import com.candyandy.budgettrackerapi.user.dto.UserRegistrationDto;
import com.candyandy.budgettrackerapi.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody @Valid UserRegistrationDto userRegistrationDto) {
        userService.createUser(userRegistrationDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Collections.singletonMap("email", userRegistrationDto.email()));
    }
}
