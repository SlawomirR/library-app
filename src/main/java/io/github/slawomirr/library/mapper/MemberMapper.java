package io.github.slawomirr.library.mapper;

import io.github.slawomirr.library.domain.Member;
import io.github.slawomirr.library.domain.dto.MemberDto;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemberMapper {

    public MemberDto mapToMemberDto(final Member member) {
        return new MemberDto(
                member.getId(),
                member.getFirstName(),
                member.getLastName(),
                Date.valueOf(member.getMemberSince())
        );
    }

    public List<MemberDto> mapToMemberDtoOutList(final List<Member> memberList) {
        return memberList.stream()
                .map(member -> mapToMemberDto(member))
                .collect(Collectors.toList());
    }

    public Member mapToMember(final MemberDto memberDto) {
        return new Member(
                memberDto.getId(),
                memberDto.getFirstName(),
                memberDto.getLastName(),
                memberDto.getMemberSince().toLocalDate(),
                null);
    }
}
