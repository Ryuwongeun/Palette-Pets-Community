package com.example.manager.memberReport.service;

import com.example.manager.memberReport.dto.MemberReportResponseDTO;

import java.util.List;

public interface MemberReportService {
    List<MemberReportResponseDTO> getMemberReportList();
}
