package com.Pet.Adoption.and.Care.Portal.services;

import com.Pet.Adoption.and.Care.Portal.models.dtos.PetDto;
import com.Pet.Adoption.and.Care.Portal.repositories.PetRepository;
import org.modelmapper.ModelMapper;

public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    
    private final ModelMapper modelMapper;

    public PetServiceImpl(PetRepository petRepository, ModelMapper modelMapper) {
        this.petRepository = petRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PetDto createPet(PetDto petDto) {
        return null;
    }

    @Override
    public PetDto getPet(Long petId) {
        return null;
    }

    @Override
    public void deletePet(Long petId) {

    }
}
