package com.Pet.Adoption.and.Care.Portal.controllers;

import com.Pet.Adoption.and.Care.Portal.models.dtos.TagDto;
import com.Pet.Adoption.and.Care.Portal.services.TagService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/tags")
public class TagController {


    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping
    public ResponseEntity<TagDto> createTag(@Valid @RequestBody TagDto tagDto) {
        TagDto savedTag = tagService.saveTag(tagDto);
        return ResponseEntity.ok(savedTag);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagDto> getTagById(@PathVariable Long id) {
        TagDto tagDto = tagService.getTagById(id);
        return tagDto != null ? ResponseEntity.ok(tagDto) : ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<TagDto>> searchForTag(@RequestParam(required = false) String type,
                                                     @RequestParam(required = false) String description,
                                                     @RequestParam(required = false) String name) {
        List<TagDto> tags = tagService.findTagsByCriteria(type, description, name);
        return ResponseEntity.ok(tags);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TagDto> updateTag(@Valid @PathVariable Long id, @RequestBody TagDto tagDto) {
        TagDto updatedTag = tagService.saveTag(tagDto);
        return ResponseEntity.ok(updatedTag);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
        return ResponseEntity.ok().build();
    }
}