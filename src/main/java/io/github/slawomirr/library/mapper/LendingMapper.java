package io.github.slawomirr.library.mapper;

import io.github.slawomirr.library.domain.Lending;
import io.github.slawomirr.library.domain.dto.LendingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class LendingMapper {

    @Autowired
    private CopyMapper copyMapper;

    @Autowired
    private MemberMapper memberMapper;

    public LendingDto mapToLendingDto(Lending lending) {
        return new LendingDto(
                lending.getId(),
                copyMapper.mapToCopyDto(lending.getCopy()),
                memberMapper.mapToMemberDto(lending.getLibraryMember()),
                Date.valueOf(lending.getLendingDate()),
                Optional.ofNullable(lending.getReturnDate())
                        .map(Date::valueOf)
                        .orElse(null));
    }

    public List<LendingDto> mapToLendingDtoList(List<Lending> lendingBookList) {
        return lendingBookList.stream()
                .map(lending -> mapToLendingDto(lending))
                .collect(Collectors.toList());
    }
}
