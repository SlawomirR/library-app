package io.github.slawomirr.library.repository;

import io.github.slawomirr.library.domain.LibraryMember;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends CrudRepository<LibraryMember, Long> {

    @Override
    LibraryMember save(LibraryMember libraryMember);

    Optional<LibraryMember> findById(Long Id);

    List<LibraryMember> findByLastName(String lastName);

    @Override
    void deleteById(Long id);
}
