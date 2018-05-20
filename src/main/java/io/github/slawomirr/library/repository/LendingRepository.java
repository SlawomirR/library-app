package io.github.slawomirr.library.repository;

import io.github.slawomirr.library.domain.Lending;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface LendingRepository extends CrudRepository<Lending, Long> {

    @Override
    Lending save(Lending lending);

    @Override
    List<Lending> findAll();
}
