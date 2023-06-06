package com.candyandy.budgettrackerapi.service.user;

import com.candyandy.budgettrackerapi.dto.UserRegistrationDto;
import com.candyandy.budgettrackerapi.entity.User;
import com.candyandy.budgettrackerapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    public UserRegistrationDto save(UserRegistrationDto userRegistrationDto) {
        User user = new User();
        user.setEmail(userRegistrationDto.email());
        user.setPassword(userRegistrationDto.password());

        userRepository.save(user);

        return userRegistrationDto;
    }
}
