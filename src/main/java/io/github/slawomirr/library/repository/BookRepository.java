package io.github.slawomirr.library.repository;

import io.github.slawomirr.library.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Override
    Book save(Book book);

    Optional<Book> findById(Long id);
}
