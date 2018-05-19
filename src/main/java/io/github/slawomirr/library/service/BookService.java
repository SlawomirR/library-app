package io.github.slawomirr.library.service;

import io.github.slawomirr.library.domain.Book;
import io.github.slawomirr.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void createBook(final Book book) {
        bookRepository.save(book);
    }

}
