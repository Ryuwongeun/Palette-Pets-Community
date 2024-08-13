package com.example.manager.memberReport.service;

import com.example.manager.memberReport.dto.MemberReportResponseDTO;
import com.example.manager.memberReport.entity.MemberReport;
import com.example.manager.memberReport.repository.MemberReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberReportServiceImpl implements MemberReportService {
    private final MemberReportRepository memberReportRepository;

    @Override
    public List<MemberReportResponseDTO> getMemberReportList() {
        List<MemberReport> memberReportList = memberReportRepository.findAll();
        return memberReportList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private MemberReportResponseDTO convertToDTO(MemberReport memberReport) {
        return MemberReportResponseDTO.builder()
                .reporterEmail(memberReport.getMemberId().getEmail())
                .reportedEmail(memberReport.getReportedMemberId().getEmail())
                .reportReason(memberReport.getReportReason())
                .reportContent(memberReport.getReportContent())
                .reportCount(memberReport.getReportCount())
                .reportDate(memberReport.getReportDate())
                .build();
    }
}
