package com.salty.bechef.repository;

import com.salty.bechef.entities.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PageRepository extends JpaRepository<Page, Long> {
    @Query("SELECT p FROM Page p WHERE p.book.id = :bookId")
    public List<Page> getPagesByBookId(Long bookId);

    @Query("SELECT p FROM Page p WHERE p.book.id = :bookId AND p.id = :pageId ")
    public Page getPageByBookId(Long bookId, Long pageId);

    @Query("DELETE FROM Page p WHERE p.book = :bookId AND p.id = :pageId ")
    public void deletePageByBookId(Long bookId, Long pageId);
}
