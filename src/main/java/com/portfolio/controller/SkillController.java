package com.portfolio.controller;

import com.portfolio.dto.SkillDto;
import com.portfolio.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/skills")
@RestController
public class SkillController {
    private final SkillService skillService;

    @GetMapping("/{userId}")
    public List<SkillDto> findByUserId(@PathVariable Long userId) {
        return skillService.findByUserId(userId);
    }

    @PostMapping
    public SkillDto create(@RequestBody SkillDto dto) {
        return skillService.create(dto);
    }

    @PutMapping("/{id}")
    public SkillDto update(@PathVariable Long id, @RequestBody SkillDto dto) {
        return skillService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        skillService.delete(id);
    }
}