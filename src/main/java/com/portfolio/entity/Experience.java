package com.portfolio.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter @Setter
@Builder @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "experiences")
public class Experience {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private String position;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isCurrent;

    @ManyToOne @JoinColumn(name = "user_id")
    private User user;
}