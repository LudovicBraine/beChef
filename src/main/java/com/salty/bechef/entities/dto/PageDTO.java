package com.salty.bechef.entities.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PageDTO {
    private Long id;
    private String title;
    private String image;
    private String content;
    private LocalDateTime createdAt;
    private String lastModifiedBy;
    private LocalDateTime modifyAt;
    private Boolean display;
    private Long user;
    private Long book;
}
