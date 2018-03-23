package io.github.slawomirr.library.repository;

import io.github.slawomirr.library.domain.Copy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CopyRepository extends CrudRepository<Copy, Long> {

    @Override
    Copy save(Copy copy);

    @Query
    int retrieveAvailableQuantity(@Param("BOOK_ID") Long bookId);

    @Query
    List<Copy> retrieveAvailableCopies(@Param("BOOK_ID") Long bookId);

    Optional<Copy> findById(Long id);
}
