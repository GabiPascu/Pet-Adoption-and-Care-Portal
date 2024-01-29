package com.Pet.Adoption.and.Care.Portal.services;

import com.Pet.Adoption.and.Care.Portal.models.dtos.TagDto;
import com.Pet.Adoption.and.Care.Portal.models.entities.Tag;
import com.Pet.Adoption.and.Care.Portal.repositories.TagRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;


    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public TagDto saveTag(TagDto tagDto) {
        Tag tag = convertToEntity(tagDto);
        Tag savedTag = tagRepository.save(tag);
        return convertToDto(savedTag);
    }

    @Override
    public TagDto getTagById(Long id) {
        return tagRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    @Override
    public List<TagDto> getAllTags() {
        return tagRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    @Override
    public List<TagDto> findTagsByCriteria(String type, String description, String name) {
        return tagRepository.findTagsByCriteria(type, description, name).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private Tag convertToEntity(TagDto tagDto) {
        Tag tag = new Tag();
        BeanUtils.copyProperties(tagDto, tag);
        return tag;
    }

    private TagDto convertToDto(Tag tag) {
        TagDto tagDto = new TagDto();
        BeanUtils.copyProperties(tag, tagDto);
        return tagDto;
    }
}
