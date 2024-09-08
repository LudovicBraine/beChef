package com.salty.bechef.entities.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BookDTO {
    private Long id;
    private String title;
    private String image;
    private String description;
    private LocalDateTime createdAt;
    private String lastModifiedBy;
    private LocalDateTime modifyAt;
    private Boolean display;
    private UserDTO user;
    private List<PageDTO> pages;
    private List<UserDTO> accessUser;
}
