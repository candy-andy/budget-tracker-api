package com.candyandy.budgettrackerapi.auth.service;

import com.candyandy.budgettrackerapi.auth.dto.UserLoginDto;
import com.candyandy.budgettrackerapi.user.dto.UserDetailsDto;
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

    public UserDetailsDto loginUser(UserLoginDto userLoginDto) throws AuthException {
        User user = userRepository.findByEmail(userLoginDto.email())
                .orElseThrow(() -> new EntityNotFoundException(String.format(NOT_FOUND_MESSAGE, userLoginDto.email())));

        if (!user.getPassword().equals(userLoginDto.password())) {
            throw new AuthException("Wrong password");
        }

        return new UserDetailsDto(user.getEmail());
    }
}
