package com.Pet.Adoption.and.Care.Portal.services;

import com.Pet.Adoption.and.Care.Portal.models.dtos.PetDto;

public interface PetService {

    PetDto createPet(PetDto petDto);

    PetDto getPet(Long petId);

    void deletePet(Long petId);
}
