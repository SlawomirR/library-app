package io.github.slawomirr.library.service;

import io.github.slawomirr.library.domain.Copy;
import io.github.slawomirr.library.domain.EItemStatus;
import io.github.slawomirr.library.repository.CopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CopyService {

    @Autowired
    private CopyRepository copyRepository;

    public Copy saveCopy(final Copy copy) {
        return copyRepository.save(copy);
    }

    public void updateLendStatus(Long copyId, EItemStatus eItemStatus) throws Exception {

        Optional<Copy> copy = copyRepository.findById(copyId);
        copy.get().setEItemStatus(eItemStatus);
        copyRepository.save(copy.orElseThrow(Exception::new));
    }

    public Long countAvailableBookCopies(final String title) {

        return copyRepository.findAll().stream()
                .filter(t -> t.getEItemStatus().equals(EItemStatus.AVAILABLE))
                .filter(t -> t.getBook().getTitle().equals(title))
                .count();
    }
}
