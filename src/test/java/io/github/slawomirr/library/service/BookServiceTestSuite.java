package io.github.slawomirr.library.service;

import io.github.slawomirr.library.domain.Book;
import io.github.slawomirr.library.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTestSuite {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void getAllBooks() {
        // Given
        Book book1 = new Book("First book", "Major Author", 2016);
        Book book2 = new Book("Second book", "Minor Author", 2017);
        bookRepository.save(book1);
        bookRepository.save(book2);
        // When
        List<Book> test = bookService.getAllBooks();
        // Then
        assertEquals(2, test.size());
        // CleanUp
        bookRepository.deleteById(book1.getId());
        bookRepository.deleteById(book2.getId());
    }

    @Test
    public void getBookById() throws Exception {
        // Given
        Book book1 = new Book("First book", "Major Author", 2016);
        Book book2 = new Book("Second book", "Minor Author", 2017);
        bookRepository.save(book1);
        bookRepository.save(book2);
        Long id = book2.getId();
        // When
        Book test = bookService.getBookById(id);
        // Then
        assertEquals("Second book", test.getTitle());
        // CleanUp
        bookRepository.deleteById(book1.getId());
        bookRepository.deleteById(book2.getId());
    }

    @Test
    public void saveBook() {
        // Given
        Book book1 = new Book("First book", "Major Author", 2016);
        Book book2 = new Book("Second book", "Minor Author", 2017);
        // When
        bookService.saveBook(book1);
        bookService.saveBook(book2);
        // Then
        assertEquals(2, bookService.getAllBooks().size());
        // CleanUp
        bookRepository.deleteById(book1.getId());
        bookRepository.deleteById(book2.getId());
    }

    @Test
    public void deleteBook() {
        // Given
        Book book1 = new Book("First book", "Major Author", 2016);
        Book book2 = new Book("Second book", "Minor Author", 2017);
        bookRepository.save(book1);
        bookRepository.save(book2);
        // When
        bookService.deleteBook(book1.getId());
        bookService.deleteBook(book2.getId());
        // Then
        assertEquals(0, bookService.getAllBooks().size());
    }
}
