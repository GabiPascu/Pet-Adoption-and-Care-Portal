package com.Pet.Adoption.and.Care.Portal.services;

import com.Pet.Adoption.and.Care.Portal.models.dtos.UserDto;

public interface UserValidationService {
    void validateUniqueUser(UserDto userDto);
}
