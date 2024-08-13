package com.palette.palettepetsback.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class FollowResponse {
    private Long id;
    private String nickname;
    private String profile;
}
