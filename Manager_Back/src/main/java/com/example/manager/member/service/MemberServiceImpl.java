package com.example.manager.member.service;

import com.example.manager.member.dto.MemberDTO;
import com.example.manager.member.dto.MemberWithReportDTO;
import com.example.manager.member.entity.Role;
import com.example.manager.member.repository.MemberRepository;
import com.example.manager.member.entity.Member;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public List<MemberWithReportDTO> getAllMemberWithReport(Role role) {
        return memberRepository.findAllMembersWithReport(role);
    }

    @Override
    @Transactional
    public void stopMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Member not found"));
        member.setIsDeleted();
        memberRepository.save(member);
    }

    @Override
    public MemberDTO findMemberDTOById(String memberEmail) {
        MemberDTO member = memberRepository.findMemberDTOById(memberEmail);
        if (member == null) {
            throw new EntityNotFoundException("Member not found with memberId: " + memberEmail);
        }
        return member;
    }
}
