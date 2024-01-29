package com.Pet.Adoption.and.Care.Portal.models.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TagDto {

    private Long id;
    @NotBlank(message = "Invalid input")
    private String emotionalSupport;
    @NotBlank(message = "Invalid input")
    private String sporty;
    @NotBlank(message = "Invalid input")
    private String guidingDog;

}
