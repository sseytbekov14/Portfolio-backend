package com.portfolio.dto;

import lombok.*;

@Setter @Getter
@Builder @NoArgsConstructor @AllArgsConstructor
public class VideoDto {
    private Long id;
    private String url;
    private String description;
    private Long userId;
}