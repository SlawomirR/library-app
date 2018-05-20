package io.github.slawomirr.library.mapper;

import io.github.slawomirr.library.domain.Member;
import io.github.slawomirr.library.domain.dto.MemberDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemberMapper {

    public Member mapToMember(final MemberDto memberDto) {
        return new Member(
                memberDto.getId(),
                memberDto.getFirstName(),
                memberDto.getLastName(),
                memberDto.getMemberSince() == null ? LocalDate.now() : memberDto.getMemberSince());
    }

    public MemberDto mapToMemberDto(final Member member) {
        return new MemberDto(
                member.getId(),
                member.getFirstName(),
                member.getLastName(),
                member.getMemberSince());
    }

    public List<MemberDto> mapToMemberDtoList(final List<Member> memberList) {
        return memberList.stream()
                .map(t -> new MemberDto(t.getId(), t.getFirstName(), t.getLastName(), t.getMemberSince()))
                .collect(Collectors.toList());
    }
}
