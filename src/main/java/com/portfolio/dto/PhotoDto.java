package com.portfolio.dto;

import lombok.*;

@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class PhotoDto {
    private Long id;
    private String url;
    private String description;
    private Long userId;
}
