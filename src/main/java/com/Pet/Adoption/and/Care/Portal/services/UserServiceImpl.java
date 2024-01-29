package com.Pet.Adoption.and.Care.Portal.services;

import com.Pet.Adoption.and.Care.Portal.models.dtos.UserDto;
import com.Pet.Adoption.and.Care.Portal.models.entities.User;
import com.Pet.Adoption.and.Care.Portal.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserValidationService userValidationService;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, UserValidationService userValidationService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userValidationService = userValidationService;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        userValidationService.validateUniqueUser(userDto);
        User savedUser = userRepository.save(modelMapper.map(userDto, User.class));
        log.info("User with id {}, saved in database.", savedUser.getId());

        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public List<UserDto> getALlUsers() {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }

    @Override
    public UserDto getUser(Long userId) {
        return null;
    }
}
