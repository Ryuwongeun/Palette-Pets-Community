package com.palette.palettepetsback.Article.redis.service;

import com.palette.palettepetsback.Article.redis.ArticleWriteRedis;
import com.palette.palettepetsback.Article.redis.ReportArticleRedis;
import com.palette.palettepetsback.Article.redis.repository.ArticleWriteRedisRepository;
import com.palette.palettepetsback.Article.redis.repository.ArticleReportRedisRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class ArticleRedisService {

    private final ArticleWriteRedisRepository articleWriteRedisRepository;
    private final ArticleReportRedisRepository articleReportRedisRepository;

    /**
     * 글 도배 방지 정보를 저장.
     * @param articleWriteRedis 저장할 정보
     * @return 저장된 정보
     */
    public void saveArticleWrite(Long memberId){

        // 현재 시간을 밀리초로 구합니다.
        long currentTimeMillis = System.currentTimeMillis()+60000;

        // 밀리초 값을 문자열로 변환합니다.
        String currentTimeMillisString = String.valueOf(currentTimeMillis);
//        log.info("formattedDate : " + currentTimeMillisString);
        ArticleWriteRedis articleWriteRedis = ArticleWriteRedis.builder()
                .memberId(memberId)
                .expirationTime(currentTimeMillisString)
                .build();
        articleWriteRedisRepository.save(articleWriteRedis);

    }

    /**
     * 글 도배 방지 정보 조회
     * @param writeId 조회할 ID
     * @return 조회된 정보
     */
    public Optional<ArticleWriteRedis> findByMemberId(Long memberId){
        return articleWriteRedisRepository.findByMemberId(memberId);
    }


    /**
     *  글 신고 정보를 저장
     * @param reportArticleRedis 저장할 정보
     * @return 저장된 정보
     */
    public ReportArticleRedis saveReportArticle(ReportArticleRedis reportArticleRedis){
        return articleReportRedisRepository.save(reportArticleRedis);
    }

    /**
     * 글 신고 정보 조회
     * @param reportId 조회할 ID
     * @return 조회된 정보
     */
    public Optional<ReportArticleRedis> findReportArticleById(String reportId){
        return articleReportRedisRepository.findByReportId(reportId);
    }
    // redis 등록 확인 테스트용
    public List<ArticleWriteRedis> findAllByMemberId(Long memberId) {
        return (List<ArticleWriteRedis>) articleWriteRedisRepository.findAllByMemberId(memberId);
    }
    
}
