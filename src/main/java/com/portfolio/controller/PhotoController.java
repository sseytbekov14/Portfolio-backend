package com.portfolio.controller;

import com.portfolio.dto.PhotoDto;
import com.portfolio.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequiredArgsConstructor
@RequestMapping("/api/photos")
public class PhotoController {
    private final PhotoService photoService;

    @GetMapping("/{userId}")
    public List<PhotoDto> getUserById(@PathVariable Long userId) {
        return photoService.findByUserId(userId);
    }

    @PostMapping
    public PhotoDto create(@RequestBody PhotoDto dto) {
        return photoService.create(dto);
    }

    @PutMapping("/{id}")
    public PhotoDto update(@PathVariable Long id, @RequestBody PhotoDto dto) {
        return photoService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        photoService.delete(id);
    }
}