package com.example.manager.member.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberDTO {
    private Long memberId;
    private String email;
    private String memberName;
    private String memberNickName;
    private boolean isDeleted;
    private Long reportCount;
    private String reportReason;
    private String reportContent;
}
