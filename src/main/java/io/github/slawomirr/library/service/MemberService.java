package io.github.slawomirr.library.service;

import io.github.slawomirr.library.domain.Member;
import io.github.slawomirr.library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member createMember(String firstName, String lastName) {
        return memberRepository.save(new Member(firstName, lastName, LocalDate.now()));
    }
}
