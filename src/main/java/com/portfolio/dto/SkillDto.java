package com.portfolio.dto;

import lombok.*;

@Builder @AllArgsConstructor @NoArgsConstructor
@Setter @Getter
public class SkillDto {
    private Long id;
    private String name;
    private String category;
    private String level;
    private Long userId;
}