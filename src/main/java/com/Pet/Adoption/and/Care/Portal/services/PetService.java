package com.Pet.Adoption.and.Care.Portal.services;

import com.Pet.Adoption.and.Care.Portal.models.dtos.PetDto;

import java.util.List;
import java.util.Optional;


public interface PetService {

    PetDto createPet(PetDto petDto);

    Optional<PetDto> getPetById(Long petId);

    List<PetDto> getAllPets();

    void deletePet(Long petId);
}
