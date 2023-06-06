package com.candyandy.budgettrackerapi.controller;

import com.candyandy.budgettrackerapi.dto.UserRegistrationDto;
import com.candyandy.budgettrackerapi.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public UserRegistrationDto register(@RequestBody @Valid UserRegistrationDto userRegistrationDto) {
        userService.save(userRegistrationDto);
        return userRegistrationDto;
    }
}
