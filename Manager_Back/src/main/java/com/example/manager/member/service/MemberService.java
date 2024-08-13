package com.example.manager.member.service;

import com.example.manager.member.dto.MemberDTO;
import com.example.manager.member.dto.MemberWithReportDTO;
import com.example.manager.member.entity.Member;
import com.example.manager.member.entity.Role;

import java.util.List;
import java.util.Optional;


public interface MemberService {

    List<MemberWithReportDTO> getAllMemberWithReport(Role role);

    void stopMember(Long memberId);

    MemberDTO findMemberDTOById(String memberEmail);
}
