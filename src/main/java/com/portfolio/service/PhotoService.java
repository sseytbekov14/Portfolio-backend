package com.portfolio.service;

import com.portfolio.dto.PhotoDto;
import com.portfolio.entity.Photo;
import com.portfolio.entity.User;
import com.portfolio.repository.PhotoRepository;
import com.portfolio.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class PhotoService {
    private final PhotoRepository photoRepository;
    private final UserRepository userRepository;

    public List<PhotoDto> findByUserId(Long id) {
        return photoRepository.findByUserId(id)
                .stream()
                .map(photo -> PhotoDto.builder()
                        .id(photo.getId())
                        .url(photo.getUrl())
                        .description(photo.getDescription())
                        .userId(photo.getUser().getId())
                        .build())
                .toList();
    }

    public PhotoDto create(PhotoDto dto) {
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() ->
                new RuntimeException("User not found"));

        Photo photo = new Photo();
        photo.setUrl(dto.getUrl());
        photo.setDescription(dto.getDescription());
        photo.setUser(user);

        Photo saved = photoRepository.save(photo);

        return PhotoDto.builder()
                .id(saved.getId())
                .url(saved.getUrl())
                .description(saved.getDescription())
                .userId(saved.getUser().getId())
                .build();
    }

    public PhotoDto update(Long id, PhotoDto dto) {
        Photo photo = photoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        photo.setUrl(dto.getUrl());
        photo.setDescription(dto.getDescription());

        Photo saved = photoRepository.save(photo);

        return PhotoDto.builder()
                .id(saved.getId())
                .url(saved.getUrl())
                .description(saved.getDescription())
                .userId(saved.getUser().getId())
                .build();
    }

    public void delete(Long id) {
        photoRepository.deleteById(id);
    }
}