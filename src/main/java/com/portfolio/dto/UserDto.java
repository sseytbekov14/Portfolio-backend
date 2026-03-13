package com.portfolio.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor @AllArgsConstructor @Builder
@Getter @Setter
public class UserDto {
    private Long id;
    private String username;
    private String role;
    private LocalDateTime createdAt;
}