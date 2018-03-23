package io.github.slawomirr.library.repository;

import io.github.slawomirr.library.domain.Copy;
import io.github.slawomirr.library.domain.Lending;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LendingRepository extends CrudRepository<Lending, Long> {

    @Override
    Lending save(Lending lending);

    //List<Lending> findByLibraryMemberId(Long memberId);

    @Query
    List<Lending> lentByMemberNotReturned(@Param("MEMBER_ID") Long memberId);

    List<Lending> findByCopyAndReturnDateIsNull(Copy copy);
}
