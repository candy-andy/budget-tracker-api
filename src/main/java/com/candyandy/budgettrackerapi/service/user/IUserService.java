package com.candyandy.budgettrackerapi.service.user;

import com.candyandy.budgettrackerapi.dto.UserRegistrationDto;

interface IUserService {
    UserRegistrationDto save(UserRegistrationDto userRegistration);
}
