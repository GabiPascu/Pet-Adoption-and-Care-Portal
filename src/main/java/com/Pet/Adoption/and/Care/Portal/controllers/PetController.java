package com.Pet.Adoption.and.Care.Portal.controllers;

import com.Pet.Adoption.and.Care.Portal.models.dtos.PetDto;
import com.Pet.Adoption.and.Care.Portal.services.PetService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;


    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public ResponseEntity<PetDto> createPet(@Valid @RequestBody PetDto petDto) {
        return ResponseEntity.ok(petService.createPet(petDto));
    }

    @GetMapping("/{petId}")
    public ResponseEntity<PetDto> getPetById(@PathVariable Long petId) {
        return petService.getPetById(petId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PetDto>> getAllPets() {
        return ResponseEntity.ok(petService.getAllPets());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetDto> updatePet(@Valid @PathVariable Long id, @RequestBody PetDto bookingDetails) {
        return ResponseEntity.ok(petService.createPet(bookingDetails));
    }

    @DeleteMapping("/{petId}")

    public ResponseEntity<Void> deletePet(@PathVariable Long petId) {
        petService.deletePet(petId);
        return ResponseEntity.ok().build();
    }
}
