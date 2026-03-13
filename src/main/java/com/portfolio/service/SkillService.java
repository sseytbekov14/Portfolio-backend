package com.portfolio.service;

import com.portfolio.dto.SkillDto;
import com.portfolio.entity.Skill;
import com.portfolio.entity.User;
import com.portfolio.repository.SkillRepository;
import com.portfolio.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor @Service
public class SkillService {
    private final SkillRepository skillRepository;
    private final UserRepository userRepository;

    public List<SkillDto> findByUserId(Long id) {
        return skillRepository.findByUserId(id)
                .stream()
                .map(skill -> SkillDto.builder()
                        .id(skill.getId())
                        .name(skill.getName())
                        .category(skill.getCategory())
                        .level(skill.getLevel())
                        .userId(skill.getUser().getId())
                        .build())
                .toList();
    }

    public SkillDto create(SkillDto dto) {
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() ->
                new RuntimeException("User not found"));

        Skill skill = new Skill();
        skill.setName(dto.getName());
        skill.setCategory(dto.getCategory());
        skill.setLevel(dto.getLevel());
        skill.setUser(user);

        Skill saved = skillRepository.save(skill);

        return SkillDto.builder()
                .id(saved.getId())
                .name(saved.getName())
                .category(saved.getCategory())
                .level(saved.getLevel())
                .userId(saved.getUser().getId())
                .build();
    }

    public SkillDto update(Long id, SkillDto dto) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Profile not found"));

        skill.setName(dto.getName());
        skill.setCategory(dto.getCategory());
        skill.setLevel(dto.getLevel());

        Skill saved = skillRepository.save(skill);

        return SkillDto.builder()
                .id(saved.getId())
                .name(saved.getName())
                .category(saved.getCategory())
                .level(saved.getLevel())
                .userId(saved.getUser().getId())
                .build();
    }

    public void delete(Long id) {
        skillRepository.deleteById(id);
    }
}
