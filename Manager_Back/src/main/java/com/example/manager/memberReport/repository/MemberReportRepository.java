package com.example.manager.memberReport.repository;

import com.example.manager.memberReport.entity.MemberReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberReportRepository extends JpaRepository<MemberReport, Long> {
}
