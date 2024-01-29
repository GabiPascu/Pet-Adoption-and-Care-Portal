package com.Pet.Adoption.and.Care.Portal.repositories;

import com.Pet.Adoption.and.Care.Portal.models.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    List<Tag> findByPetId(Long petId);

    List<Tag> findTagsByCriteria(@Param("type") String type, @Param("description") String description, @Param("name") String name);
}
