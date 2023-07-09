package com.candyandy.budgettrackerapi.user.service;

import com.candyandy.budgettrackerapi.user.dto.UserRegistrationDto;
import com.candyandy.budgettrackerapi.user.entity.User;
import com.candyandy.budgettrackerapi.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(UserRegistrationDto userRegistrationDto) {
        User user = new User();
        user.setEmail(userRegistrationDto.email());
        user.setPassword(userRegistrationDto.password());

        userRepository.save(user);
    }
}
