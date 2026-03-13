package com.portfolio.service;

import com.portfolio.dto.HobbyDto;
import com.portfolio.entity.Hobby;
import com.portfolio.entity.User;
import com.portfolio.repository.HobbyRepository;
import com.portfolio.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class HobbyService {
    private final HobbyRepository hobbyRepository;
    private final UserRepository userRepository;

    public List<HobbyDto> findByUserId(Long id) {
        return hobbyRepository.findByUserId(id)
                .stream()
                .map(hobby -> HobbyDto.builder()
                        .id(hobby.getId())
                        .name(hobby.getName())
                        .description(hobby.getDescription())
                        .userId(hobby.getUser().getId())
                        .build())
                .toList();
    }

    public HobbyDto create(HobbyDto dto) {
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() ->
                new RuntimeException("User not found"));

        Hobby hobby = new Hobby();
        hobby.setName(dto.getName());
        hobby.setDescription(dto.getDescription());
        hobby.setUser(user);

        Hobby saved = hobbyRepository.save(hobby);

        return HobbyDto.builder()
                .id(saved.getId())
                .name(saved.getName())
                .description(saved.getDescription())
                .userId(saved.getUser().getId())
                .build();
    }

    public HobbyDto update(Long id, HobbyDto dto) {
        Hobby hobby = hobbyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        hobby.setName(dto.getName());
        hobby.setDescription(dto.getDescription());

        Hobby saved = hobbyRepository.save(hobby);

        return HobbyDto.builder()
                .id(saved.getId())
                .name(saved.getName())
                .description(saved.getDescription())
                .userId(saved.getUser().getId())
                .build();
    }

    public void delete(Long id) {
        hobbyRepository.deleteById(id);
    }
}