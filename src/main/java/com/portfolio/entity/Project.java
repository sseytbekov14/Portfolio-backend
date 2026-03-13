package com.portfolio.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@Builder @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "projects")
public class Project {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;
    private String techStack;
    private String githubUrl;
    private String liveUrl;
    private String imageUrl;

    @ManyToOne @JoinColumn(name = "user_id")
    private User user;
}