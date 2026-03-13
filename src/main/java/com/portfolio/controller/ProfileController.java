package com.portfolio.controller;

import com.portfolio.dto.ProfileDto;
import com.portfolio.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/profiles")
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping("/{userId}")
    public Optional<ProfileDto> findByUserId(@PathVariable Long userId) {

        return profileService.findByUserId(userId);
    }

    @PostMapping
    public ProfileDto create(@RequestBody ProfileDto dto) {
        return profileService.create(dto);
    }

    @PutMapping("/{id}")
    public ProfileDto update(@PathVariable Long id, @RequestBody ProfileDto dto) {
        return profileService.update(id, dto);
    }
}