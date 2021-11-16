package com.example.demo.InterviewTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadTestDataBase {
    private static final Logger log = LoggerFactory.getLogger(LoadTestDataBase.class);
    @Bean
    CommandLineRunner initDatabase(InterviewTestRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new InterviewTest("TestC++", "Developers", "Medium", "setIntrebar1")));
            log.info("Preloading " + repository.save(new InterviewTest("TestManagement", "ProductOwner", "Easy", "setIntrebari2")));
        };
    }
}
