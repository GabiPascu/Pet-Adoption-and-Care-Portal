package com.Pet.Adoption.and.Care.Portal.services;

import com.Pet.Adoption.and.Care.Portal.models.dtos.PetDto;
import com.Pet.Adoption.and.Care.Portal.models.entities.Pet;
import com.Pet.Adoption.and.Care.Portal.repositories.PetRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;


    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public PetDto createPet(PetDto petDto) {
        Pet pet = convertToEntity(petDto);
        Pet savedPet = petRepository.save(pet);
        return convertToDto(savedPet);
    }

    @Override
    public Optional<PetDto> getPetById(Long petId) {
        return petRepository.findById(petId)
                .map(this::convertToDto);

    }

    @Override
    public List<PetDto> getAllPets() {
        return petRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePet(Long petId) {
        petRepository.deleteById(petId);
    }

    private Pet convertToEntity(PetDto petDto) {
        Pet pet = new Pet();
        BeanUtils.copyProperties(petDto, pet);
        return pet;
    }

    private PetDto convertToDto(Pet pet) {
        PetDto petDto = new PetDto();
        BeanUtils.copyProperties(pet, petDto);
        return petDto;
    }
}
