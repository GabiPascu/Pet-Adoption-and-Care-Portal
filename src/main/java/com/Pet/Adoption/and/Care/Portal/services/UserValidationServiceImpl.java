package com.Pet.Adoption.and.Care.Portal.services;

import com.Pet.Adoption.and.Care.Portal.exceptions.DuplicateUserException;
import com.Pet.Adoption.and.Care.Portal.models.dtos.UserDto;
import com.Pet.Adoption.and.Care.Portal.models.entities.User;
import com.Pet.Adoption.and.Care.Portal.repositories.UserRepository;

public class UserValidationServiceImpl implements UserValidationService {

    private final UserRepository userRepository;

    public UserValidationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validateUniqueUser(UserDto userDto) {
        User foundUser = userRepository.findByEmail(userDto.getEmail());
        if (foundUser != null) {
            throw new DuplicateUserException("Email already exists.");
        }
    }
}
