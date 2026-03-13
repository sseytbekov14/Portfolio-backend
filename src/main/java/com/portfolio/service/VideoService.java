package com.portfolio.service;

import com.portfolio.dto.PhotoDto;
import com.portfolio.dto.VideoDto;
import com.portfolio.entity.Photo;
import com.portfolio.entity.User;
import com.portfolio.entity.Video;
import com.portfolio.repository.UserRepository;
import com.portfolio.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class VideoService {
    private final VideoRepository videoRepository;
    private final UserRepository userRepository;

    public List<VideoDto> findByUserId(Long id) {
        return videoRepository.findByUserId(id)
                .stream()
                .map(video -> VideoDto.builder()
                        .id(video.getId())
                        .url(video.getUrl())
                        .description(video.getDescription())
                        .userId(video.getUser().getId())
                        .build())
                .toList();
    }

    public VideoDto create(VideoDto dto) {
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() ->
                new RuntimeException("User not found"));

        Video video = new Video();
        video.setUrl(dto.getUrl());
        video.setDescription(dto.getDescription());
        video.setUser(user);

        Video saved = videoRepository.save(video);

        return VideoDto.builder()
                .id(saved.getId())
                .url(saved.getUrl())
                .description(saved.getDescription())
                .userId(saved.getUser().getId())
                .build();
    }

    public VideoDto update(Long id, VideoDto dto) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        video.setUrl(dto.getUrl());
        video.setDescription(dto.getDescription());

        Video saved = videoRepository.save(video);

        return VideoDto.builder()
                .id(saved.getId())
                .url(saved.getUrl())
                .description(saved.getDescription())
                .userId(saved.getUser().getId())
                .build();
    }

    public void delete(Long id) {
        videoRepository.deleteById(id);
    }
}