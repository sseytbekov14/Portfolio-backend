package com.portfolio.controller;

import com.portfolio.dto.HobbyDto;
import com.portfolio.service.HobbyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequiredArgsConstructor
@RequestMapping("/api/hobbies")
public class HobbyController {
    private final HobbyService hobbyService;

    @GetMapping("/{userId}")
    public List<HobbyDto> getUserById(@PathVariable Long userId) {
        return hobbyService.findByUserId(userId);
    }

    @PostMapping
    public HobbyDto create(@RequestBody HobbyDto dto) {
        return hobbyService.create(dto);
    }

    @PutMapping("/{id}")
    public HobbyDto update(@PathVariable Long id, @RequestBody HobbyDto dto) {
        return hobbyService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        hobbyService.delete(id);
    }
}