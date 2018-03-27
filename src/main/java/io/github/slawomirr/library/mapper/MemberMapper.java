package io.github.slawomirr.library.mapper;

import io.github.slawomirr.library.domain.LibraryMember;
import io.github.slawomirr.library.domain.dto.MemberDto;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemberMapper {

    public MemberDto mapToMemberDto(LibraryMember libraryMember) {
        return new MemberDto(
                libraryMember.getId(),
                libraryMember.getFirstName(),
                libraryMember.getLastName(),
                Date.valueOf(libraryMember.getMemberSince())
        );
    }

    public List<MemberDto> mapToMemberDtoOutList(List<LibraryMember> libraryMemberList) {
        return libraryMemberList.stream()
                .map(member -> mapToMemberDto(member))
                .collect(Collectors.toList());
    }

    public LibraryMember mapToMember(MemberDto memberDto) {
        return new LibraryMember(
                memberDto.getId(),
                memberDto.getFirstName(),
                memberDto.getLastName(),
                memberDto.getMemberSince().toLocalDate(),
                null);
    }
}
