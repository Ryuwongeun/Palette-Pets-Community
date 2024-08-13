package com.example.manager.member.repository;

import com.example.manager.member.dto.MemberDTO;
import com.example.manager.member.dto.MemberWithReportDTO;
import com.example.manager.member.entity.Member;
import com.example.manager.member.entity.Role;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("""
       SELECT new com.example.manager.member.dto.MemberWithReportDTO(
       m.memberId, m.email, m.memberName, m.memberNickName, m.memberAddress, m.memberBirth, m.memberPhone, m.role, m.isDeleted, COUNT(r))
       FROM Member m 
       LEFT JOIN m.memberReport r 
       WHERE m.role = :role
       GROUP BY m.memberId, m.email, m.memberName, m.memberNickName, m.memberAddress, m.memberBirth, m.memberPhone, m.role, m.isDeleted
       """)
    List<MemberWithReportDTO> findAllMembersWithReport(@Param("role")Role role);

    @Query("""
        select new com.example.manager.member.dto.MemberDTO(
        m.memberId, m.email, m.memberName, m.memberNickName, m.isDeleted, COUNT(r), r.reportReason, r.reportContent)
        from Member m
        left join m.memberReport r
        where m.email = :memberEmail
        group by m.memberId
        """)
    MemberDTO findMemberDTOById(@Param("memberEmail") String memberEmail);
}
