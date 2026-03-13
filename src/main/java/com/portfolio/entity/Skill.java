package com.portfolio.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@Builder @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "skills")
public class Skill {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    private String level;

    @ManyToOne @JoinColumn(name = "user_id")
    private User user;
}