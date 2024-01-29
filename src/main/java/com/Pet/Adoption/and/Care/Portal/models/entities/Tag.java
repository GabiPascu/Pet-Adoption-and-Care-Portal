package com.Pet.Adoption.and.Care.Portal.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;
    @Column(name = "description")
    private String description;
    @Column(name = "name")
    private String name;
    @ManyToMany
    @JoinTable(
            name = "pet_tag",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_id")
    )
    private Set<Pet> pets = new HashSet<>();
}