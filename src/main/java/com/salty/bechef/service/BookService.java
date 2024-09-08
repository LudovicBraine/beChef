package com.salty.bechef.service;

import com.salty.bechef.entities.Book;
import com.salty.bechef.entities.dto.BookDTO;
import com.salty.bechef.entities.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooks();
    Optional<Book> getBook(Long id);
    void deleteBook(Long id);
    Book saveBook(BookDTO book);
    void linkUsersToBook(Long bookId, List<UserDTO> users);
}
