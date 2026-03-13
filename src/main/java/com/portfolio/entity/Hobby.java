package com.portfolio.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "hobbies")
public class Hobby {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String description;

    @ManyToOne @JoinColumn(name = "user_id")
    private User user;
}