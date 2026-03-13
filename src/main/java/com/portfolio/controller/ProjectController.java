package com.portfolio.controller;

import com.portfolio.dto.ProjectDto;
import com.portfolio.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/projects")
@RestController
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("/{userId}")
    public List<ProjectDto> findByUserId(@PathVariable Long userId) {
        return projectService.findByUserId(userId);
    }

    @PostMapping
    public ProjectDto create(@RequestBody ProjectDto dto) {
        return projectService.create(dto);
    }

    @PutMapping("/{id}")
    public ProjectDto update(@PathVariable Long id, @RequestBody ProjectDto dto) {
        return projectService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        projectService.delete(id);
    }
}