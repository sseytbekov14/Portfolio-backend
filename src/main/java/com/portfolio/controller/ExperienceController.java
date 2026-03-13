package com.portfolio.controller;

import com.portfolio.dto.ExperienceDto;
import com.portfolio.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiences")
@RequiredArgsConstructor
public class ExperienceController {
    private final ExperienceService experienceService;

    @GetMapping("/{userId}")
    public List<ExperienceDto> findByUserId(@PathVariable Long userId) {
        return experienceService.findByUserId(userId);
    }

    @PostMapping
    public ExperienceDto create(@RequestBody ExperienceDto dto) {
        return experienceService.create(dto);
    }

    @PutMapping("/{id}")
    public ExperienceDto update(@PathVariable Long id, @RequestBody ExperienceDto dto) {
        return experienceService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        experienceService.delete(id);
    }
}