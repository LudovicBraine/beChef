package com.salty.bechef.mapper;

import com.salty.bechef.entities.Book;
import com.salty.bechef.entities.dto.BookDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel =  "spring", uses = {PageMapper.class})
public interface BookMapper  {

    @Mapping(target="id", source ="book.id")
    @Mapping(target="image", source="book.image")
    @Mapping(target="createdAt", source="book.createdAt")
    @Mapping(target="lastModifiedBy", source="book.lastModifiedBy")
    @Mapping(target="modifyAt", source="book.modifyAt")
    @Mapping(target="display", source="book.display")
    @Mapping(target="user", source="book.user")
    @Mapping(target="pages", source="book.pages")
    BookDTO bookToBookDTO(Book book);

    @InheritInverseConfiguration
    Book bookToBookDTO(BookDTO bookDTO);

    List<BookDTO> listBookToListBookDTO(List<Book> bookList);

    List<Book> listBookDTOToListBook(List<BookDTO> bookDTOList);
}

