package io.github.slawomirr.library.repository;

import io.github.slawomirr.library.domain.Lending;
import org.springframework.data.repository.CrudRepository;

public interface LendingRepository extends CrudRepository<Lending, Long> {

    @Override
    Lending save(Lending lending);
}
