package com.portfolio.service;

import com.portfolio.dto.ExperienceDto;
import com.portfolio.entity.Experience;
import com.portfolio.entity.User;
import com.portfolio.repository.ExperienceRepository;
import com.portfolio.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class ExperienceService {
    private final ExperienceRepository experienceRepository;
    private final UserRepository userRepository;

    public List<ExperienceDto> findByUserId(Long id) {
        return experienceRepository.findByUserId(id)
                .stream()
                .map(experience -> ExperienceDto.builder()
                        .id(experience.getId())
                        .company(experience.getCompany())
                        .position(experience.getPosition())
                        .description(experience.getDescription())
                        .startDate(experience.getStartDate())
                        .endDate(experience.getEndDate())
                        .isCurrent(experience.isCurrent())
                        .userId(experience.getUser().getId())
                        .build())
                .toList();
    }

    public ExperienceDto create(ExperienceDto dto) {
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() ->
                new RuntimeException("User not found"));

        Experience experience = new Experience();
        experience.setCompany(dto.getCompany());
        experience.setPosition(dto.getPosition());
        experience.setDescription(dto.getDescription());
        experience.setStartDate(dto.getStartDate());
        experience.setEndDate(dto.getEndDate());
        experience.setCurrent(dto.isCurrent());
        experience.setUser(user);

        Experience saved = experienceRepository.save(experience);

        return ExperienceDto.builder()
                .id(saved.getId())
                .company(saved.getCompany())
                .position(saved.getPosition())
                .description(saved.getDescription())
                .startDate(saved.getStartDate())
                .endDate(saved.getEndDate())
                .isCurrent(saved.isCurrent())
                .userId(saved.getUser().getId())
                .build();
    }

    public ExperienceDto update(Long id, ExperienceDto dto) {
        Experience experience = experienceRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Profile not found"));

        experience.setCompany(dto.getCompany());
        experience.setPosition(dto.getPosition());
        experience.setDescription(dto.getDescription());
        experience.setStartDate(dto.getStartDate());
        experience.setEndDate(dto.getEndDate());
        experience.setCurrent(dto.isCurrent());

        Experience saved = experienceRepository.save(experience);

        return ExperienceDto.builder()
                .id(saved.getId())
                .company(saved.getCompany())
                .position(saved.getPosition())
                .description(saved.getDescription())
                .startDate(saved.getStartDate())
                .endDate(saved.getEndDate())
                .isCurrent(saved.isCurrent())
                .userId(saved.getUser().getId())
                .build();
    }

    public void delete(Long id) {
        experienceRepository.deleteById(id);
    }
}