package io.github.slawomirr.library.controller;

import io.github.slawomirr.library.domain.dto.MemberDto;
import io.github.slawomirr.library.mapper.MemberMapper;
import io.github.slawomirr.library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/member")
@CrossOrigin(origins = "*")
public class MemberController {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private MemberService memberService;


    @PostMapping(value = "createMember", consumes = APPLICATION_JSON_VALUE)
    public void createMember(@RequestBody MemberDto memberDto) {
        memberMapper.mapToMemberDto(memberService.createMember(
                memberMapper.mapToMember(memberDto).getFirstName(),
                memberMapper.mapToMember(memberDto).getLastName())
        );
    }


}
