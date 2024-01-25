package com.Pet.Adoption.and.Care.Portal.repositories;

import com.Pet.Adoption.and.Care.Portal.models.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
