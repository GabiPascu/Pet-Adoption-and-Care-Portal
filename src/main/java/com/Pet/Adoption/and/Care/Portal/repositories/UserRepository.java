package com.Pet.Adoption.and.Care.Portal.repositories;

import com.Pet.Adoption.and.Care.Portal.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
