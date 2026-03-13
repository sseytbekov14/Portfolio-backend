package com.portfolio.dto;

import lombok.*;

import java.time.LocalDate;

@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ExperienceDto {
    private Long id;
    private String company;
    private String position;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isCurrent;
    private Long userId;
}
