package com.example.demo.AvailablePositions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadJobDataBase {
    private static final Logger log = LoggerFactory.getLogger(LoadJobDataBase.class);
    @Bean
    CommandLineRunner initJobDatabase(JobRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Job("DeveloperC++", "Developers", "2", "C++ Developer Wanted", "Junior")));
            log.info("Preloading " + repository.save(new Job("Project Management", "ProductOwner", "1", "Available position of PO in prospering project", "Senior")));
        };
    }
}
