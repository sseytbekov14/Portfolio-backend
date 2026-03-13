package com.portfolio.service;

import com.portfolio.dto.ProfileDto;
import com.portfolio.entity.Profile;
import com.portfolio.entity.User;
import com.portfolio.repository.ProfileRepository;
import com.portfolio.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service @RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    public Optional<ProfileDto> findByUserId(Long id) {
        return profileRepository.findByUserId(id)
                .map(profile -> ProfileDto.builder()
                        .id(profile.getId())
                        .firstname(profile.getFirstname())
                        .lastname(profile.getLastname())
                        .bio(profile.getBio())
                        .location(profile.getLocation())
                        .avatarUrl(profile.getAvatarUrl())
                        .userId(profile.getUser().getId())
                        .build());
    }

    public ProfileDto create(ProfileDto dto) {
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() ->
                new RuntimeException("User not found"));

        Profile profile = new Profile();
        profile.setFirstname(dto.getFirstname());
        profile.setLastname(dto.getLastname());
        profile.setBio(dto.getBio());
        profile.setLocation(dto.getLocation());
        profile.setAvatarUrl(dto.getAvatarUrl());
        profile.setUser(user);

        Profile saved = profileRepository.save(profile);

        return ProfileDto.builder()
                .id(saved.getId())
                .firstname(saved.getFirstname())
                .lastname(saved.getLastname())
                .bio(saved.getBio())
                .location(saved.getLocation())
                .avatarUrl(saved.getAvatarUrl())
                .userId(saved.getUser().getId())
                .build();
    }

    public ProfileDto update(Long id, ProfileDto dto) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        profile.setFirstname(dto.getFirstname());
        profile.setLastname(dto.getLastname());
        profile.setBio(dto.getBio());
        profile.setLocation(dto.getLocation());
        profile.setAvatarUrl(dto.getAvatarUrl());

        Profile saved = profileRepository.save(profile);

        return ProfileDto.builder()
                .id(saved.getId())
                .firstname(saved.getFirstname())
                .lastname(saved.getLastname())
                .bio(saved.getBio())
                .location(saved.getLocation())
                .avatarUrl(saved.getAvatarUrl())
                .userId(saved.getUser().getId())
                .build();
    }

}