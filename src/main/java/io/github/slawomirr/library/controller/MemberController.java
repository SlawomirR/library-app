package io.github.slawomirr.library.controller;

import io.github.slawomirr.library.domain.dto.MemberDto;
import io.github.slawomirr.library.mapper.MemberMapper;
import io.github.slawomirr.library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/member")
@CrossOrigin(origins = "*")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberMapper memberMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getMembers")
    public List<MemberDto> getMembers() {
        return memberMapper.mapToMemberDtoList(memberService.getAllMembers());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getMember")
    public MemberDto getMember(@RequestParam Long userId) throws Exception {
        return memberMapper.mapToMemberDto(memberService.getMemberById(userId));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addMember", consumes = APPLICATION_JSON_VALUE)
    public void addMember(@RequestBody MemberDto memberDto) {
        memberMapper.mapToMemberDto(memberService.saveMember(memberMapper.mapToMember(memberDto)));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateMember")
    public void updateMember(@RequestBody MemberDto memberDto) {
        memberMapper.mapToMemberDto(memberService.saveMember(memberMapper.mapToMember(memberDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteMember")
    public void deleteMember(@RequestParam Long userId) {
        memberService.deleteMember(userId);
    }
}
