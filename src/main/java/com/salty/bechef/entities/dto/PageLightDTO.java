package com.salty.bechef.entities.dto;

import com.salty.bechef.entities.Book;
import com.salty.bechef.entities.User;
import lombok.Data;

import java.time.LocalDateTime;

public class PageLightDTO {
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
        private User user;
        private Book book;
    }

}
