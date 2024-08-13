package com.example.manager.member.dto;

import com.example.manager.member.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberWithReportDTO {
    private Long memberId;
    private String email;
    private String memberName;
    private String memberNickName;
    private String memberAddress;
    private String memberBirth;
    private String memberPhone;
    private Role role;
    private boolean isDeleted;
    private Long reportCount;
}
