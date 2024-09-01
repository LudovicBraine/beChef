package com.salty.bechef.service;

import com.salty.bechef.entities.Page;
import com.salty.bechef.entities.dto.PageDTO;

import java.util.List;

public interface PageService {
    List<Page> getPagesByBookId(Long bookId);
    Page getPageByBookId(Long bookId, Long pageId);
    void deletePageByBookId(Long bookId, Long pageId);
    Page addPage(Long bookId, PageDTO page);
}
