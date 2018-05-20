package io.github.slawomirr.library.repository;

import io.github.slawomirr.library.domain.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {

    @Override
    Member save(Member member);

    Optional<Member> findById(Long id);

    @Override
    void deleteById(Long id);

    @Override
    List<Member> findAll();
}
