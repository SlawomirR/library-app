package io.github.slawomirr.library.service;

import io.github.slawomirr.library.domain.Book;
import io.github.slawomirr.library.domain.LibraryMember;
import io.github.slawomirr.library.repository.BookRepository;
import io.github.slawomirr.library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DbService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MemberRepository memberRepository;

    public Book findBookWithId(Long bookId) throws Exception {
        return bookRepository.findById(bookId).orElseThrow(Exception::new);
    }

    public LibraryMember createMember(String firstName, String lastName) {
        return memberRepository.save(new LibraryMember(firstName, lastName, LocalDate.now()));
    }
}
