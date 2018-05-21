package io.github.slawomirr.library.service;

import io.github.slawomirr.library.domain.Member;
import io.github.slawomirr.library.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberServiceTestSuite {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void getAllMembers() {
        // Given
        Member member1 = new Member("Alice", "Mirror", LocalDate.now());
        Member member2 = new Member("Cat", "Milk", LocalDate.now());
        memberRepository.save(member1);
        memberRepository.save(member2);
        // When
        List<Member> test = memberService.getAllMembers();
        // Then
        assertEquals(2, test.size());
        // CleanUp
        memberRepository.deleteById(member1.getId());
        memberRepository.deleteById(member2.getId());
    }

    @Test
    public void getMemberById() throws Exception {
        // Given
        Member member1 = new Member("Alice", "Mirror", LocalDate.now());
        Member member2 = new Member("Cat", "Milk", LocalDate.now());
        memberRepository.save(member1);
        memberRepository.save(member2);
        Long id = member2.getId();
        // When
        Member test = memberService.getMemberById(id);
        // Then
        assertEquals("Cat", test.getFirstName());
        // CleanUp
        memberRepository.deleteById(member1.getId());
        memberRepository.deleteById(member2.getId());
    }

    @Test
    public void saveMember() {
        // Given
        Member member1 = new Member("Alice", "Mirror", LocalDate.now());
        Member member2 = new Member("Cat", "Milk", LocalDate.now());
        // When
        memberService.saveMember(member1);
        memberService.saveMember(member2);
        // Then
        assertEquals(2, memberService.getAllMembers().size());
        // CleanUp
        memberRepository.deleteById(member1.getId());
        memberRepository.deleteById(member2.getId());
    }

    @Test
    public void deleteMember() {
        // Given
        Member member1 = new Member("Alice", "Mirror", LocalDate.now());
        Member member2 = new Member("Cat", "Milk", LocalDate.now());
        memberRepository.save(member1);
        memberRepository.save(member2);
        // When
        memberService.deleteMember(member1.getId());
        memberService.deleteMember(member2.getId());
        // Then
        assertEquals(0, memberService.getAllMembers().size());
    }
}
