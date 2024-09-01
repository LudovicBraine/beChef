package com.salty.bechef.service.impl;

import com.salty.bechef.entities.Book;
import com.salty.bechef.entities.Page;
import com.salty.bechef.entities.User;
import com.salty.bechef.entities.dto.PageDTO;
import com.salty.bechef.mapper.PageMapper;
import com.salty.bechef.repository.BookRepository;
import com.salty.bechef.repository.PageRepository;
import com.salty.bechef.repository.UserRepository;
import com.salty.bechef.service.PageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PageServiceImpl implements PageService {

    private final PageRepository pageRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final PageMapper pageMapper;

    @Override
    public List<Page> getPagesByBookId(Long bookId) {
        return this.pageRepository.getPagesByBookId(bookId);
    }

    @Override
    public Page getPageByBookId(Long bookId, Long pageId) {
        return this.pageRepository.getPageByBookId(bookId, pageId);
    }

    @Override
    public void deletePageByBookId(Long bookId, Long pageId) {
        this.pageRepository.deletePageByBookId(bookId, pageId);
    }

    @Override
    public Page addPage(Long bookId, PageDTO pageDTO) {

        if(pageDTO.getCreatedAt() == null) {
            pageDTO.setCreatedAt(LocalDateTime.now());
        } else {
            pageDTO.setModifyAt(LocalDateTime.now());
        }

        Page page = this.pageMapper.pageDtoToPage(pageDTO);

        Book book = this.bookRepository.findById(bookId).orElseThrow();
        User user = this.userRepository.findById(pageDTO.getUser()).orElseThrow();
        page.setBook(book);
        page.setUser(user);

        return this.pageRepository.save(page);
    }
}
