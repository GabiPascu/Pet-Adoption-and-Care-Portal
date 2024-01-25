package com.Pet.Adoption.and.Care.Portal.controllers;

import com.Pet.Adoption.and.Care.Portal.models.dtos.PetDto;
import com.Pet.Adoption.and.Care.Portal.models.entities.Pet;
import com.Pet.Adoption.and.Care.Portal.services.PetService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/users")
public class PetController {

    private final PetService petService;


    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public ResponseEntity<PetDto> createPet(@Valid @RequestBody PetDto petDto) {
        return ResponseEntity.ok(petService.createPet(petDto));
    }

    @GetMapping("getPet")
    public ResponseEntity<PetDto> getPet(@PathVariable Long petId) {
        return ResponseEntity.ok(petService.getPet(petId));
    }

    @DeleteMapping("/{petId}")

    public ResponseEntity<Void> deletePet(@PathVariable Long petId) {
        petService.deletePet(petId);
        return ResponseEntity.ok().build();
    }
}
