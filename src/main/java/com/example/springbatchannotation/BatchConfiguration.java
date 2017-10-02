package com.example.springbatchannotation;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Bean
    Job job(JobBuilderFactory jbf, StepBuilderFactory sbf, Step1Configuration step1Configuration, Step2Configuration step2Configuration) throws Exception {
        Step step1= sbf.get("file-db")
                .<Person, Person> chunk(100)
                .reader(step1Configuration.fileReader(null))
                .writer(step1Configuration.jdbcWriter(null))
                .build();
        Step step2=sbf.get("db-file")
                .<Map<Integer,Integer>,Map<Integer,Integer>> chunk(100)
                .reader(step2Configuration.jdbcReader(null))
                .writer(step2Configuration.fileWriter(null))
                .build();
        return jbf.get("etl").incrementer(new RunIdIncrementer())
                .start(step1)
                .next(step2)
                .build();
    }
}
