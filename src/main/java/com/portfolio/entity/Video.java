package com.portfolio.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity @Table(name = "videos")
public class Video {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;
    private String description;

    @ManyToOne @JoinColumn(name = "user_id")
    private User user;
}