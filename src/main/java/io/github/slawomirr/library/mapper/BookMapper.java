package io.github.slawomirr.library.mapper;

import io.github.slawomirr.library.domain.Book;
import io.github.slawomirr.library.domain.dto.BookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    public BookDto mapToBookDto(final Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublicationYear());
    }

    public List<BookDto> mapToBookDtoList(final List<Book> bookList) {
        return bookList.stream()
                .map(book -> mapToBookDto(book))
                .collect(Collectors.toList());
    }

    public Book mapToBook(final BookDto bookDtoIn) {
        return new Book(
                bookDtoIn.getId(),
                bookDtoIn.getTitle(),
                bookDtoIn.getAuthor(),
                bookDtoIn.getPublicationYear(),
                null);
    }
}
