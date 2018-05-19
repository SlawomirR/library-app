package io.github.slawomirr.library.repository;

import io.github.slawomirr.library.domain.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {

    @Override
    Member save(Member member);

    Optional<Member> findById(Long Id);

    @Override
    void deleteById(Long id);
}
