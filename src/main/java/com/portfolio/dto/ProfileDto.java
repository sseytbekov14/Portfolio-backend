package com.portfolio.dto;

import lombok.*;

@Builder @NoArgsConstructor @AllArgsConstructor
@Setter @Getter
public class ProfileDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String bio;
    private String location;
    private String avatarUrl;
    private Long userId;
}