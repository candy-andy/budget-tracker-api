package com.candyandy.budgettrackerapi.auth.service;

import com.candyandy.budgettrackerapi.auth.dto.LoginDto;
import com.candyandy.budgettrackerapi.user.dto.UserDto;
import com.candyandy.budgettrackerapi.user.entity.User;
import com.candyandy.budgettrackerapi.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.security.auth.message.AuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private static final String NOT_FOUND_MESSAGE = "User with email %s not found";

    @Autowired
    private UserRepository userRepository;

    public UserDto login(LoginDto loginDto) throws AuthException {
        User user = userRepository.findByEmail(loginDto.email())
                .orElseThrow(() -> new EntityNotFoundException(String.format(NOT_FOUND_MESSAGE, loginDto.email())));

        if (!user.getPassword().equals(loginDto.password())) {
            throw new AuthException("Wrong password");
        }

        return new UserDto(user.getEmail());
    }
}
