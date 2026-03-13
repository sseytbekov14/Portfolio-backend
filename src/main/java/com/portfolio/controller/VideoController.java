package com.portfolio.controller;

import com.portfolio.dto.VideoDto;
import com.portfolio.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequiredArgsConstructor
@RequestMapping("/api/videos")
public class VideoController {
    private final VideoService videoService;

    @GetMapping("/{userId}")
    public List<VideoDto> getUserById(@PathVariable Long userId) {
        return videoService.findByUserId(userId);
    }

    @PostMapping
    public VideoDto create(@RequestBody VideoDto dto) {
        return videoService.create(dto);
    }

    @PutMapping("/{id}")
    public VideoDto update(@PathVariable Long id, @RequestBody VideoDto dto) {
        return videoService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        videoService.delete(id);
    }
}