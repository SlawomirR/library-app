package io.github.slawomirr.library.service;

import io.github.slawomirr.library.domain.Member;
import io.github.slawomirr.library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(final Long userId) throws Exception {
        return memberRepository.findById(userId).orElseThrow(Exception::new);
    }

    public Member saveMember(final Member member) {
        return memberRepository.save(member);
    }

    public void deleteMember(final Long userId) {
        memberRepository.deleteById(userId);
    }
}
