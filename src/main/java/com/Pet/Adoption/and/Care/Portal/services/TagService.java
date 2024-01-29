package com.Pet.Adoption.and.Care.Portal.services;

import com.Pet.Adoption.and.Care.Portal.models.dtos.TagDto;

import java.util.List;

public interface TagService {

    TagDto saveTag(TagDto tagDto);

    TagDto getTagById(Long id);

    List<TagDto> getAllTags();

    void deleteTag(Long id);

    List<TagDto> findTagsByCriteria(String type, String description, String name);

}
