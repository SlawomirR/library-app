package io.github.slawomirr.library.controller;

import io.github.slawomirr.library.domain.dto.BookDto;
import io.github.slawomirr.library.mapper.BookMapper;
import io.github.slawomirr.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/book")
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getBooks")
    public List<BookDto> getBooks() {
        return bookMapper.mapToBookDtoList(bookService.getAllBooks());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBook")
    public BookDto getBook(@RequestParam Long bookId) throws Exception {
        return bookMapper.mapToBookDto(bookService.getBookById(bookId));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addNewBook", consumes = APPLICATION_JSON_VALUE)
    public void addNewBook(@RequestBody BookDto bookDto) {
        bookMapper.mapToBookDto(bookService.saveBook(bookMapper.mapToBook(bookDto)));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateBook")
    public void updateBook(@RequestBody BookDto bookDto) {
        bookMapper.mapToBookDto(bookService.saveBook(bookMapper.mapToBook(bookDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBook")
    public void deleteBook(@RequestParam Long bookId) {
        bookService.deleteBook(bookId);
    }
}
