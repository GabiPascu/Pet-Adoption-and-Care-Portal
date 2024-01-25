package com.Pet.Adoption.and.Care.Portal.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDto {

    private Long id;
    @NotBlank(message = "Invalid first name")
    private String firstName;
    @NotBlank(message = "Invalid last name")
    private String lastName;
    @NotBlank
    @Email(message = "Invalid email")
    private String email;
}