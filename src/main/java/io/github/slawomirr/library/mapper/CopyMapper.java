package io.github.slawomirr.library.mapper;

import io.github.slawomirr.library.domain.Copy;
import io.github.slawomirr.library.domain.dto.CopyDto;
import io.github.slawomirr.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CopyMapper {

    @Autowired
    private BookRepository bookRepository;

    public Copy mapToCopy(final CopyDto copyDto) {
        return new Copy(
                copyDto.getId(),
                bookRepository.findById(copyDto.getBookId()).get(),
                copyDto.getEItemStatus());
    }

    public CopyDto mapToCopyDto(final Copy copy) {
        return new CopyDto(
                copy.getId(),
                copy.getBook().getId(),
                copy.getEItemStatus());
    }

    public List<CopyDto> mapToCopyDtoList(final List<Copy> copyList) {
        return copyList.stream()
                .map(this::mapToCopyDto)
                .collect(Collectors.toList());
    }
}
