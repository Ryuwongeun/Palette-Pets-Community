//package com.example.manager.Config.Batch;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.BatchStatus;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobExecution;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.annotation.AfterJob;
//import org.springframework.batch.core.annotation.BeforeJob;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.job.builder.JobBuilder;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.step.builder.StepBuilder;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.jdbc.support.JdbcTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//
//
//import javax.sql.DataSource;
//
//
//@Configuration
//@Slf4j
//@EnableBatchProcessing(dataSourceRef = "batchDataSourceProperties", transactionManagerRef = "batchTransactionManager") //일괄 작업을 위한 기본 구성 제공
//@RequiredArgsConstructor
//public class BatchConfiguration implements JobExecutionListener {
//
//    @Bean
//    @Primary
//    public DataSource batchDataSourceProperties(DataSourceProperties properties) {
//        // 배치가 수행되는 데이터 저장소 지정
//        return properties.initializeDataSourceBuilder().build();
//    }
//
//    @Bean
//    public JdbcTransactionManager batchTransactionManager(DataSource dataSource) {
//        return new JdbcTransactionManager(dataSource);
//    }
//
//
//    @Bean
//    // JobRepository : 배치 작업에 관련된 모든 정보 저장, Job, Step의 실행정보 저장
//    public Job exampleJob(JobRepository jobRepository, Step step1){
//        log.info(">>>exampleJob<<<");
//        return new JobBuilder("exampleJob", jobRepository)
//                .start(step1)
////                .preventRestart() 다시 시작을 막는다. 예외발생 https://docs.spring.io/spring-batch/reference/job/configuring.html#restartability
//
//                .build();
//    }
//
//    @Bean
//    // Tasklet : 리소스 정리, 시스템 상태 체크에 활용
//    public Step exampleStep(JobRepository jobRepository,
//                            PlatformTransactionManager platformTransactionManager, DataSourceTransactionManager transactionManager) {
//        log.info(">>>exampleStep<<<");
//        return new StepBuilder("step1", jobRepository)
//                .tasklet((contribution, chunkContext) -> null , transactionManager)
//                .build();
//    }
//
////    @Bean
////    public ItemReader testReader(){
////        return () -> {
////            log.info(">>>testReader<<<");
////            articleRepository.findById(10L);
////            return null;
////        };
////    }
//
//    @Bean
//    public ItemProcessor testProcessor(){
//        return item -> {
//            log.info(">>>testProcessor<<<");
//            return item;
//        };
//    }
//
//    @Bean
//    public ItemWriter testWriter(){
//        return list -> {
//            log.info(">>>testWriter<<<");
//        };
//    }
//
//
//    @Bean
//    public Tasklet testTasklet(){
//        return (contribution, chunkContext) -> {
//            log.info(">>>testTasklet<<<");
//            return RepeatStatus.FINISHED;
//        };
//    }
//
//
//    @Override
//    @BeforeJob // Job이 시작되기 전에 호출
//    public void beforeJob(JobExecution jobExecution) {
//        log.info(">>>BATCH JOB {} STARTED<<<", jobExecution.getJobId());
//    }
//
//    @Override
//    @AfterJob // Job이 끝난 후에 호출
//    public void afterJob(JobExecution jobExecution) {
//        if(jobExecution.getStatus() == BatchStatus.COMPLETED){
//            log.info(">>>BATCH JOB {} COMPLETED<<<", jobExecution.getJobId());
//        }
//        else if(jobExecution.getStatus() == BatchStatus.FAILED){
//            log.error(">>>BATCH JOB {} FAILED<<<", jobExecution.getJobId());
//        }
//    }
//}