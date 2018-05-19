package io.github.slawomirr.library.service;

import io.github.slawomirr.library.domain.EItemStatus;
import io.github.slawomirr.library.domain.Lending;
import io.github.slawomirr.library.repository.CopyRepository;
import io.github.slawomirr.library.repository.LendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class LendingService {

    @Autowired
    private LendingRepository lendingRepository;

    @Autowired
    private CopyRepository copyRepository;

    public Lending saveLend(final Lending lending) {
        lending.getCopy().setEItemStatus(EItemStatus.CHECKED_OUT);
        copyRepository.save(lending.getCopy());
        return lendingRepository.save(lending);
    }

    public void returnBook(Long lendBookId) {
        Optional<Lending> lendBook = lendingRepository.findById(lendBookId);
        Lending lending = lendBook.get();
        lending.getCopy().setEItemStatus(EItemStatus.AVAILABLE);
        copyRepository.save(lending.getCopy());
        lending.setReturnDate(LocalDate.now());
        lendingRepository.save(lending);
    }
}
