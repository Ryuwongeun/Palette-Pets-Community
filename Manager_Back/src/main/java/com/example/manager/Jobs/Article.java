package com.example.manager.Jobs;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@Table(name = "article")
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long articleId;

    @Column(name = "created_who")
    private Long createdWho;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "TEXT", name = "content", nullable = false)
    private String content;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "article_tags")
    private String articleTags;
    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private Article.State state;

    @Column(name = "count_loves")
    private Integer countLoves;

    @Column(name = "count_report")
    private Integer countReport;

    @Column(name = "count_views")
    private Integer countViews;

    @Column(name = "count_review")
    private Integer countReview;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    //추가 Entity
    @Column(name = "board_name")
    @Enumerated(EnumType.STRING)
    private ComminityBoard boardName;

    @Column(name = "article_head")
    private String articleHead;

    public enum ComminityBoard{
        FREEBOARD,INFORMATION,SHOW,QNA
    }

    public enum State{
        ACTIVE,MODIFIED,DELETED
    }
}
