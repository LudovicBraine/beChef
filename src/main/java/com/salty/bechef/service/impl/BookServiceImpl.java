package com.salty.bechef.service.impl;

import com.salty.bechef.entities.Book;
import com.salty.bechef.entities.User;
import com.salty.bechef.entities.dto.BookDTO;
import com.salty.bechef.entities.dto.UserDTO;
import com.salty.bechef.mapper.BookMapper;
import com.salty.bechef.mapper.UserMapper;
import com.salty.bechef.repository.BookRepository;
import com.salty.bechef.repository.UserRepository;
import com.salty.bechef.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final BookMapper bookMapper;
    private final UserMapper userMapper;

    @Override
    public List<Book> getBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBook(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public void deleteBook(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Book saveBook(BookDTO bookDTO) {
        // Récupère l'utilisateur à partir de l'ID contenu dans le champ `user` du DTO
        User user = this.userRepository.findById(bookDTO.getUser().getId()).orElseThrow();
        UserDTO userDTO = this.userMapper.userDTOToUser(user);

        bookDTO.setUser(userDTO);
        if(bookDTO.getCreatedAt() == null) {
            bookDTO.setCreatedAt(LocalDateTime.now());
        } else {
            bookDTO.setModifyAt(LocalDateTime.now());
        }
        bookDTO.setLastModifiedBy(user.getFirstname() + ' ' + user.getLastname());

        Book book = this.bookMapper.bookToBookDTO(bookDTO);

        return this.bookRepository.save(book);
    }
}
