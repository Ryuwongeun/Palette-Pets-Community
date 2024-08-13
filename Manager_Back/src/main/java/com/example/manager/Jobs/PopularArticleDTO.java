package com.example.manager.Jobs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PopularArticleDTO {
    private Long articleId;
    private String title;
    private Long memberId;
    private String memberNickname;
    private Integer countLoves;
    private Integer countComments;
}
