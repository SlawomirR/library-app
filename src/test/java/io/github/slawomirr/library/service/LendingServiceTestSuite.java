package io.github.slawomirr.library.service;

import io.github.slawomirr.library.domain.*;
import io.github.slawomirr.library.repository.BookRepository;
import io.github.slawomirr.library.repository.CopyRepository;
import io.github.slawomirr.library.repository.LendingRepository;
import io.github.slawomirr.library.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LendingServiceTestSuite {

    @Autowired
    private LendingService lendingService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CopyRepository copyRepository;

    @Autowired
    private LendingRepository lendingRepository;

    @Test
    public void getAllLend() {
        // Given
        Book book1 = new Book("First book", "Major Author", 2016);
        bookRepository.save(book1);
        Copy copy1 = new Copy(book1, EItemStatus.AVAILABLE);
        copyRepository.save(copy1);
        Member member1 = new Member("Alice", "Mirror", LocalDate.now());
        memberRepository.save(member1);
        Lending lending1 = new Lending(copy1, member1, LocalDate.now
                (), LocalDate.now());
        lendingService.saveLend(lending1);
        // When
        List<Lending> test = lendingService.getAllLend();
        // Then
        assertEquals(1, test.size());
        // CleanUp
        lendingRepository.delete(lending1);
        copyRepository.deleteById(copy1.getId());
        memberRepository.deleteById(member1.getId());
        bookRepository.deleteById(book1.getId());
    }

    @Test
    public void saveLend() {
        // Given
        Book book1 = new Book("First book", "Major Author", 2016);
        bookRepository.save(book1);
        Copy copy1 = new Copy(book1, EItemStatus.NEW);
        copyRepository.save(copy1);
        Member member1 = new Member("Alice", "Mirror", LocalDate.now());
        memberRepository.save(member1);
        Lending lending1 = new Lending(copy1, member1, LocalDate.now(), LocalDate.of(2999, 12, 31));
        // When
        lendingService.saveLend(lending1);
        // Then
        assertEquals(1, lendingService.getAllLend().size());
        assertEquals(EItemStatus.CHECKED_OUT, copy1.getEItemStatus());
        // CleanUp
        lendingRepository.delete(lending1);
        copyRepository.deleteById(copy1.getId());
        memberRepository.deleteById(member1.getId());
        bookRepository.deleteById(book1.getId());
    }

    @Test
    public void returnBook() {
        // Given
        Book book1 = new Book("First book", "Major Author", 2016);
        bookRepository.save(book1);
        Copy copy1 = new Copy(book1, EItemStatus.NEW);
        copyRepository.save(copy1);
        Member member1 = new Member("Alice", "Mirror", LocalDate.now());
        memberRepository.save(member1);
        Lending lending1 = new Lending(copy1, member1, LocalDate.now(), LocalDate.of(1990, 12, 31));
        lendingService.saveLend(lending1);
        // When
        lendingService.returnBook(lending1.getId());
        // Then
        assertEquals(EItemStatus.AVAILABLE, lendingService.getAllLend().get(0).getCopy().getEItemStatus());
        assertEquals(LocalDate.now(), lendingService.getAllLend().get(0).getReturnDate());
        // CleanUp
        lendingRepository.delete(lending1);
        copyRepository.deleteById(copy1.getId());
        memberRepository.deleteById(member1.getId());
        bookRepository.deleteById(book1.getId());
    }
}
