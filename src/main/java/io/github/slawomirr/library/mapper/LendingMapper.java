package io.github.slawomirr.library.mapper;

import io.github.slawomirr.library.domain.Lending;
import io.github.slawomirr.library.domain.dto.LendingDto;
import io.github.slawomirr.library.repository.CopyRepository;
import io.github.slawomirr.library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LendingMapper {

    @Autowired
    private CopyRepository copyRepository;

    @Autowired
    private MemberRepository memberRepository;

    public Lending mapToLending(final LendingDto lendingDto) {
        return new Lending(
                lendingDto.getId(),
                copyRepository.findById(lendingDto.getCopyId()).get(),
                memberRepository.findById(lendingDto.getMemberId()).get(),
                lendingDto.getLendDate(),
                lendingDto.getReturnDate());
    }

    public LendingDto mapToLendingDto(final Lending lending) {
        return new LendingDto(
                lending.getId(),
                lending.getCopy().getId(),
                lending.getMemberId().getId(),
                lending.getLendDate(),
                lending.getReturnDate());
    }

    public List<LendingDto> mapToLendingDtoList(final List<Lending> lendingList) {
        return lendingList.stream()
                .map(this::mapToLendingDto)
                .collect(Collectors.toList());
    }
}
