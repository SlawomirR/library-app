package io.github.slawomirr.library.repository;

import io.github.slawomirr.library.domain.Copy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CopyRepository extends CrudRepository<Copy, Long> {

    @Override
    Copy save(Copy copy);

    Optional<Copy> findById(Long id);

    @Override
    List<Copy> findAll();
}
