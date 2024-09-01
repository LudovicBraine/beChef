package com.salty.bechef.entities.dto;

import com.salty.bechef.entities.Page;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

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
    private Set<Page> pages;
}
