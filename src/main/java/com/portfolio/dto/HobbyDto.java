package com.portfolio.dto;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Builder
@Getter @Setter
public class HobbyDto {
    private Long id;
    private String name;
    private String description;
    private Long userId;
}
