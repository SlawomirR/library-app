package io.github.slawomirr.library.service;

import io.github.slawomirr.library.domain.Book;
import io.github.slawomirr.library.domain.Copy;
import io.github.slawomirr.library.domain.EItemStatus;
import io.github.slawomirr.library.repository.BookRepository;
import io.github.slawomirr.library.repository.CopyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CopyServiceTestSuite {

    @Autowired
    private CopyService copyService;

    @Autowired
    private CopyRepository copyRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Test
    public void getAllCopies() {
        // Given
        List<Copy> theList = new ArrayList<>();
        theList.add(new Copy(EItemStatus.AVAILABLE));
        theList.add(new Copy(EItemStatus.NEW));
        Book book1 = new Book("First book", "Major Author", 2016, theList);
        bookRepository.save(book1);
        // When
        List<Copy> test = copyService.getAllCopies();
        // Then
        assertEquals(2, test.size());
        // CleanUp
        copyRepository.deleteById(book1.getCopies().get(0).getId());
        copyRepository.deleteById(book1.getCopies().get(1).getId());
        bookRepository.deleteById(book1.getId());
    }

    @Test
    public void getCopyById() throws Exception {
        // Given
        List<Copy> theList = new ArrayList<>();
        theList.add(new Copy(EItemStatus.AVAILABLE));
        theList.add(new Copy(EItemStatus.NEW));
        Book book1 = new Book("First book", "Major Author", 2016, theList);
        bookRepository.save(book1);
        Long id = theList.get(1).getId();
        // When
        Copy test = copyService.getCopyById(id);
        // Then
        assertEquals(EItemStatus.NEW, test.getEItemStatus());
        // CleanUp
        copyRepository.deleteById(book1.getCopies().get(0).getId());
        copyRepository.deleteById(book1.getCopies().get(1).getId());
        bookRepository.deleteById(book1.getId());
    }

    @Test
    public void saveCopy() {
        // Given
        Book book1 = new Book("First book", "Major Author", 2016);
        Copy copy1 = new Copy(book1, EItemStatus.AVAILABLE);
        Copy copy2 = new Copy(book1, EItemStatus.NEW);
        // When
        bookService.saveBook(book1);
        copyService.saveCopy(copy1);
        copyService.saveCopy(copy2);
        // Then
        assertEquals(2, copyService.getAllCopies().size());
        // CleanUp
        copyRepository.deleteById(copy1.getId());
        copyRepository.deleteById(copy2.getId());
        bookRepository.deleteById(book1.getId());
    }

    @Test
    public void deleteCopy() {
        // Given
        Book book1 = new Book("First book", "Major Author", 2016);
        bookRepository.save(book1);
        Copy copy1 = new Copy(book1, EItemStatus.NEW);
        Copy copy2 = new Copy(book1, EItemStatus.NEW);
        copyRepository.save(copy1);
        copyRepository.save(copy2);
        // When
        copyService.deleteCopy(copy1.getId());
        copyService.deleteCopy(copy2.getId());
        // Then
        assertEquals(0, copyService.getAllCopies().size());
        // CleanUp
        bookRepository.deleteById(book1.getId());
    }

    @Test
    public void updateLendStatus() throws Exception {
        // Given
        List<Copy> theList = new ArrayList<>();
        theList.add(new Copy(EItemStatus.NEW));
        Book book1 = new Book("First book", "Major Author", 2016, theList);
        bookRepository.save(book1);
        copyRepository.save(theList.get(0));
        Long id = theList.get(0).getId();
        // When
        copyService.updateLendStatus(id, EItemStatus.AVAILABLE);
        // Then
        assertEquals(EItemStatus.AVAILABLE, copyService.getCopyById(id).getEItemStatus());
        // CleanUp
        copyRepository.deleteById(book1.getCopies().get(0).getId());
        bookRepository.deleteById(book1.getId());
    }

    @Test
    public void countAvailableCopies() {
        // Given
        Book book1 = new Book("First book", "Major Author", 2016);
        bookRepository.save(book1);
        Copy copy1 = new Copy(book1, EItemStatus.AVAILABLE);
        Copy copy2 = new Copy(book1, EItemStatus.AVAILABLE);
        Copy copy3 = new Copy(book1, EItemStatus.NEW);
        copyRepository.save(copy1);
        copyRepository.save(copy2);
        copyRepository.save(copy3);
        // When
        Long count = copyService.countAvailableCopies("First book");
        // Then
        assertEquals(2, count, 0);
        // CleanUp
        copyRepository.deleteById(copy1.getId());
        copyRepository.deleteById(copy2.getId());
        copyRepository.deleteById(copy3.getId());
        bookRepository.deleteById(book1.getId());
    }
}
