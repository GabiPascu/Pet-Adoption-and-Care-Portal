package com.Pet.Adoption.and.Care.Portal.models.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PetDto {

    private Long id;
    @NotBlank(message = "Invalid name")
    private String name;
    @NotBlank(message = "Invalid age")
    private Integer age;
    @NotBlank(message = "Invalid gender")
    private String gender;
    @NotBlank(message = "Invalid breed")
    private String breed;
    @NotBlank(message = "Invalid type")
    private String type;
    @NotBlank(message = "Invalid status")
    private String adoptionStatus;

}
