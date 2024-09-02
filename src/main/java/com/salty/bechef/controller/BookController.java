package com.salty.bechef.controller;

import com.salty.bechef.entities.Book;
import com.salty.bechef.entities.Page;
import com.salty.bechef.entities.dto.BookDTO;
import com.salty.bechef.entities.dto.PageDTO;
import com.salty.bechef.exception.NotFoundException;
import com.salty.bechef.mapper.BookMapper;
import com.salty.bechef.mapper.PageMapper;
import com.salty.bechef.service.BookService;
import com.salty.bechef.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final BookMapper bookMapper;
    private final PageService pageService;
    private final PageMapper pageMapper;

    @GetMapping("/total")
    public ResponseEntity<Number> getAllBookTotal() {
        Number bookSize = this.bookService.getBooks().size();
        return new ResponseEntity<>(bookSize, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<Book> books = this.bookService.getBooks();
        List<BookDTO> bookDTOS = this.bookMapper.listBookToListBookDTO(books);
        return new ResponseEntity<>(bookDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable("id") Long id) {
        try {
            Book book = this.bookService.getBook(id).orElseThrow();
            BookDTO bookDTO = this.bookMapper.bookToBookDTO(book);
            return new ResponseEntity<>(bookDTO, HttpStatus.OK);
        } catch (Exception e) {
            throw new NotFoundException(NotFoundException.NotFoundExceptionType.BOOK_NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        this.bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping()
    public ResponseEntity<BookDTO> saveBook(@RequestBody BookDTO book) {
        Book bookToSave = this.bookService.saveBook(book);
        BookDTO bookDTO = this.bookMapper.bookToBookDTO(bookToSave);

        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
    }




    @GetMapping("/{id}/pages")
    public ResponseEntity<List<PageDTO>> findAllPageByBookId(@PathVariable("id") Long id) {
        List<Page> pages = this.pageService.getPagesByBookId(id);
        List<PageDTO> pageDTOS = this.pageMapper.listPageToListPageDTO(pages);
        return new ResponseEntity<>(pageDTOS, HttpStatus.OK);
    }

    @GetMapping("/{bookId}/page/{pageId}")
    public ResponseEntity<PageDTO>findPageById(@PathVariable("bookId") Long bookId, @PathVariable Long pageId) {
        Page page = this.pageService.getPageByBookId(bookId, pageId);
        PageDTO pageDTO = this.pageMapper.pageToPageDTO(page);
        return new ResponseEntity<>(pageDTO, HttpStatus.OK);
    }

    @PostMapping("/{bookId}/page")
    public ResponseEntity<PageDTO> addPage(@PathVariable("bookId") Long bookId, @RequestBody PageDTO page) {
        Page pageSaved = this.pageService.addPage(bookId ,page);
        PageDTO pageDTO = this.pageMapper.pageToPageDTO(pageSaved);
        //        PageLightDTO pageLightDTO = this.pageMapper.pageToPageLightDTO(pageSaved);
        return new ResponseEntity<>(pageDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}/page/{pageId}")
    public ResponseEntity<Void> deleById(@PathVariable("bookId") Long bookId, @PathVariable("pageId") Long pageId){
        this.pageService.deletePageByBookId(bookId, pageId);
        return ResponseEntity.ok().build();
    }
}
