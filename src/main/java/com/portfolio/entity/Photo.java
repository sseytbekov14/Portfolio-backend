package com.portfolio.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@Builder @AllArgsConstructor @NoArgsConstructor
@Entity @Table(name = "photos")
public class Photo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;
    private String description;

    @ManyToOne @JoinColumn(name = "user_id")
    private User user;
}