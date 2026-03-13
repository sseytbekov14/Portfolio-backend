package com.portfolio.service;

import com.portfolio.dto.ProjectDto;
import com.portfolio.entity.Project;
import com.portfolio.entity.User;
import com.portfolio.repository.ProjectRepository;
import com.portfolio.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public List<ProjectDto> findByUserId(Long id) {
        return projectRepository.findByUserId(id)
                .stream()
                .map(project -> ProjectDto.builder()
                        .id(project.getId())
                        .title(project.getTitle())
                        .description(project.getDescription())
                        .techStack(project.getTechStack())
                        .githubUrl(project.getGithubUrl())
                        .liveUrl(project.getLiveUrl())
                        .imageUrl(project.getImageUrl())
                        .userId(project.getUser().getId())
                        .build())
                .toList();
    }

    public ProjectDto create(ProjectDto dto) {
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() ->
                new RuntimeException("User not found"));

        Project project = new Project();
        project.setTitle(dto.getTitle());
        project.setDescription(dto.getDescription());
        project.setTechStack(dto.getTechStack());
        project.setGithubUrl(dto.getGithubUrl());
        project.setLiveUrl(dto.getLiveUrl());
        project.setImageUrl(dto.getImageUrl());
        project.setUser(user);

        Project saved = projectRepository.save(project);

        return ProjectDto.builder()
                .id(saved.getId())
                .title(saved.getTitle())
                .description(saved.getDescription())
                .techStack(saved.getTechStack())
                .githubUrl(saved.getGithubUrl())
                .liveUrl(saved.getLiveUrl())
                .imageUrl(saved.getImageUrl())
                .userId(saved.getUser().getId())
                .build();
    }


    public ProjectDto update(Long id, ProjectDto dto) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Profile not found"));

        project.setTitle(dto.getTitle());
        project.setDescription(dto.getDescription());
        project.setTechStack(dto.getTechStack());
        project.setGithubUrl(dto.getGithubUrl());
        project.setLiveUrl(dto.getLiveUrl());
        project.setImageUrl(dto.getImageUrl());

        Project saved = projectRepository.save(project);

        return ProjectDto.builder()
                .id(saved.getId())
                .title(saved.getTitle())
                .description(saved.getDescription())
                .techStack(saved.getTechStack())
                .githubUrl(saved.getGithubUrl())
                .liveUrl(saved.getLiveUrl())
                .imageUrl(saved.getImageUrl())
                .userId(saved.getUser().getId())
                .build();

    }

    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

}