package com.example.manager.member.controller;

import com.example.manager.member.dto.MemberDTO;
import com.example.manager.member.dto.MemberWithReportDTO;
import com.example.manager.member.entity.Role;
import com.example.manager.member.service.MemberService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/memberList")
    public List<MemberWithReportDTO> getAllMemberWithReport() {
        Role role = Role.USER;
        List<MemberWithReportDTO> memberList = memberService.getAllMemberWithReport(role);
        System.out.println("memberList = " + memberList);
        return memberList;
    }

    @GetMapping("/member/{memberEmail}")
    public ResponseEntity<MemberDTO> findMemberDTOById(@PathVariable String memberEmail) {
        System.out.println("memberEmail = " + memberEmail);
        if (memberEmail == null) {
            return ResponseEntity.badRequest().build();
        }

        MemberDTO member;
        try {
            member = memberService.findMemberDTOById(memberEmail);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(member);
    }

    @PutMapping("/stopMember/{memberId}")
    public void stopMember(@PathVariable Long memberId) {
        System.out.println("memberId = " + memberId);
        memberService.stopMember(memberId);
    }


}
