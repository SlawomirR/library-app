package io.github.slawomirr.library.service;

import io.github.slawomirr.library.domain.Book;
import io.github.slawomirr.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(final Long bookId) throws Exception {
        return bookRepository.findById(bookId).orElseThrow(Exception::new);
    }

    public Book saveBook(final Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(final Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
