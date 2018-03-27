package io.github.slawomirr.library.mapper;

import io.github.slawomirr.library.domain.Copy;
import io.github.slawomirr.library.domain.dto.CopyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CopyMapper {

    @Autowired
    private BookMapper bookMapper;

    public CopyDto mapToCopyDto(Copy copy) {
        return new CopyDto(
                copy.getId(),
                copy.getBookId(),
                copy.getStatus());
    }

    public List<CopyDto> mapToCopyDtoList(List<Copy> copies) {
        return copies.stream().map(c -> mapToCopyDto(c)).collect(Collectors.toList());
    }
}
